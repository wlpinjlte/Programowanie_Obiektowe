package agh.ics.oop;

public class Grass extends AbstractWorldMapElement{

    public Grass(Vector2d position){
        this.position=position;
    }

    public Vector2d getPosition(){
        return position;
    }

    @Override
    public String toString(){
        return "*";
    }

    @Override
    public String getImageResource() {
        return "src/main/resources/grass.png";
    }

    @Override
    public String toGuiString() {
        return "Trawa";
    }
}
