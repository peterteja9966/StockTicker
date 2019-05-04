package com.example.group2.group2.utils;


import java.util.HashMap;

/**
 * Created by admin on 5/4/2019.
 */

public class Util {

    public static HashMap<String, String> getPrimaryList() {
        HashMap<String, String> companynamesprimary = new HashMap<>();
        companynamesprimary.put(Constants.ACCENTURE, Constants.ACCENTURE);
        companynamesprimary.put(Constants.BIRLA_SOFT, Constants.BIRLA_SOFT);
        companynamesprimary.put(Constants.HONEY_WELL, Constants.HONEY_WELL);
        companynamesprimary.put(Constants.INFOSYS, Constants.INFOSYS);
        companynamesprimary.put(Constants.TATA, Constants.TATA);
        companynamesprimary.put(Constants.DBS, Constants.DBS);
        companynamesprimary.put(Constants.HDFC, Constants.HDFC);
        companynamesprimary.put(Constants.SBI, Constants.SBI);
        companynamesprimary.put(Constants.CITIBANK, Constants.CITIBANK);
        companynamesprimary.put(Constants.PROKARMA, Constants.PROKARMA);
        return companynamesprimary;
    }

    public static HashMap<String, String> getSecondaryList() {
        HashMap<String, String> companynamessecondary = new HashMap<>();
        companynamessecondary.put(Constants.DBS, Constants.DBS);
        companynamessecondary.put(Constants.HDFC, Constants.HDFC);
        companynamessecondary.put(Constants.SBI, Constants.SBI);
        companynamessecondary.put(Constants.CITIBANK, Constants.CITIBANK);
        companynamessecondary.put(Constants.PROKARMA, Constants.PROKARMA);
        return companynamessecondary;
    }

    public static HashMap<String, String> getCompanyList() {
        HashMap<String, String> companynamessecondary = new HashMap<>();
        companynamessecondary.put(Constants.HONEY_WELL, "HON");
        companynamessecondary.put(Constants.HDFC, Constants.HDFC);
        companynamessecondary.put(Constants.SBI, Constants.SBI);
        companynamessecondary.put(Constants.CITIBANK, Constants.CITIBANK);
        companynamessecondary.put(Constants.PROKARMA, Constants.PROKARMA);
        return companynamessecondary;
    }

}
