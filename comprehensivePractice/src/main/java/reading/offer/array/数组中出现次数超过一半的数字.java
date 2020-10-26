package reading.offer.array;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class 数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0){
            return 0;
        }
        
        int result = array[0];
        int times = 1;

        for(int i = 0; i < array.length; i++){
            if(times == 0){
                result = array[i];
                times = 1;
            } else if(array[i] == result){
                times++;
            } else{
                times--;
            }
        }
        
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == result){
                count++;
            }
        }
        
        if(count > (array.length / 2)){
            return result;
        } else{
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,2,5,4,2};


        //boxed装箱
        final List<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toList());
        final Iterator<Integer> iterator = collect.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next() +  " ");
        }
        final int[] array = collect.stream().mapToInt(Integer::intValue).toArray();
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}