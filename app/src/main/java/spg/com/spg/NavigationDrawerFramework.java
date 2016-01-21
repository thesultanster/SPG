package spg.com.spg;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class NavigationDrawerFramework extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //NAVIGATION DRAWER VARIABLES
    //TOOLBAR VARIABLES
    private static final long DRAWER_CLOSE_DELAY_MS = 250;
    private static final String NAV_ITEM_ID = "navItemId";
    private final Handler mDrawerActionHandler = new Handler();
    private DrawerLayout mDrawerLayout;
    private View mHeaderLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private int mNavItemId;
    private NavigationView navigationView;

    protected FrameLayout mContent;
    protected Toolbar toolbar;

    boolean isEmployer = false;

    @Override
    public void setContentView(final int layoutResID) {


        mDrawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.framework_navigation_drawer, null);

        mContent = (FrameLayout) mDrawerLayout.findViewById(R.id.content);

        // Setting the content of layout your provided to the content frame
        getLayoutInflater().inflate(layoutResID, mContent, true);
        super.setContentView(mDrawerLayout);

        // Setting header variables
        mHeaderLayout = getLayoutInflater().inflate(R.layout.framework_navigation_header, null);


        // Setting toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null)
            setSupportActionBar(toolbar);

        // listen for navigation events
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);

        // set up the hamburger icon to open and close the drawer
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

    }


    // Navigation Drawer Code /===========================================================================
    //====================================================================================================

    @Override
    public boolean onNavigationItemSelected(final MenuItem menuItem) {
        // Update highlighted item in the navigation menu
        menuItem.setChecked(true);
        mNavItemId = menuItem.getItemId();

        // Allow some time after closing the drawer before performing real navigation
        // So the user can see what is happening
        mDrawerLayout.closeDrawer(GravityCompat.START);
        mDrawerActionHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, DRAWER_CLOSE_DELAY_MS);
        return true;
    }

    @Override
    public void onConfigurationChanged(final Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == android.support.v7.appcompat.R.id.home) {
            return mDrawerToggle.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(NAV_ITEM_ID, mNavItemId);
    }


    //====================================================================================================


    protected ActionBar getToolbar() {
        return getSupportActionBar();
    }


}
