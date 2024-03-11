package com.example.transformers_tabyldieva;

public class TransformerYellow extends Transformer{
    public int num_lasers;
    private String sound;

    public String opisanieSelf;

    public TransformerYellow(String name, int energy, int num_lasers, String opisanieSelf) {
        super(name, energy);
        this.num_lasers = num_lasers;
        this.sound = sound;
        this.opisanieSelf = opisanieSelf;
    }

    public int getNum_lasers() {
        return num_lasers;
    }

    public void setNum_lasers(int num_lasers) {
        this.num_lasers = num_lasers;
    }

    public String getOpisanieSelf() {
        return opisanieSelf;
    }


    public void setOpisanieSelf(String opisanieSelf) {
        this.opisanieSelf = opisanieSelf;
    }

    @Override
    public void shooting() {

    }

    public String printSelf(){
        opisanieSelf = (getName() +" : " + getOpisanieSelf());
        return opisanieSelf;

    }
}
