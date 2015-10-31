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

}

class SortSearchUtilTester{
    public static class randArray {
        private Random random;
        private int[] intArray;

        public randArray(int arraySize, int seed) {
            this.random = new Random(seed);
            this.intArray = new int[arraySize];
            for (int i = 0; i < arraySize; i++) {
                this.intArray[i] = random.nextInt();
            }
        }

        public int[] getIntArray() {
            return this.intArray;
        }
    }

    public static void main(String[] args){
        SortSearchUtil ssu = new SortSearchUtil();
        randArray randomArray = new randArray(100000, 100);
        int[] test = randomArray.getIntArray();
        ssu.shellSort(test);
        printArray(test);
    }

    private static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]+"");
        }
    }
}