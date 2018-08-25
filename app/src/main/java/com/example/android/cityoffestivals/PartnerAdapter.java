package com.example.android.cityoffestivals;

/*
 * Grow With Google Challenge Scholarship: Android Basics
 * Project: 5
 * Version: 1.0
 * App Name: City of Festivals
 * Author: Joseph McDonald
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PartnerAdapter extends RecyclerView.Adapter<PartnerHolder> {

    private final Context context;
    private final int itemResource;
    private final ArrayList<Partner> partners;

    public PartnerAdapter(Context context, int itemResource, ArrayList<Partner> partners) {

        this.context = context;
        this.itemResource = itemResource;
        this.partners = partners;
    }

    @NonNull
    @Override
    public PartnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Inflate the view and return the new ViewHolder.
        View view = LayoutInflater.from(parent.getContext())
                .inflate(this.itemResource, parent, false);
        return new PartnerHolder(this.context, view);
    }

    @Override
    public void onBindViewHolder(@NonNull PartnerHolder holder, int position) {

        // Use position to access the correct Partner object.
        Partner partner = this.partners.get(position);

        // Bind the partner object to the holder.
        holder.bindPartner(partner);
    }

    @Override
    public int getItemCount() {

        return this.partners.size();
    }
}