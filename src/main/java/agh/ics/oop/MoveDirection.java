package agh.ics.oop;

public enum MoveDirection {
    BACKWARD,
    FORWARD,
    LEFT,
    RIGHT,
    UNKNOWN;
    public static MoveDirection stringToDirection(String direction) {
        return switch (direction) {
            case "f" -> FORWARD;
            case "b" -> BACKWARD;
            case "r" -> RIGHT;
            case "l" -> LEFT;
            default -> UNKNOWN;
        };
    }
    }
