package com.ddrx.Api.Automation.serviceVo.userDetailsVo;

import java.util.List;
import com.ddrx.Api.Automation.commons.MockUpData;
import com.ddrx.Api.Automation.serviceVo.userDetailsVo.roles.rolesVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsVo {

    private String[] userDetails;

    @MockUpData(type = "roleIds")
    private String roleIds;

    @MockUpData(type = "userLevel")
    private String userLevel;

    @MockUpData(type = "email")
    private String emailId;

    @MockUpData(type = "firstName")
    private String firstName;

    @MockUpData(type = "lastName")
    private String lastName;

    @MockUpData(type = "userName")
    private String userName;

    @MockUpData(type = "phoneNumber")
    private String phoneNumber;

    @MockUpData(type = "externalUserId")
    private String externalUserId;

    @MockUpData(type = "id")
    private String id;

    @MockUpData(type = "roles")
    private List<rolesVo> roles;
}
