package com.ddrx.Api.Automation.serviceVo;

public class BuyerlistVo {

    public static void generatedynamiCheckerVodatafor() {
         addBuyerRequestVo buyer = BuyerDetailsFactory.generateBuyerdetails();

        
        getAllBuyerListMakerAndCheckerVo buyerlist = getAllBuyerListMakerAndCheckerVo.builder().build();
        buyerlist.setSearchBuyerName(buyer.getcompanyName());

        System.out.println("Searching Buyers with Company Name: " + buyerlist.getSearchBuyerName());
    }
}
