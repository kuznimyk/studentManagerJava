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
}
