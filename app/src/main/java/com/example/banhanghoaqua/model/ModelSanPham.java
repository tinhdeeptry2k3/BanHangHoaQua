package com.example.banhanghoaqua.model;

public class ModelSanPham {
    private String name;
    private String price;

    private String des;
    private int image;

    public ModelSanPham(String name, String price, String des, int image) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public  String getDes(){
        return  des;
    }

    public void setDes(String des){
        this.des = des;
    }
}
