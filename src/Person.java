public abstract class Person {
    protected static int idTracker = 1000001;
    protected int id;
    protected String name;
    protected String adress;
    protected int[] birthdate;


    protected Person(){
        this.id = idTracker;
        idTracker += 3;
        birthdate = new int[3];

    }
    protected Person(String name, String adress, int birthDay, int birthMonth, int birthYear){
        birthdate = new int[3];
        this.name = name;
        this.adress = adress;
        birthdate[0] = birthDay;
        birthdate[1] = birthMonth;
        birthdate[2] = birthYear;
    }
}
