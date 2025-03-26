package com.ddrx.Api.Automation.serviceVo;

import com.ddrx.Api.Automation.commons.MockUpData;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class getAllBuyerListMakerAndCheckerVo {

	@MockUpData(type = "searchBuyerName")
	private String searchBuyerName;

	@MockUpData(type = "page")
	private String page;
	@MockUpData(type = "size")
	private String size;
}
