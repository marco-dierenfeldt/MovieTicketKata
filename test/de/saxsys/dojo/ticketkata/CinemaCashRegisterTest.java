package de.saxsys.dojo.ticketkata;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marco Dierenfeldt
 */
public class CinemaCashRegisterTest {

    public CinemaCashRegisterTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of startPurchase method, of class CinemaCashRegister.
     */
    @Test
    public void testPurchaseNo3DParqetWeekdayNoGroupMidageNoStudent() {
        System.out.println("testPurchaseNo3DParqetWeekdayNoGroupMidageNoStudent");
        int runtime = 72;
        Day day = Day.TUE;
        boolean isParquet = true;
        boolean is3D = false;
        int age = 35;
        boolean isStudent = false;

        float expResult = 44.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testPurchase3DParqetWeekdayNoGroupMidageNoStudent() {
        System.out.println("testPurchase3DParqetWeekdayNoGroupMidageNoStudent");
        int runtime = 72;
        Day day = Day.TUE;
        boolean isParquet = true;
        boolean is3D = true;
        int age = 35;
        boolean isStudent = false;
        
        float expResult = 56.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testPurchase3DLogeWeekdayNoGroupMidageNoStudent() {
        System.out.println("testPurchase3DLogeWeekdayNoGroupMidageNoStudent");
        int runtime = 72;
        Day day = Day.TUE;
        boolean isParquet = false;
        boolean is3D = true;
        int age = 35;
        boolean isStudent = false;

        float expResult = 64.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);

        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testPurchase3DLogeMovieDayNoGroupMidageNoStudent() {
        System.out.println("testPurchase3DLogeMovieDayNoGroupMidageNoStudent");
        int runtime = 72;
        Day day = Day.THU;
        boolean isParquet = false;
        boolean is3D = true;
        int age = 35;
        boolean isStudent = false;

        float expResult = 56.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);

        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testPurchase3DLogeWeekendNoGroupMidageNoStudent() {
        System.out.println("testPurchase3DLogeWeekendNoGroupMidageNoStudent");
        int runtime = 72;
        Day day = Day.SAT;
        boolean isParquet = false;
        boolean is3D = true;
        int age = 35;
        boolean isStudent = false;

        float expResult = 70.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);

        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testPurchaseOverlengthNo3DParqetWeekdayNoGroupMidageNoStudent() {
        System.out.println("testPurchaseOverlengthNo3DParqetWeekdayNoGroupMidageNoStudent");
        int runtime = 145;
        Day day = Day.TUE;
        boolean isParquet = true;
        boolean is3D = false;
        int age = 35;
        boolean isStudent = false;

        float expResult = 50.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);

        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }


    @Test
    public void testPurchaseOverlengthNo3DParqetWeekdayNoGroupMidageWithStudents() {
        System.out.println("testPurchaseOverlengthNo3DParqetWeekdayNoGroupMidageWithStudents");
        int runtime = 145;
        Day day = Day.TUE;
        boolean isParquet = true;
        boolean is3D = false;
        int age = 35;
        boolean isStudent = false;

        float expResult = 44.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        isStudent = true;
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);

        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }


