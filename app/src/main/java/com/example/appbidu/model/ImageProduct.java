package com.example.appbidu.model;

public class ImageProduct {
    private int idImage;
    private int imageView;

    public ImageProduct(int idImage, int imageView) {
        this.idImage = idImage;
        this.imageView = imageView;
    }

    @Override
    public String toString() {
        return "ImageProduct{" +
                "idImage=" + idImage +
                ", ImageView=" + imageView +
                '}';
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }
}
