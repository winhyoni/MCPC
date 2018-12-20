package com.example.elite.mcpc;
import android.widget.ImageView;

public class restaurant {
    private ImageView img;
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

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
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
