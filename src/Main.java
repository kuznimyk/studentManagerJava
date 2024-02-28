
import java.text.DecimalFormat;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
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

        instance.printReport(); //Output captured in outContent
    }
}