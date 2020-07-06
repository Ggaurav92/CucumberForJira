package com.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




@CucumberOptions(features = {"src/test/resources/features"}, glue = { "com/stepDefinitions" }, plugin = { "pretty",
"html:target/cucumber-reports/cucumber-pretty", "json:target/cucumber-reports/CucumberTestReport.json","rerun:target/cucumber-reports/rerun.txt","com.Listeners.MyTestListener"},
tags= {"@Smoke"})
public class TestRunner extends AbstractTestNGCucumberTests{

/*
private TestNGCucumberRunner testNGCucumberRunner;

@BeforeClass(alwaysRun=true)
public void setUpClass() {
testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
}//End of setUpClass


@Test(groups="cucumber",description="Run cucumber Features",dataProvider="features")
public void feature(CucumberFeatureWrapper cucumberFeature) {
testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());

}//End of feature


@DataProvider
public Object[][] features(){
return testNGCucumberRunner.provideFeatures();

}//End of DataProvider feature

@AfterClass(alwaysRun=true)
public void testDownClass() {
testNGCucumberRunner.finish();
}//End of testDownClass

*/
}//End of class