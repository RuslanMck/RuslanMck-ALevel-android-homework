package ua.home_studying.homework_17.fighters;

public abstract class BaseFighter {
    private String name;
    private String imgLink;
    private Integer info;
    private int health;
    private int attack;
    private int defence;


    public BaseFighter(String name, String imgLink, Integer info, int health, int attack, int defence) {
        this.name = name;
        this.imgLink = imgLink;
        this.info = info;
        this.health = health;
        this.attack = attack;
        this.defence = defence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public Integer getInfo() {
        return info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }
}
