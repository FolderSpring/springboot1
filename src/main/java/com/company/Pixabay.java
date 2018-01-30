package com.company;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;

public class Pixabay {

    /**
     * Function gets url by term from pixabay api
     *
     * @param searchTerm
     * @return
     * @throws Exception
     */
    public String getUrlByTerm(String searchTerm) throws Exception {
        String httpsURL = Constants.PIXABAY_URL + "api/?key=" + Constants.PIXABAY_KEY + "&q=" + searchTerm + "&image_type=photo&pretty=true";
        URL myUrl = new URL(httpsURL);
        HttpsURLConnection conn = (HttpsURLConnection) myUrl.openConnection();
        InputStream is = conn.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String inputLine;
        StringBuilder buffer = new StringBuilder();
        while ((inputLine = br.readLine()) != null) {
            buffer.append(inputLine);
        }
        br.close();

        return getWebformatUrlFrom(buffer);
    }

    /**
     * Function gets webformatURL value from received JSONObject that is in StringBuilder
     *
     * @param buffer
     * @return webformatURL
     * @throws JSONException
     */
    private String getWebformatUrlFrom(StringBuilder buffer) throws JSONException {
        JSONObject json = new JSONObject(buffer.toString());
        Iterator<String> keys = json.keys();
        String str_Name = keys.next();
        JSONArray jsonArray = json.optJSONArray(str_Name);
        JSONObject curImage = jsonArray.getJSONObject(0);
        return curImage.getString("webformatURL");
    }

}
