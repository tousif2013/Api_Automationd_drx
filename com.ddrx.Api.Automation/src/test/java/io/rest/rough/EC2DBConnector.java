package io.rest.rough;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.channel.direct.LocalPortForwarder;
import net.schmizz.sshj.connection.channel.direct.Parameters;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.channel.direct.Session;
import java.io.IOException;

public class EC2DBConnector {
	public static void main(String[] args) throws IOException, InterruptedException, SQLException {

		String host = "ec2-13-200-125-152.ap-south-1.compute.amazonaws.com";
		String user = "ubuntu";
		String privateKeyPath = "C://Users//TousifInamdar//DDRX Automation Wokspace//com.ddrx.Api.Automation//src//main//resources//jdbc//pem//qa-jump.pem";

		String remoteDBHost = "credable-qa-rds-primary.cqbr8gy4vcb8.ap-south-1.rds.amazonaws.com";
		java.lang.String dbUser = "ddrx_super";
		java.lang.String dbPassword = "DDRX@Sup3R#24";
		java.lang.String dbName = "ddrx_staging";
		int localPort = 3307;

		SSHClient ssh = new SSHClient();
		try {
			ssh.loadKnownHosts();
			ssh.connect(host);
			ssh.authPublickey(user, privateKeyPath);

			System.out.println(" SSH Connected to EC2");

			String query = "select * from user LIMIT 10;";
			String mysqlCommand = String.format("mysql -h %s -P 3307 -u %s -p'%s' -D %s -e \"%s\"",
					"credable-qa-rds-primary.cqbr8gy4vcb8.ap-south-1.rds.amazonaws.com", dbUser, dbPassword, dbName,
					query);

			// String mysqlCommand = String.format("mysql -u %s -p%s -D %s -e \"%s\"",
			// dbUser, dbPassword, dbName, query);

			try (Session session = ssh.startSession()) {
				Session.Command cmd = session.exec(mysqlCommand);

				BufferedReader reader = new BufferedReader(new InputStreamReader(cmd.getInputStream()));
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}

				cmd.join();
			}

			ssh.disconnect();
			System.out.println(" SSH Disconnected");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
