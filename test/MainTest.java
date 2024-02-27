import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    //==========================================================================
    /*
     * Tests of calcGpa method, of class Student.
     */
    @Test
    void testCalcGpa0Courses() {
        System.out.println("CalcGPA no courses");
        Student instance = new Student("Puff The Magic Dragon",
                "4112 66 St \nCamrose, AB",
                2, 3, 2000);
        double expResult = 0;
        double result = instance.calcGpa();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.calcGpa(), 0.01);
    }

    @Test
    void testCalcGpa1Courses() {
        System.out.println("CalcGPA 1 course");
        Student instance = new Student("Puff The Magic Dragon",
                "4112 66 St \nCamrose, AB",
                2, 3, 2000);
        instance.addCourse("AUCSC 112", 96.74);
        double expResult = 96.74;
        double result = instance.calcGpa();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.calcGpa(), 0.01);
    }

    @Test
    void testCalcGpa2Courses() {
        System.out.println("CalcGPA 2 courses");
        Student instance = new Student("Puff The Magic Dragon",
                "4112 66 St \nCamrose, AB",
                2, 3, 2000);
        instance.addCourse("AUCSC 112", 96.74);
        instance.addCourse("AUCSC 111", 68.79);
        double expResult = 82.765;
        double result = instance.calcGpa();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.calcGpa(), 0.01);
    }

    @Test
    void testCalcGpa3Courses() {
        System.out.println("CalcGPA 3 courses");
        Student instance = new Student("Puff The Magic Dragon",
                "4112 66 St \nCamrose, AB",
                2, 3, 2000);
        instance.addCourse("AUCSC 112", 96.74);
        instance.addCourse("AUCSC 111", 68.79);
        instance.addCourse("AUBIO 110", 72.34);
        double expResult = 79.29;
        double result = instance.calcGpa();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.calcGpa(), 0.01);
    }

    @Test
    void testCalcGpa12Courses() {
        System.out.println("CalcGPA 12 courses");
        Student instance = new Student("Puff The Magic Dragon",
                "4112 66 St \nCamrose, AB",
                2, 3, 2000);
        instance.addCourse("AUCSC 112", 75);
        instance.addCourse("AUCSC 111", 78);
        instance.addCourse("AUBIO 110", 91);
        instance.addCourse("AUBWE 101", 52);

        instance.addCourse("AUPHY 111", 80);
        instance.addCourse("AUCHE 110", 72);
        instance.addCourse("AUIDS 101", 72);
        instance.addCourse("AUENG 106", 76);

        instance.addCourse("AUPED 110", 92);
        instance.addCourse("AUKIN 102", 98);
        instance.addCourse("AUCSC 218", 65);
        instance.addCourse("AUIDS 201", 94);

        double expResult = 78.75;
        double result = instance.calcGpa();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.calcGpa(), 0.01);
    }

    //==========================================================================
    /*
     * Test of printReport method, of class Student.
     */
    @Test
    void printReport() {
        System.out.println("PrintReport");

        //Set up the capture of the output, from standard out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        //Here is the actual test starting
        Student instance = new Student("Puff the Magic Dragon",
                "4112 66 St\r\nCamrose, AB",
                2, 3, 2000);
        instance.addCourse("AUCSC 112", 4);
        instance.addCourse("AUMAT 116", 3.3);
        instance.addCourse("AUCSC 111", 3.7);
        instance.addCourse("AUMAT 120", 3.0);

        instance.printReport(); //Output captured in outContent
        String expResult = //top line and id num removed
                "Puff the Magic Dragon\r\n" +
                        "4112 66 St\r\n" +
                        "Camrose, AB\r\n" +
                        "--------------------------------------------\r\n" +
                        "   AUCSC 112:        4.00\r\n" +
                        "   AUMAT 116:        3.30\r\n" +
                        "   AUCSC 111:        3.70\r\n" +
                        "   AUMAT 120:        3.00\r\n" +
                        "\r\n" +
                        "         GPA:        3.50\r\n" +
                        "===============================================\r\n";
        System.setOut(originalOut);
        String savedOut = removeIdNum(outContent.toString());
        assertEquals(expResult, savedOut);

        //Restore standard out
        System.setOut(originalOut);
    }

    //==========================================================================
    /**
     * Strips off the id num of the report.  Done by removing the first
     * two lines.
     * @param original - report string with id num
     * @return - report string without id num
     *
     * Note:  I have left it to print the actual string that is left
     * so that someone can see the literal values that they have.
     * Note 2:  If someone has trouble, and the output "looks" the same,
     * just check that each and every line ends in \r\n (Windows end of
     * line).
     */
    public String removeIdNum(String original){
        String newString = "";
        int index = 0;

        try{
            //move over first '\n'
            while(original.charAt(index) != '\n'){
                index++;
            }
            index++; //go past '\n'
            //move over 2nd '\n'
            while(original.charAt(index) != '\n'){
                index++;
            }
            index++; //go past '\n'

            while(index < original.length()){
                if (original.charAt(index) == '\n'){
                    System.out.println();
                }
                else if (original.charAt(index) < ' ') {
                    System.out.print("'" + (int) original.charAt(index)
                            + "'");
                }
                else {
                    System.out.print("'" + original.charAt(index) + "'");
                }
                newString = newString + original.charAt(index);
                index++;
            }
            return newString;
        }
        catch (Exception e){return "";}
    }

    //==========================================================================
}



