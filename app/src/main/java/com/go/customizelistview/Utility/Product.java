package com.go.customizelistview.Utility;

public class Product {
    String code;
    String name;
    String weight;
    double price;
    int quantity;
    boolean checked;
    String image;

    public Product() {

    }

    public Product(String code, String name, String weight, double price, int quantity, boolean checked, String image) {
        this.code = code;
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.quantity = quantity;
        this.checked = checked;
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
