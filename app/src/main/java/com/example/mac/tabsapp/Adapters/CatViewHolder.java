package com.example.mac.tabsapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mac.tabsapp.R;

/**
 * Created by mac on 9‏/12‏/2016.
 */

public class CatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView catName;
    private ImageView catImage;
    ItemClickListner itemClickListner;


    public CatViewHolder(View itemView) {
        super(itemView);
        catImage=(ImageView) itemView.findViewById(R.id.catImageView);
        catName=(TextView) itemView.findViewById(R.id.catTextView);
         itemView.setOnClickListener(this);
    }

    public TextView getCatName() {
        return catName;
    }

    public void setCatName(TextView catName) {
        this.catName = catName;
    }

    public ImageView getCatImage() {
        return catImage;
    }

    public void setCatImage(ImageView catImage) {
        this.catImage = catImage;
    }

    public ItemClickListner getItemClickListner() {
        return itemClickListner;
    }

    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListner.onItemClick(v,getLayoutPosition());

    }




    public interface ItemClickListner {
        void onItemClick(View v, int pos);
    }
}