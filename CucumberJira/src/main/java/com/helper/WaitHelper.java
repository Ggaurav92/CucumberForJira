package com.helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//This class is not used in the framework
public class WaitHelper {

Logger log = LoggerHelper.getLogger(WaitHelper.class);

private WebDriver driver;

public WaitHelper(WebDriver driver) {
this.driver = driver;
}//End of constructor


public void WaitForElement(WebElement element, long timeOutInSeconds) {

log.info("waiting for element visibility of....");
WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
wait.until(ExpectedConditions.visibilityOf(element));
log.info("element is visible");
}//End of WatiforElement
}//End of Class


