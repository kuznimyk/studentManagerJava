public class Student extends Person{
    private String[] courseList;
    private float GPA;
    public Student(){
        super();
        this.name = "Test Name";
        this.adress = "Test Adress";
        this.birthdate[0] = 1;
        this.birthdate[1] = 1;
        this.birthdate[2] = 2000;
    }
    public Student(String name,String adress, int birthDay, int birthMonth, int birthYear){
        super();
        this.name = name;
        this.adress = adress;
        this.birthdate[0] = birthDay;
        this.birthdate[1] = birthMonth;
        this.birthdate[2] = birthYear;

    }
}
