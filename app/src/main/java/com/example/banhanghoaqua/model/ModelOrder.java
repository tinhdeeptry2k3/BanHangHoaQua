package com.example.banhanghoaqua.model;

public class ModelOrder {
    private String name;
    private String price;

    private String des;
    private int image;

    private int quantity;

    public ModelOrder(String name, String price, String des, int image, int quantity) {
        this.name = name;
        this.price = price;
        this.des = des;
        this.image = image;
        this.quantity = quantity;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
