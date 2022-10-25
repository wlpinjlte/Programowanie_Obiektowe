package agh.ics.oop;

import static agh.ics.oop.MoveDirection.FORWARD;
import static agh.ics.oop.MoveDirection.RIGHT;
import static java.lang.System.out;

public class World {
    public static void start(){
        out.println("Start");
    }
    public static void end(){
        out.println("Stop");
    }
    public static void changeToDirect(MoveDirection[] tab, String[] arg){
        int i=0;
        for(String znak:arg){
            tab[i]= MoveDirection.stringToDirection(znak);
            i+=1;
        }
    }
    public static void run(MoveDirection[] tab){
        for(MoveDirection move:tab){
            String message=switch(move){
                case FORWARD->"Zwierzak idzie do przodu";
                case BACKWARD->"Zwierzak idzie do tyłu";
                case RIGHT->"Zwierzak skręca w prawo";
                case LEFT->"Zwierzak skręca w lewo";
                default -> "Nieznana komenda";
            };
            out.println(message);
        }
    }

    public static void main(String[] args) {
        MoveDirection[] tab= new MoveDirection[args.length];
        Animal animal = new Animal();

        World.start();
        out.println(animal.toString());
        World.changeToDirect(tab,args);
        World.run(tab);
        MoveDirection [] moves=OptionsParser.parse(args);
        for(MoveDirection move:moves){
            animal.move(move);
        }
        out.println(animal.toString());
        World.end();
    }
}