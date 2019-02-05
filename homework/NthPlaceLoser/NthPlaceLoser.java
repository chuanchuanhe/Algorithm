public class NthPlaceLoser {
    public static void knuthShuffle(Student[] aList) {
        int n = aList.length;
        for (int i = 0; i < n; i++) {
            int r = (int) (Math.random() * (i + 1));
            Student swap = aList[r];
            aList[r] = aList[i];
            aList[i] = swap;
        }
    }
    public static Student NthPlaceLoser(Student[] aList, int N) {
        // TODO implement this yourself
        knuthShuffle(aList);
        int answer = aList.length -1 -N; 
        int lo = 0; 
        int hi = aList.length - 1;
        while (hi > lo) {
            int j = partition(aList, lo, hi); 
            if (j < answer) {
                lo = j + 1;
            }
            else if (j > answer) {
                hi = j - 1; 
            }
            else {
                return aList[answer]; 
            }
        }
        return aList[answer];
    }
    //helper method -- partition 
    //lefthand side: hi righthand side: lo 
    public static int partition(Student[] a, int pivot, int end) {
        /*int i = pivot + 1;
        int j = end; //why in the slide it is lo + 1 
        while (true) {
            while (less(a[pivot], a[i++])) {
                if (i == end) break; //switched i == end to i > end
            }
            while (less(a[j--], a[pivot])) {
                if (j == pivot + 1) break; //switched i == end to i > end
            }
            if (i >= j) break; //cornerr case -> u dunno which one is bigger a[i] and a[j] i=j or i-j= 1
            exch(a, i, j); //swap 
        }
        exch(a, pivot, j); //swap with partitioning item 
        return j;*/
        int i = pivot;
        int j = end + 1;
        while (true) {
            while (less(a[++i], a[pivot])) {
                if (i == end) break; //switched i == end to i > end
            }
            while (less(a[pivot], a[--j])) {
                if (j == pivot) break; //switched i == end to i > end
            }
            if (i >= j) break; //cornerr case -> u dunno which one is bigger a[i] and a[j] i=j or i-j= 1
            exch(a, i, j); //swap 
        }
        exch(a, pivot, j); //swap with partitioning item 
        return j;
    }
    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    /**
     * This method returns whether a student is less than another student in respect
     * to how your compareTo method is defined
     * @param v First Student
     * @param w Second Student
     * @return if v (first student) is less than w (second student)
     */
    private static boolean less(Student v, Student w) {
        if (v == w) return false;   // optimization when reference equals
        return v.compareTo(w) < 0;
    }

    /**
     * This method exchanges a[i] and a[j] in an array
     * @param a array in which you want to swap
     * @param i index of first item
     * @param j index of second item
     */
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /***************************************************************************
     *  Main method
     ***************************************************************************/

    public static void main(String[] args) {
        Student one = new Student(1, "Aucy");
        Student two = new Student(1, "Aaca");
        Student three = new Student(2, "Haha");
        Student four = new Student(2, "Exex"); 
        Student[] students = new Student[4];
        students[0] = one;
        students[1] = two;
        students[2] = three;
        students[3] = four;
        knuthShuffle(students);
        for (int i = 0; i < students.length; i++){
            System.out.println(students[i].rank);
            System.out.println(students[i].name);
        }
        Student answer = NthPlaceLoser(students, 0);
        System.out.println(answer.rank); 
        System.out.println(answer.name); 
    }
}


