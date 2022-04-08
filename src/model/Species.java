package model;

public class Species {
    // Atributos
    private String name;
    private String scientificName;
    private String migratorySpecies;
    private TypesSpecies typesSpecies;

    // Methods
    /**
     * 
     * @param name
     * @param scientificName
     * @param migratorySpecies
     * @param whitchTypeOfAnimal
     */
    public Species(String name, String scientificName, String migratorySpecies, int whitchTypeOfAnimal) {
        this.name = name;
        this.scientificName = scientificName;
        this.migratorySpecies = migratorySpecies;
        switch(whitchTypeOfAnimal){
            case 1:
                typesSpecies = TypesSpecies.TERRESTICFLORA;
                break;
            case 2:
                typesSpecies = TypesSpecies.ACUATICFLORA;
                break;
            case 3:
                typesSpecies = TypesSpecies.BIRD;
                break;
            case 4:
                typesSpecies = TypesSpecies.MAMMAL;
                break;
            case 5:
                typesSpecies = TypesSpecies.ACUATICANIMAL;
                break;
        }
    }

    // Getters and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getMigratorySpecies() {
        return migratorySpecies;
    }

    public void setMigratorySpecies(String migratorySpecies) {
        this.migratorySpecies = migratorySpecies;
    }

    public TypesSpecies getTypesSpecies() {
        return typesSpecies;
    }

    public void setTypesSpecie(TypesSpecies typesSpecie) {
        this.typesSpecies = typesSpecie;
    }

}
