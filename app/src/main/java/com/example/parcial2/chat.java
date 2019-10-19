package com.example.parcial2;

public class chat {
    private String msj;
    private int usr;


    public chat(String mensaje, int tipo_usuario){
        this.msj = mensaje;
        this.usr = tipo_usuario;
    }


    public String getMsj() {
        return msj;
    }

    public int getUsr() {
        return usr;
    }
}
