package Enum;

public enum TypeOfTerrain {
    // TODO changeOfCombatType
    DESERT("desert", 0, 0, 0, 1,(float) -33/100,
            new TerrainFeatures[]{TerrainFeatures.OASIS, TerrainFeatures.FLOODPLAINS},
            new Resources[]{Resources.IRON, Resources.GOLD, Resources.SILVER, Resources.MARBLE, Resources.COTTON,
                    Resources.ALOE, Resources.SHEEP}),
    GRASSLAND("grassland", 0, 2, 0, 1, (float) -33/100,
            new TerrainFeatures[]{TerrainFeatures.FOREST, TerrainFeatures.MARSH},
            new Resources[]{Resources.IRON, Resources.HORSE, Resources.COAL, Resources.COW, Resources.GOLD,
                    Resources.MARBLE, Resources.COTTON, Resources.SHEEP}),
    HILL("hill", 0,0, 2, 2, (float) 25/100,
            new TerrainFeatures[]{TerrainFeatures.FOREST, TerrainFeatures.JUNGLE},
            new Resources[]{Resources.IRON, Resources.COAL, Resources.GAZELLE, Resources.GOLD, Resources.SILVER,
                    Resources.MARBLE, Resources.SHEEP}),
    MOUNTAIN("mountain", 0, 0, 0, 10000, (float) 25/100, null,
            null),
    OCEAN("ocean", 0, 0, 0, 10000, (float) 25/100, null,
            null),
    PLAIN("plain", 0, 1, 1, 1, (float) -33/100,
            new TerrainFeatures[]{TerrainFeatures.FOREST, TerrainFeatures.JUNGLE},
            new Resources[]{Resources.IRON, Resources.HORSE, Resources.COAL, Resources.WHEAT, Resources.GOLD,
                    Resources.MARBLE, Resources.IVORY, Resources.COTTON, Resources.ALOE, Resources.SHEEP}),
    SNOW("snow", 0, 0, 0, 1, (float) -33/100, null,
            new Resources[]{Resources.IRON}),
    TUNDRA("tundra", 0, 1, 0, 1, (float) -33/100,
            new TerrainFeatures[]{TerrainFeatures.FOREST},
            new Resources[]{Resources.IRON, Resources.HORSE, Resources.GAZELLE, Resources.SILVER, Resources.MARBLE});

    private String name;
    private int gold;
    private int food;
    private int production;
    private int mpNeeded;
    private float changeOfCombat;
    private TerrainFeatures[] possibleFeatures;
    private Resources[] possibleResources;

    TypeOfTerrain(String name, int gold, int food, int production, int mpNeeded, float changeOfCombat,
                  TerrainFeatures[] possibleFeatures, Resources[] possibleResources) {
        this.name = name;
        this.gold = gold;
        this.food = food;
        this.production = production;
        this.mpNeeded = mpNeeded;
        this.changeOfCombat = changeOfCombat;
        this.possibleFeatures = possibleFeatures;
        this.possibleResources = possibleResources;
    }

    public String getName() {
        return name;
    }

    public int getGold() {
        return gold;
    }

    public int getFood() {
        return food;
    }

    public int getProduction() {
        return production;
    }

    public int getMpNeeded() {
        return mpNeeded;
    }

    public float getChangeOfCombat() {
        return changeOfCombat;
    }

    public TerrainFeatures[] getPossibleFeatures() {
        return possibleFeatures;
    }

    public Resources[] getPossibleResources() {
        return possibleResources;
    }
}
