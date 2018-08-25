package com.example.android.cityoffestivals;

/*
 * Grow With Google Challenge Scholarship: Android Basics
 * Project: 5
 * Version: 1.0
 * App Name: City of Festivals
 * Author: Joseph McDonald
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class SponsorFragment extends Fragment {

    public SponsorFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Declare the fragment ArrayList.
        final ArrayList<Partner> partners = new ArrayList<>();

        // Populate the ArrayList.
        partners.add(new Partner(getString(R.string.klements), R.drawable.klements, getString(R.string.klements_sponsors), getString(R.string.klements_url)));
        partners.add(new Partner(getString(R.string.harley_davidson), R.drawable.harleydavidson, getString(R.string.harley_davidson_sponsors), getString(R.string.harley_davidson_url)));
        partners.add(new Partner(getString(R.string.usingers), R.drawable.usingers, getString(R.string.usingers_sponsors), getString(R.string.usingers_url)));
        partners.add(new Partner(getString(R.string.potawatomi_hotel_casino), R.drawable.potawatomi, getString(R.string.potawatomi_hotel_casino_sponsors), getString(R.string.potawatomi_hotel_casino_url)));
        partners.add(new Partner(getString(R.string.cedar_crest_ice_cream), R.drawable.cedarcrest, getString(R.string.cedar_crest_ice_cream_sponsors), getString(R.string.cedar_crest_ice_cream_url)));
        partners.add(new Partner(getString(R.string.gilles_frozen_custard), R.drawable.gilles, getString(R.string.gilles_frozen_custard_sponsors), getString(R.string.gilles_frozen_custard_url)));
        partners.add(new Partner(getString(R.string.el_rey_grocery), R.drawable.elrey, getString(R.string.el_rey_grocery_sponsors), getString(R.string.el_rey_grocery_url)));
        partners.add(new Partner(getString(R.string.potawatomi_foundation), R.drawable.potawatomifoundation, getString(R.string.potawatomi_foundation_sponsors), getString(R.string.potawatomi_foundation_url)));
        partners.add(new Partner(getString(R.string.sendiks_food_market), R.drawable.sendiks, getString(R.string.sendiks_food_market_sponsors), getString(R.string.sendiks_food_market_url)));
        partners.add(new Partner(getString(R.string.central_bark_doggie_day_care), R.drawable.centralbark, getString(R.string.central_bark_doggie_day_care_sponsors), getString(R.string.central_bark_doggie_day_care_url)));

        // Create the Adapter.
        PartnerAdapter partnerAdapter = new PartnerAdapter(getActivity(), R.layout.fragment_item, partners);

        // Find the root view item layout.
        View rootView = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Assign the root view to the recycler view.
        RecyclerView listView = rootView.findViewById(R.id.item_list);

        // For performance, tell RecyclerView its size is fixed.
        listView.setHasFixedSize(true);

        // Declare and set the layout manager.
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        listView.setLayoutManager(layoutManager);

        // Declare and set item divider drawable.
        DividerItemDecoration divider = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(getResources().getDrawable(R.drawable.divider));
        listView.addItemDecoration(divider);

        // Set the Adapter to the list view.
        listView.setAdapter(partnerAdapter);

        return rootView;
    }
}
