public class Course {
    private String id;
    private double grade;

    //basic constructor for the course
    public Course() {
        id = "Test ID";
        grade = 0;
    }

    //constructor taht sets up course's information
    public Course(String id, double grade) {
        this.id = id;
        this.grade = grade;
    }

    //method that sets up a grade for the course
    public void setMark(double newMark) {
        this.grade = newMark;
    }

    //getter that returns course id
    public String getId() {
        return this.id;
    }

    //getter that returns course grade

    public double getGrade() {
        return this.grade;
    }
}
