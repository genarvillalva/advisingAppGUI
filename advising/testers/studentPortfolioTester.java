package advising.testers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import advising.DataLoader;
import advising.StudentPortfolio;


public class studentPortfolioTester {

    //@BeforeClass
    ArrayList<StudentPortfolio> portfolios = DataLoader.getAllStudentPortfolios();
    StudentPortfolio portfolio = portfolios.get(0);


    // assertEquals(val1,val2);
	// assertFalse(val);
	// assertTrue(val);
	// assertSame(val1,val2);
	// assertNotSame(val1,val2);
	// assertNull(val);
	// assertNotNull(val);


    //CONVERT LETTER GRADE TO GPA
    @Test
    public void testConvertLetterGradeToGPAValid(){
        int fact = portfolio.ConvertLetterGradeToGpa(90);
        assertEquals(4, fact, "90 does equal a 4!");
    }

    @Test
    public void testConvertLetterGradeToGPAOverBound(){
        int fact = portfolio.ConvertLetterGradeToGpa(150);
        assertEquals(0, fact, "150 does equal a 0!");
    }

    @Test
    public void testConvertLetterGradeToGPAUnderBound(){
        int fact = portfolio.ConvertLetterGradeToGpa(-20);
        assertEquals(0, fact, "-20 does equal a 0!");
    }

    @Test
    public void testConvertLetterGradeToGPAZero(){
        int fact = portfolio.ConvertLetterGradeToGpa(0);
        assertEquals(0, fact, "0 does equal a 0!");
    }

    @Test
    public void testConvertLetterGradeToGPAMax(){
        int fact = portfolio.ConvertLetterGradeToGpa(2000);
        assertEquals(0, fact, "2000 does equal a 0!");
    }

    @Test
    public void testConvertLetterGradeToGPAMin(){
        int fact = portfolio.ConvertLetterGradeToGpa(-2000);
        assertEquals(0, fact, "-2000 does equal a 0!");
    }



    //CHECK CLASS FAILURE
    @Test
    public void testCheckClassFailureValid(){
        boolean fact = portfolio.checkClassFailure(85);
        assertFalse(fact);
    }

    @Test
    public void testCheckClassFailureOverBound(){
        boolean fact = portfolio.checkClassFailure(150);
        assertTrue(fact);
    }

    @Test
    public void testCheckClassFailureUnderBound(){
        boolean fact = portfolio.checkClassFailure(-20);
        assertTrue(fact);
    }

    @Test
    public void testCheckClassFailureZero(){
        boolean fact = portfolio.checkClassFailure(0);
        assertTrue(fact);
    }

    @Test
    public void testCheckClassFailureMax(){
        boolean fact = portfolio.checkClassFailure(1000);
        assertTrue(fact);
    }

    @Test
    public void testCheckClassFailureMin(){
        boolean fact = portfolio.checkClassFailure(-2000);
        assertTrue(fact);
    }



    //CHECK SCHOLARSHIP
    @Test
    public void testCheckScholarshipValid(){
        double gpa = 3.5;
        int yearCreditCount = 30;
        boolean fact = portfolio.checkScholarship(gpa, yearCreditCount);
        assertTrue(fact);
    }

    @Test
    public void testCheckScholarshipOverGPA(){
        double gpa = 5.0;
        int yearCreditCount = 30;
        boolean fact = portfolio.checkScholarship(gpa, yearCreditCount);
        assertFalse(fact);
    }

}
