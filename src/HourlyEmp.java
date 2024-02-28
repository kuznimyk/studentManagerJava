/*
File with hourly employers data and calculations
*/
public class HourlyEmp extends Employee{


    //basic constructor that sets the payrate to default value
    public HourlyEmp(){
        super();
        this.payRate = 15.00;

    }

    //constructor that sets up person's information
    public HourlyEmp(String name,String adress, double salary, int birthDay, int birthMonth,int birthYear){
        super();
        this.name = name;
        this.adress = adress;
        this.payRate = salary;
        this.birthdate[0] = birthDay;
        this.birthdate[1] = birthMonth;
        this.birthdate[2] = birthYear;
    }


    //calculats the taxes depending on the salary range
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

    //setter that sets the amount of hours worked
    public void setHoursWorked(double hours){
        if (hours > 0) {
            this.hoursWorked = hours;
        }
    }
    //getter of hours worked
    public double getHoursWorked(){
        return this.hoursWorked;
    }

    //calculates gross pay depending ont he amoutn of hours
    public double calcGrossPay(){
        if (hoursWorked > 0){
            if (hoursWorked > 140 && hoursWorked <= 147){
                this.grossPay =  140 * payRate + payRate * (hoursWorked - 140) * 1.5;
                calcEi();
                calcCpp();
                calcTax();
                return grossPay;
            }
            else if(hoursWorked > 147){
                this.grossPay =  140 * payRate + payRate * 7 * 1.5 + (hoursWorked - 147)*2 * payRate;
                calcEi();
                calcCpp();
                calcTax();
                return grossPay;
            }
            else{this.grossPay = hoursWorked * payRate;
                calcEi();
                calcCpp();
                calcTax();
                return grossPay;
            }
        }
        else{
            this.grossPay = 0;
            calcEi();
            calcCpp();
            calcTax();
            return grossPay;
        }
    }


    //method calculates pension plan
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

    //methond calculates employment insurance
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

    //method that calculates net pay
    public double calcNetPay() {
        return grossPay - tax - CPP - EI;
    }

    //method that prins out all the information: salary, taxes, pension plan and insurance

    public void printPayCheque(double hours) {
        hoursWorked = hours;
        calcGrossPay();
        calcCpp();
        calcTax();
        calcEi();
        System.out.println("===============================================");
        System.out.println(this.id);
        System.out.println(this.name);
        System.out.println(this.adress);
        System.out.println("--------------------------------------------");
        System.out.printf("   Hours worked: %.2f   Rate: %.2f%n", hoursWorked, payRate);
        System.out.println("--------------------------------------------");
        System.out.printf("   Gross Pay:     %.2f%n", grossPay);
        System.out.printf("   Tax:            %.2f%n", tax);
        System.out.printf("   CPP:            %.2f%n", CPP);
        System.out.printf("   EI:              %.2f%n%n", EI);
        System.out.printf("   Net Pay:       %.2f%n", calcNetPay());
        System.out.println("===============================================");
    }


}

