package ua.home_studying.homework_17.fighters;

public abstract class BaseFighter {
    private String name;
    private int ph;
    private int ap;
    private int deff;

    public BaseFighter(String name, int ph, int ap, int deff) {
        this.name = name;
        this.ph = ph;
        this.ap = ap;
        this.deff = deff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPh() {
        return ph;
    }

    public void setPh(int ph) {
        this.ph = ph;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public int getDeff() {
        return deff;
    }

    public void setDeff(int deff) {
        this.deff = deff;
    }
}
