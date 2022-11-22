package agh.ics.oop;

public class OptionsParser {
    private static final String[] posibleMoves={"f", "forward", "r", "right", "l", "left", "b", "backward"};

    public static MoveDirection[] parse(String[] args){
        MoveDirection[] moves=new MoveDirection[args.length];
        int i=0;
        for(String move:args){
            switch(move){
                case "f","forward"->moves[i]=MoveDirection.FORWARD;
                case "r","right"->moves[i]=MoveDirection.RIGHT;
                case "b","backward"->moves[i]=MoveDirection.BACKWARD;
                case "l","left"->moves[i]=MoveDirection.LEFT;
                default -> throw new IllegalArgumentException(move+" is not legal move specification");
            }
            i+=1;
        }

        return moves;
    }
}
