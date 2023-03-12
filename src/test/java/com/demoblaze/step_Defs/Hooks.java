package com.demoblaze.step_Defs;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){

        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }

    @After
    public void tearDown(Scenario scenario){



        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        BrowserUtils.waitFor(1);
        Driver.closeDriver();

    }

    @Before ("@db")
    public void setUpDb(){
        System.out.println("\tConnecting DB");


    }
    @After ("@db")
    public void tearDownDb(){
        System.out.println("\tConnecting DB");
    }


}
