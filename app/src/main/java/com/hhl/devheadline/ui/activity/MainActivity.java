package com.hhl.devheadline.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hhl.devheadline.R;
import com.hhl.devheadline.presenter.MainPresenter;
import com.hhl.devheadline.ui.fragment.HomeFragment;
import com.hhl.devheadline.ui.fragment.ShareFragment;
import com.hhl.devheadline.ui.iview.IMainView;

public class MainActivity extends BaseActivity<MainPresenter>
        implements NavigationView.OnNavigationItemSelectedListener, IMainView {

    private HomeFragment mHomeFragment;
    private ShareFragment mShareFragment;

    /**
     * 启动MainActivity
     *
     * @param context
     */
    public static void launch(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        SimpleDraweeView avatarView = (SimpleDraweeView) navigationView.getHeaderView(0).findViewById(R.id.sdv_avatar);
        if (avatarView != null) {
            avatarView.setImageURI(Uri.parse("https://avatars2.githubusercontent.com/u/4241807?v=3&s=460"));
        }

        //fragment Manager
        managerFragment(savedInstanceState);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected boolean isNeedToolbar() {
        return false;
    }

    /**
     * 管理Fragment
     *
     * @param savedInstanceState
     */
    private void managerFragment(Bundle savedInstanceState) {
        FragmentManager fm = getSupportFragmentManager();
        if (savedInstanceState == null) {
            mHomeFragment = HomeFragment.newInstance("1", "2");
            mShareFragment = ShareFragment.newInstance("3", "4");
            fm.beginTransaction().add(R.id.container, mHomeFragment)
                    .add(R.id.container, mShareFragment).commit();
        }

        fm.beginTransaction().hide(mShareFragment).show(mHomeFragment).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        if (id == R.id.nav_feedback) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    FeedbackActivity.launch(MainActivity.this);
                }
            }, 300);
        } else if (id == R.id.nav_setting) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    SettingActivity.launch(MainActivity.this);
                }
            }, 300);
        } else {
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().hide(mHomeFragment).hide(mShareFragment).commit();

            if (id == R.id.nav_home) {
                // Handle the camera action
                fm.beginTransaction().show(mHomeFragment).commit();
            } else if (id == R.id.nav_share) {
                fm.beginTransaction().show(mShareFragment).commit();
            } else if (id == R.id.nav_create_theme) {

            } else if (id == R.id.nav_subscrier_theme) {

            } else if (id == R.id.nav_favorite) {

            }
        }
        return true;
    }

}
