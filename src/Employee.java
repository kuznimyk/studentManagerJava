public class Employee extends Person{
    protected int hoursWorked;
    protected double payRate;
    protected float grossPay;
    protected float tax;
    protected float CPP;
    protected float EI;

    public Employee(){
        super();
        this.name = "test name";
        this.adress = "test adress";
        this.birthdate[0] = 1;
        this.birthdate[1] = 1;
        this.birthdate[2] = 2000;

    }
}
