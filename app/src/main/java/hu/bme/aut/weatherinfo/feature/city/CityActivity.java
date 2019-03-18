package hu.bme.aut.weatherinfo.feature.city;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import hu.bme.aut.weatherinfo.R;
import hu.bme.aut.weatherinfo.feature.details.DetailsActivity;

public class CityActivity extends AppCompatActivity
        implements CityAdapter.OnCitySelectedListener, AddCityDialogFragment.AddCityDialogListener {

    private RecyclerView recyclerView;
    private CityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        initFab();
        initRecyclerView();
    }

    private void initFab() {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AddCityDialogFragment()
                        .show(getSupportFragmentManager(), AddCityDialogFragment.class.getSimpleName());
            }
        });
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.MainRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CityAdapter(this);
        adapter.addCity("Budapest");
        adapter.addCity("Debrecen");
        adapter.addCity("Sopron");
        adapter.addCity("Szeged");
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onCitySelected(String city) {
        Intent showDetailsIntent = new Intent();
        showDetailsIntent.setClass(CityActivity.this, DetailsActivity.class);
        showDetailsIntent.putExtra( DetailsActivity.EXTRA_CITY_NAME, city);
        startActivity(showDetailsIntent);
    }

    @Override
    public void onCityAdded(String city) {
        adapter.addCity(city);
    }
}