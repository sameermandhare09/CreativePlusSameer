package com.example.creativeplussameer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Country {

    @SerializedName("lst_CountryData")
    @Expose
    private List<LstCountryDatum> lstCountryData = null;

    public List<LstCountryDatum> getLstCountryData() {
        return lstCountryData;
    }

    public void setLstCountryData(List<LstCountryDatum> lstCountryData) {
        this.lstCountryData = lstCountryData;
    }
    public class LstCountryDatum {

        @SerializedName("Country")
        @Expose
        private String country;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

    }

}

