package com.example.appbidu.model;

import android.media.Image;

import java.util.List;

public class RatingShop {
    private int idUserShop;
    private int imageCircleUser;
    private String nameUser;
    private int ratingUser;
    private String dateTime;
    private List<ImageProduct> imageProducts;
    private String description;
    private String nameShop;
    private String commentClient;
    private String category;

    @Override
    public String toString() {
        return "RatingShop{" +
                "idUserShop=" + idUserShop +
                ", ImageCircleUser=" + imageCircleUser +
                ", nameUser='" + nameUser + '\'' +
                ", ratingUser=" + ratingUser +
                ", dateTime='" + dateTime + '\'' +
                ", imageProducts=" + imageProducts +
                ", description='" + description + '\'' +
                ", nameShop='" + nameShop + '\'' +
                ", commentClient='" + commentClient + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    public RatingShop(int idUserShop, int imageCircleUser, String nameUser, int ratingUser, String dateTime, List<ImageProduct> imageProducts, String description, String nameShop, String commentClient, String category) {
        this.idUserShop = idUserShop;
        this.imageCircleUser = imageCircleUser;
        this.nameUser = nameUser;
        this.ratingUser = ratingUser;
        this.dateTime = dateTime;
        this.imageProducts = imageProducts;
        this.description = description;
        this.nameShop = nameShop;
        this.commentClient = commentClient;
        this.category = category;
    }

    public int getIdUserShop() {
        return idUserShop;
    }

    public void setIdUserShop(int idUserShop) {
        this.idUserShop = idUserShop;
    }

    public int getImageCircleUser() {
        return imageCircleUser;
    }

    public void setImageCircleUser(int imageCircleUser) {
        this.imageCircleUser = imageCircleUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public int getRatingUser() {
        return ratingUser;
    }

    public void setRatingUser(int ratingUser) {
        this.ratingUser = ratingUser;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public List<ImageProduct> getImageProducts() {
        return imageProducts;
    }

    public void setImageProducts(List<ImageProduct> imageProducts) {
        this.imageProducts = imageProducts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNameShop() {
        return nameShop;
    }

    public void setNameShop(String nameShop) {
        this.nameShop = nameShop;
    }

    public String getCommentClient() {
        return commentClient;
    }

    public void setCommentClient(String commentClient) {
        this.commentClient = commentClient;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
