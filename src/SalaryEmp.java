/*
File with regular employers data and calculations
*/

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
        double paycheck = grossPay * 12;

        if (paycheck < 14000) {
            this.tax = 0;
            return this.tax;
        }
        else if (paycheck < 50000 )
        {
            this.tax = paycheck * 0.15/12.00;
            return this.tax;
        }
        else if (paycheck < 100000 ) {
            this.tax = paycheck * 0.21/12.00;
            return this.tax;
        }
        else if (paycheck < 150000 ) {
            this.tax = paycheck *0.26/12.00;
            return this.tax;
        }
        else {
            this.tax = paycheck*0.29/12.00;
            return this.tax;
        }


    }
    public double calcGrossPay(){
        this.grossPay = payRate /12;
        calcEi();
        calcCpp();
        calcTax();
        return grossPay;
    }

    public double calcCpp(){
        double pension = grossPay * 0.0545;
        if (pension > 266.67){
            this.CPP =  266.67;
            return CPP;
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

    public void printPayCheque() {
        calcGrossPay();
        double tax = calcTax();
        double cpp = calcCpp();
        double ei = calcEi();
        double netPay = calcNetPay();
        System.out.println(this.id);
        System.out.println(name);
        System.out.println(adress.replace("\n", "\r\n"));
        System.out.println("--------------------------------------------");
        System.out.println("   Hours worked: 189.00   Rate: " + String.format("%.2f", payRate));
        System.out.println("--------------------------------------------");
        System.out.println("   Gross Pay:     " + String.format("%.2f", grossPay));
        System.out.println("   Tax:           " + String.format("%.2f", tax));
        System.out.println("   CPP:            " + String.format("%.2f", cpp));
        System.out.println("   EI:              " + String.format("%.2f", ei));
        System.out.println();
        System.out.println("   Net Pay:       " + String.format("%.2f", netPay));
        System.out.println("===============================================");
    }



}
