package org.example.service;

import org.example.model.Flight;
import org.example.model.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class HBmodel {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public HBmodel(){
        this.sessionFactory=HibernateUtil.getSessionFactory();
    }

    //Flight operations
    public void addFlight(String flightNumber, int maxSeats, String route, Date departureDate){
        Session session=this.sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Flight flight=new Flight(flightNumber,departureDate,maxSeats,route,maxSeats);
        session.persist(flight);
        transaction.commit();
        session.close();
    }

    public void addTicket(Passenger passenger, String flightId){
        Session session=this.sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Flight flight=session.get(Flight.class,flightId);
        flight.addPassenger(passenger);
        session.merge(flight);
        transaction.commit();
        session.close();
    }
    public void changeRoute(String flightId,String route){
        Session session=this.sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Flight flight=session.get(Flight.class,flightId);
        flight.setRoute(route);
        session.merge(flight);
        transaction.commit();
        session.close();
    }

    public void changeDepartureDate(String flightId,Date departureDate){
        Session session=this.sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Flight flight=session.get(Flight.class,flightId);
        flight.setDepartureDate(departureDate);
        session.merge(flight);
        transaction.commit();
        session.close();
    }

    public List<Flight> showAllFlights(){
        Session session=this.sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        var result= session.createQuery("from org.example.model.Flight",org.example.model.Flight.class).list();
        transaction.commit();
        session.close();
        return result;
    }

    public void deleteFlight(Flight flight){
        Session session=this.sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.remove(flight);
        transaction.commit();
        session.close();
    }


    //Passenger operations
    public void addPassenger(String name, String surname, String phoneNumber){
        Session session=this.sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Passenger passenger=new Passenger();
        passenger.setName(name);
        passenger.setSurname(surname);
        passenger.setPhoneNumber(phoneNumber);
        session.persist(passenger);
        transaction.commit();
        session.close();
    }
    public void changePassengerPhone(int passId,String phoneNumber){
        Session session=this.sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Passenger passenger=session.get(Passenger.class,passId);
        passenger.setPhoneNumber(phoneNumber);
        session.merge(passenger);
        transaction.commit();
        session.close();
    }

    public List<Passenger> showAllPassengers(){
        Session session=this.sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        var result= session.createQuery("from org.example.model.Passenger",org.example.model.Passenger.class).list();
        transaction.commit();
        session.close();
        return result;
    }

    public void deletePassenger(Passenger passenger){
        Session session=this.sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.remove(passenger);
        transaction.commit();
        session.close();
    }
}
