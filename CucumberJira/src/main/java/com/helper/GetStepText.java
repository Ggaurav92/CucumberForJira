package com.helper;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import io.cucumber.core.backend.TestCaseState;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;

public class GetStepText {



public String getStepText(io.cucumber.java.Scenario scenario) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{      
   String  currentStepDescr = null;
   String currentTag = null;
   String currentTagPlusStepDescr = null;
   
   //value currentStepDefIndex is tracked in the another class
   int currentStepDefIndex = OtherClass.getStepIndex();

   Field f = scenario.getClass().getDeclaredField("delegate");
   f.setAccessible(true);
   TestCaseState tcs = (TestCaseState) f.get(scenario);

   Field f2 = tcs.getClass().getDeclaredField("testCase");
   f2.setAccessible(true);
   TestCase r = (TestCase) f2.get(tcs);

       List<PickleStepTestStep> stepDefs = r.getTestSteps()
               .stream()
               .filter(x -> x instanceof PickleStepTestStep)
               .map(x -> (PickleStepTestStep) x)
               .collect(Collectors.toList());


       PickleStepTestStep currentStepDef = stepDefs
               .get(currentStepDefIndex);
       currentStepDescr = currentStepDef.getStep().getText();
       currentTag = currentStepDef.getStep().getKeyWord();
       
       currentTagPlusStepDescr = currentStepDefIndex +" " + currentTag + " " + currentStepDescr;
       
       currentStepDefIndex += 1;
       OtherClass.setStepIndex(currentStepDefIndex);
        return currentTagPlusStepDescr;
      }


}