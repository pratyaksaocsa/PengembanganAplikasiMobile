package com.ocsa.tutorialandroidgallery;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class SingleAlbumAdapter extends BaseAdapter {
    Activity activity;
    ArrayList<HashMap<String, String>> data;

    public SingleAlbumAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data = d;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SingleAlbumViewHolder holder = null;
        if(convertView == null) {
            holder = new SingleAlbumViewHolder();
            convertView = LayoutInflater.from(activity).inflate(R.layout.single_album_row, parent, false);

            holder.galleryImage = convertView.findViewById(R.id.galleryImage);

            convertView.setTag(holder);
        } else {
            holder = (SingleAlbumViewHolder) convertView.getTag();
        }

        holder.galleryImage.setId(position);

        HashMap<String, String> image = new HashMap<>();
        image = data.get(position);
        try {
            Glide.with(activity).load(new File(image.get(Function.KEY_PATH))).into(holder.galleryImage);
        } catch(Exception ex) {

        }

        return convertView;
    }
}

class SingleAlbumViewHolder {
    ImageView galleryImage;
}
