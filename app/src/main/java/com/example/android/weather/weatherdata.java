package com.example.android.weather;

import org.json.JSONException;
import org.json.JSONObject;

public class weatherdata {

    private String mTemperatue, micon, mcity, mWeatherType;
    private int mCondition;

    public static weatherdata fromJson(JSONObject jsonObject)
    {
        try
        {
            weatherdata weatherD=new weatherdata();
            weatherD.mcity=jsonObject.getString("name");
            weatherD.mCondition=jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherD.mWeatherType=jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            weatherD.micon=updateWeatherIcon(weatherD.mCondition);
            double tempResult = jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundValue=(int)Math.rint(tempResult);
            weatherD.mTemperatue=Integer.toString(roundValue);
            return weatherD;
        }
        catch (JSONException e)
        {
            e.printStackTrace();
            return  null;
        }


    }

    private static String updateWeatherIcon(int condition) {
        if (condition >= 0 && condition <= 300) {
            return "thunderstorm1";
        }
        else if (condition >= 300 && condition <= 500)
        {
            return "rain";
        }
        else if (condition >= 500 && condition <= 600)
        {
            return "shower";
        }
        else if (condition >= 600 && condition <= 700)
        {
            return "snow2";
        }
        else if (condition >= 701 && condition <= 771)
        {
            return "fog";
        }
        else if (condition >= 772 && condition <= 800)
        {
            return "overcast";
        }
        else if (condition==800)
        {
            return "sunny";
        }
        else if (condition >= 801 && condition <= 804)
        {
            return "cloudy";
        }
        else if (condition >= 900 && condition <= 902)
        {
            return "thunderstorm1";
        }
        else if (condition == 903)
        {
            return "snow1";
        }

        else if (condition==904)
        {
            return "sunny";
        }
        else if (condition >= 900 && condition <= 1000)
        {
            return "thunderstorm2";
        }

        return "dunno";

     }

    public String getmTemperatue() {
        return mTemperatue+"°C";
    }

    public String getMicon() {
        return micon;
    }

    public String getMcity() {
        return mcity;
    }

    public String getmWeatherType() {
        return mWeatherType;
    }
}
