package chapter2;

/**
 * @author jhmarryme.cn
 * @date 2019/8/30 14:57
 */
public class Code3_FindDuplicateNumber {

    public static boolean find(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            while(arr[i] != i){
                if (arr[i] == arr[arr[i]]){
                    return true;
                }

                int temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 1, 0 ,6, 5, 4};
        System.out.println(find(arr));
    }
}
