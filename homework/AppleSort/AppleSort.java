import java.util.ArrayList;

public class AppleSort {

    /**
     * Implement this method that takes in an arraylist of Apples and sorts them into one giant array of Apples.
     * You are free to implement any helper methods you need.
     * @param apples
     * @return
     */
    public static Comparable[] sort(ArrayList<Apple[]> apples){
        int arrayListSize = apples.size();
        Comparable[] answer = makeNewArrayMerge(apples.get(0), apples.get(1)); 
        for (int i = 2; i < arrayListSize; i++ ) {
            answer = makeNewArrayMerge(answer, apples.get(i)); 
        }
        return answer; 
        /*int arrayListSize = apples.size();
        int count = 0;
        for (int i = 0; i < arrayListSize; i++) {
            count = count + apples.get(i).length; 
        }
        Comparable[] lastList = new Comparable[count]; 
        int[] basketIndex = new int[arrayListSize];
        for (int i = 0; i < arrayListSize; i++) {
            Apple min = apples.get(1)[basketIndex[1]];
            for (int j = 1, j < arrayListSize; j++) {
                if (less(apples.get(1)[basketIndex[i]], a)) {
                    min = apples.get(1)[basketIndex[i]]; 
                    basketIndex[i] = basketIndex[i] + 1; 
                }
            }
            //insert to the arraylist
            //how to change arraylist to array 
        }
        int arrayListSize = apples.size();
        int count = 0;
        for (int i = 0; i < arrayListSize; i++) {
            count = count + apples.get(i).length; 
        }
        Comparable[] lastList = new Comparable[count]; 
        for (int i = 0; i < arrayListSize; i++) {
            for (int j = 0; j < apples.get(i).length; j++) {
                for (int k = 0; k < count; k++) {
                    lastList[k] = apples.get(i)[j]; 
                }
            }
        } //now I form my unsorted final array 
        //sort and merge my unsorted array  
        sort(lastList, 0, arrayListSize - 1); 
        return lastList;
    }
    //merge helper function 
    public static void merge (Comparable[] arr, int l, int m, int h) {
        int s1 = m - l + 1; //size of the first subarray
        int s2 = h - m; //size of the second subarray
        //temp arrays 
        Comparable[] left = new Comparable[s1]; 
        for (int i = 0; i < s1; i++) { //copy the data to the left temp array
            left[i] = arr[l+i];
        }
        Comparable[] right = new Comparable[s2]; 
        for (int j = 0; j < s2; j++) { //copy the data to the right temp array 
            right[j] = arr[m+1+j]; 
        }
        //To merge the subarrays 
        int i = 0;
        int j = 0;
        int k = l;
        while (i < s1 && j < s2) {
            if (left[i].compareTo(right[j]) == -1 || left[i].compareTo(right[j]) == 0) {
                arr[k] = left[i]; 
                i++; 
            }
            else {  //when compareTo returns 1 
                arr[k] = right[j];
                j++; 
            }
            k++;
        }
        //copying the remaining elements from the left array
        while (i < s1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        //copying the remaining elements from the right array
        while(j < s2) {
            arr[k] = right[j];
            j++;
            k++; 
        }
    }

    public static void sort (Comparable[] arr, int l, int h) {
        if (l < h) {
            int m = l + (h-l)/2; // find the midpoint, avoid integer overflow 
            sort(arr, l, m); //sort the first half 
            sort(arr, m+1, h); //sort the second half 
            merge(arr, l, m, h); //merge the sorted halves 
        }*/
        //Comparable[] lastList = new Comparable[1];
        //return lastList; 
    }
    private static Comparable[] makeNewArrayMerge(Comparable[] a, Comparable[] b) {
        int size = a.length + b.length;
        int count = 0; 
        Comparable[] newArray = new Comparable[size]; 
        for (int i = 0; i < a.length; i++) {
            newArray[i] = a[i];
            count++; 
        }
        for (int j = 0; j < b.length; j++) {
            newArray[count] = b[j];
            count++; 
        }
        //already make the newArray; 
        //make a sorted new array -> merge 
        Comparable[] aux = new Comparable[size]; 
        for (int k = 0; k < size; k++) {
            aux[k] = newArray[k]; 
        } //copy the newArray to aux 
        int i = 0; 
        int mid = a.length - 1;
        int j = mid + 1; 
        int hi = newArray.length - 1; 
        for (int k = 0; k <= hi; k++) {
            if (i > mid) {
                newArray[k] = aux[j++]; 
            }
            else if (j > hi) {
                newArray[k] = aux[i++];
            }
            else if (less(aux[j], aux[i])) {
                newArray[k] = aux[j++];
            }
            else {
                newArray[k] = aux[i++]; 
            }
        }
        return newArray; 
    }
    
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void main(String[] args) {

    }

}

