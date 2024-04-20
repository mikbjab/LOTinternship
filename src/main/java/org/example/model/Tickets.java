package org.example.model;

public class Tickets {
    private int id;
    private int passId;
    private String flightId;

    public Tickets(int id, int passId, String flightId){
        this.flightId = flightId;
        this.id=id;
        this.passId = passId;
    }
    public Tickets(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassId() {
        return passId;
    }

    public void setPassId(int passId) {
        this.passId = passId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }
}
