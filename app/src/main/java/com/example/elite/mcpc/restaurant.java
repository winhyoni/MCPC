package com.example.elite.mcpc;

public class restaurant {
    private int img;
    private String name;
    private String star;
    private double x;
    private double y;
    private int distance;
    private int bno;

    public restaurant(int imgid, String name, String star, double x, double y, int bno){
        super();
        this.img =imgid;
        this.name = name;
        this.star = star;
        this.x = x;
        this.y = y;
        this.bno = bno;
    }


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }
}
