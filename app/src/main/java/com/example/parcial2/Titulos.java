package com.example.parcial2;

public class Titulos {

    private String UserName;
    private String UserMsj;
    private int imgUser;
    private int imgCheck;

    public Titulos(String UsrName, String UsrMsj,int imgUsr,int imgChecker){

        UserName = UsrName;
        UserMsj = UsrMsj;
        imgUser=imgUsr;
        imgCheck = imgChecker;
    }


    public String getUserName() {
        return UserName;
    }

    public String getUserMsj() {
        return UserMsj;
    }

    public int getImgUser() {
        return imgUser;
    }

    public int getImgCheck(){
        return imgCheck;
    }

    public void setImgCheck(int imgChecker){
        this.imgCheck = imgChecker;
    }

}
