package com.example.appbidu.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appbidu.Adapter.AdapterRatingUser;
import com.example.appbidu.R;
import com.example.appbidu.model.RatingShop;
import com.example.appbidu.viewmodel.ViewmodelRating;

import java.util.ArrayList;
import java.util.List;

import static com.example.appbidu.R.drawable.customer_textview_category;
import static com.example.appbidu.R.drawable.customer_textview_category_click;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewmodelRating viewmodelRating;
    private RecyclerView recyclerView;
    private List<RatingShop> mlistTemp;
    private AdapterRatingUser adapterRatingUser;
    private TextView tvAll,tvComment,tvMedia,tv5,tv4,tv3,tv2,tv1;
    private ConstraintLayout ctrboxstar1,ctrboxstar2,ctrboxstar3,ctrboxstar4,ctrboxstar5;
    private TextView tvNoneRating;
    private ImageView imageViewStar;
    private String mCategory = "All";
    private Integer numberStar =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        recyclerView = findViewById(R.id.rvRatingShop);
        recyclerView.setHasFixedSize(true);
        viewmodelRating = new ViewModelProvider(this).get(ViewmodelRating.class);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        viewmodelRating.getListRatingLiveData().observe(this,ratingShops -> {
            if(ratingShops.size() == 0){
                recyclerView.setVisibility(View.INVISIBLE);
                imageViewStar.setVisibility(View.VISIBLE);
                tvNoneRating.setVisibility(View.VISIBLE);
            }
            else{
                recyclerView.setVisibility(View.VISIBLE);
                imageViewStar.setVisibility(View.INVISIBLE);
                tvNoneRating.setVisibility(View.INVISIBLE);
                mlistTemp =new ArrayList<>();
                mlistTemp.addAll(ratingShops);
                if(adapterRatingUser == null ){
                    adapterRatingUser = new AdapterRatingUser(this,ratingShops);
                    recyclerView.setAdapter(adapterRatingUser);
                }
                adapterRatingUser.setListData(ratingShops);
            }
        });
    }

    private void init() {
        tvNoneRating = findViewById(R.id.tvnoneRating);
        imageViewStar = findViewById(R.id.imageViewStar);
        tvAll = findViewById(R.id.tvALL);
        tvComment =findViewById(R.id.tvComment);
        tvMedia = findViewById(R.id.tvMedia);
        ctrboxstar1 = findViewById(R.id.boxStar1);
        ctrboxstar2 = findViewById(R.id.boxStar2);
        ctrboxstar3 = findViewById(R.id.boxStar3);
        ctrboxstar4 = findViewById(R.id.boxStar4);
        ctrboxstar5 = findViewById(R.id.boxStar5);
        tv1= findViewById(R.id.tvcount1);
        tv2 = findViewById(R.id.tvcount2);
        tv3 = findViewById(R.id.tvcount3);
        tv4 = findViewById(R.id.tvcount4);
        tv5 = findViewById(R.id.tvcount5);
        tvAll.setOnClickListener(this);
        tvComment.setOnClickListener(this);
        tvMedia.setOnClickListener(this);
        ctrboxstar1.setOnClickListener(this);
        ctrboxstar2.setOnClickListener(this);
        ctrboxstar3.setOnClickListener(this);
        ctrboxstar4.setOnClickListener(this);
        ctrboxstar5.setOnClickListener(this);
    }


    @SuppressLint({"ResourceAsColor", "NonConstantResourceId"})
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvALL:
                selectedButton(tvAll, tvComment, tvMedia,ctrboxstar1,ctrboxstar2,ctrboxstar3,ctrboxstar4,ctrboxstar5,tv1,tv2,tv3,tv4,tv5);
                mCategory = "All";
                viewmodelRating.updateData2(mCategory);
                break;
            case R.id.tvComment:
                selectedButton(tvComment, tvAll, tvMedia, ctrboxstar1,ctrboxstar2,ctrboxstar3,ctrboxstar4,ctrboxstar5,tv1,tv2,tv3,tv4,tv5);
                mCategory = "Comment";
                viewmodelRating.updateData2(mCategory);
                break;
            case R.id.tvMedia:
                selectedButton(tvMedia, tvComment, tvAll, ctrboxstar1,ctrboxstar2,ctrboxstar3,ctrboxstar4,ctrboxstar5,tv1,tv2,tv3,tv4,tv5);
                mCategory = "Media";
                viewmodelRating.updateData2(mCategory);
                break;
            case R.id.boxStar1:
                numberStar = 1;
                selectedButtonStar(ctrboxstar1,ctrboxstar2,ctrboxstar3,ctrboxstar4,ctrboxstar5,tv1,tv2,tv3,tv4,tv5, tvMedia, tvComment, tvAll);
