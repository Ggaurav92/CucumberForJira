package com.Listeners;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.functions.ImageClass;
import com.stepDefinitions.ServiceHooks;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.Result;
import io.cucumber.plugin.event.Status;
import io.cucumber.plugin.event.TestCase;
import io.cucumber.plugin.event.TestCaseFinished;

public class MyTestListener implements ConcurrentEventListener  {
   

@Override
    public void setEventPublisher(EventPublisher publisher) {


        publisher.registerHandlerFor(TestCaseFinished.class, event -> {
try {
handleTestCaseFinished(event);
} catch (FileNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} catch (NoSuchFieldException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} catch (SecurityException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} catch (IllegalArgumentException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} catch (IllegalAccessException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
});
    }


//TestCaseFinished event

    private void handleTestCaseFinished(TestCaseFinished event) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, IOException {
       

    TestCase testCase = event.getTestCase();
        Result result = event.getResult();
        Status status = result.getStatus();
       
        //String scenarioName = testCase.getName();
        String id = "" + testCase.getUri() + testCase.getLine();
        System.out.println("Testcase " + id + " - " + status.name());
       
     
    //Creating instance of ImageClass to put image in word
    ImageClass Im = new ImageClass();
   
       
System.out.println("if check" + status.name().toString().equalsIgnoreCase("PASSED") );
        System.out.println("else check " + status.name().toString().equalsIgnoreCase("FAILED"));
       
       if(ServiceHooks.scenario.isFailed()) {
       
        System.out.println("Inside testlistener failed");
       
        Throwable error = result.getError();
        String errorString = "Failure : " + error.toString();
       
        System.out.println(errorString);
       
      //Attaching screenshot in word doc file
Im.ImageAttachClass(ServiceHooks.CurrScenarioName,ServiceHooks.CurrScenarioName,ServiceHooks.StepTagPlusDescrip.substring(0, 7),errorString,
ServiceHooks.StepTagPlusDescrip,ServiceHooks.Screenshotpath,ServiceHooks.CurrFeatureFileName);
       
        }
       
        }
   
   
   
   
}//end of Class


