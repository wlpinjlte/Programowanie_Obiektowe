package agh.ics.oop;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SimulationEngine implements IEngine{
    private final MoveDirection[] moves;

    private final IWorldMap map;

    private final ArrayList<Animal> animals=new ArrayList<>();

    public SimulationEngine(MoveDirection[] moves,IWorldMap map,Vector2d[] initialPositions) throws IllegalAccessException {
        this.moves=moves;
        this.map=map;
        for(Vector2d position:initialPositions){
            animals.add(addAnimal(position));
        }
    }

    public Animal addAnimal(Vector2d vector2d) throws IllegalAccessException {
        Animal animal = new Animal(map,vector2d);
        if(map.canMoveTo(vector2d)){
            map.place(animal);
        }
        return animal;
    }

    @Override
    public void run() {
        for(int i=0;i<moves.length;i++){
            animals.get(i%animals.size()).move(moves[i]);
        }
    }
}
