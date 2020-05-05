package com.company;

import com.company.model.CountryDetails;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


public class ApiConnector {
    private static Logger log = LogManager.getLogger(ApiConnector.class);
    private static final String URL_API_CORONA = "https://corona.lmao.ninja/v2/all";
    private CountryDetails countryDetails;
    private String json;

    public CountryDetails fetchCountryDetailsFromApi() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(URL_API_CORONA).build();
        String json = client.newCall(request).execute().body().string();
        CountryDetails countryDetails = new Gson().fromJson(json, CountryDetails.class);
        log.info("countryDetails JSON: " + countryDetails);
        return countryDetails;
    }

    public CountryDetails getCountryDetails() {
        return countryDetails;
    }

    public void setCountryDetails(CountryDetails countryDetails) {
        this.countryDetails = countryDetails;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
