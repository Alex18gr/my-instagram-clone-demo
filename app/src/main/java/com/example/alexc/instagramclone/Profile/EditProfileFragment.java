package com.example.alexc.instagramclone.Profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.alexc.instagramclone.R;
import com.example.alexc.instagramclone.Utils.UniversalImageLoader;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EditProfileFragment extends Fragment {

    private static final String TAG = "EditProfileFragment";

    private ImageView mProfilePhoto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);

        mProfilePhoto = view.findViewById(R.id.profile_photo);

        //setProfilePhotoPicasso();
        setProfileImage();

        // back arrow for nav igatinf back to ProfileActivity
        ImageView backArrow = view.findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: navigatin back to ProfileActivity");
                getActivity().finish();
            }
        });

        return view;
    }



    private void setProfileImage() {
        Log.d(TAG, "setProfileImage: setting profile image.");
        String imageURL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT53NtcTb2rgVG3o4iFYQ1fiko5Q_pc50CGYHmuBfiHmq7u_GnW";
        UniversalImageLoader.setImage(imageURL, mProfilePhoto, null, "");
    }

    private void setProfilePhotoPicasso() {
        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(mProfilePhoto);
    }


}
