package question2;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/*
 * EJ Mann - 9/8/2015
 */

public class Question2Main {

	public static void main(String[] args) {
		int duration[] = {3,5,4,11};
		int tones[] = {2,1,3,1};
		System.out.println("The total amount of songs Sarah can sing is " + songMax(duration, tones, 17));
	}
	
	public static int songMax(int[] duration, int[] tones, int totalTime){
        int loop = 0;
        int prev = 0;
        int stepDurationTotal = 0;
        int stepToneTotal = 0;
        int maxSongCount = 0;
        //use TreeMap to automatically sort values (ascending order)
        SortedMap<Integer, Integer> songToneMap = new TreeMap<Integer, Integer>();
        //if duration or tone array is null, alert user
        if(duration == null || tones == null){
        	System.out.println("Bro, you're empty.");
        }else{
        	//set the key of new map as all durations, set values of each duration to corresponding tone (assumption: tone array will always be same size as duration array)
            for(int i = 0; i < duration.length; i++){
                songToneMap.put(duration[i], tones[i]);
            }
        }
       
        //Loop through each item in the sorted map and perform logic
        for(Map.Entry<Integer, Integer> e: songToneMap.entrySet()){
            //always add current key to duration total
            stepDurationTotal += e.getKey();
            //check if you are on the first element or not
            if(loop == 0){
                //check if the first song is too long
                if(stepDurationTotal > totalTime){
                    return 0;
                }else{
                    maxSongCount++;
                }
            }else{
                //Get absolute value of difference between prev tone and current tone
                stepToneTotal += Math.abs(songToneMap.get(prev) - e.getValue());
                //check if current total of durations & tones is > total time
                if((stepDurationTotal + stepToneTotal) > totalTime){
                    return maxSongCount;
                }else{
                    maxSongCount++;
                }
            }
            //set current value to the prev variable & increment loop by 1
            prev = e.getKey();
            loop++;
            //System.out.println("My Tones Are " + e.getValue());
        }
        return maxSongCount;
	}

}


