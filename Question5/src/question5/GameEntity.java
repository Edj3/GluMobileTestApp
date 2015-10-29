package question5;

//2D space considered only as depicted by example
public class GameEntity {
	  //I could have used the java point class but decided to keep things simple
	  int x;
	  int y;
	  float radius;
	 
	  //Constructor for location & radius
	  GameEntity(int x, int y, float radius){
          this.x = x;
          this.y = y;
          this.radius = radius;
	  }
}