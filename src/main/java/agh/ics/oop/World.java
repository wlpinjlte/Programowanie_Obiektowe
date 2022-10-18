package agh.ics.oop;

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
        World.start();
        World.changeToDirect(tab,args);
        World.run(tab);
        World.end();
    }
}