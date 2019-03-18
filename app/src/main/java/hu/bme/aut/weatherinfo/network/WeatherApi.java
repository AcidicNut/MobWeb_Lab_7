package hu.bme.aut.weatherinfo.network;

import hu.bme.aut.weatherinfo.model.WeatherData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("/data/2.5/weather")
    Call<WeatherData> getWeather(
            @Query("q") String cityName,
            @Query("units") String units,
            @Query("appid") String appId
    );
}