class SalaryEmpTest {
    //==========================================================================
    /*
     * Tests of calcGrossPay method, of class SalaryEmp.
     */
    @Test
    public void testCalcGrossPay60000() {
        System.out.println("calcGrossPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                60000, 2, 3, 2000);
        double expResult = 5000.00;
        double result = instance.calcGrossPay();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getGrossPay(), 0.01);
    }
    @Test
    public void testCalcGrossPay15000() {
        System.out.println("calcGrossPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                15000, 2, 3, 2000);
        double expResult = 1250.00;
        double result = instance.calcGrossPay();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getGrossPay(), 0.01);
    }
    @Test
    public void testCalcGrossPay13999() {
        System.out.println("calcGrossPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                13999.99, 2, 3, 2000);
        double expResult = 1166.67;
        double result = instance.calcGrossPay();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.grossPay, 0.01);
    }

    //==========================================================================
    /*
     * Tests of calculating tax method, of class SalaryEmp, inherited from
     * Employee.
     */
    @Test
    public void testCalcTax60000() {
        System.out.println("calcTax");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                60000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 1050.00;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax14000() {
        System.out.println("calcTax");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                14000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 175.00;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax13999() {
        System.out.println("calcTax");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                13999.99, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 0.0;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax49999() {
        System.out.println("calcTax");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                49999.99, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 625.0;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax50000() {
        System.out.println("calcTax");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                50000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 875.0;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax99999() {
        System.out.println("calcTax");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                99999.99, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 1750.0;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax100000() {
        System.out.println("calcTax");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                100000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 2166.67;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax149999() {
        System.out.println("calcTax");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                149999.99, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 3250;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax150000() {
        System.out.println("calcTax");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                150000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 3625;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }

    //==========================================================================
    /*
     * Tests of calculating ei method, of class SalaryEmp, inherited from
     * Employee.
     */
    @Test
    public void testCalcEi18000() {
        System.out.println("CalcEi");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                18000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 23.70;
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEI(), 0.01);
    }
    @Test
    public void testCalcEi14004() {
        System.out.println("CalcEi");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                14004, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 18.44;
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEI(), 0.01);
    }
    @Test
    public void testCalcEi13999() {
        System.out.println("CalcEi");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                13999.99, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 18.43;
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEI(), 0.01);
    }
    @Test
    public void testCalcEi49999() {
        System.out.println("CalcEi");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                49999.99, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 65.83;
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEI(), 0.01);
    }
    @Test
    public void testCalcEi50000() {
        System.out.println("CalcEi");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                50000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 65.83;
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEI(), 0.01);
    }
    @Test
    public void testCalcEi99999() {
        System.out.println("CalcEi");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                99999.99, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 74.17;
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEI(), 0.01);
    }
    @Test
    public void testCalcEi100000() {
        System.out.println("CalcEi");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                100000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 74.17;
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEI(), 0.01);
    }
    @Test
    public void testCalcEi149999() {
        System.out.println("CalcEi");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                149999.99, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 74.17;
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEI(), 0.01);
    }
    @Test
    public void testCalcEi150000() {
        System.out.println("CalcEi");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                150000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 74.17;
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEI(), 0.01);
    }

    //This one checks max
    @Test
    public void testCalcEiOverMax() {
        System.out.println("CalcEi");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                500000, 2, 3, 2000);
        instance.calcGrossPay();  //EI is 658.33 per month
        double expResult = 74.17;
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEI(), 0.01);
    }

    //==========================================================================
    /*
     * Tests of calculating cpp method, of class SalaryEmp, inherited from
     * Employee.
     */
    @Test
    public void testCalcCpp56000() {
        System.out.println("calcCpp");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                56000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 254.33;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCPP(), 0.01);
    }
    @Test
    public void testCalcCpp14000() {
        System.out.println("calcCpp");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                14000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 63.58;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCPP(), 0.01);
    }
    @Test
    public void testCalcCpp13999() {
        System.out.println("calcCpp");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                13999.99, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 63.58;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCPP(), 0.01);
    }
    @Test
    public void testCalcCpp49999() {
        System.out.println("calcCpp");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                49999.99, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 227.08;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCPP(), 0.01);
    }
    @Test
    public void testCalcCpp50000() {
        System.out.println("calcCpp");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                50000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 227.08;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCPP(), 0.01);
    }
    @Test
    public void testCalcCpp58000() {
        System.out.println("calcCpp");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                58000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 263.42;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCPP(), 0.01);
    }
    @Test
    public void testCalcCpp100000() {
        System.out.println("calcCpp");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                100000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 266.67;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCPP(), 0.01);
    }
    @Test
    public void testCalcCpp149999() {
        System.out.println("calcCpp");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                149999.99, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 266.67;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCPP(), 0.01);
    }
    @Test
    public void testCalcCpp150000() {
        System.out.println("calcCpp");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                150000, 2, 3, 2000);
        instance.calcGrossPay();
        double expResult = 266.67;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCPP(), 0.01);
    }

    //This one checks max
    @Test
    public void testCalcCppOverMax() {
        System.out.println("CalcCpp");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                500000, 2, 3, 2000);
        instance.calcGrossPay();  //cpp is 2270.83 per month
        double expResult = 266.67;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCPP(), 0.01);
    }

    //==========================================================================
    /*
     * Tests of calculating net pay method, of class SalaryEmp, inherited from
     * Employee.
     */
    @Test
    public void testCalcNetPay60000() {
        System.out.println("calcPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                60000, 2, 3, 2000);
        calcPriorItems(instance); //gPay = 5000, cpp = 266.67, ei = 74.17
        //tax = 1050
        instance.calcNetPay();
        double expResult = 3609.16; //Net pay
        assertEquals(expResult, instance.calcNetPay(), 0.01);
    }
    @Test
    public void testCalcNetPay14000() {
        System.out.println("calcPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                14000, 2, 3, 2000);
        calcPriorItems(instance); //gPay = 1166.67 cpp = 63.58 ei = 18.43
        //tax = 175.00
        instance.calcNetPay();
        double expResult = 909.66; //Net pay
        assertEquals(expResult, instance.calcNetPay(), 0.01);
    }
    @Test
    public void testCalcNetPay13999() {
        System.out.println("calcPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                13999.99, 2, 3, 2000);
        calcPriorItems(instance);
        instance.calcNetPay();
        double expResult = 1084.65; //Net pay
        assertEquals(expResult, instance.calcNetPay(), 0.01);
    }
    @Test
    public void testCalcNetPay49999() {
        System.out.println("calcPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                49999.99, 2, 3, 2000);
        calcPriorItems(instance); //gPay = 4166.67 cpp = 227.08 ei = 65.83
        //tax = 625.00
        instance.calcNetPay();
        double expResult = 3248.75; //Net pay
        assertEquals(expResult, instance.calcNetPay(), 0.01);
    }
    @Test
    public void testCalcNetPay50000() {
        System.out.println("calcPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                50000, 2, 3, 2000);
        calcPriorItems(instance); //gPay = 4166.67 cpp = 227.08 ei = 65.83
        //tax = 875.00
        instance.calcNetPay();
        double expResult = 2998.75; //Net pay
        assertEquals(expResult, instance.calcNetPay(), 0.01);
    }
    @Test
    public void testCalcNetPay99999() {
        System.out.println("calcPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                99999.99, 2, 3, 2000);
        calcPriorItems(instance); //gPay = 8333.33 cpp = 266.67 ei = 74.17
        //tax =1750.00
        instance.calcNetPay();
        double expResult = 6242.49; //Net pay
        assertEquals(expResult, instance.calcNetPay(), 0.01);
    }
    @Test
    public void testCalcNetPay100000() {
        System.out.println("calcPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                100000, 2, 3, 2000);
        calcPriorItems(instance); //gPay = 8333.33 cpp = 266.67 ei = 74.17
        //tax = 2166.67
        instance.calcNetPay();
        double expResult = 5825.83; //Net pay
        assertEquals(expResult, instance.calcNetPay(), 0.01);
    }
    @Test
    public void testCalcNetPay149999() {
        System.out.println("calcPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                149999.99, 2, 3, 2000);
        calcPriorItems(instance); //gPay = 12500 cpp = 266.67 ei = 74.17
        //tax = 3250
        instance.calcNetPay();
        double expResult = 8909.16; //Net pay
        assertEquals(expResult, instance.calcNetPay(), 0.01);
    }
    @Test
    public void testCalcNetPay150000() {
        System.out.println("calcPay");
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                150000, 2, 3, 2000);
        calcPriorItems(instance);  //gPay = 12500 cpp = 266.67 ei = 74.17
        //tax = 3625
        instance.calcNetPay();
        double expResult = 8534.16; //Net pay
        assertEquals(expResult, instance.calcNetPay(), 0.01);
    }

    public void calcPriorItems(SalaryEmp instance){
        instance.calcGrossPay();
        instance.calcEi();
        instance.calcCpp();
        instance.calcTax();
    }

    //==========================================================================
    /*
     * Tests of printing pay info, of class SalaryEmp, inherited from
     * Employee.
     */
    @Test
    public void testPrintMid() {
        System.out.println("PrintMid");

        //Set up the capture of the output, from standard out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        //Here is the actual test starting
        SalaryEmp instance = new SalaryEmp("Jon Doe",
                "4112 66 St\r\nCamrose, AB",
                75000, 2, 3, 2000);

        instance.printPayCheque(); //Output captured in outContent
        String expResult = //top line and id num removed
                "Jon Doe\r\n" +
                        "4112 66 St\r\n" +
                        "Camrose, AB\r\n" +
                        "--------------------------------------------\r\n" +
                        "   Hours worked: 189.00   Rate: 75000.00\r\n" +
                        "--------------------------------------------\r\n" +
                        "   Gross Pay:     6250.00\r\n" +
                        "   Tax:           1312.50\r\n" +
                        "   CPP:            266.67\r\n" +
                        "   EI:              74.17\r\n" +
                        "\r\n" +
                        "   Net Pay:       4596.66\r\n" +
                        "===============================================\r\n";
        System.setOut(originalOut);
        String savedOut = removeIdNum(outContent.toString());
        assertEquals(expResult, savedOut);

        //Restore standard out
        System.setOut(originalOut);
    }

    /**
     * Strips off the id num of the pay check.  Done by removing the first
     * two lines.
     * @param original - pay check string with id num
     * @return - pay check string without id num
     *
     * Note:  I have left it to print the actual string that is left
     * so that someone can see the literal values that they have.
     * Note 2:  If someone has trouble, and the output "looks" the same,
     * just check that each and every line ends in \r\n (Windows end of
     * line).
     */
    public String removeIdNum(String original){
        String newString = "";
        int index = 0;

        try{
            //move over first '\n'
            while(original.charAt(index) != '\n'){
                index++;
            }
            index++; //go past '\n'
            //move over 2nd '\n'
            while(original.charAt(index) != '\n'){
                index++;
            }
            index++; //go past '\n'

            while(index < original.length()){
                if (original.charAt(index) == '\n'){
                    System.out.println();
                }
                else if (original.charAt(index) < ' ') {
                    System.out.println("'" + (int) original.charAt(index)
                            + "'");
                }
                else {
                    System.out.println("'" + original.charAt(index) + "'");
                }
                newString = newString + original.charAt(index);
                index++;
            }
            return newString;
        }
        catch (Exception e){return "";}
    }

    //==========================================================================
}


class HourlyEmpTest {

    //==========================================================================
    /*
     * Tests of calcGrossPay method, of class HourlyEmp.
     */
    @Test
    public void testCalcGrossPay60000() {
        System.out.println("calcGrossPay");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                36.23, 2, 3, 2000);
        instance.setHoursWorked(140);
        double expResult = 5072.20;
        double result = instance.calcGrossPay();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getGrossPay(), 0.01);
    }
    @Test
    public void testCalcGrossPay60000WithOver1() {
        System.out.println("calcGrossPay");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                36.23, 2, 3, 2000);
        instance.setHoursWorked(141);
        double expResult = 5126.55;
        double result = instance.calcGrossPay();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getGrossPay(), 0.01);
    }
    @Test
    public void testCalcGrossPay60000WithOver2() {
        System.out.println("calcGrossPay");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                36.23, 2, 3, 2000);
        instance.setHoursWorked(147);
        double expResult = 5452.62;
        double result = instance.calcGrossPay();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getGrossPay(), 0.01);
    }
    @Test
    public void testCalcGrossPay60000WithDoubleOver() {
        System.out.println("calcGrossPay");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                36.23, 2, 3, 2000);
        instance.setHoursWorked(147.5);
        double expResult = 5488.84;
        double result = instance.calcGrossPay();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getGrossPay(), 0.01);
    }

    @Test
    public void testCalcGrossPay60000WithDoubleOverMore() {
        System.out.println("calcGross Pay");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                47.23, 2, 3, 2000);
        instance.setHoursWorked(180);
        calcPriorItems(instance); //gPay = 8501.40
        instance.calcGrossPay();
        double expResult = 10225.30;
        assertEquals(expResult, instance.getGrossPay(), 0.01);
    }

    @Test
    public void testCalcGrossPay13999() {
        System.out.println("calcGrossPay");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                15.65, 2, 3, 2000);
        instance.setHoursWorked(74.5);
        double expResult = 1165.93;
        double result = instance.calcGrossPay();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getGrossPay(), 0.01);
    }

    //==========================================================================
    /*
     * Tests of calculating tax method, of class HourlyEmp, inherited from
     * Employee.
     */
    @Test
    public void testCalcTax60000() {
        System.out.println("calcTax");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                36.23, 2, 3, 2000);
        instance.setHoursWorked(147);
        instance.calcGrossPay();
        double expResult = 1145.05;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax14000() {
        System.out.println("calcTax");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                15.00, 2, 3, 2000);
        instance.setHoursWorked(78);
        instance.calcGrossPay();
        double expResult = 175.50;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax13999() {
        System.out.println("calcTax");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                15.00, 2, 3, 2000);
        instance.setHoursWorked(77);
        instance.calcGrossPay();
        double expResult = 0.0;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax49999() {
        System.out.println("calcTax");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                25.85, 2, 3, 2000);
        instance.setHoursWorked(152);
        instance.calcGrossPay();
        double expResult = 622.34;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax50000() {
        System.out.println("calcTax");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                36.00, 2, 3, 2000);
        instance.setHoursWorked(115.75);
        instance.calcGrossPay();
        double expResult = 875.07;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax99999() {
        System.out.println("calcTax");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                60.20, 2, 3, 2000);
        instance.setHoursWorked(138);
        instance.calcGrossPay();
        double expResult = 1744.60;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax100000() {
        System.out.println("calcTax");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                45.50, 2, 3, 2000);
        instance.setHoursWorked(163.5);
        instance.calcGrossPay();
        double expResult = 2170.81;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax149999() {
        System.out.println("calcTax");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                200.00, 2, 3, 2000);
        instance.setHoursWorked(62.25);
        instance.calcGrossPay();
        double expResult = 3237.00;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }
    @Test
    public void testCalcTax150000() {
        System.out.println("calcTax");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                200.00, 2, 3, 2000);
        instance.setHoursWorked(62.5);
        instance.calcGrossPay();
        double expResult = 3625.00;
        double result = instance.calcTax();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getTax(), 0.01);
    }

    //==========================================================================
    /*
     * Tests of calculating ei method, of class HourlyEmp, inherited from
     * Employee.
     */
    @Test
    public void testCalcEiOverMax() {
        System.out.println("CalcEi");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                36.23, 2, 3, 2000);
        instance.setHoursWorked(147);
        instance.calcGrossPay(); //5452.62
        double expResult = 74.17; //Max reached
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEI(), 0.01);
    }
    @Test
    public void testCalcEi14000() {
        System.out.println("CalcEi");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                15.00, 2, 3, 2000);
        instance.setHoursWorked(78);
        instance.calcGrossPay(); //1170.00
        double expResult = 18.49;
        double result = instance.calcEi();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getEI(), 0.01);
    }


    //==========================================================================
    /*
     * Tests of calculating cpp method, of class HourlyEmp, inherited from
     * Employee.
     */
    @Test
    public void testCalcCppOverMax() {
        System.out.println("calcCpp");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                36.23, 2, 3, 2000);
        instance.setHoursWorked(147);
        instance.calcGrossPay(); //5452.62
        double expResult = 266.67;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCPP(), 0.01);
    }
    @Test
    public void testCalcCpp14000() {
        System.out.println("calcCpp");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                15.00, 2, 3, 2000);
        instance.setHoursWorked(78);
        instance.calcGrossPay(); //1170.00
        double expResult = 63.77;
        double result = instance.calcCpp();
        assertEquals(expResult, result, 0.01);
        assertEquals(expResult, instance.getCPP(), 0.01);
    }

    //==========================================================================
    /*
     * Tests of calculating net pay method, of class HourlyEmp, inherited from
     * Employee.
     */
    @Test
    public void testCalcNetPay122703() {
        System.out.println("calcNetPay");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                47.23, 2, 3, 2000);
        instance.setHoursWorked(180);
        calcPriorItems(instance); //gPay = 10225.30 cpp = 266.67 ei = 74.17
        //tax = 2658.67
        instance.calcNetPay();
        double expResult = 7225.88; //Net pay
        assertEquals(expResult, instance.calcNetPay(), 0.01);
    }
    @Test
    public void testCalcNetPay14000() {
        System.out.println("calcNetPay");
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St \nCamrose, AB",
                15.00, 2, 3, 2000);
        instance.setHoursWorked(78);
        calcPriorItems(instance);
        instance.calcNetPay();
        double expResult = 912.24; //Net pay
        assertEquals(expResult, instance.calcNetPay(), 0.01);
    }

    public void calcPriorItems(HourlyEmp instance){
        instance.calcGrossPay();
        instance.calcEi();
        instance.calcCpp();
        instance.calcTax();
    }

    //==========================================================================
    /*
     * Tests of printing pay info, of class HourlyEmp, inherited from
     * Employee.
     */
    @Test
    public void testPrintMid() {
        System.out.println("PrintMid");

        //Set up the capture of the output, from standard out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        //Here is the actual test starting
        HourlyEmp instance = new HourlyEmp("Jon Doe",
                "4112 66 St\r\nCamrose, AB",
                75.00, 2, 3, 2000);

        instance.printPayCheque(60); //Output captured in outContent
        String expResult = //top line and id num removed
                "Jon Doe\r\n" +
                        "4112 66 St\r\n" +
                        "Camrose, AB\r\n" +
                        "--------------------------------------------\r\n" +
                        "   Hours worked: 60.00   Rate: 75.00\r\n" +
                        "--------------------------------------------\r\n" +
                        "   Gross Pay:     4500.00\r\n" +
                        "   Tax:            945.00\r\n" +
                        "   CPP:            245.25\r\n" +
                        "   EI:              71.10\r\n" +
                        "\r\n" +
                        "   Net Pay:       3238.65\r\n" +
                        "===============================================\r\n";
        System.setOut(originalOut);
        String savedOut = removeIdNum(outContent.toString());
        assertEquals(expResult, savedOut);

        //Restore standard out
        System.setOut(originalOut);
    }


    /**
     * Strips off the id num of the pay check.  Done by removing the first
     * two lines.
     * @param original - pay check string with id num
     * @return - pay check string without id num
     *
     * Note:  I have left it to print the actual string that is left
     * so that someone can see the literal values that they have.
     * Note 2:  If someone has trouble, and the output "looks" the same,
     * just check that each and every line ends in \r\n (Windows end of
     * line).
     */
    public String removeIdNum(String original){
        String newString = "";
        int index = 0;

        try{
            //move over first '\n'
            while(original.charAt(index) != '\n'){
                index++;
            }
            index++; //go past '\n'
            //move over 2nd '\n'
            while(original.charAt(index) != '\n'){
                index++;
            }
            index++; //go past '\n'

            while(index < original.length()){
                if (original.charAt(index) == '\n'){
                    System.out.println();
                }
                else if (original.charAt(index) < ' ') {
                    System.out.println("'" + (int) original.charAt(index)
                            + "'");
                }
                else {
                    System.out.println("'" + original.charAt(index) + "'");
                }
                newString = newString + original.charAt(index);
                index++;
            }
            return newString;
        }
        catch (Exception e){return "";}
    }

    //==========================================================================

    /**
     * Test of setHoursWorked method, of class HourlyEmp.
     */
    @Test
    public void testSetHoursWorked() {
        System.out.println("setHoursWorked");
        double hours = 0.0;
        HourlyEmp instance = new HourlyEmp();
        instance.setHoursWorked(hours);
        assertEquals(hours, instance.getHoursWorked());
    }

    //==========================================================================
}