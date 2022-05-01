package Enum.regexes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum CityMenuCommands {

    EXIT("exit"),
    EMPLOY_CITIZEN_TO_TILE("assign citizen(?<number>\\d+) to terrain (?<X>\\d+) (?<Y>\\d+)"),
    UNLOCK_CITIZEN("unlock citizen(?<number>\\d+)"),
    CREATE_UNIT("create unit (?<unit>[a-zA-Z]+)"),
    BUY_UNIT_WITH_GOLD("buy unit (?<unitNumber>\\d+) with gold");

    private String regex;

    CityMenuCommands(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
    public static Matcher getMatcher(String input , CityMenuCommands command) {
        Matcher matcher = Pattern.compile(command.getRegex()).matcher(input);
        if (matcher.matches()) return matcher;
        return null;
    }
}