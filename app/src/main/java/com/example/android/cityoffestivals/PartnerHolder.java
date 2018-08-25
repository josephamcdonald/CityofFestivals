package com.example.android.cityoffestivals;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PartnerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final Context context;

    // Declare the current partner.
    private Partner currentPartner;

    // Declare the current item content views.
    private final ImageView itemImageView;
    private final TextView itemTextView1;
    private final TextView itemTextView2;
    private final TextView itemTextView3;

    public PartnerHolder(Context context, View itemView) {

        super(itemView);

        // Set the context.
        this.context = context;

        // Find and assign the subviews.
        this.itemImageView = itemView.findViewById(R.id.item_image);
        this.itemTextView1 = itemView.findViewById(R.id.item_text_content1);
        this.itemTextView2 = itemView.findViewById(R.id.item_text_content2);
        this.itemTextView3 = itemView.findViewById(R.id.item_text_content3);

        // Set the "onClick" listener to the item view.
        itemView.setOnClickListener(this);
    }

    public void bindPartner(Partner partner) {

        // This is the current partner in the list.
        this.currentPartner = partner;

        // Get and set the partner image.
        this.itemImageView.setImageResource(partner.getPartnerImageResId());

        // Get and set the partner name.
        this.itemTextView1.setText(partner.getPartnerName());

        if (partner.isFestival()) {
            // If this partner is indeed a festival, set textview2 with its festival date.
            this.itemTextView2.setText(partner.getFestDate());

        } else {
            // else set textview2 with the partner's attending festival.
            this.itemTextView2.setText(partner.getPartnerFest());
        }

        if (partner.isMusicAct()) {
            // If the current partner is a Music Act, set textview3 with the act's stage time.
            this.itemTextView3.setText(partner.getMusicTime());

        } else {
            // else set textview3 with the partner web URL.
            this.itemTextView3.setText(partner.getPartnerUrl());
        }
    }

    @Override
    public void onClick(View v) {

        if (currentPartner.isMusicAct()) {
            // Create Music Act showtime string for toasting.
            String toastMessage = context.getString(R.string.showtime_for) + currentPartner.getPartnerName() +
                    context.getString(R.string.is) + currentPartner.getMusicTime() + context.getString(R.string.enjoy_the_show);

            // Create the toast message and show it.
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();

        } else {
            // Create the toast message and show it.
            Toast.makeText(context, context.getString(R.string.loading) + currentPartner.getPartnerUrl() + context.getString(R.string.ellipse), Toast.LENGTH_SHORT).show();

            // Create intent for the partner URL and start it.
            Intent urlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(context.getString(R.string.http) + currentPartner.getPartnerUrl()));
            context.startActivity(urlIntent);
        }
    }
}