package com.ddrx.Api.Automation.serviceVo.userDetailsVo.roles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
 
public class rolesFactory {
	
	public static void generateroles() {
	
	rolesVo rolesVo = new rolesVo();
	rolesVo.setRoleId("24");
	rolesVo.setRoleDescription("Buyer API");
	
	}

}
