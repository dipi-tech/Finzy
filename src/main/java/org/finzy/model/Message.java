package org.finzy.model;

public class Message {

    private Boolean success;

    private String message;

    public Message(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "success=" + success +
                ", message='" + message + '\'' +
                '}';
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

}
