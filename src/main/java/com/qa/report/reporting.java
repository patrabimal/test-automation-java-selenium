//package com.centurylink.utilities;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.markuputils.ExtentColor;
//import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import org.testng.ITestContext;
//import org.testng.ITestResult;
//import org.testng.TestListenerAdapter;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class reporting extends TestListenerAdapter {
//    public ExtentHtmlReporter htmlReporter;
//    public ExtentReports extent;
//    public ExtentTest logger;
//
//    public void onStart(ITestContext testContext){
//        String timeStamp = new SimpleDateFormat("YYYY.MM.dd.HH.mm.ss").format(new Date());//time stamp
//        String repName= "Test-Report-"+timeStamp+".html";
//        htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);//specify location
//        htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-cinfig.xml");
//
//        extent=new ExtentReports();
//
//        extent.attachReporter(htmlReporter);
//        extent.setSystemInfo("Host name","localhost");
//        extent.setSystemInfo("Environment","QA");
//        extent.setSystemInfo("user","bimal");
//
//        htmlReporter.config().setDocumentTitle("CenturyLink Project");//Title of the project
//        htmlReporter.config().setReportName("Functional Test Report");// name of the report
//        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);//Location of the chart
//        htmlReporter.config().setTheme(Theme.DARK);
//
//    }
//    public void onTestSuccess(ITestResult tr){
//        logger=extent.createTest(tr.getName());//create new entry in the report
//        logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
//    }
//
//    public void onTestFailure(ITestResult tr){
//        logger=extent.createTest(tr.getName());
//        logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
//
//        String screenshotpath=System.getProperty("user.dir")+"\\Screenshot\\"+tr.getName()+".png";
//        File file=new File(screenshotpath);
//        if(file.exists()){
//            try{
//                logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotpath));
//            }
//            catch(IOException e)
//            {
//                e.printStackTrace();
//            }
//        }
//    }
//    public void onTestSkipped(ITestResult tr){
//        logger=extent.createTest(tr.getName());
//        logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
//    }
//    public void onFinish(ITestContext testContext){
//        extent.flush();
//    }
//
//}
