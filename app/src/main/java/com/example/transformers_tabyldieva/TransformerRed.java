package com.example.transformers_tabyldieva;

public class TransformerRed extends Transformer{
    public int num_lasers;
    public String opisanieSelf;

    public TransformerRed(String name, int energy, int num_lasers, String opisanieSelf) {
        super(name, energy);
        this.num_lasers = num_lasers;
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
