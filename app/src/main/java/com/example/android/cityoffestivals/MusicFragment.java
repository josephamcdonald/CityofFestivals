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

public class MusicFragment extends Fragment {

    public MusicFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Declare the fragment ArrayList.
        final ArrayList<Partner> partners = new ArrayList<>();

        // Populate the ArrayList.
        partners.add(new Partner(getString(R.string.chasing_lovely), getString(R.string.chasing_lovely_gig), R.drawable.chasinglovely, getString(R.string.chasing_lovely_time)));
        partners.add(new Partner(getString(R.string.faux_fiction), getString(R.string.faux_fiction_gig), R.drawable.fauxfiction, getString(R.string.faux_fiction_time)));
        partners.add(new Partner(getString(R.string.rat_pack_reprise), getString(R.string.rat_pack_reprise_gig), R.drawable.ratpackreprise, getString(R.string.rat_pack_reprise_time)));
        partners.add(new Partner(getString(R.string.anthony_crivello), getString(R.string.anthony_crivello_gig), R.drawable.anthonycrivello, getString(R.string.anthony_crivello_time)));
        partners.add(new Partner(getString(R.string.die_lauser), getString(R.string.die_lauser_gig), R.drawable.dielauser, getString(R.string.die_lauser_time)));
        partners.add(new Partner(getString(R.string.alte_kameraden), getString(R.string.alte_kameraden_gig), R.drawable.altekameraden, getString(R.string.alte_kameraden_time)));
        partners.add(new Partner(getString(R.string.calibre), getString(R.string.calibre_gig), R.drawable.calibre, getString(R.string.calibre_time)));
        partners.add(new Partner(getString(R.string.maquinaria), getString(R.string.maquinaria_gig), R.drawable.maquinaria, getString(R.string.maquinaria_time)));
        partners.add(new Partner(getString(R.string.aislinn_gagliardi), getString(R.string.aislinn_gagliardi_gig), R.drawable.aislinngagliardi, getString(R.string.aislinn_gagliardi_time)));
        partners.add(new Partner(getString(R.string.three_pints_gone), getString(R.string.three_pints_gone_gig), R.drawable.threepintsgone, getString(R.string.three_pints_gone_time)));

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
