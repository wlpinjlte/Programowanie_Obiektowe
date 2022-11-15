package agh.ics.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GrassField extends AbstractWorldMap{
    final Vector2d endOfGrassField;

    public GrassField(int amount){
        endOfGrassField=new Vector2d((int) Math.sqrt(10*amount), (int) Math.sqrt(10*amount));

        ArrayList<Vector2d> availableFields=findingAvabileFields();
        //shuffle list
        Collections.shuffle(availableFields);

        //adding grass to map
        if(amount<=availableFields.size()){
            for(int i=0;i<amount;i++){
                map.put(availableFields.get(i), new Grass(availableFields.get(i)));
            }
        }else{//adding max of availabelFields when amount>availabelFields.size()
            for(int i=0;i<availableFields.size();i++){
                map.put(availableFields.get(i), new Grass(availableFields.get(i)));
            }
        }

    }

    private ArrayList<Vector2d> findingAvabileFields(){
        ArrayList<Vector2d> availableFields=new ArrayList<>();
        //finding potencial position

        for(int i=0;i< endOfGrassField.x();i++){
            for(int j=0;j<endOfGrassField.y();j++){
                Vector2d potencialPosition=new Vector2d(i,j);
                if(objectAt(potencialPosition)==null){
                    availableFields.add(potencialPosition);
                }
            }
        }
        return availableFields;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position)instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) {
        if(objectAt(animal.getPosition())instanceof Animal){
            return false;
        }
        if (animal.getPreviousPosition() != null) {
            map.remove(animal.getPreviousPosition());
        }
        if(objectAt(animal.getPosition())instanceof Grass){
            ArrayList<Vector2d> availableFields=findingAvabileFields();
            Collections.shuffle(availableFields);
            if(availableFields.size()>0) {//adding only when space on the map
                map.put(availableFields.get(0), new Grass(availableFields.get(0)));
            }
        }
        map.put(animal.getPosition(),animal);
        return true;
    }

    @Override
    public Vector2d lowerLeftDraw(){

        Vector2d lowerPosition= map.keySet().stream().findFirst().get();

        for(Vector2d position:map.keySet()){
            lowerPosition=lowerPosition.lowerLeft(position);
        }
        return lowerPosition;
    }

    @Override
    public Vector2d upperRightDraw(){

        Vector2d upperPosition= map.keySet().stream().findFirst().get();
        for(Vector2d position:map.keySet()){
            upperPosition=upperPosition.upperRight(position);
        }
        return upperPosition;
    }
}
