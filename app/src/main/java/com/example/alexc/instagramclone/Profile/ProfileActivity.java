package com.example.alexc.instagramclone.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.alexc.instagramclone.R;
import com.example.alexc.instagramclone.Utils.BottomNavigationViewHelper;
import com.example.alexc.instagramclone.Utils.GridImageAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    private static final int ACTIVITY_NUM = 4;

    private Context mContext = ProfileActivity.this;

    private ProgressBar mProgressBar;
    private ImageView profilePhoto;
    private static final int MUN_GRID_COLUMNS = 3;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: started");


        setupBottomNavigationView();
        setupToolbar();
        setupActivityWidgets();
        setProfileImage();

        tempGridSetup();
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.profileToolbar);
        setSupportActionBar(toolbar);

        ImageView profileMenu = findViewById(R.id.profileMenu);
//        profileMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d(TAG, "onClick: navigating to account settings");
//                Intent intent = new Intent(mContext, AccountSettingActivity.class);
//                startActivity(intent);
//            }
//        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                Log.d(TAG, "onMenuItemClick: clicked menu item");

                switch(item.getItemId()) {
                    case R.id.profileMenu:
                        Log.d(TAG, "onMenuItemClick: Navigating to Profile Preferences");
                        Intent intent = new Intent(mContext, AccountSettingActivity.class);
                        startActivity(intent);
                        break;
                }

                return false;
            }
        });
    }

    private void setupActivityWidgets() {
        mProgressBar = findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);
        profilePhoto = findViewById(R.id.profile_photo);
    }

    private void setProfileImage() {
        Log.d(TAG, "setProfileImage: setting profile photo.");
        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(profilePhoto);
    }

    private void setupImageGrid(ArrayList<String> imgURLs) {
        GridView gridView = findViewById(R.id.gridView);

        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int imageWidth = gridWidth/MUN_GRID_COLUMNS;
        gridView.setColumnWidth(imageWidth);

        GridImageAdapter adapter = new GridImageAdapter(mContext, R.layout.layout_grid_imageview,
                "", imgURLs);
        gridView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu, menu);
        return true;
    }

    private void tempGridSetup() {
        ArrayList<String> imgURLs = new ArrayList<>();
        imgURLs.add("https://cdn.shopify.com/s/files/1/0825/2951/files/Android-under-maintenance_1600x1600.png?v=1509371840");
        imgURLs.add("https://2.bp.blogspot.com/-2ZMkSo7CnUs/WvMvSK0u9RI/AAAAAAAAFZA/zJOCZ8LUM8ol3hcHYHwVyOpc3iiYaxquACLcBGAs/s1600/Jetpack_logo.png");
        imgURLs.add("https://tr2.cbsistatic.com/hub/i/r/2016/04/14/957569ba-49e0-4762-8a9b-032594d44404/resize/770x/e151fc109f851df34cf29116cdaddb9b/android-security-1.jpg");
        imgURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-Nx02HfBq_GRXRD_OoNW_pNy4YYlCKySAAd9MT68lwwcnaSR1-g");
        imgURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfqnbN--CdFXrLgPoqruoN__5Xcf7uX9D-jMRhSWC-SoQ6ZBWr");
        imgURLs.add("https://cdn.vox-cdn.com/thumbor/eVoUeqwkKQ7MFjDCgrPrqJP5ztc=/0x0:2040x1360/1200x800/filters:focal(860x1034:1186x1360)/cdn.vox-cdn.com/uploads/chorus_image/image/59377089/wjoel_180413_1777_android_001.1523625143.jpg");
        imgURLs.add("https://prod-discovery.edx-cdn.org/media/course/image/019dd154-cb89-4a24-aed5-f0b8db33d705-1becb8880fa8.small.jpg");
        imgURLs.add("https://cdn.wccftech.com/wp-content/uploads/2017/08/download-android-8.jpg");
        imgURLs.add("https://i.redd.it/9dbo7puxpy521.jpg");
        imgURLs.add("https://external-preview.redd.it/62rvPqVG-hWEi9q5M_bPy878XUAEuSl7H8ejsuWEBpE.jpg?auto=webp&s=6420851201a561c6d948d327912a8e257b39c9b7");
        imgURLs.add("https://i.redd.it/st8gdu6gcy521.jpg");
        imgURLs.add("https://i.redd.it/b20fxfimou521.jpg");



        setupImageGrid(imgURLs);
    }

    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
