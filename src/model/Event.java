package model;
import java.time.LocalDate;


public class Event {
    //Atributos
    private EventType eventType;
    private String autorName;
    private double value;
    private String description;
    private LocalDate date;
    //Relacion

    //Constructor
    /**
     * 
     * @param eventType1
     * @param autorName
     * @param description
     * @param value
     * @param day
     * @param month
     * @param year
     */
    public Event(int eventType1, String autorName, String description, double value,int day ,int month ,int year){
        switch(eventType1){
            case 1:
                this.eventType = EventType.MAINTENANCE;
                break;
            case 2:
            this.eventType =EventType.SCHOOLVISIT;
                break;
            case 3:
            this.eventType =EventType.IMPROVEMENTACTIVITY;
                break;
            case 4:
            this.eventType =EventType.CELEBRATION;
                break;

        }
        this.autorName = autorName;
        this.description = description;
        this.value = value;
        this.date = LocalDate.of(year,month,day);
    }
    //Getters and Setter
    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
    
    public String getAutorName() {
        return autorName;
    }
    public void setAutorName(String autorName) {
        this.autorName = autorName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
}
