package hu.bme.aut.weatherinfo.network;

import hu.bme.aut.weatherinfo.model.WeatherData;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {

    private static final String SERVICE_URL = "https://api.openweathermap.org";
    private static final String APP_ID = "3b163e8a4dfd4b8cb94b63fa7de40b7e";

    private static NetworkManager instance;

    public static NetworkManager getInstance() {
        if (instance == null) {
            instance = new NetworkManager();
        }
        return instance;
    }

    private Retrofit retrofit;
    private WeatherApi weatherApi;

    private NetworkManager() {
        retrofit = new Retrofit.Builder()
                .baseUrl(SERVICE_URL)
                .client(new OkHttpClient.Builder().build())
                .addConverterFactory( GsonConverterFactory.create())
                .build();
        weatherApi = retrofit.create(WeatherApi.class);
    }

    public Call<WeatherData> getWeather(String city) {
        return weatherApi.getWeather(city, "metric", APP_ID);
    }
}
