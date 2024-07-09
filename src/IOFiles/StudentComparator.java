//
//import java.util.*;
//
//public class StudentComparator {
//    int marks;
//    String name;
//    StudentComparator(int marks, String name){
//        this.marks=marks;
//        this.name=name;
//    }
//}
//
//
//Comparator<StudentComparator> comparator=new Comparator<StudentComparator>() {
//    @Override
//    public int compare(StudentComparator t1, StudentComparator t2) {
//        if (t1.marks>t2.marks) return 1;
//        if (t1.marks<t2.marks) return -1;
//        return 0;
//    }
//};
//
//
//
//public void main() {
//
//    List<StudentComparator> students = new ArrayList<StudentComparator>();
//    students.add(new StudentComparator(100, "a"));
//    students.add(new StudentComparator(99, "b"));
//    students.add(new StudentComparator(95, "c"));
//
//    Collections.sort(students, comparator);
//
//
//}
