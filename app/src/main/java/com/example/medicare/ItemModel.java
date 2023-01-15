package com.example.medicare;

public class ItemModel {

    String name;
    String desc;
    int image;

    public ItemModel(String name, String desc, int image) {
        this.name = name;
        this.desc = desc;
        this.image = image;
    }

    //GETTER SETTER
    //name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //desc
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    //image
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
