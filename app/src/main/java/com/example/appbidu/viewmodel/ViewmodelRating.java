package com.example.appbidu.viewmodel;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.appbidu.R;
import com.example.appbidu.model.ImageProduct;
import com.example.appbidu.model.RatingShop;

import java.util.ArrayList;
import java.util.List;

public class ViewmodelRating extends ViewModel {
    private final MutableLiveData<List<RatingShop>> listRatingLiveData;
    private List<RatingShop> mListRating;
    public ViewmodelRating() {
        listRatingLiveData = new MutableLiveData<>();
        initDataRatingShop();
    }

    public MutableLiveData<List<RatingShop>> getListRatingLiveData() {
        return listRatingLiveData;
    }

    //public RatingShop(int idUserShop, int imageCircleUser, String nameUser, int ratingUser
    //                        , String dateTime, List<ImageProduct> imageProducts, String description
    //                        , String nameShop, String commentClient) {
    private void initDataRatingShop() {
        mListRating = new ArrayList<>();
        mListRating.add(new RatingShop(1, R.drawable.anhuser5,"Kim Joong***",4,"06-04-2021 11:36",
                null,"I am very satisfied with this product ",null,null,"Media"));
        mListRating.add(new RatingShop(2, R.drawable.anhuser4,"Park H***",5,"06-04-2021 11:36",
                null,"Every spring I start going through dress withdrawals and go crazy over all the pretty spring dresses that come out haha. It’s like famine and then feast and dresses HAPPY SPRING! ",null,null,"Media"));
        mListRating.add(new RatingShop(3, R.drawable.anhuser3,"Kim*******",3,"06-04-2021 11:36",
                getListImage(),"Every spring I start going through dress withdrawals and go crazy over all the pretty spring dresses that come","Angela Soraphiare Shop","Hi, thank you for feedback","Comment"));
        mListRating.add(new RatingShop(4, R.drawable.anhuser2,"Kim Joong***",3,"06-04-2021 11:36",
                null,"I am very satisfied with this product ",null,null,"Media"));
        mListRating.add(new RatingShop(5, R.drawable.anhuser5,"Kim Joong***",4,"06-04-2021 11:36",
                null,"I am very satisfied with this product ",null,null,"Media"));
        mListRating.add(new RatingShop(6, R.drawable.anhuser4,"Park H***",5,"06-04-2021 11:36",
                null,"Every spring I start going through dress withdrawals and go crazy over all the pretty spring dresses that come out haha. It’s like famine and then feast and dresses HAPPY SPRING!\n",null,null,"Media"));
        mListRating.add(new RatingShop(7, R.drawable.anhuser3,"Kim*******",3,"06-04-2021 11:36",
                getListImage(),"Every spring I start going through dress withdrawals and go crazy over all the pretty spring dresses that come","Angela Soraphiare Shop","Hi, thank you for feedback","Comment"));
        mListRating.add(new RatingShop(8, R.drawable.anhuser2,"Kim Joong***",4,"06-04-2021 11:36",
                null,"I am very satisfied with this product ",null,null,"Media"));
        mListRating.add(new RatingShop(9, R.drawable.anhuser5,"Kim Joong***",4,"06-04-2021 11:36",
                null,"I am very satisfied with this product ",null,null,"Media"));
        mListRating.add(new RatingShop(10, R.drawable.anhuser4,"Park H***",5,"06-04-2021 11:36",
                null,"Every spring I start going through dress withdrawals and go crazy over all the pretty spring dresses that come out haha. It’s like famine and then feast and dresses HAPPY SPRING!\n",null,null,"Media"));
        mListRating.add(new RatingShop(11, R.drawable.anhuser3,"Kim*******",3,"06-04-2021 11:36",
                getListImage(),"Every spring I start going through dress withdrawals and go crazy over all the pretty spring dresses that come","Angela Soraphiare Shop","Hi, thank you for feedback","Commnet"));
        mListRating.add(new RatingShop(12, R.drawable.anhuser2,"Kim Joong***",3,"06-04-2021 11:36",
                null,"I am very satisfied with this product ",null,null,"Media"));
        mListRating.add(new RatingShop(13, R.drawable.anhuser3,"Kim*******",4,"06-04-2021 11:36",
                getListImage(),"Every spring I start going through dress withdrawals and go crazy over all the pretty spring dresses that come","Angela Soraphiare Shop","Hi, thank you for feedback","Comment"));
        mListRating.add(new RatingShop(7, R.drawable.anhuser3,"Kim*******",5,"06-04-2021 11:36",
                getListImage(),"Every spring I start going through dress withdrawals and go crazy over all the pretty spring dresses that come","Angela Soraphiare Shop","Hi, thank you for feedback","Comment"));

        listRatingLiveData.setValue(mListRating);
    }