    @Test
    public void testPurchaseOverlengthNo3DParqetWeekdayNoGroupSeniorNoStudents() {
        System.out.println("testPurchaseOverlengthNo3DParqetWeekdayNoGroupSeniorNoStudents");
        int runtime = 145;
        Day day = Day.TUE;
        boolean isParquet = true;
        boolean is3D = false;
        int age = 35;
        boolean isStudent = false;

        float expResult = 45.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        age = 68;
        instance.addTicket(age, isStudent);

        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testPurchaseOverlengthNo3DParqetWeekdayNoGroupSeniorAsStudents() {
        System.out.println("testPurchaseOverlengthNo3DParqetWeekdayNoGroupSeniorAsStudents");
        int runtime = 145;
        Day day = Day.TUE;
        boolean isParquet = true;
        boolean is3D = false;
        int age = 35;
        boolean isStudent = false;

        float expResult = 45.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        age = 68;
        isStudent = true;
        instance.addTicket(age, isStudent);

        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }

@Test
    public void testPurchaseOverlengthNo3DParqetWeekdayNoGroupChildrenNoStudents() {
        System.out.println("testPurchaseOverlengthNo3DParqetWeekdayNoGroupChildrenNoStudents");
        int runtime = 145;
        Day day = Day.TUE;
        boolean isParquet = true;
        boolean is3D = false;
        int age = 35;
        boolean isStudent = false;

        float expResult = 44.5F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        age = 10;
        instance.addTicket(age, isStudent);

        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }


@Test
    public void testPurchaseOverlengthNo3DParqetWeekdayNoGroupChildrenAsStudents() {
        System.out.println("testPurchaseOverlengthNo3DParqetWeekdayNoGroupChildrenAsStudents");
        int runtime = 145;
        Day day = Day.TUE;
        boolean isParquet = true;
        boolean is3D = false;
        int age = 35;
        boolean isStudent = false;

        float expResult = 44.5F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        age = 10;
        isStudent = true;
        instance.addTicket(age, isStudent);

        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testPurchaseNo3DParqetWeekdayGroupMidageNoStudent() {
        System.out.println("testPurchaseNo3DParqetWeekdayGroupMidageNoStudent");
        int runtime = 72;
        Day day = Day.TUE;
        boolean isParquet = true;
        boolean is3D = false;
        int age = 35;
        boolean isStudent = false;

        float expResult = 138.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        for (int i = 0; i < 23; i++) {
            instance.addTicket(age, isStudent);
        }
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testPurchase3DParqetWeekdayGroupMidageNoStudent() {
        System.out.println("testPurchase3DParqetWeekdayGroupMidageNoStudent");
        int runtime = 72;
        Day day = Day.TUE;
        boolean isParquet = true;
        boolean is3D = true;
        int age = 35;
        boolean isStudent = false;

        float expResult = 207.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        for (int i = 0; i < 23; i++) {
            instance.addTicket(age, isStudent);
        }
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testPurchase3DParqetMovieDayGroupMidageNoStudent() {
        System.out.println("testPurchase3DParqetMovieDayGroupMidageNoStudent");
        int runtime = 72;
        Day day = Day.THU;
        boolean isParquet = true;
        boolean is3D = true;
        int age = 35;
        boolean isStudent = false;

        float expResult = 207.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        for (int i = 0; i < 23; i++) {
            instance.addTicket(age, isStudent);
        }
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testPurchasebigEnoughSchoolclassWithTwoTeachers() {
        System.out.println("testPurchasebigEnoughSchoolclassWithTwoTeachers");
        int runtime = 72;
        Day day = Day.WED;
        boolean isParquet = true;
        boolean is3D = false;
        int age = 12;
        boolean isStudent = false;

        float expResult = 154.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        for (int i = 0; i < 24; i++) {
            instance.addTicket(age, isStudent);
        }
        age = 45;
            instance.addTicket(age, isStudent);
        age = 27;
            instance.addTicket(age, isStudent);
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }


    @Test
    public void testPurchaseTooSmallSchoolclassWithTwoTeachers() {
        System.out.println("testPurchaseTooSmallSchoolclassWithTwoTeachers");
        int runtime = 72;
        Day day = Day.WED;
        boolean isParquet = true;
        boolean is3D = false;
        int age = 12;
        boolean isStudent = false;

        float expResult = 120.00F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        for (int i = 0; i < 18; i++) {
            instance.addTicket(age, isStudent);
        }
        age = 45;
            instance.addTicket(age, isStudent);
        age = 27;
            instance.addTicket(age, isStudent);
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testPurchaseMix() {
        System.out.println("testPurchaseMix");
        int runtime = 125;
        Day day = Day.THU;
        boolean isParquet = false;
        boolean is3D = true;
        int age = 12;
        boolean isStudent = false;

        float expResult = 300.00F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        for (int i = 0; i < 5; i++) {
            instance.addTicket(age, isStudent);
        }
        age = 45;
        for (int i = 0; i < 7; i++) {
            instance.addTicket(age, isStudent);
        }
        age = 75;
        for (int i = 0; i < 4; i++) {
            instance.addTicket(age, isStudent);
        }
        age = 27;
        isStudent = true;
        for (int i = 0; i < 8; i++) {
            instance.addTicket(age, isStudent);
        }
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }

    /*
     * Tests the re-initialisation in the startPurchase method
     */
    @Test
    public void testMultipleTransactionsWitheSameCinemaCashRegister(){
        System.out.println("testMultipleTransactionsWitheSameCinemaCashRegister");
        int runtime = 90;
        Day day = Day.MON;
        boolean isParquet = true;
        boolean is3D = true;
        int age = 35;
        boolean isStudent = false;

        float expResult = 70.00F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        for (int i = 0; i < 5; i++) {
            instance.addTicket(age, isStudent);
        }
        float result = instance.finishPurchase();
        assertEquals(expResult,result,0.0f);

        instance.startPurchase(runtime, day, isParquet, is3D);
        for (int i = 0; i < 5; i++) {
            instance.addTicket(age, isStudent);
        }
        result = instance.finishPurchase();
        assertEquals(expResult,result,0.0f);
    }
}
