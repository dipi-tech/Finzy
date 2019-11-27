package org.finzy.model;

public enum Stamp {
    LOCAL,
    NATIONAL;

    boolean validate(State fromState, State toState){
        switch(this) {
            case LOCAL:
                if (fromState.equals(toState)) {
                    return true;
                } else {
                    return false;
                }
            case NATIONAL:
                if (fromState.equals(toState)) {
                    return false;
                } else {
                    return true;
                }
            default:
                throw new AssertionError("Unknown stamp " + this);
        }
    }
}
