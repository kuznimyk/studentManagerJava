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
        double paycheck = grossPay * 12;

        if (paycheck < 14000) {
            this.tax = 0;
            return this.tax;
        }

        else if (paycheck < 50000 )
        {
            this.tax = paycheck * 0.15 /12.00;
            return this.tax;
        }
        else if (paycheck < 100000 ) {
            this.tax = paycheck * 0.21 /12.00;
            return this.tax;
        }
        else if (paycheck < 150000 ) {
            this.tax = paycheck *0.26 /12.00;
            return this.tax;
        }
        else {
            this.tax = paycheck*0.29 /12.00;
            return this.tax;
        }


    }
    public void setHoursWorked(int hours){
        if (hours > 0) {
            this.hoursWorked = hours;
        }
    }

    public void calcGrossPay(){
        if (hoursWorked > 0){
            if (hoursWorked > 140 && hoursWorked <= 147){
                this.grossPay =  140 * payRate + payRate * (hoursWorked - 140) * 1.5;
            }
            else if(hoursWorked > 147){
                this.grossPay =  140 * payRate + payRate * 7 * 1.5 + (hoursWorked - 147)*2 * payRate;
            }
            else{this.grossPay = hoursWorked * payRate;}
        }
        else{
            this.grossPay = 0;
        }
    }

    public double calcCpp(){
        double pension = grossPay * 0.0545;
        if (pension > 266.67){
            this.CPP =  266.67;
            return this.CPP;
        }
        else{
            this.CPP = pension;
            return this.CPP;
        }

    }

    public double calcEi(){
        double ei = grossPay * 0.0158;
        if (ei <= 74.17){
            this.EI = ei;
            return this.EI;
        }
        else{
            this.EI = 74.17;
            return this.EI;
        }
    }

    public double getNetPay() {
        return grossPay - tax - CPP - EI;
    }

}
