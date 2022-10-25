package agh.ics.oop;

public class Animal {
    private MapDirection direction=MapDirection.NORTH;
    private Vector2d position=new Vector2d(2,2);

    private final Vector2d endOfMap=new Vector2d(4,4);

    private final Vector2d startOfMap=new Vector2d(0,0);

    public String toString(){
        return "Position:"+position+" Direction:"+direction.toString();
    }

    public boolean isAt(Vector2d position){
        return position.equals(this.position);
    }

    public void move(MoveDirection move){
       switch(move){
           case LEFT->this.direction=this.direction.previous();
           case RIGHT ->this.direction=this.direction.next();
           case FORWARD ->{
               Vector2d positonAfter=position.add(direction.toUnitVector());
               if(positonAfter.follows(startOfMap)&&positonAfter.precedes(endOfMap)){
                   position=positonAfter;
               }
           }
           case BACKWARD -> {
               Vector2d positonAfter=position.subtract(direction.toUnitVector());
               if(positonAfter.follows(startOfMap)&&positonAfter.precedes(endOfMap)){
                   position=positonAfter;
               }
           }
       }
    }


}
