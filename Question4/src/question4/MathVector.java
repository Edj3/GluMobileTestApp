package question4;

public class MathVector {
	//2D Vector considered only as depicted by problem example
    float x, y;

    //Constructor with x and y parameters (To keep it simple, I kept these as integers)
    MathVector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Vector Addition
    public MathVector add(MathVector vector2) {
        this.x += vector2.x;
        this.y += vector2.y;
        return this;
    }
    
    //Vector Subtraction - used in reflect calculation
    public MathVector subtract(MathVector vector2) {
        this.x -= vector2.x;
        this.y -= vector2.y;
        return this;
    }
    
    //Vector Scalar Multiply - used in reflect calculation
    public MathVector scalarMultiply(float multiplier) {
    	//make sure x and y stay as integers
    	this.x = this.x * multiplier;
    	this.y = this.y * multiplier;
    	return this;
    }
    
    //Pythagorean theorem = square components, add them, and get the square root - used in reflect calculation
    public float getMagnitude(){
    	return (float) Math.sqrt((Math.pow(this.x, 2) + Math.pow(this.y, 2)));	
    }
    
    
    //divide each component by the vector's overall magnitude
    public void normalize(){
    	float magnitude = this.getMagnitude();
    	//make sure x and y stay as integers
    	this.x = this.x / magnitude;
    	this.y = this.y / magnitude;
    }
    
    // x1y1 + x2y2
    public float getDotProduct(MathVector vector2){
    	return (this.x * vector2.x) + (this.y * vector2.y);    	
    }

}
