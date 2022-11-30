package agh.ics.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GrassField extends AbstractWorldMap{
    final Vector2d endOfGrassField;

    public GrassField(int amount) throws IllegalAccessException {
        endOfGrassField=new Vector2d((int) Math.sqrt(10*amount), (int) Math.sqrt(10*amount));

        ArrayList<Vector2d> availableFields=findingAvabileFields();
        //shuffle list
        Collections.shuffle(availableFields);

        //adding grass to map
        if(amount<=availableFields.size()){
            for(int i=0;i<amount;i++){
                place(new Grass(availableFields.get(i)));
            }
        }else{//adding max of availabelFields when amount>availabelFields.size()
            for(int i=0;i<availableFields.size();i++){
                place(new Grass(availableFields.get(i)));
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
    public void changingGrassPosition(Vector2d grassPosition){
        Grass grass=(Grass) objectAt(grassPosition);
        ArrayList<Vector2d> availableFields=findingAvabileFields();
        Collections.shuffle(availableFields);
        if(availableFields.size()>0) {//adding only when space on the map
            grass.positionChanged(grassPosition,availableFields.get(0));
            grass.position=availableFields.get(0);
        }
    }
    @Override
    public void place(AbstractWorldMapElement animal) throws IllegalAccessException {
        if(objectAt(animal.getPosition())instanceof Grass){
            changingGrassPosition(animal.getPosition());
        }
        super.place(animal);
        map.put(animal.getPosition(),animal);
    }

    @Override
    public void positionChange(IMapElement element,Vector2d oldPosition, Vector2d newPosition){
        if(objectAt(newPosition)instanceof Grass){
            changingGrassPosition(newPosition);
        }
        super.positionChange(element,oldPosition, newPosition);
    }
}
