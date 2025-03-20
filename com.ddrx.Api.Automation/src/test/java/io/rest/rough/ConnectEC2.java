package io.rest.rough;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.channel.direct.LocalPortForwarder;
import net.schmizz.sshj.connection.channel.direct.Parameters;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

public class ConnectEC2 {
	public static void main(String[] args) {

		String host = "ec2-13-200-125-152.ap-south-1.compute.amazonaws.com";
		String user = "ubuntu";
		String privateKeyPath = "C://Users//TousifInamdar//DDRX Automation Wokspace//com.ddrx.Api.Automation//src//main//resources//jdbc//pem//qa-jump.pem";

		String remoteDBHost = "credable-qa-rds-primary.cqbr8gy4vcb8.ap-south-1.rds.amazonaws.com";
		java.lang.String dbUser = "ddrx_super";
		java.lang.String dbPassword = "DDRX@Sup3R#24";
		java.lang.String dbName = "ddrx";
		int remotePort = 3307;
		int localPort = 3307;

		try (SSHClient ssh = new SSHClient()) {
			ssh.addHostKeyVerifier(new PromiscuousVerifier());
			ssh.connect(host);

			// Check if private key exists
			File keyFile = new File(privateKeyPath);
			if (!keyFile.exists()) {
				throw new RuntimeException("Private key file not found: " + privateKeyPath);
			}

			ssh.authPublickey(user, privateKeyPath);

			// Verify SSH connection
			try (Session session = ssh.startSession()) {
				Session.Command cmd = session.exec("whoami");
				cmd.join(5, TimeUnit.SECONDS);
				try (InputStream inputStream = cmd.getInputStream()) {
					String output = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
					System.out.println("SSH Connected. User: " + output.trim());
				}
			}

			// Start local port forwarding
			try (ServerSocket serverSocket = new ServerSocket(localPort)) {
				LocalPortForwarder forwarder = ssh.newLocalPortForwarder(
						new Parameters("127.0.0.1", localPort, host, remotePort), serverSocket);

				Thread forwarderThread = new Thread(() -> {
					try {
						forwarder.listen();
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				forwarderThread.setDaemon(true); // Runs in background
				forwarderThread.start();

				System.out.println(
						"Port forwarding started: localhost:" + localPort + " -> " + host + ":" + remotePort);

				// Give the tunnel a moment to establish
				Thread.sleep(2000);

				// Connect to MySQL using the forwarded port
				try (Connection conn = DriverManager
						.getConnection("jdbc:mysql://localhost:" + localPort + "/ddrx", dbUser, dbPassword);
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery("SELECT DATABASE();")) {
					while (rs.next()) {
						System.out.println("Connected to MySQL database: " + rs.getString(1));
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
