package org.finzy.model;

public class StandardAddress {

    private String houseNumber;

    private String streetLane;

    private String streetName;

    private String city;

    private Long pincode;

    private State state;

    private Country country;

    public StandardAddress(String houseNumber, String streetLane, String streetName, String city, Long pincode, State state, Country country) {
        this.houseNumber = houseNumber;
        this.streetLane = streetLane;
        this.streetName = streetName;
        this.city = city;
        this.pincode = pincode;
        this.state = state;
        this.country = country;
    }


    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
