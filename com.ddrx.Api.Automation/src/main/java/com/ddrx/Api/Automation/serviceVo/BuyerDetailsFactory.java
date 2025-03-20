package com.ddrx.Api.Automation.serviceVo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import com.ddrx.Api.Automation.commons.MockPan;
import com.ddrx.Api.Automation.serviceVo.attributeValue.Appversion;
import com.ddrx.Api.Automation.serviceVo.attributeValue.InitialStepUpWizard;
import com.ddrx.Api.Automation.serviceVo.attributeValue.KycRequired;
import com.ddrx.Api.Automation.serviceVo.attributeValue.Rating;
import com.ddrx.Api.Automation.serviceVo.attributeValue.UserTCapplied;
import com.ddrx.Api.Automation.serviceVo.userDetailsVo.UserDetailsVo;
import com.github.javafaker.Faker;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuyerDetailsFactory {

	private static final Faker faker = new Faker();

	public static addBuyerRequestVo generateBuyerdetails() {
		addBuyerRequestVo buyerVo = addBuyerRequestVo.builder().build();

		buyerVo.setBuyerId("");
		buyerVo.setAddressLine1(faker.address().streetAddress());
		buyerVo.setAddressLine2(faker.address().fullAddress());
		buyerVo.setCinNo("L" + faker.numerify("#####") + faker.letterify("??").toUpperCase() + faker.numerify("####")
				+ faker.letterify("???").toUpperCase() + faker.numerify("######"));
		buyerVo.setCity(faker.address().city());
		;
		buyerVo.setImageUrl("");
		buyerVo.setCountry(faker.address().country());
		buyerVo.setCompanyEmail(faker.internet().emailAddress());
		buyerVo.setPanNo(MockPan.generateDummyPAN());
		String pan = MockPan.generateDummyPAN();
		buyerVo.setPhone(pan);

		buyerVo.setPincode(faker.numerify("######"));
		buyerVo.setState(faker.address().state());
		buyerVo.setCompanyName(faker.company().name());
		buyerVo.setGstinNo(faker.numerify("##") + pan + "1" + "Z" + faker.numerify("#"));
		buyerVo.setBuyerRating(Rating.getRating());
		buyerVo.setIndustryType(("fmcg"));
		buyerVo.setCorpArbitrageRate(faker.numerify("##"));
		buyerVo.setAppVersion(Appversion.DDRX.name());
		buyerVo.setBank_name(faker.name().name());
		buyerVo.setBank_account(faker.numerify("##############"));
		buyerVo.setBank_ifsc(faker.letterify("????").toUpperCase() + faker.numerify("#######"));
		buyerVo.setRelationshipManager(faker.name().firstName());
		buyerVo.setMinCreditPeriod(faker.number().digits(3));
		buyerVo.setMaxCreditPeriod(faker.number().digits(3));
		buyerVo.setBuyerCode(faker.name().nameWithMiddle());
		buyerVo.setKycRequired(KycRequired.No.name());

		buyerVo.setScreenProgress(InitialStepUpWizard.NotRequired.name());
		buyerVo.setAccountLabel("");
		buyerVo.setDistrict(faker.numerify("##"));
		buyerVo.setCoverageGroup(faker.numerify("##"));
		buyerVo.setSmeCenterHeadMailId(faker.internet().emailAddress());
		buyerVo.setFax(faker.numerify("##"));
		buyerVo.setConstitution(faker.letterify("??").toUpperCase());
		buyerVo.setLeiNo(faker.regexify("[A-Z0-9]{20}"));

		LocalDate date = LocalDate.now();
		;

		SimpleDateFormat inboubd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat outbound = new SimpleDateFormat("dd-MMM-yyyy");
		date = LocalDate.now();
		try {
			buyerVo.setDateOfIncorporation(outbound.format(inboubd.parse(date.toString())));
		} catch (ParseException e) {
			System.out.println("exception occured while paring date for setDateOfIncorporation() ");
			e.printStackTrace();
		}
		buyerVo.setSmeCenter(faker.numerify("###"));
		buyerVo.setExternalCorpId("");
		buyerVo.setTncAppliedFor(UserTCapplied.NONE.name());
		buyerVo.setTncVerificationVia("DIGITAL");
		buyerVo.setIsBuyerEdit("true");
		List<UserDetailsVo> userDetailsList = Collections.singletonList(new UserDetailsVo());
		buyerVo.setUserDetails(userDetailsList);
		return buyerVo;

	}

}