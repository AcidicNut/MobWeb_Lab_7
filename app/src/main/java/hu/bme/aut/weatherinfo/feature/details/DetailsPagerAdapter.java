package hu.bme.aut.weatherinfo.feature.details;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import hu.bme.aut.weatherinfo.R;

public class DetailsPagerAdapter extends FragmentPagerAdapter {
    private Context context;

    public DetailsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    // This method is called whenever the adapter needs a Fragment for a certain position
    @Override
    public Fragment getItem(int position) {
        Fragment ret = null;
        switch (position) {
            case 0:
                ret = new DetailsMainFragment();
                break;
            case 1:
                ret = new DetailsMoreFragment();
                break;
        }
        return ret;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title;
        switch (position) {
            case 0:
                title = context.getString(R.string.main);
                break;
            case 1:
                title = context.getString( R.string.details);
                break;
            default:
                title = "";
        }
        return title;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
