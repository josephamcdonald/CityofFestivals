package com.example.android.cityoffestivals;

/*
 * Grow With Google Challenge Scholarship: Android Basics
 * Project: 5
 * Version: 1.0
 * App Name: City of Festivals
 * Author: Joseph McDonald
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private View main_content_view;
    private Fragment chosenFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the main content view.
        main_content_view = findViewById(R.id.main_content);

        // Setup Toolbar.
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setup navigation drawer and its open/close toggle.
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // Setup NavigationView.
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        // If drawer is open, close it.
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        // Declare fragment transaction.
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        switch (item.getItemId()) {
            case R.id.nav_home:
                // Choose "Home" to remove any Fragment, show the main content view, update title.
                if (chosenFragment != null) {
                    ft.remove(chosenFragment).commit();
                    chosenFragment = null;
                    main_content_view.setVisibility(View.VISIBLE);
                    toolbar.setTitle(getString(R.string.app_name));
                }
                break;

            case R.id.nav_fest:
                // Choose "Festivals" to remove main content view, launch FestFragment, update title.
                main_content_view.setVisibility(View.GONE);
                chosenFragment = new FestFragment();
                toolbar.setTitle(getString(R.string.fest));
                break;

            case R.id.nav_music:
                // Choose "Entertainment" to remove main content view, launch MusicFragment, update title.
                main_content_view.setVisibility(View.GONE);
                chosenFragment = new MusicFragment();
                toolbar.setTitle(getString(R.string.music));
                break;

            case R.id.nav_food:
                // Choose "Food/Drink" to remove main content view, launch FoodFragment, update title.
                main_content_view.setVisibility(View.GONE);
                chosenFragment = new FoodFragment();
                toolbar.setTitle(getString(R.string.food));
                break;

            case R.id.nav_sponsor:
                // Choose "Sponsors" to remove main content view, launch SponsorFragment, update title.
                main_content_view.setVisibility(View.GONE);
                chosenFragment = new SponsorFragment();
                toolbar.setTitle(getString(R.string.sponsor));
                break;

            case R.id.nav_share:
                // Choose "Share" to create ACTION_SEND Intent and start it.
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_message));
                shareIntent.setType(getString(R.string.text_plain));
                startActivity(shareIntent);
                break;

            case R.id.nav_send:
                // Choose "Send" to create ACTION_SENDTO Intent and start it.
                Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
                sendIntent.setData(Uri.parse(getString(R.string.mailto)));
                sendIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.its_festival_time));
                sendIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_message));

                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);
                }
                break;
        }

        // If any destination is chosen except "Home", replace the current Fragment with the chosen Fragment.
        if (chosenFragment != null) {
            ft.replace(R.id.frame_layout_content, chosenFragment).commit();
        }

        // Close the drawer after selecting a destination.
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
