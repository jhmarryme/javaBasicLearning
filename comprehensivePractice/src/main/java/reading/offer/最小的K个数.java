package reading.offer;

import java.util.Arrays;
import java.util.ArrayList;
public class 最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(input == null){
            return null;
        }
        if(input.length < k){
            return result;
        }
        Arrays.sort(input);
        for(int i = 0; i < k; i++){
            result.add(input[i]);
        }
        return result;
    }
}