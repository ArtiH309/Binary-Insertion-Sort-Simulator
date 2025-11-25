import java.io.*;
import java.util.*; //importing all necessary libraries
//Sorting a txt file of students by their IDs using Binary Insertion Sort
public class BinaryInsertionSort {
    //method that implements the algorithm
    private static void binaryInsertionSort(Student[] A){
        int n = A.length; //setting n to length of array
        //main for loop
        for(int i=1; i<n; i++){
            Student v = A[i]; //setting the temp variables v l r
            int l=0;
            int r=i-1;
            //main binary search loop
            while(l<=r){
                int m = (l+r)/2; //sets middle
                if(v.getID()>A[m].getID()){ //the key comparison of the student's IDs, if student at v is greater than the student at the middle's ID
                    l=m+1; //if its in 2nd half, set l to mid+1
                }
                else{
                    r=m-1; //if its in the first half set r to mid-1
                }
            }
            //Insertion Sort portion where shifts occur
            int j=i-1;
            while(j>=l){
                A[j+1]=A[j]; //performing the shifts
                j=j-1;
            }
            A[l]=v; //sends v to where it should go as far left as it needs to
        }

    }
    public static void main(String[] args) throws Exception {//main method
        //to read the txt file
        Scanner sc = new Scanner(new File("students.txt"));
        //counting the number of students
        int count=0;
        while(sc.hasNextLine()){
            sc.nextLine();
            count++;
        }
        sc.close();
        //an array of students of the length equal to number of students
        Student[] students = new Student[count];
        //reading all of the data in the file, parsing and adding it to the students array
        sc = new Scanner(new File("students.txt"));
        int index=0;
        while(sc.hasNextLine()){
            String[] line = sc.nextLine().split(",");
            students[index] = new Student(Integer.parseInt(line[0].trim()), line[1].trim(), Integer.parseInt(line[2].trim()), Double.parseDouble(line[3].trim()));
            index++;
        }
        sc.close();
        //loop to print each student in the array from the txt file before the sorting
        System.out.println("Students Before Sorting: ");
        for(Student s : students){
            System.out.println(s);
        }
        //sort the array using the Binary Insertion Sort
        binaryInsertionSort(students);
        //loop to print the students after sorting is done
        System.out.println("\nStudents After Sorting: ");
        for(Student s : students){
            System.out.println(s);
        }
        //To create a new txt file with the sorted students
        PrintWriter pw = new PrintWriter("sorted_students.txt");
        for(Student s : students){
            pw.println(s.toString());
        }
        pw.close();
        System.out.println("\nSorted Students saved to sorted_students.txt");
    }
}
