import java.util.ArrayList;

public class Student extends Person {
    private static int MAX_COURSES = 7;
    private int coursetracker;
    private Course[] courseList;
    private double GPA;

    public Student(String name, String address, int birthDay, int birthMonth, int birthYear) {
        super(name, address, birthDay, birthMonth, birthYear);
        coursetracker = 0;
        courseList = new Course[7];
    }


    public void addCourse(String newCourseIdentifier, double mark) {
        if (courseList.length < MAX_COURSES) {
            Course newCourse = new Course(newCourseIdentifier, mark);
            this.courseList[coursetracker] = newCourse;
        } else {
            System.out.println("Maximum number of courses reached.");
        }
        coursetracker += 1;
    }


    public double calcGpa() {
        double totalMarks = 0;
        for (Course course : courseList) {
            totalMarks += course.getGrade();
        }
        this.GPA = coursetracker > 0 ? totalMarks / coursetracker : 0;
        return this.GPA;
    }


    public void printReport() {
        System.out.println("===============================================");
        System.out.println(name + " " + adress);
        System.out.println("----------------------------------------------");
        for (Course course : courseList) {
            System.out.printf("   %s:        %.2f\n", course.getId(), course.getGrade());
        }
        System.out.printf("       GPA:        %.2f\n", this.calcGpa());
        System.out.println("===============================================");
    }
}
