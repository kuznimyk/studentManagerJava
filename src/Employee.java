public class Employee extends Person{
    protected double hoursWorked;
    protected double payRate;
    protected double grossPay;
    protected double tax;
    protected double CPP;
    protected double EI;
    //basic contructor that sets up everything as test and date of birth on 1/1/2000
    public Employee(){
        super();
        this.name = "test name";
        this.adress = "test adress";
        this.birthdate[0] = 1;
        this.birthdate[1] = 1;
        this.birthdate[2] = 2000;
        this.hoursWorked = 0;

    }
    //toString class
    public String toString(){
        return "Test";
    }

    //getters and setters that will be inherited by salaryemploee and hourlyemployee
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
