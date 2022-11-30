package agh.ics.oop;

import java.util.ArrayList;

public class Animal extends AbstractWorldMapElement{
    private MapDirection direction=MapDirection.NORTH;


    private IWorldMap map;

    public MapDirection getDirection(){
        return direction;
    }

    public Animal(IWorldMap map) {
        position=new Vector2d(2,2);
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map=map;
        position=initialPosition;
    }

    public String toString(){
        return switch (direction){
            case NORTH -> "N";
            case WEST -> "W";
            case SOUTH -> "S";
            case EAST -> "E";
        };
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
               if(map.canMoveTo(positonAfter)){
                   positionChanged(position,positonAfter);
                   position=positonAfter;
               }
           }
           case BACKWARD -> {
               Vector2d positonAfter=position.subtract(direction.toUnitVector());
               if(map.canMoveTo(positonAfter)){
                   positionChanged(position,positonAfter);
                   position=positonAfter;
               }
           }
       }
    }


}
