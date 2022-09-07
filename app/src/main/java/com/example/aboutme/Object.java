package com.example.aboutme;

public class Object {
    String text;
    int Img;

    public Object(String text, int img) {
        this.text = text;
        Img = img;
    }

    void settext(String text){
        this.text=text;
    }
    void setImg(int Img){
        this.Img=Img;
    }
    String gettext(){
        return text;
    }
    int getImg(){
        return Img;
    }
}
