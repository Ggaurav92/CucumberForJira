package com.stepDefinitions;

import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.functions.ImageClass;
import com.functions.ScreenShotClass;
import com.helper.GetFeatureFileData;
import com.helper.OtherClass;
import com.testBase.TestBase;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;





public class ServiceHooks extends TestBase {

//Initializing all the static variables needed
public static Scenario scenario;
public static String errMsg = null;
public static String CurrFeatureFileName = null;
public static String StepTagPlusDescrip = null;
public static String Screenshotpath = null;
public static String CurrScenarioName = null;

//Creating instance of the Logger class to create logs
Logger log = LogManager.getLogger(this.getClass().getName());

//Creating instance of ScreenShotClass class for taking screenshot
ScreenShotClass SSh = new ScreenShotClass(driver);

//Creating instance of ImageClass to put image in word
ImageClass Im = new ImageClass();

@Before
public void before(Scenario scenario) {

//Creating instance of the GetFeatureFileDta to get the data from feature file needed for evidence docs
GetFeatureFileData gst = new GetFeatureFileData();

//Assigning the current scenario to the static scenario variable
ServiceHooks.scenario = scenario;

//Getting the current feature file name
String CurrFeatureFileName = gst.getFeatureFileName(scenario);

System.out.println("The Feature file name is : " + CurrFeatureFileName);

  //Creating folder for Word Document
String Wordpath = "./Evidences/WordDocs/" + CurrFeatureFileName;// + "/" + scenario.getName();
//Creating a File object
   File wordfile = new File(Wordpath);
   wordfile.mkdir();
   log.info(CurrFeatureFileName  + " folder created in WordDocs folder");
   
   String SecondWordpath = "./Evidences/WordDocs/" + CurrFeatureFileName + "/" + scenario.getName();
//Creating a File object
   File secwordfile = new File(SecondWordpath);
   secwordfile.mkdir();
   log.info(scenario.getName() + " folder created in the Current Feature File folder in WordDocs");
   
   //Creating folder for Screenshots
String Screenpath1 = "./Evidences/Screenshot/" + CurrFeatureFileName;// + "/" + scenario.getName();
//Creating a File object
   File file = new File(Screenpath1);
   file.mkdir();
   
   //Creating folder for Screenshots
String path = "./Evidences/Screenshot/" + CurrFeatureFileName + "/" + scenario.getName();
//Creating a File object
   File secScreenfile = new File(path);
   secScreenfile.mkdir();
   
   log.info(CurrFeatureFileName + " folder created in Screenshot and " + scenario.getName() +  " folder created in it" );
}

@After
public void after() {


if(scenario.isFailed()) {
//Embedding screenshot in advance report
ServiceHooks.TakeScreenshot("Failure Screenshot");
log.error("Attaching error screenshot in the Advanced report");

}



//Closing the driver
driver.quit();
log.info("Closed the browser and driver instance");

//Setting the OtherClass StepIndex to 0 after the end of every scenario
OtherClass.setStepIndex(0);
}//End of After



@AfterStep
public void afterStep(Scenario scenario) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, IOException {

//Creating instance of  GetFeatureFileData to get the data from feature file needed for evidence file
GetFeatureFileData gst = new GetFeatureFileData();

//Getting the current scenario name and assigning it to static variable CurrScenarioName
CurrScenarioName = scenario.getName();

//Getting the Current Feature File name and assigning it to the static vatiable CurrFeatureFileName
CurrFeatureFileName = gst.getFeatureFileName(scenario);

//Getting the Current Step Text and assigning it to varible StepTagPlusDescrip
    StepTagPlusDescrip = gst.getStepText(scenario);
    System.out.println("STEP TEXT  :   " + StepTagPlusDescrip);
   
    //Creating a Screenshot path
Screenshotpath = "./Evidences/Screenshot/" + CurrFeatureFileName + "/" + scenario.getName() + "/"+ StepTagPlusDescrip.substring(0, 7) + ".png";


//Taken screenshot to attach in the Cucumber Advanced Report
ServiceHooks.TakeScreenshot(StepTagPlusDescrip.substring(0, 7));
log.info("Screenshot attached in Advanced Report for :" +  StepTagPlusDescrip);

//full page screenshot
//SSh.fullPgScreenCapture(driver, Screenshotpath);

//Capturing the screenshot for Word Evidence
SSh.screencapture(driver, Screenshotpath);
log.info("Took the screenshot for evidence and saved it in path : " + Screenshotpath);

if (!scenario.isFailed()) {

//Attaching screenshot in Word evidence file
Im.ImageAttachClass(CurrScenarioName,CurrScenarioName,StepTagPlusDescrip.substring(0, 7),"",StepTagPlusDescrip,Screenshotpath,CurrFeatureFileName);
log.info("Word doc prepared and screenshot attached for the step :" + StepTagPlusDescrip);



}//end of if



   

}//End of AfterStep






public static void TakeScreenshot(String fileName) {
final byte[] screenshot = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES);

//Embedding the image in png in report
ServiceHooks.scenario.attach(screenshot, "image/png", fileName);

}//End of TakeScreenshot




}//End of ServiceHooks

