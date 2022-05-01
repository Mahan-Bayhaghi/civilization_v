package Model;
import Enum.TypeOfUnit;
import Enum.UnitStatus;

import java.util.ArrayList;

public class Unit {
    private TypeOfUnit typeOfUnit;
    private UnitStatus unitStatus;
    private Location location;
    private int hp;
    private Civilization civilization;
    private int turn;
    private int mp;
    private ArrayList<Terrain> pathToGo;


    public UnitStatus getUnitStatus() {
        return unitStatus;
    }

    public Unit(TypeOfUnit typeOfUnit, UnitStatus unitStatus, Location location, int hp, Civilization civilization, int turn) {
        this.typeOfUnit = typeOfUnit;
        this.unitStatus = unitStatus;
        this.location = location;
        this.hp = hp;
        this.civilization = civilization;
        this.turn = turn;
        this.mp = typeOfUnit.getMp();
    }

    public TypeOfUnit getTypeOfUnit() {
        return typeOfUnit;
    }

    public int getTurn() {
        return turn;
    }

    public void setUnitStatus(UnitStatus unitStatus) {
        this.unitStatus = unitStatus;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Civilization getCivilization() {
        return civilization;
    }

    public void setCivilization(Civilization civilization) {
        this.civilization = civilization;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public ArrayList<Terrain> getPathToGo() {
        return pathToGo;
    }

    public void setPathToGo(ArrayList<Terrain> pathToGo) {
        this.pathToGo = pathToGo;
    }
}