    private List<ImageProduct> getListImage() {
        List<ImageProduct> list =new ArrayList<>();
        list.add(new ImageProduct(1,R.drawable.product1));
        list.add(new ImageProduct(2,R.drawable.product2));
        list.add(new ImageProduct(3,R.drawable.product3));
        list.add(new ImageProduct(4,R.drawable.product4));
        list.add(new ImageProduct(5,R.drawable.product1));
        list.add(new ImageProduct(6,R.drawable.product2));
        list.add(new ImageProduct(7,R.drawable.product3));
        list.add(new ImageProduct(8,R.drawable.product4));
        list.add(new ImageProduct(9,R.drawable.product1));
        list.add(new ImageProduct(10,R.drawable.product2));
        list.add(new ImageProduct(11,R.drawable.product3));
        list.add(new ImageProduct(12,R.drawable.product4));
        list.add(new ImageProduct(13,R.drawable.product4));

        return  list;
    }


    public void updateData(Integer numberStar, String mCategory) {
        if(numberStar == null){
            List<RatingShop> list =new ArrayList<>();
            for(int i=0;i<mListRating.size();i++){
                if(mListRating.get(i).getCategory().equals(mCategory)){
                    list.add(mListRating.get(i));
                }
            }
            listRatingLiveData.setValue(list);
        }else if(mCategory.equals("All")){
            List<RatingShop> list =new ArrayList<>();
            for(int i=0;i<mListRating.size();i++){
                if(mListRating.get(i).getRatingUser() == numberStar){
                    list.add(mListRating.get(i));
                }
            }
            listRatingLiveData.setValue(list);
        } else{
            List<RatingShop> list =new ArrayList<>();
            for(int i=0;i<mListRating.size();i++){
                if(mListRating.get(i).getCategory().equals(mCategory) && mListRating.get(i).getRatingUser() == numberStar){
                    list.add(mListRating.get(i));
                }
            }
            listRatingLiveData.setValue(list);
        }
    }

    public void updateData2(String mCategory) {
        if(mCategory.equals("All")) {
            listRatingLiveData.setValue(mListRating);
        }
        else if(mCategory.equals("Comment")) {
            List<RatingShop> list = new ArrayList<>();
            for(int i=0; i<mListRating.size(); i++) {
                if (mListRating.get(i).getImageProducts() == null) {
                    list.add(mListRating.get(i));
                }
            }
            listRatingLiveData.setValue(list);
        }
        else if(mCategory.equals("Media")) {
            List<RatingShop> list = new ArrayList<>();
            for(int i=0; i<mListRating.size(); i++) {
                if (mListRating.get(i).getImageProducts() != null) {
                    list.add(mListRating.get(i));
                }
            }
            listRatingLiveData.setValue(list);
        }
    }

    public void updateData3(Integer numberStar) {
        List<RatingShop> list = new ArrayList<>();
        for(int i=0; i<mListRating.size(); i++) {
            if(mListRating.get(i).getRatingUser() == numberStar) {
                list.add(mListRating.get(i));
            }
        }
        listRatingLiveData.setValue(list);
    }
}
