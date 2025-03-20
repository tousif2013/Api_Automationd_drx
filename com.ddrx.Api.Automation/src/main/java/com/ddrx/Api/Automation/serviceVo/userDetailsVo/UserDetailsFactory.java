package com.ddrx.Api.Automation.serviceVo.userDetailsVo;

import java.util.Collections;
import java.util.List;
import com.github.javafaker.Faker;
import com.ddrx.Api.Automation.serviceVo.userDetailsVo.roles.rolesVo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetailsFactory {

    private static final Faker faker = new Faker();

    public static UserDetailsVo generateUserDetails() {

        UserDetailsVo userDetails = UserDetailsVo.builder()
                .id("24")
                .userLevel("ADMIN")
                .emailId(faker.internet().emailAddress())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .userName(faker.name().username())
                .phoneNumber(faker.phoneNumber().phoneNumber())
                .externalUserId(faker.idNumber().valid())
                .roles(Collections.singletonList(new rolesVo()))
                .build();

        return userDetails;
    }
}
