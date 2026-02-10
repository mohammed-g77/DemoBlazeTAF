package com.automationexercices.utils;

import static java.lang.System.currentTimeMillis;

public class TimeManager {
    // screenshot - logs - reports
  public static String getTimeStamp(){
      return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
  }
  // unique timestamp
  public static String getSimpleTimestamp(){

     return  Long.toString(currentTimeMillis());
  }


}
