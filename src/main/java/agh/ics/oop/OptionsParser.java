package agh.ics.oop;

public class OptionsParser {
    private static final String[] posibleMoves={"f", "forward", "r", "right", "l", "left", "b", "backward"};

    public static MoveDirection[] parse(String[] args){
        int howManyMoves=0;
        for(String string: args){
            for(String move: posibleMoves){
                if(string.equals(move)){
                    howManyMoves+=1;
                    break;
                }
            }
        }

        MoveDirection[] moves=new MoveDirection[howManyMoves];
        int i=0;

        for(String move:args){
            switch(move){
                case "f","forward"->moves[i]=MoveDirection.FORWARD;
                case "r","right"->moves[i]=MoveDirection.RIGHT;
                case "b","backward"->moves[i]=MoveDirection.BACKWARD;
                case "l","left"->moves[i]=MoveDirection.LEFT;
                default -> i=-1;
            }
            i+=1;
        }

        return moves;
    }
}
