package hu.bme.aut.weatherinfo.feature.details;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hu.bme.aut.weatherinfo.R;
import hu.bme.aut.weatherinfo.model.WeatherData;

public class DetailsMoreFragment extends Fragment {
    private TextView tvTemperature;

    private TextView tvMinTemp;

    private TextView tvMaxTemp;

    private TextView tvPressure;

    private TextView tvHumidity;

    private WeatherDataHolder weatherDataHolder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity() instanceof WeatherDataHolder) {
            weatherDataHolder = (WeatherDataHolder) getActivity();
        } else {
            throw new RuntimeException("Activity must implement WeatherDataHolder interface!");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_details_more,
                container, false);
        tvTemperature = view.findViewById(R.id.tvTemperature);
        tvMinTemp = view.findViewById(R.id.tvMinTemp);
        tvMaxTemp = view.findViewById(R.id.tvMaxTemp);
        tvPressure = view.findViewById(R.id.tvPressure);
        tvHumidity = view.findViewById(R.id.tvHumidity);
        if (weatherDataHolder.getWeatherData() != null) {
            showWeatherData();
        }
        return view;
    }

    private void showWeatherData() {
        WeatherData weatherData = weatherDataHolder.getWeatherData();
        tvTemperature.setText("" + weatherData.main.temp);
        tvMinTemp.setText("" + weatherData.main.temp_min);
        tvMaxTemp.setText("" + weatherData.main.temp_max);
        tvPressure.setText("" + weatherData.main.pressure);
        tvHumidity.setText("" + weatherData.main.humidity);
    }
}
