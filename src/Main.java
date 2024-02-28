/*

                                                Ý Æ Ã-Ø Œ ¿

Code description:
    Software for Augustana Associated (HRAA) to manage their students’ and employees’ information., including payroll,
    with the prospect of adding their student management system at a later date.

Authors:
    * Mykyta Kuznietsov
    * Vadim Rudenko

Class:
    * AUCSC 112 LAB 1H04

ID numbers:
    * 1796900
    * 1793290

Date:
    * 27 Feb, 2024

Task spreading:
    * Parts 1-9: Mykyta
    * Parts 10-14: Vadim
    * Bug fixing, refactoring and etc: Both

*/

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {

        SalaryEmp x = new SalaryEmp("Meagain Minkle", "23 Japer Ave\r\nRed "
                + "Deer, AB", 13999.99, 4, 8, 1981);
        x.printPayCheque();
        System.out.println();
        HourlyEmp y = new HourlyEmp("Ashley Laben", "18 Parkview Dr\r\nOhaton,"
                + " AB", 15.67, 5, 6, 2001);
        y.printPayCheque(185.0);
        System.out.println();


        Student z = new Student("Mildred Mouse", "Box 56\r\nEdmonton, AB",
                3, 12, 2002);
        z.addCourse("AUSCI 235", 4);
        z.addCourse("AUMAT 116", 3.3);
        z.printReport();


        Student instance = new Student("Puff the Magic Dragon",
                "4112 66 St\r\nCamrose, AB",
                2, 3, 2000);
        instance.addCourse("AUCSC 112", 4);
        instance.addCourse("AUMAT 116", 3.3);
        instance.addCourse("AUCSC 111", 3.7);
        instance.addCourse("AUMAT 120", 3.0);

        instance.printReport(); 
    }
}
