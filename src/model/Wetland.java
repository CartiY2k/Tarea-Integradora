package model;


public class Wetland {
    //Constant
    public static final int NUMBEREVENTS = 80;
    public static final int NUMBERSPECIE = 100;
    // Atriubute
    private String name;
    private ZoneType zone;
    private PrivacityType type;
    private String quantityKm2;
    private String url;
    private String protectedArea;
    private String enviromentTests;
    // Relaciones
    private Event []events;
    private Species [] animalsAndFloura;
    // Constructor
    /**
     * 
     * @param name
     * @param zone
     * @param type
     * @param quantityKm2
     * @param url
     * @param protectedArea
     * @param enviromentTests
     */

    public Wetland(String name, int zoneType, int privacityType, String quantityKm2, String url, String protectedArea,String enviromentTests) {
        this.name = name;
        this.quantityKm2 = quantityKm2;
        this.url = url;
        this.protectedArea = protectedArea;
        this.enviromentTests = enviromentTests;
        events = new Event[NUMBEREVENTS];
        animalsAndFloura = new Species[NUMBERSPECIE];
        switch(zoneType){
            case 1:
                this.zone= ZoneType.RURAL;
                break;
            case 2:
                this.zone= ZoneType.URBAN;
                break;
        }
        switch(privacityType){
            case 1:
                this.type = PrivacityType.PUBLIC;
                break;
            case 2:
                this.type = PrivacityType.PRIVATE;
                break;

        }
        
    }
    //Methods

    /**
     * So, this method make counter of the maintenances and a year that the user input.
     * <b> pre:</b> The user don't know how many Maintenances have in a year
     * <b> pos:</b> The user know how many Maintenances have in a year, because you need to return a String than it will be print in the Main
     * @param wetlandPosition it's the position of the wetland that you will return
     * @param yearSerch it's the year That the user wanna  know
     * @return  a message, it's said that how many maintenances have each wetland in the year that the user input.
     */

    public String gimmeTheInformatiton(int wetlandPosition,int yearSerch){
        String message = "";
        int counter = 0;
        for(int i = 0;i<events.length && events[i]!= null;i++){
            if(events[i].getEventType()==EventType.MAINTENANCE&& events[i].getDate().getYear()== yearSerch)
                counter++;
        }
        message = "["+(wetlandPosition+1)+"]The maintenances in the wetland "+name+" was "+counter+".";
        return message;
    }
    /**
     * This method will be use when you need to register a new Specie, it can be Flora or Fauna and return and variable type String
     * <b> pre:<b> The user wanna register a new Specie and in the main him select The option number 3.
     * <b> pos:<b> The user registered a new Specie in a Correct Way.
     * @param name This is the name of the specie as you can see.
     * @param scientificName This is the scientific Name of the specie as you can see.
     * @param migratorySpecie This said me if the species that the user registered was migratory or not.
     * @param speciType This said me what kinda of specie is it.
     * @return a message, the information that it return is depend on the algorithm
     */
    public String registerSpecie(String name, String scientificName,String migratorySpecie ,int speciType){
        String message = name+" registered in a correct way.";
        boolean continue1 = true;
        for(int i = 0;i<animalsAndFloura.length && continue1 != false;i++){
            if(animalsAndFloura[i]==null){
                animalsAndFloura[i] =new Species(name, scientificName, migratorySpecie, speciType);
                continue1 = false;
            }
        }
        if(continue1)
            message = "Too many Species, you can't add more.Pls contact with you provider";
        return message;
    }
    /**
     * <b> pre:<b>
     * <b> pos:<b>
     * @param eventType int :This is  the type of the event the variable need to be != null
     * @param directorName String:the variable need to be != null
     * @param value double :the variable need to be != null
     * @param description String:the variable need to be != null
     * @param day int :the variable need to be != null
     * @param month int :the variable need to be != null
     * @param year int :the variable need to be != null
     * @return a message, the information that it return is depend on the algorithm
     */

    public String registerdEvent(int eventType,String directorName,double value,String description,int day,int month, int year){
        String message = "The event registered in a correct way.";
        boolean continue1 = true;
        for(int i = 0;i<events.length && continue1 != false;i++){
            if(events[i]==null){
                events[i] =new Event(eventType,directorName,description,value,day,month,year);
                continue1 = false;
            }
        }
        if(continue1)
            message = "Too many Events, you can't add more.Pls contact with you provider";
        return message;
    }
    /**
     * <b> pre:<b>
     * <b> pos:<b> 
     * @return counter
     */

    public int counterFlora(){
        int counter =0;
        for(int i = 0;i<animalsAndFloura.length && animalsAndFloura[i]!= null;i++){
            if(animalsAndFloura[i].getTypesSpecies()==TypesSpecies.TERRESTICFLORA ||animalsAndFloura[i].getTypesSpecies()==TypesSpecies.ACUATICFLORA)
            counter++;
        }
        return counter;
    }
    /**
     * 
     * @return counter
     */

    public int counterFauna(){
        int counter =0;
        for(int i = 0;i<animalsAndFloura.length && animalsAndFloura[i]!= null;i++){
            if(animalsAndFloura[i].getTypesSpecies()==TypesSpecies.BIRD ||animalsAndFloura[i].getTypesSpecies()==TypesSpecies.MAMMAL||animalsAndFloura[i].getTypesSpecies()==TypesSpecies.ACUATICANIMAL)
            counter++;
        }
        return counter;
    }

    /**
     * 
     * @param nameSpecie
     * @return
     */

    public boolean searchSpecie(String nameSpecie){
        boolean animalsFloraExist = false;
        boolean continue1 = true;
        for(int i  = 0;i< animalsAndFloura.length && animalsAndFloura[i]!= null&&continue1 != false;i++){
            if(animalsAndFloura[i].getName().equalsIgnoreCase(nameSpecie)){
                animalsFloraExist= true;
                continue1 = false;
            }
        }
        return animalsFloraExist;
    }


    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZoneType getZone() {
        return zone;
    }

    public void setZone(ZoneType zone) {
        this.zone = zone;
    }

    public PrivacityType getType() {
        return type;
    }

    public void setType(PrivacityType type) {
        this.type = type;
    }

    public String getQuantityKm2() {
        return quantityKm2;
    }

    public void setQuantityKm2(String quantityKm2) {
        this.quantityKm2 = quantityKm2;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProtectedArea() {
        return protectedArea;
    }

    public void setProtectedArea(String protectedArea) {
        this.protectedArea = protectedArea;
    }

    public String getEnviromentTests() {
        return enviromentTests;
    }

    public void setEnviromentTests(String enviromentTests) {
        this.enviromentTests = enviromentTests;
    }

    public Event[] getEvents() {
        return events;
    }

    public void setEvents(Event[] events) {
        this.events = events;
    }

    public Species[] getAnimalsAndFloura() {
        return animalsAndFloura;
    }

    public void setAnimalsAndFloura(Species[] animalsAndFloura) {
        this.animalsAndFloura = animalsAndFloura;
    }
    

}
