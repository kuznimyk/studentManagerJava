public class Employee extends Person{
    protected double hoursWorked;
    protected double payRate;
    protected double grossPay;
    protected double tax;
    protected double CPP;
    protected double EI;

    public Employee(){
        super();
        this.name = "test name";
        this.adress = "test adress";
        this.birthdate[0] = 1;
        this.birthdate[1] = 1;
        this.birthdate[2] = 2000;
        this.hoursWorked = 0;

    }
    public String toString(){
        return "Test";
    }

    public double getGrossPay(){
        return grossPay;
    }
    public double getTax(){
        return tax;
    }
    public double getCPP(){
        return CPP;
    }
    public double getEI(){
        return EI;
    }



}
