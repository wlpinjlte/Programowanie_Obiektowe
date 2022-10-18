package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString(){
        return switch(this){
            case NORTH -> "Północ";
            case EAST -> "Zachód";
            case WEST -> "Wschód";
            case SOUTH -> "Południe";
        };
    }

    public MapDirection next(){
        return switch(this){
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case WEST -> NORTH;
            case SOUTH -> WEST;
        };
    }

    public MapDirection previous(){
        return switch(this){
            case NORTH -> WEST;
            case EAST -> NORTH;
            case WEST -> SOUTH;
            case SOUTH -> EAST;
        };
    }

    public Vector2d toUnitVector(){
        return switch(this){
            case NORTH -> new Vector2d(0,1);
            case EAST -> new Vector2d(1,0);
            case WEST -> new Vector2d(-1,0);
            case SOUTH -> new Vector2d(0,-1);
        };
    }
}
