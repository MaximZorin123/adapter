package com.example.spiski;

public class gam {
    private String name; // название
    private String ops;  // столица
    private int foto; // ресурс флага
    private int count;

    public gam(String name, String ops, int foto, int count){
        this.ops=ops;
        this.foto = foto;
        this.count=count;
        this.name=name;

    }


    public int getCount() {
        return this.count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOps() {
        return this.ops;
    }

    public void setOps(String ops) {
        this.ops = ops;
    }

    public int getFoto() {
        return this.foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
