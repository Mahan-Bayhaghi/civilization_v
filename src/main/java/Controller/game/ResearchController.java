package Controller.game;

import Model.Civilization;
import Model.Technology;
import Enum.TypeOfTechnology;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;

public class ResearchController {

    public static String showCurrentResearch(final Civilization civilization){
        if (civilization.getCurrentResearch()==null)
            return "no research" ;
        return ("technology : "+civilization.getCurrentResearch().getTypeOfTechnology().getName()
                + "\nremaining turns : " + civilization.getCurrentResearch().getRemainingTurns() + "\n") ;
    }

    private static ArrayList<TypeOfTechnology> getGainedTypeOfTechnologies(final Civilization civilization){
        ArrayList<TypeOfTechnology> out = new ArrayList<TypeOfTechnology>();
        for (Technology gainedTechnology : civilization.getGainedTechnologies())
            out.add(gainedTechnology.getTypeOfTechnology());
        return out;
    }

    public static String showAvailableResearch(final Civilization civilization){
        StringBuilder out = new StringBuilder("list of available researches : \n");
        ArrayList<TypeOfTechnology> gainedTypeOfTechnologies = getGainedTypeOfTechnologies(civilization);
        for (TypeOfTechnology value : TypeOfTechnology.values()) {
            TypeOfTechnology[] neededTechnologies = value.getPrerequisiteTech() ;
            if (neededTechnologies==null)
                out.append(value.getName()).append("\n");
            else{
                boolean condition = true;
                for (TypeOfTechnology neededTechnology : neededTechnologies)
                    condition &= !gainedTypeOfTechnologies.contains(neededTechnology) ;
                if (condition)
                    out.append(value.getName()).append("\n");
            }
        }
        return out.toString();
    }

    public static String showOwnedResearch(Civilization civilization){
        ArrayList<Technology> gainedTechnologies = civilization.getGainedTechnologies() ;
        if (gainedTechnologies.isEmpty())
            return "no research yet";
        StringBuilder out = new StringBuilder("list of owned technologies : \n");
        for (Technology gainedTechnology : gainedTechnologies)
            out.append(gainedTechnology.getTypeOfTechnology().getName()).append("\n");
        out.append("total number : ").append(gainedTechnologies.size()).append("\n");
        return out.toString();
    }

    private static boolean isTechnologyNameValid (String typeOfTechnologyName){
        for (TypeOfTechnology value : TypeOfTechnology.values()) {
            if (value.getName().equalsIgnoreCase(typeOfTechnologyName))
                return true;
        }
        return false;
    }
    
    private static boolean isTechnologyAlreadyAchieved(TypeOfTechnology typeOfTechnology , final Civilization civilization){
        return getGainedTypeOfTechnologies(civilization).contains(typeOfTechnology);
    }

    private static TypeOfTechnology getTypeOfTechnologyByName(String typeOfTechnologyName){
        for (TypeOfTechnology value : TypeOfTechnology.values()) {
            if (value.getName().equalsIgnoreCase(typeOfTechnologyName))
                return value;
        }
        return null;
    }

    private static boolean canCivilizationResearchThisTypeOfTechnology(TypeOfTechnology typeOfTechnology , Civilization civilization){
        ArrayList<TypeOfTechnology> neededTechs = new ArrayList<TypeOfTechnology>(Arrays.asList(typeOfTechnology.getPrerequisiteTech()));
        ArrayList<TypeOfTechnology> owned = getGainedTypeOfTechnologies(civilization);
        return owned.containsAll(neededTechs);
    }

    public static String researchTechnology(Matcher matcher , final Civilization civilization){
        String technologyName = matcher.group("technologyName");
        if (!isTechnologyNameValid(technologyName))
            return "no technology with name "+technologyName ;
        TypeOfTechnology typeOfTechnology = getTypeOfTechnologyByName(technologyName);
        if (isTechnologyAlreadyAchieved(typeOfTechnology , civilization))
            return "you already achieved this technology" ;

        Technology currentResearch = civilization.getCurrentResearch();
        if (currentResearch==null) {
            if (canCivilizationResearchThisTypeOfTechnology(typeOfTechnology , civilization)) {
                civilization.setCurrentResearch(new Technology(typeOfTechnology));
                return "research " + typeOfTechnology.getName() + " set successfully";
            }
            else
                return "you don't have all prerequisite technologies" ;
        }
        else if (currentResearch.getTypeOfTechnology() == typeOfTechnology)
            return "you are already researching for this technology";
        else {
            if (canCivilizationResearchThisTypeOfTechnology(typeOfTechnology , civilization)) {
                civilization.setCurrentResearch(new Technology(typeOfTechnology));
                return "research " + currentResearch + " replaced with " + typeOfTechnology.getName();
            }
            else
                return "you don't have all prerequisite technologies" ;
        }
    }

}