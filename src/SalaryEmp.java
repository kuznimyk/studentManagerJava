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
}
