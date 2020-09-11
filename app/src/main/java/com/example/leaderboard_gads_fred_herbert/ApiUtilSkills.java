package com.example.leaderboard_gads_fred_herbert;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class ApiUtilSkills {

    private ApiUtilSkills(){}

    public static final String BASE_API_URL =
            "https://gadsapi.herokuapp.com";

    public static URL buildUrl () {
        String fullUrl = BASE_API_URL + "/api/skilliq";
        URL url = null;

        try {
            url = new URL(fullUrl);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return url;
    }

    public static String getJson(URL url) throws IOException {

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            InputStream stream = connection.getInputStream();
            Scanner scanner = new Scanner(stream);
            scanner.useDelimiter("\\A");
            boolean hasData = scanner.hasNext();
            if (hasData){
                return scanner.next();
            }
            else {
                return null;
            }
        }
        catch (Exception e){
            Log.d("Error",e.toString());
            return null;

        }
        finally {
            connection.disconnect();
        }


    }

    public static ArrayList<Skills> skillsArrayListFromjson (String json){
        final String ITEMS = "items";
        final String NAME = "name";

        final String COUNTRY = "country";
        final String HOURS = "score";
        final String BADGEURL = "badgeUrl";



        ArrayList<Skills> skills = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);


            for ( int i = 0; i < jsonArray.length(); i++){
                JSONObject o = jsonArray.getJSONObject(i);

                Skills skills1 = new Skills(
                        o.getString("name"),
                        o.getString("score"),
                        o.getString("country"),
                        o.getString("badgeUrl")
                );
                skills.add(skills1);
            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return skills;
    }
}
