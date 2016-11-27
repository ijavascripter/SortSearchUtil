import java.util.ArrayList;
import java.util.Random;

/**
 * Created by journ on 11/26/2016.
 */
public class Tester {
    public static void main(String[] args) {
        SortSearchUtil ssu = new SortSearchUtil();
        randArray randomArray = new randArray(1000000);
        ArrayList<Integer> test = new ArrayList<>();

        test = randomArray.getIntArray();
        ArrayList<Integer> test2 = test;
        ArrayList<Integer> test3 = test;
        ssu.quickSort(test, 0, test.size() - 1);

        long startTime = System.nanoTime();
        long endTime = System.nanoTime();
        ssu.mergeSort(test);
        long duration = (endTime - startTime);
        System.out.println("Merge Sort: " + duration);


        startTime = System.nanoTime();
        endTime = System.nanoTime();
        ssu.quickSort(test2, 0, test.size() - 1);
        duration = (endTime - startTime);
        System.out.println("Quick Sort: " + duration);


        startTime = System.nanoTime();
        endTime = System.nanoTime();
        ssu.shellSort(test3);
        duration = (endTime - startTime);
        System.out.println("Shell Sort: " + duration);
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + "");
        }
    }

    public static class randArray {
        private Random random;
        private ArrayList<Integer> intArray;

        public randArray(int arraySize) {
            this.random = new Random(System.currentTimeMillis());
            this.intArray = new ArrayList<>();
            for (int i = 0; i < arraySize; i++) {
                this.intArray.add(i, random.nextInt());
            }
        }

        public ArrayList<Integer> getIntArray() {
            return this.intArray;
        }
    }
}
