package Controller.game;

import Model.Location;
import Model.Unit;
import Enum.UnitStatus;
import Enum.TypeOfUnit;

import java.util.regex.Matcher;

public class UnitController {

    // TODO the first two errors are the same in all methods --> handle
    public static String moveUnit(Matcher matcher, GameController gameController) {
        int x = Integer.parseInt(matcher.group("X"));
        int y = Integer.parseInt(matcher.group("Y"));
        Unit selectedUnit = SelectController.selectedUnit;
        Location origin = selectedUnit.getLocation();
        Location destination = new Location(x, y);
        String placeName;

        if (SelectController.selectedUnit == null)
            return "There isn't any selected unit!";

        if (!hasOwnerShip(selectedUnit, gameController))
            return "This unit does not belong to you!";

        if (!SelectController.positionIsValid(destination))
            return "Destination ( " + x + " , " + y + " ) is not valid!";

        if ((placeName = TheShortestPath.destinationIsValid(destination)) != null)
            return "Your destination is " + placeName + " so you can not go to it!";

        return TheShortestPath.checkNeededMpForMove(origin, destination);
    }

    public static boolean hasOwnerShip(Unit currentUnit, GameController gameController) {
        for (Unit unit : gameController.getCurrentCivilization().getUnits()) {
            if (currentUnit.getLocation().getX() == unit.getLocation().getX()
                    && currentUnit.getLocation().getY() == unit.getLocation().getY())
                return true;
        }
        return false;
    }

    public static String sleep(GameController gameController) {
        // show errors just when you select the unit
        if (SelectController.selectedUnit == null)
            return "There isn't any selected unit!";

        if (!hasOwnerShip(SelectController.selectedUnit, gameController))
            return "This unit does not belong to you!";

        SelectController.selectedUnit.setUnitStatus(UnitStatus.SLEEP);
        return "Selected unit has slept successfully!";
    }

    public static String fortifyUnit(GameController gameController) {
        Unit selectedUnit = SelectController.selectedUnit;

        if (selectedUnit == null)
            return "There isn't any selected unit!";

        if (!hasOwnerShip(selectedUnit, gameController))
            return "This unit does not belong to you!";

        if (selectedUnit.getTypeOfUnit() == TypeOfUnit.WORKER
                || selectedUnit.getTypeOfUnit() == TypeOfUnit.SETTLER)
            return "Selected-unit's type should be combat for this action!";

        // TODO HEAL and main things to do!
        return "";
    }

    public void healUnit(Unit unit) {
    }

    public static String cancelMission(GameController gameController) {
        if (SelectController.selectedUnit == null)
            return "There isn't any selected unit!";

        if (!hasOwnerShip(SelectController.selectedUnit, gameController))
            return "This unit does not belong to you!";
        // TODO handle unit's movements first!
        // TODO remove all movements!
        return "All of the missions of the selected unit have been canceled!";
    }

    public static String wake(GameController gameController) {
        if (SelectController.selectedUnit == null)
            return "There isn't any selected unit!";

        if (!hasOwnerShip(SelectController.selectedUnit, gameController))
            return "This unit does not belong to you!";

        SelectController.selectedUnit.setUnitStatus(UnitStatus.ACTIVE);
        return "Selected unit is awake!";
    }

    public static String deleteUnit(GameController gameController) {
        Unit selectedUnit = SelectController.selectedUnit;

        if (selectedUnit == null)
            return "There isn't any selected unit!";

        if (!hasOwnerShip(selectedUnit, gameController))
            return "This unit does not belong to you!";

        // find the selected unit in current civilization and remove it.
        for (Unit unit : gameController.getCurrentCivilization().getUnits()) {
            if (unit.getLocation().getX() == selectedUnit.getLocation().getX()
                    && unit.getLocation().getY() == selectedUnit.getLocation().getY()) {
                gameController.getCurrentCivilization().getUnits().remove(unit);
                break;
            }
        }
        return "Unit deleted successfully!";
    }

    // TODO what is this ?
    public String upgrade(Unit unit) {
        return "";
    }
}
