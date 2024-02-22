public class HourlyEmp extends Employee{


    public HourlyEmp(){
        super();
        this.payRate = 15.00;

    }
    public HourlyEmp(String name,String adress, double salary, int birthDay, int birthMonth,int birthYear){
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
    public void setHoursWorked(int hours){
        if (hours > 0) {
            this.hoursWorked = hours;
        }
    }

    public double calcGrossPay(){
        if (hoursWorked > 0){
            if (hoursWorked > 140 && hoursWorked <= 147){
                return 140 * payRate + payRate * (hoursWorked - 140) * 1.5;
            }
            else if(hoursWorked > 147){
                return 140 * payRate + payRate * 7 * 1.5 + (hoursWorked - 147)*2 * payRate;
            }
            else{return hoursWorked * payRate;}
        }
        else{
            return 0;
        }
    }

}
