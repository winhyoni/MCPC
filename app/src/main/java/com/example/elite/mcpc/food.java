package com.example.elite.mcpc;

public class food {
    private int foodimg;
    private String foodname;
    private String foodprice;

    public food(String foodname,String foodprice){
        this.foodname = foodname;
        this.foodprice = foodprice;
    }
    public food(int foodimg, String foodname,String foodprice){
        this.foodimg = foodimg;
        this.foodname = foodname;
        this.foodprice = foodprice;
    }

    public int getFoodimg() {
        return foodimg;
    }

    public void setFoodimg(int foodimg) {
        this.foodimg = foodimg;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(String foodprice) {
        this.foodprice = foodprice;
    }
}
