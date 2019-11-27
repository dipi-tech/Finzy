package org.finzy.model;

public class User {

    private Long userId;

    private String userName;

    private StandardAddress address;

    public User(Long userId, String userName, StandardAddress address) {
        this.userId = userId;
        this.userName = userName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", address=" + address +
                '}';
    }

    public StandardAddress getAddress() {
        return address;
    }

    // To avoid multiple get calls from the actual model
    public State getState(){
        return  this.getAddress().getState();
    }

    public void setState(State state){
        address.setState(state);
    }
}
