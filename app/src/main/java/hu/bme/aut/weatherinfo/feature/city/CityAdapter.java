package hu.bme.aut.weatherinfo.feature.city;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.weatherinfo.R;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {

    private final List<String> cities;

    private OnCitySelectedListener listener;

    public interface OnCitySelectedListener {
        void onCitySelected(String city);
    }

    CityAdapter(OnCitySelectedListener listener) {
        this.listener = listener;
        cities = new ArrayList<>();
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        String item = cities.get(position);
        holder.nameTextView.setText(cities.get(position));
        holder.item = item;

    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public void addCity(String newCity) {
        cities.add(newCity);
        notifyItemInserted(cities.size() - 1);
    }

    public void removeCity(int position) {
        cities.remove(position);
        notifyItemRemoved(position);
        if (position < cities.size()) {
            notifyItemRangeChanged(position, cities.size() - position);
        }
    }

    class CityViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;

        Button removeButton;

        String item;

        CityViewHolder(View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.CityItemNameTextView);
            removeButton = itemView.findViewById(R.id.CityItemRemoveButton);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onCitySelected(item);
                    }
                }
            });
        }
    }
}