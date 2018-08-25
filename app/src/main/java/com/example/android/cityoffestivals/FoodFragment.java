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

public class FoodFragment extends Fragment {

    public FoodFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Declare the fragment ArrayList.
        final ArrayList<Partner> partners = new ArrayList<>();

        // Populate the ArrayList.
        partners.add(new Partner(getString(R.string.koepsells_popcorn), R.drawable.koepsells, getString(R.string.koepsells_popcorn_serves), getString(R.string.koepsells_popcorn_url)));
        partners.add(new Partner(getString(R.string.maders), R.drawable.maders, getString(R.string.maders_serves), getString(R.string.maders_url)));
        partners.add(new Partner(getString(R.string.chubbys_cheesesteaks), R.drawable.chubbys, getString(R.string.chubbys_cheesesteaks_serves), getString(R.string.chubbys_cheesesteaks_url)));
        partners.add(new Partner(getString(R.string.cousins_subs), R.drawable.cousinssubs, getString(R.string.cousins_subs_serves), getString(R.string.cousins_subs_url)));
        partners.add(new Partner(getString(R.string.wein_bauer_inc), R.drawable.weinbauer, getString(R.string.wein_bauer_inc_serves), getString(R.string.wein_bauer_inc_url)));
        partners.add(new Partner(getString(R.string.sazs), R.drawable.sazs, getString(R.string.sazs_serves), getString(R.string.sazs_url)));
        partners.add(new Partner(getString(R.string.peter_sciortino_bakery), R.drawable.petersciortino, getString(R.string.peter_sciortino_bakery_serves), getString(R.string.peter_sciortino_bakery_url)));
        partners.add(new Partner(getString(R.string.cider_boys), R.drawable.ciderboys, getString(R.string.cider_boys_serves), getString(R.string.cider_boys_url)));
        partners.add(new Partner(getString(R.string.lakefront_brewery), R.drawable.lakefront, getString(R.string.lakefront_brewery_serves), getString(R.string.lakefront_brewery_url)));
        partners.add(new Partner(getString(R.string.sprecher_brewery), R.drawable.sprecher, getString(R.string.sprecher_brewery_serves), getString(R.string.sprecher_brewery_url)));

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
