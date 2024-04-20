package org.example.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "passengers")
public class Passenger {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Id
    @GeneratedValue
    @Column(name="pass_id")
    private int id;

    @Column(name="ph_num")
    private String phoneNumber;

    public Passenger(String name, String surname, int id, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    public Passenger(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private Set<Flight> flights = new HashSet<Flight>();

    @ManyToMany(mappedBy = "passengers")
    public Set<Flight> getFlights() {
        return flights;
    }

    public void addFlight(Flight flight){
        this.flights.add(flight);
    }
}
