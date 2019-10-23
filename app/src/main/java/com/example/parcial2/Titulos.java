package com.example.parcial2;

public class Titulos {

    private String titulo;
    private String subtitulo;
    private String nota;
    private int imgUser;

    public Titulos(String tit, String sub, String not,int img){

        titulo = tit;
        subtitulo = sub;
        nota = not;
        imgUser=img;
    }





    public String getTitulo(){
        return titulo;
    }

    public String getSubtitulo(){
        return subtitulo;
    }

    public String getNota() {
        return nota;
    }
    public int getImgUser() {
        return imgUser;
    }
    public void setImgUser (int imgUser) {
        this.imgUser = imgUser;
    }

}
