package question4;

/*
 * EJ Mann - 9/8/2015
 */

/*	-- Derivation of formula R = I - 2 ( I . N ) N --
 
	Scale the normal N so that it is the vector connecting the -I vector and the R vector itself
	R = N (Scaled) - I
	 
	Split scaled N in half so that there is a constant c that can be doubled to equal N (scaled)
	2C = N (Scaled)
	 
	Replace N(scaled) with 2C
	R = 2C - I
	 
	Replace C with the projection
	R = 2 (( (N . I) / | N |^2) - I
	 
	Simplify since N is normalized
	R = 2 ( N . I) N - I
	 
	Adjust the problem to match given formula
	R = I - 2 (I . N) N
	 
	Evaluation Using Example Vectors:
	I = [1,0]
	N = [1,0]
	R = [1,0] - 2 ( [1,0] . [1,0]) [1,0]
	R = [1,0] - 2 ( 1 + 0 ) [1,0]
	R = [1,0] - 2 [1,0]
	R = [1,0] - [2,0]
	R = [-1, 0]
	
 */

public class Question4Main {

	public static void main(String[] args) {
		//initialize i & n vectors using class
		MathVector i = new MathVector(1,0);
		MathVector n = new MathVector(1,0);
		//reflect i & n
		MathVector r = reflect(i, n);
		//Output reflection vector in nice format
		System.out.println("The vector of reflection = " + "[" + (int)r.x + "," + (int)r.y + "]");
	}
	
	// r = i - 2 (i . n) n
    public static MathVector reflect(MathVector i, MathVector n){
    	n.normalize(); //if it's not normalized, it will be
    	float dot = n.getDotProduct(i);
    	float dotDoubled = 2 * (int)dot;
    	MathVector nDotDoubled = n.scalarMultiply((int)dotDoubled);
    	MathVector r = i.subtract(nDotDoubled);
    	r.normalize(); //if it's not normalized, it will be
    	return r;
    }

}
