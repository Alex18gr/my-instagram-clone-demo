package com.example.alexc.instagramclone.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.alexc.instagramclone.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class GridImageAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private LayoutInflater mInflater;
    private int layoutResource;
    private String mAppend;
    private ArrayList<String> imgURLs;

    public GridImageAdapter(@NonNull Context context, int layoutResource,
                            String mAppend,@NonNull ArrayList<String> imgURLs) {
        super(context, layoutResource, imgURLs);
        this.mContext = context;
        this.layoutResource = layoutResource;
        this.mAppend = mAppend;
        this.imgURLs = imgURLs;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder holder;

        if(convertView == null) {
            convertView = mInflater.inflate(layoutResource, parent, false);
            holder = new ViewHolder();
            holder.image = convertView.findViewById(R.id.gridImageView);
            holder.mProgressBar = convertView.findViewById(R.id.gridImageProgressbar);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String imgURL = getItem(position);

//        ImageLoader imageLoader = ImageLoader.getInstance();
//        imageLoader.displayImage(imgURL, holder.image, new ImageLoadingListener() {
//            @Override
//            public void onLoadingStarted(String imageUri, View view) {
//                if(holder.mProgressBar != null) {
//                    holder.mProgressBar.setVisibility(View.VISIBLE);
//                }
//            }
//
//            @Override
//            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
//                if(holder.mProgressBar != null) {
//                    holder.mProgressBar.setVisibility(View.GONE);
//                }
//            }
//
//            @Override
//            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
//                if(holder.mProgressBar != null) {
//                    holder.mProgressBar.setVisibility(View.GONE);
//                }
//            }
//
//            @Override
//            public void onLoadingCancelled(String imageUri, View view) {
//                if(holder.mProgressBar != null) {
//                    holder.mProgressBar.setVisibility(View.GONE);
//                }
//            }
//        });
        Picasso.get().load(imgURL).into(holder.image);
        holder.mProgressBar.setVisibility(View.GONE);

        return convertView;
    }

    private static class ViewHolder {
        ImageView image;
        ProgressBar mProgressBar;

    }
}
