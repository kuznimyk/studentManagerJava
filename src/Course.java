public class Course {
    private String id;
    private double grade;

    public Course() {
        id = "Test ID";
        grade = 0;
    }

    public Course(String id, double grade) {
        this.id = id;
        this.grade = grade;
    }

       public void setMark(double newMark) {
        this.grade = newMark;
    }

    public String getId() {
        return this.id;
    }

    public double getGrade() {
        return this.grade;
    }
}
