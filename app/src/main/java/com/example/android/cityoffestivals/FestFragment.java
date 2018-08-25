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

public class FestFragment extends Fragment {

    public FestFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Declare the fragment ArrayList.
        final ArrayList<Partner> partners = new ArrayList<>();

        // Populate the ArrayList.
        partners.add(new Partner(getString(R.string.pride_fest), getString(R.string.pride_fest_date), getString(R.string.pride_fest_url), R.drawable.pridefest));
        partners.add(new Partner(getString(R.string.polish_fest), getString(R.string.polish_fest_date), getString(R.string.polish_fest_url), R.drawable.polishfest));
        partners.add(new Partner(getString(R.string.summer_fest), getString(R.string.summer_fest_date), getString(R.string.summer_fest_url), R.drawable.summerfest));
        partners.add(new Partner(getString(R.string.festa_italiana), getString(R.string.festa_italiana_date), getString(R.string.festa_italiana_url), R.drawable.festaitaliana));
        partners.add(new Partner(getString(R.string.german_fest), getString(R.string.german_fest_date), getString(R.string.german_fest_url), R.drawable.germanfest));
        partners.add(new Partner(getString(R.string.black_arts_fest), getString(R.string.black_arts_fest_date), getString(R.string.black_arts_fest_url), R.drawable.blackartsfest));
        partners.add(new Partner(getString(R.string.irish_fest), getString(R.string.irish_fest_date), getString(R.string.irish_fest_url), R.drawable.irishfest));
        partners.add(new Partner(getString(R.string.mexican_fiesta), getString(R.string.mexican_fiesta_date), getString(R.string.mexican_fiesta_url), R.drawable.mexicanfiesta));
        partners.add(new Partner(getString(R.string.indian_summer_festival), getString(R.string.indian_summer_festival_date), getString(R.string.indian_summer_festival_url), R.drawable.indiansummer));
        partners.add(new Partner(getString(R.string.pet_fest), getString(R.string.pet_fest_date), getString(R.string.pet_fest_url), R.drawable.petfest));

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
