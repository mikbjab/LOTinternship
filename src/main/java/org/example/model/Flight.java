package org.example.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @Column(name="flight_id", unique = true, nullable = false)
    private String flightNumber;

    @Column(name="dep_date", nullable = false)
    private Date departureDate;

    @Column(name="av_seats", nullable = false)
    private int availableSeats;

    @Column(name="max_seats", nullable = false)
    private int maxSeats;

    @Column(name="route", nullable = false)
    private String route;

    public Flight(String flightNumber, Date departureDate,
                  int availableSeats, String route, int maxSeats) {
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.availableSeats = availableSeats;
        this.route=route;
        this.maxSeats=maxSeats;

    }

    public Flight(){}

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    private Set<Passenger> passengers = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tickets",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "pass_id")
    )
    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void addPassenger(Passenger passenger){
        this.passengers.add(passenger);
    }
}
