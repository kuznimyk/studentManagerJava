public class SalaryEmp extends Employee{

    public SalaryEmp(){
        super();
        this.payRate = 31200.00;
    }
    SalaryEmp(String name,String adress, double salary, int birthDay, int birthMonth,int birthYear){
        super();
        this.name = name;
        this.adress = adress;
        this.payRate = salary;
        this.birthdate[0] = birthDay;
        this.birthdate[1] = birthMonth;
        this.birthdate[2] = birthYear;

    }

    public double calcTax(){
        double paycheck = calcGrossPay() * 12;

        if (paycheck < 14000)
            return 0;
        else if (paycheck < 50000)
            return paycheck * 0.15;
        else if (paycheck < 100000)
            return paycheck * 0.21;
        else if (paycheck < 150000)
            return paycheck * 0.26;
        else
            return paycheck * 0.29;


    }
    public double calcGrossPay(){
        return payRate /12;
    }
}
