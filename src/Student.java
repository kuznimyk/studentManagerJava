import java.util.ArrayList;

public class Student extends Person {
    private Course[] courseList;
    private double GPA;

    public Student(String name, String address, int birthDay, int birthMonth, int birthYear) {


    }


    public void addCourse(String newCourseIdentifier, double mark) {
        if (courseList.size() < MAX_COURSES) {
            Course newCourse = new Course(newCourseIdentifier, mark);
            this.courseList.add(newCourse);
        } else {
            System.out.println("Maximum number of courses reached.");
        }
    }


    public double calcGpa() {
        double totalMarks = 0;
        for (Course course : courseList) {
            totalMarks += course.getGrade();
        }
        this.GPA = courseList.size() > 0 ? totalMarks / courseList.size() : 0;
        return this.GPA;
    }


    public void printReport() {
        System.out.println("===============================================");
        System.out.println(super.getName() + " " + super.getAddress());
        System.out.println("----------------------------------------------");
        for (Course course : courseList) {
            System.out.printf("   %s:        %.2f\n", course.getId(), course.getGrade());
        }
        System.out.printf("       GPA:        %.2f\n", this.calcGpa());
        System.out.println("===============================================");
    }
}
