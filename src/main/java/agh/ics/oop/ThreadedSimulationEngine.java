package agh.ics.oop;

import agh.ics.oop.gui.IMapRefreshObserver;

import java.util.ArrayList;

public class ThreadedSimulationEngine implements IEngine, Runnable {

    private final IWorldMap map;
    private MoveDirection[] moves;
    private final ArrayList<Animal> animals = new ArrayList<>();
    private final ArrayList<IMapRefreshObserver> mapRefreshObservers = new ArrayList<>();

    public final int moveDelay;

    public ThreadedSimulationEngine(IWorldMap map, Vector2d[] initialPositions, int moveDelay) throws IllegalAccessException {
        this.map = map;
        this.moveDelay = moveDelay;

        for (Vector2d position: initialPositions) {
            animals.add(new Animal(this.map, position));
        }

        for (Animal animal: animals) {
            this.map.place(animal);
        }
    }

    public ThreadedSimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] initialPosiitons, int moveDelay) throws IllegalAccessException {
        this(map, initialPosiitons, moveDelay);
        setMoves(moves);
    }

    public void mapRefresh() {
        for (IMapRefreshObserver observer: mapRefreshObservers) {
            observer.refresh();
        }
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < moves.length; i++) {
                Thread.sleep(moveDelay);
                animals.get(i % animals.size()).move(moves[i]);
                mapRefresh();
            }
        }
        catch (InterruptedException e) {
            System.err.println("Interuption while waiting for the animal move!");
        }
    }

    public void setMoves(MoveDirection[] moves) {
        this.moves = moves;
    }
    public void addObserver(IMapRefreshObserver observer) {
        this.mapRefreshObservers.add(observer);
    }

    public void removeObserver(IMapRefreshObserver observer) {
        this.mapRefreshObservers.remove(observer);
    }
}