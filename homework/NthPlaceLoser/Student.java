public class Student implements Comparable<Student>{
    public int rank;
    public String name;

    public Student(int rank, String name){
        this.rank = rank;
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        // TODO implement this yourself
        //System.out.println("haha");
        if (this.rank < o.rank) {
           // System.out.println("haha1");
            return -1;
        }
        if (this.rank > o.rank) {
            //System.out.println("haha2");
            return 1; 
        }
        if (this.rank == o.rank) {
            int l1 = this.name.length(); 
            int l2 = o.name.length(); 
            if (l1 == l2) {
            for (int i = 0; i < l1 && i < l2; i++) {
                int str1_ch = (int)this.name.charAt(i);
                int str2_ch = (int)o.name.charAt(i);  
                if(str1_ch == str2_ch) {
                    continue; 
                }
                else {
                    if (str1_ch - str2_ch < 0) {
                       // System.out.println(str1_ch - str2_ch); 
                        return -1;
                    }
                    else if (str1_ch - str2_ch > 0) {
                       // System.out.println(str1_ch - str2_ch); 
                        return 1;
                    }
                }
            }
        }
        else if (l1 < l2) {
            for (int i = 0; i < l1; i++) {
                int str1_ch = (int)this.name.charAt(i);
                int str2_ch = (int)o.name.charAt(i);  
                if(str1_ch == str2_ch) {
                    continue; 
                }
                else {
                    if (str1_ch - str2_ch < 0) {
                        //System.out.println(str1_ch - str2_ch); 
                        return -1;
                    }
                    else if (str1_ch - str2_ch > 0) {
                        //System.out.println(str1_ch - str2_ch); 
                        return 1;
                    }
                }
            }
            return -1; 
        }
        else {
            for (int i = 0; i < l2; i++) {
                int str1_ch = (int)this.name.charAt(i);
                int str2_ch = (int)o.name.charAt(i); 
                if(str1_ch == str2_ch) {
                    continue; 
                }
                else {
                    if (str1_ch - str2_ch < 0) {
                        //System.out.println(str1_ch - str2_ch); 
                        return -1;
                    }
                    else if (str1_ch - str2_ch > 0) {
                        //System.out.println(str1_ch - str2_ch); 
                        return 1;
                    }
                }
            }
            return 1; 
        }
        }
        return 0;
    }
    public static void main(String[] args) {
        //Student one = new Student(1, "Aucy");
        //Student two = new Student(1, "Aaca");
        //System.out.println(one.compareTo(two));
    }
}
