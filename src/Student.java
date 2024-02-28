import java.util.ArrayList;

public class Student extends Person {
    private static int MAX_COURSES = 12;
    private int coursetracker;
    private Course[] courseList;
    private double GPA;

    public Student(String name, String address, int birthDay, int birthMonth, int birthYear) {
        super(name, address, birthDay, birthMonth, birthYear);
        coursetracker = 0;
        courseList = new Course[12];
    }



    public String toString(){
        return "Test";
    }

    public void addCourse(String newCourseIdentifier, double mark) {
        if (coursetracker < MAX_COURSES) {
            Course newCourse = new Course(newCourseIdentifier, mark);
            this.courseList[coursetracker] = newCourse;
        } else {
            System.out.println("Maximum number of courses reached.");
        }
        coursetracker += 1;
    }


    public double calcGpa() {
        double totalMarks = 0;
        for (int i = 0; i < coursetracker; i++) {
            totalMarks += courseList[i].getGrade();
        }
        this.GPA = coursetracker > 0 ? totalMarks / coursetracker : 0;
        return this.GPA;
    }


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
