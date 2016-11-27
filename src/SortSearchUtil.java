import java.util.*;

/**
 * Created by jeff on 10/29/15.
 *
 * A Collection of search and sort algorithms
 */
public class SortSearchUtil {

    public void shellSort(ArrayList<Integer> array){
        int increment = array.size() / 2;
        while(increment > 0){
            for(int i = increment; i < array.size(); i++){
                int j = i;
                int temp = array.get(i);
                while(j >= increment && array.get(j - increment) > temp){
                    array.set(j, array.get(j - increment));
                    j = j - increment;
                }
                array.set(j, temp);
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

    public <E extends Comparable<? super E>> List<E> mergeSort(List<E> m){
        if(m.size() <= 1) return m;

        int middle = m.size() / 2;
        List<E> left = m.subList(0, middle);
        List<E> right = m.subList(middle, m.size());

        right = mergeSort(right);
        left = mergeSort(left);
        List<E> result = merge(left, right);

        return result;
    }

    public <E extends Comparable<? super E>> List<E> merge(List<E> left, List<E> right){
        List<E> result = new ArrayList<E>();
        Iterator<E> it1 = left.iterator();
        Iterator<E> it2 = right.iterator();

        E x = it1.next();
        E y = it2.next();
        while (true){
            //change the direction of this comparison to change the direction of the sort
            if(x.compareTo(y) <= 0){
                result.add(x);
                if(it1.hasNext()){
                    x = it1.next();
                }else{
                    result.add(y);
                    while(it2.hasNext()){
                        result.add(it2.next());
                    }
                    break;
                }
            }else{
                result.add(y);
                if(it2.hasNext()){
                    y = it2.next();
                }else{
                    result.add(x);
                    while (it1.hasNext()){
                        result.add(it1.next());
                    }
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Quicksort over an array
     * @param arr int[]
     * @param low
     * @param high
     */
    public void quickSort(ArrayList<Integer> arr, int low, int high) {
        if (arr == null || arr.size() == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr.get(middle);

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr.get(i) < pivot) {
                i++;
            }

            while (arr.get(j) > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }
}