package com.helper;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;

public class GetFeatureFileData {



public String getStepText(Scenario scenario) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{      
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

       List<Object> stepDefs = r.getTestSteps()
               .stream()
               .filter(x -> x instanceof PickleStepTestStep)
               .map(x -> (PickleStepTestStep) x)
               .collect(Collectors.toList());

       
       
       Object currentStepDef = stepDefs
               .get(currentStepDefIndex);
       currentStepDescr = ((PickleStepTestStep) currentStepDef).getStep().getText();
       currentTag = ((PickleStepTestStep) currentStepDef).getStep().getKeyWord();
       
       
       currentTagPlusStepDescr = currentStepDefIndex +" " + currentTag + " " + currentStepDescr;
       
       currentStepDefIndex += 1;
       OtherClass.setStepIndex(currentStepDefIndex);
        return currentTagPlusStepDescr;
      }



public String getFeatureFileName(Scenario scenario) {
/*
String featureName = null;
   String rawFeatureName = scenario.getId().split(";")[0].replace("-"," ");
   featureName = featureName + rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);

   return featureName;
*/



String scenarioId=scenario.getId();

// getId gives >> file:///C:/Users/P10444427/eclipse-workspace/PIC_Cucumber/src/test/resources/features/MPSlogin.feature:5
System.out.println("The scenario id  is " + scenarioId);

String[] dividedbyseparator = scenarioId.split("/");

String FeatureFilewithcolon = dividedbyseparator[dividedbyseparator.length-1];

String[] dividedByColon = FeatureFilewithcolon.split(":");

String FeatureFileName = dividedByColon[0].replace(".feature", "");

        return FeatureFileName;
}




}//End of Class


