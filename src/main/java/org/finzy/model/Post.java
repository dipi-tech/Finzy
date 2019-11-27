package org.finzy.model;

public class Post {

    private User sender;

    private User receiver;

    private Stamp stamp;

    public Post(User sender, User receiver, Stamp stamp) {
        this.sender = sender;
        this.receiver = receiver;
        this.stamp = stamp;
    }

    public Message send(){
        try {
            if (this.stamp.validate(this.sender.getState(), this.receiver.getState())) {
                // We can call any API endpoint here to deliver the message.
                return new  Message(true,"Post Sent Successfully");
            } else {
                return new  Message(false,"Stamp Usage Not Correct");
            }
        }catch(AssertionError ae){
            return new  Message(false, ae.getMessage());
        }
    }
}
