package com.example.elite.mcpc;

public class restaurant {
    private int img;
    private String name;
    private String star;
    private String distance;
    private int bno;

    public restaurant( String name, String star, String distance, int bno){
        super();
      // this.img = img;
       this.name = name;
       this.star = star;
       this.distance = distance;
       this.bno = bno;
    }
    public restaurant(int imgid, String name, String star, String distance, int bno){
        super();
        this.img =imgid;
        this.name = name;
        this.star = star;
        this.distance = distance;
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

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }
}
