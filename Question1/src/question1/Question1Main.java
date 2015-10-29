package question1;

/*
 * EJ Mann - 9/8/2015
 */

public class Question1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String stringToCompress = "aaabcccdeefffgggg";
		System.out.println(stringCompress(stringToCompress));
	}
	
	public static String stringCompress(String givenString){
        String compressedString = "";
        char prev = 0;
        int sequenceCount = 0;
        int size = givenString.length();
        //If string is null or blank, throw message
        if(givenString == null || givenString.isEmpty()){
            return "Oops, you gave me a blank string my friend.";
        }
       
        //If string is 1 character, then return the string itself
        if(givenString.length() < 2){
            return givenString;
        }
       
        //loop through each character in the array of characters in the string
        for(char current: givenString.toCharArray()){
            //decrement the size as you go through each character
            --size;
            //check if the previous character == current
            if(prev != current){
                //check if sequence count is 1 or not and perform string concatenation appropriately
                if(sequenceCount <= 1){
                    compressedString += "" + current;
                }else{
                    compressedString += "" + sequenceCount + "x" + current;
                }
                //reset count to 1 in the case where the character changes to a different character
                sequenceCount = 1;
            }else{
                //increment count in the case the character is repeated
                sequenceCount++;
                //special case for final character
                if(size == 0){
                    compressedString += "" + sequenceCount + "x";
                }
            }
            //set the value of the current char to the prev variable at the end of the iteration
            prev = current;
        }
        return compressedString;
	}

}
