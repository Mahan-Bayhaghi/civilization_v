package game.Controller.game;

import game.Model.*;
import game.Enum.TerrainFeatures;
import game.Enum.TypeOfUnit;

public class NonCombatUnitController {

    // TODO type of improvement?
    // TODO handle statics
    // TODO want a method to just check the location of the terrain --> get terrain by location in TerrainController

    public static boolean isSettler(Unit unit) {
        return unit.getTypeOfUnit() == TypeOfUnit.SETTLER;
    }

    public static boolean isWorker(Unit unit) {
        return unit.getTypeOfUnit() == TypeOfUnit.WORKER;
    }


    public static Terrain isJungleHere(Location location) {
        Terrain[][] terrain = GameController.getInstance().getMap();

        for (int i = 0; i < GameController.getInstance().getMapHeight(); i++) {
            for (int j = 0; j < GameController.getInstance().getMapWidth(); j++) {
                if (terrain[i][j].getLocation().getX() == location.getX()
                        && terrain[i][j].getLocation().getY() == location.getY()
                        && terrain[i][j].getTerrainFeatures() == TerrainFeatures.JUNGLE)
                    return terrain[i][j];
            }
        }
        return null;
    }

    public static Terrain isForestHere(Location location) {
        Terrain[][] terrain = GameController.getInstance().getMap();

        for (int i = 0; i < GameController.getInstance().getMapHeight(); i++) {
            for (int j = 0; j < GameController.getInstance().getMapWidth(); j++) {
                if (terrain[i][j].getLocation().getX() == location.getX()
                        && terrain[i][j].getLocation().getY() == location.getY()
                        && terrain[i][j].getTerrainFeatures() == TerrainFeatures.FOREST)
                    return terrain[i][j];
            }
        }
        return null;
    }

    public static Terrain isRouteHere(Location location) {
        Terrain[][] terrain = GameController.getInstance().getMap();

        for (int i = 0; i < GameController.getInstance().getMapHeight(); i++) {
            for (int j = 0; j < GameController.getInstance().getMapWidth(); j++) {
                if (terrain[i][j].getLocation().getX() == location.getX()
                        && terrain[i][j].getLocation().getY() == location.getY()
                        && (terrain[i][j].hasRailRoad()
                        || terrain[i][j].hasRoad()))
                    return terrain[i][j];
            }
        }
        return null;
    }

    public static Terrain isMarshHere(Location location) {
        Terrain[][] terrain = GameController.getInstance().getMap();

        for (int i = 0; i < GameController.getInstance().getMapHeight(); i++) {
            for (int j = 0; j < GameController.getInstance().getMapWidth(); j++) {
                if (terrain[i][j].getLocation().getX() == location.getX()
                        && terrain[i][j].getLocation().getY() == location.getY()
                        && terrain[i][j].getTerrainFeatures() == TerrainFeatures.MARSH)
                    return terrain[i][j];
            }
        }
        return null;
    }
}