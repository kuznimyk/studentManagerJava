import java.util.ArrayList;

public class Student extends Person {
//    set maximum amout of courses that student can enroll
    private static int MAX_COURSES = 12;
    //set the tracker that tracks the amount of courses the student rolled in
    private int coursetracker;
    //create array of courses
    private Course[] courseList;
    private double GPA;

    //constructor that sets students id, his name and his other data

    public Student(String name, String address, int birthDay, int birthMonth, int birthYear) {
        super(name, address, birthDay, birthMonth, birthYear);
        coursetracker = 0;
        courseList = new Course[12];
    }



    //toString class
    public String toString(){
        return "Test";
    }


    //addcourse method. Checks for maximum amout of courses. If not, then adds up course to the array
    public void addCourse(String newCourseIdentifier, double mark) {
        if (coursetracker < MAX_COURSES) {
            Course newCourse = new Course(newCourseIdentifier, mark);
            this.courseList[coursetracker] = newCourse;
        } else {
            System.out.println("Maximum number of courses reached.");
        }
        coursetracker += 1;
    }



    //calculates gpa by suming up all grades from courses and diving them by course amount
    public double calcGpa() {
        double totalMarks = 0;
        for (int i = 0; i < coursetracker; i++) {
            totalMarks += courseList[i].getGrade();
        }
        this.GPA = coursetracker > 0 ? totalMarks / coursetracker : 0;
        return this.GPA;
    }


    //prints out report
    public void printReport() {
        System.out.println("===============================================");
        System.out.println(this.id + "\n" + name + "\r\n" + adress);
        System.out.println("--------------------------------------------");
        for (int i = 0; i < coursetracker; i++) {
            System.out.printf("   %s:        %.2f\r\n", courseList[i].getId(), courseList[i].getGrade());
        }
        System.out.printf("\r\n         GPA:        %.2f\r\n", this.calcGpa());
        System.out.println("===============================================");
    }
}
