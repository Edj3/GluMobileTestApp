package question5;

import java.util.ArrayList;

/*
 * EJ Mann - 9/8/2015
 */
public class Question5Main {
	//List of all entities
	static ArrayList<GameEntity> entityList;
	
	public static void main(String[] args) {
		
		//Create List to house all game entities in 2D Map
		entityList = new ArrayList<GameEntity>();
		entityList.add(new GameEntity(0, 0, 10));
		entityList.add(new GameEntity(1, 1, 4));
		entityList.add(new GameEntity(2, 2, 4));
		entityList.add(new GameEntity(10, 10, 4));
		entityList.add(new GameEntity(12, 12, 4));
		entityList.add(new GameEntity(4, 4, 4));
		
		//Call function and store returned list in an array list
		@SuppressWarnings("unused")
		
		//Using first entity in the list as the point to find neighbors of
		ArrayList<GameEntity> neighborList = findNeighbors(entityList.get(0));
	}
	
	//Function to find and return a list of neighboring entities
	public static ArrayList<GameEntity> findNeighbors(GameEntity entity){
		//initialize list of neighbors
	    ArrayList<GameEntity> nList = new ArrayList<GameEntity>();
	    
	    //Counter
	    int i = 0;
	    
	    //Pythagorean Theorem
	    //(x2 - x1)^2 + (y2 - y1)^2 <= r2^2
	    System.out.println("Your neighbors for entity (" + entity.x + ", " + entity.y +") are:");
	    for(GameEntity e: entityList){
            i++;
            if (Math.pow((entity.x - e.x), 2) + Math.pow((entity.y - e.y), 2) < Math.pow(entity.radius, 2)){
                nList.add(e);
                System.out.println("Entity " + i + " (" + e.x + ", " + e.y +")");
            }
	    }
        return nList;
	}

}
