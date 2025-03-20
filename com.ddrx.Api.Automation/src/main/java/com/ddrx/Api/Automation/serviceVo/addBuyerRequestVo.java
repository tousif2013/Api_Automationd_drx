package com.ddrx.Api.Automation.serviceVo;

import java.util.List;

import com.ddrx.Api.Automation.commons.MockUpData;
import com.ddrx.Api.Automation.serviceVo.userDetailsVo.UserDetailsVo;

import lombok.Data;

@Data
@lombok.Builder
public class addBuyerRequestVo {

	@MockUpData(type = "")
	private String buyerId;
	@MockUpData(type = "addressLine1")
	private String addressLine1;
	@MockUpData(type = "addressLine2")
	private String addressLine2;
	@MockUpData(type = "cinNo")
	private String cinNo;
	@MockUpData(type = "city")
	private String city;
	@MockUpData(type = "imageUrl")
	private String imageUrl;
	@MockUpData(type = "country")
	private String country;
	@MockUpData(type = "companyEmail")
	private String companyEmail;
	@MockUpData(type = "panNo")
	private String panNo;// unique
	@MockUpData(type = "phone")
	private String phone;
	@MockUpData(type = "pincode")
	private String pincode;
	@MockUpData(type = "state")
	private String state;
	@MockUpData(type = "companyName")
	private String companyName;// unique
	@MockUpData(type = "gstinNo")
	private String gstinNo;// unique
	@MockUpData(type = "buyerRating")
	private String buyerRating;
	@MockUpData(type = "industryType")
	private String industryType;
	@MockUpData(type = "corpArbitrageRate")
	private String corpArbitrageRate;
	@MockUpData(type = "appVersion")
	private String appVersion;
	@MockUpData(type = "bank_name")
	private String bank_name;
	@MockUpData(type = "bank_account")
	private String bank_account;
	@MockUpData(type = "bank_ifsc")
	private String bank_ifsc;
	@MockUpData(type = "relationshipManager")
	private String relationshipManager;
	@MockUpData(type = "miniCreditPeriod")
	private String minCreditPeriod;
	@MockUpData(type = "maxCreditPeriod")
	private String maxCreditPeriod;
	@MockUpData(type = "buyerCode")
	private String buyerCode;// unique
	@MockUpData(type = "kycRequired")
	private String kycRequired;
	@MockUpData(type = "screenProgress")
	private String screenProgress;
	@MockUpData(type = "initialSetupWizard")
	private String initialSetupWizard;
	@MockUpData(type = "accountLabel")
	private String accountLabel;
	@MockUpData(type = "district")
	private String district;
	@MockUpData(type = "coverageGroup")
	private String coverageGroup;
	@MockUpData(type = "smeCenterHeadMailId")
	private String smeCenterHeadMailId;
	@MockUpData(type = "fax")
	private String fax;
	@MockUpData(type = "constitution")
	private String constitution;
	@MockUpData(type = "leiNo")
	private String leiNo;
	@MockUpData(type = "dateOfIncorporation")
	private String dateOfIncorporation;
	@MockUpData(type = "smeCenter")
	private String smeCenter;
	@MockUpData(type = "externalCorpId")
	private String externalCorpId;
	@MockUpData(type = "tncAppliedFor")
	private String tncAppliedFor;
	@MockUpData(type = "tncVerificationVia")
	private String tncVerificationVia;
	@MockUpData(type = "isBuyerEdit")
	private String isBuyerEdit;
	@MockUpData(type = "userDetails")
	private List<UserDetailsVo> userDetails;

	
	

	

	
}
