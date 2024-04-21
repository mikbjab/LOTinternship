package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.example.service.HBmodel;

import java.io.IOException;
import java.util.List;

public class StartViewController {

    @FXML
    private Button addPassengerButton;
    @FXML
    private Button showPassengersButton;
    @FXML
    private Button showFlightsButton;
    @FXML
    private Button addFlightButton;
    @FXML
    private Button findFlightButton;

    private HBmodel hbModel;


    @FXML
    private void initialize(){
        hbModel=new HBmodel();
        System.out.println("dotarlo");

        addPassengerButton.setOnAction(this::onAddPassengerButtonClick);
        showPassengersButton.setOnAction(this::onShowPassengersButtonClick);
        showFlightsButton.setOnAction(this::onShowFlightsButtonClick);
        addFlightButton.setOnAction(this::onAddFlightButtonClick);
        findFlightButton.setOnAction(this::onFindFlightButtonClick);
}

    private void onFindFlightButtonClick(ActionEvent actionEvent) {
    }

    private void onAddFlightButtonClick(ActionEvent actionEvent) {
    }

    private void onShowFlightsButtonClick(ActionEvent actionEvent) {
    }


    private void onShowPassengersButtonClick(ActionEvent actionEvent) {
    }

    private void onAddPassengerButtonClick(ActionEvent event) {
        
    }
}
