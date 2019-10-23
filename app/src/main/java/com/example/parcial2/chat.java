package com.example.parcial2;

public class chat {
    private String msj;
    private int usr;
    private int color;


    public chat(String mensaje, int tipo_usuario, int color_text){
        this.msj = mensaje;
        this.usr = tipo_usuario;
        this.setColor(color_text);
    }


    public String getMsj() {
        return msj;
    }

    public int getUsr() {
        return usr;
    }


    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
