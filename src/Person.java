

//abstract class person that will be inherited by other classes
public abstract class Person {
    //unique id tracker
    protected static int idTracker = 1000001;
    protected int id;
    protected String name;
    protected String adress;
    protected int[] birthdate;

    //basic constructor that sets up id of the person
    protected Person(){
        this.id = idTracker;
        idTracker += 3;
        birthdate = new int[3];

    }

    //parametric construcor that initializes all person's data
    protected Person(String name, String adress, int birthDay, int birthMonth, int birthYear){
        this.id = idTracker;
        idTracker += 3;
        birthdate = new int[3];
        birthdate = new int[3];
        this.name = name;
        this.adress = adress;
        birthdate[0] = birthDay;
        birthdate[1] = birthMonth;
        birthdate[2] = birthYear;
    }
}
