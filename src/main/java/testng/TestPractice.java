package testng;

import org.testng.annotations.*;

public class TestPractice {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @Test
    public void TC001(){
        System.out.println("TC001");
    }

    @Test
    public void TC002(){
        System.out.println("TC002");
    }

}
