package com.example.event_fragment_iii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CommunicationListener {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        launchDetails();
    }

    private void launchDetails() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        EventDetailsFragment fragment = new EventDetailsFragment();
        fragmentTransaction.add(R.id.idcontaner,fragment,"EventDetail").commit();
    }

    @Override
    public void launchTimeAndDateFragment(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TimeAndDateFragment timeAndDateFragment = new TimeAndDateFragment();
        timeAndDateFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.idcontaner,timeAndDateFragment,"TimeAndDate").addToBackStack("").commit();
    }

    @Override
    public void launchPriceDetailFragment(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        PriceDetailsFragment priceDetailsFragment = new PriceDetailsFragment();
        priceDetailsFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.idcontaner,priceDetailsFragment,"priceDetailsFragment").addToBackStack("").commit();

    }
}