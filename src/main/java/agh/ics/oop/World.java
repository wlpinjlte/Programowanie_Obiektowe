package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class World {
    public static void start(){
        out.println("Start");
    }
    public static void zakoniczenie(){
        out.println("Stop");
    }
    public static void zmiana1(List<Direction> tab){
        out.println("Podaj Argumenty");
        Scanner scanner = new Scanner(System.in);
        String slowo=scanner.nextLine();
        String temp="";
        for(int i=0;i<slowo.length();i++){
            if (slowo.charAt(i)==','||slowo.charAt(i)==' ') {
                tab.add(Direction.valueOf(temp));
                temp="";
            }else{
                temp+=slowo.charAt(i);
            }
        }
        tab.add(Direction.valueOf(temp));
    }
    public static void zmiana2(List<Direction> tab,String[] arg){
        for(String znak:arg){
            tab.add(Direction.valueOf(znak));
        }
    }
    public static void run(List<Direction> tab){
        for(Direction ruch:tab){
            String message=switch(ruch){
                case f->"Zwierzak idzie do przodu";
                case b->"Zwierzak idzie do tyłu";
                case r->"Zwierzak skręca w prawo";
                case l->"Zwierzak skręca w lewo";
                default -> "Nieznana komenda";
            };
            out.println(message);
        }
    }

    public static void main(String[] args) {
        List<Direction> tab=new ArrayList<>();
        World.start();
        if (args.length==0) {
            World.zmiana1(tab);
        } else{
            World.zmiana2(tab,args);
        }
        World.run(tab);
        World.zakoniczenie();
    }
}