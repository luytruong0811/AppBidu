package com.example.appbidu.Adapter;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.appbidu.R;
import com.example.appbidu.model.RatingShop;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class AdapterRatingUser extends RecyclerView.Adapter<AdapterRatingUser.RatingViewHodel> {
    private Context context;

    private List<RatingShop> listRatingShop;

    public AdapterRatingUser(Context context,List<RatingShop> listRatingShop) {
        this.context = context;
        this.listRatingShop = listRatingShop;
    }

    public void setListData(List<RatingShop> listRatingShop) {
        this.listRatingShop = listRatingShop;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RatingViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer_rating,parent,false);
        return new RatingViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RatingViewHodel holder, int position) {
        holder.setIsRecyclable(false);
        RatingShop ratingShop = listRatingShop.get(position);
        holder.imageViewUser.setImageResource(ratingShop.getImageCircleUser());
        holder.tvNameUser.setText(ratingShop.getNameUser());
        holder.tvDateTime.setText(ratingShop.getDateTime());
        holder.ratingBar.setRating(ratingShop.getRatingUser());
        if(ratingShop.getImageProducts()==null){
            holder.rvImage.setVisibility(View.GONE);
        }else {
            AdapterImageView adapterImageView = new AdapterImageView(ratingShop.getImageProducts());
            holder.rvImage.setHasFixedSize(true);
            LinearLayoutManager linearLayoutManager =new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
            holder.rvImage.setLayoutManager(linearLayoutManager);
            holder.rvImage.setAdapter(adapterImageView);
        }


        holder.tvdescripTion.setText(ratingShop.getDescription());
        holder.tvdescripTion.post(new Runnable() {
            @Override
            public void run() {
                int lineCnt = holder.tvdescripTion.getLineCount();
                if(lineCnt < 4) holder.tvseemore.setVisibility(View.GONE);
                holder.tvseemore.setOnClickListener(v -> {
                    holder.tvseemore.setVisibility(View.GONE);
                    holder.tvdescripTion.setMaxLines(Integer.MAX_VALUE);
                });
            }
        });

        if(ratingShop.getCommentClient()==null){
            holder.constraintLayout.setVisibility(View.GONE);
        }else {
            holder.tvNameShop.setText(ratingShop.getNameShop());
            holder.tvComment.setText(ratingShop.getCommentClient());
        }
    }



    @Override
    public int getItemCount() {
        return listRatingShop.size();
    }

    public class RatingViewHodel extends RecyclerView.ViewHolder {
        private CircleImageView imageViewUser;
        private TextView tvNameUser;
        private TextView tvDateTime;
        private RatingBar ratingBar;
        private RecyclerView rvImage;
        private TextView tvdescripTion,tvseemore;
        private TextView tvNameShop;
        private TextView tvComment;
        private ConstraintLayout constraintLayout;
        public RatingViewHodel(@NonNull View itemView) {
            super(itemView);
            imageViewUser = itemView.findViewById(R.id.circleImageView);
            tvNameUser = itemView.findViewById(R.id.tvnameUser);
            tvDateTime = itemView.findViewById(R.id.tvdateTime);
            ratingBar = itemView.findViewById(R.id.ratingUser);
            rvImage = itemView.findViewById(R.id.rvListImage);
            tvdescripTion = itemView.findViewById(R.id.tvdecripTion);
            tvNameShop = itemView.findViewById(R.id.tvNameShop);
            tvComment = itemView.findViewById(R.id.tvCommentitem);
            tvseemore = itemView.findViewById(R.id.tvSeeMore);
            constraintLayout = itemView.findViewById(R.id.cardViewComment1);
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
