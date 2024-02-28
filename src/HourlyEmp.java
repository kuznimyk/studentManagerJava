/*
File with hourly employers data and calculations
*/
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
    public void setHoursWorked(double hours){
        if (hours > 0) {
            this.hoursWorked = hours;
        }
    }
    public double getHoursWorked(){
        return this.hoursWorked;
    }

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

    public double calcNetPay() {
        return grossPay - tax - CPP - EI;
    }


    public void printPayCheque(double hours) {
        hoursWorked = hours;
        System.out.println("Jon Doe");
        System.out.println("4112 66 St");
        System.out.println("Camrose, AB");
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