//                viewmodelRating.updateData(numberStar,mCategory);
                viewmodelRating.updateData3(numberStar);
                break;
            case R.id.boxStar2:
                numberStar =2;
                selectedButtonStar(ctrboxstar2,ctrboxstar1,ctrboxstar3,ctrboxstar4,ctrboxstar5,tv2,tv1,tv3,tv4,tv5, tvMedia, tvComment, tvAll);
//                viewmodelRating.updateData(numberStar,mCategory);
                viewmodelRating.updateData3(numberStar);
                break;
            case R.id.boxStar3:
                numberStar =3;
                selectedButtonStar(ctrboxstar3,ctrboxstar2,ctrboxstar1,ctrboxstar4,ctrboxstar5,tv3,tv2,tv1,tv4,tv5, tvMedia, tvComment, tvAll);
//                viewmodelRating.updateData(numberStar,mCategory);
                viewmodelRating.updateData3(numberStar);
                break;
            case R.id.boxStar4:
                numberStar =4;
                selectedButtonStar(ctrboxstar4,ctrboxstar3,ctrboxstar2,ctrboxstar1,ctrboxstar5,tv4,tv3,tv2,tv1,tv5, tvMedia, tvComment, tvAll);
//                viewmodelRating.updateData(numberStar,mCategory);
                viewmodelRating.updateData3(numberStar);
                break;
            case R.id.boxStar5:
                numberStar = 5;
                selectedButtonStar(ctrboxstar5,ctrboxstar4,ctrboxstar3,ctrboxstar2,ctrboxstar1,tv5,tv4,tv3,tv2,tv1, tvMedia, tvComment, tvAll);
//                viewmodelRating.updateData(numberStar,mCategory);
                viewmodelRating.updateData3(numberStar);
                break;
        }
    }

    private void selectedButton(TextView tvAll, TextView tvComment, TextView tvMedia, ConstraintLayout ctStar1, ConstraintLayout ctStar2, ConstraintLayout ctStar3,ConstraintLayout ctStar4,ConstraintLayout ctStar5
            ,TextView tv1,TextView tv2,TextView tv3,TextView tv4,TextView tv5) {
        tvAll.setTextColor(Color.WHITE);
        tvAll.setBackgroundResource(customer_textview_category_click);
        tvComment.setTextColor(Color.BLACK);
        tvComment.setBackgroundResource(customer_textview_category);
        tvMedia.setTextColor(Color.BLACK);
        tvMedia.setBackgroundResource(customer_textview_category);
        tv1.setTextColor(Color.BLACK);
        ctStar1.setBackgroundResource(customer_textview_category);
        tv2.setTextColor(Color.BLACK);
        ctStar2.setBackgroundResource(customer_textview_category);
        tv3.setTextColor(Color.BLACK);
        ctStar3.setBackgroundResource(customer_textview_category);
        tv4.setTextColor(Color.BLACK);
        ctStar4.setBackgroundResource(customer_textview_category);
        tv5.setTextColor(Color.BLACK);
        ctStar5.setBackgroundResource(customer_textview_category);

    }
    private void selectedButtonStar(ConstraintLayout ctStar1, ConstraintLayout ctStar2, ConstraintLayout ctStar3,ConstraintLayout ctStar4,ConstraintLayout ctStar5
                                    ,TextView tv1,TextView tv2,TextView tv3,TextView tv4,TextView tv5,TextView tvAll, TextView tvComment, TextView tvMedia) {
        tv1.setTextColor(Color.WHITE);
        ctStar1.setBackgroundResource(customer_textview_category_click);
        tv2.setTextColor(Color.BLACK);
        ctStar2.setBackgroundResource(customer_textview_category);
        tv3.setTextColor(Color.BLACK);
        ctStar3.setBackgroundResource(customer_textview_category);
        tv4.setTextColor(Color.BLACK);
        ctStar4.setBackgroundResource(customer_textview_category);
        tv5.setTextColor(Color.BLACK);
        ctStar5.setBackgroundResource(customer_textview_category);
        tvAll.setTextColor(Color.BLACK);
        tvAll.setBackgroundResource(customer_textview_category);
        tvComment.setTextColor(Color.BLACK);
        tvComment.setBackgroundResource(customer_textview_category);
        tvMedia.setTextColor(Color.BLACK);
        tvMedia.setBackgroundResource(customer_textview_category);
    }
}