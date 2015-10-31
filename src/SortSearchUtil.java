import java.util.LinkedList;
import java.util.Random;

/**
 * Created by jeff on 10/29/15.
 */
public class SortSearchUtil {

    public void shellSort(int[] array){
        int increment = array.length / 2;
        while(increment > 0){
            for(int i = increment; i < array.length; i++){
                int j = i;
                int temp = array[i];
                while(j >= increment && array[j - increment] > temp){
                    array[j] = array[j-increment];
                    j = j - increment;
                }
                array[j] = temp;
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            }
        }
    }

    public int binarySearch(int value, int[] array){
        int first = 0;
        int last = array.length - 1;
        int middle = (first + last) / 2;

        while(first <= last){
            if(array[middle] < value){
                first = middle + 1;
            }else if(array[middle] == value){
                return array[middle];
            }
            else{
                last = middle - 1;
            }
            middle = (first + last)/2;
            if(first > last){
                return -1;
            }
        }
        return -1;
    }

}

class SortSearchUtilTester{
    public static class randArray {
        private Random random;
        private int[] intArray;

        public randArray(int arraySize, int seed) {
            this.random = new Random(seed);
            this.intArray = new int[arraySize];
            for (int i = 0; i < arraySize; i++) {
                this.intArray[i] = random.nextInt(101);
            }
        }

        public int[] getIntArray() {
            return this.intArray;
        }
    }

    public static void main(String[] args){
        SortSearchUtil ssu = new SortSearchUtil();
        randArray randomArray = new randArray(1000,(int) System.currentTimeMillis());
        int[] test = randomArray.getIntArray();
        ssu.shellSort(test);
        printArray(test);


        System.out.println(ssu.binarySearch(5,test));
    }

    private static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]+"");
        }
    }
}