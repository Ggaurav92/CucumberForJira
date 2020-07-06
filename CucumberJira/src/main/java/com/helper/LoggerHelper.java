package com.helper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

//This class is not used on the framework
public class LoggerHelper {

private static boolean root = false;


public static Logger getLogger(Class<?> cls) {

if(root) {
return Logger.getLogger(cls);
}
PropertyConfigurator.configure("log4j.properties");
root = true;
return Logger.getLogger(cls);

}//End of getLogger


}//End of Class

