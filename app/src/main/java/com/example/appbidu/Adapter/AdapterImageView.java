package com.example.appbidu.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbidu.R;
import com.example.appbidu.model.ImageProduct;

import java.util.List;

public class AdapterImageView extends RecyclerView.Adapter<AdapterImageView.ImageViewhodel> {
    private final List<ImageProduct> listImagePR;

    public AdapterImageView(List<ImageProduct> listImagePR) {
        this.listImagePR = listImagePR;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageViewhodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_imageview,parent,false);
        return new ImageViewhodel(view);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ImageViewhodel holder, int position) {
        ImageProduct imageProduct = listImagePR.get(position);
        holder.imageView.setImageResource(imageProduct.getImageView());
        if(position == 4){
            holder.tvMore.setText("+"+(listImagePR.size()-4));
            holder.tvMore.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class ImageViewhodel extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView tvMore;
        public ImageViewhodel(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tvMore = itemView.findViewById(R.id.tvMore);
        }
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
