package com.ddrx.Api.Automation.serviceVo.userDetailsVo.roles;

import com.ddrx.Api.Automation.commons.MockUpData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class rolesVo {

	@MockUpData(type = "roleId")
	private String roleId;

	@MockUpData(type = "roleDescription")
	private String roleDescription;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
}
