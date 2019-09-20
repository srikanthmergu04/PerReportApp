package com.traveltripper.perfMonitoringApp;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.CSVDataSet;
import org.apache.jmeter.config.gui.ArgumentsPanel;
import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.control.gui.LoopControlPanel;
import org.apache.jmeter.control.gui.TestPlanGui;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.functions.FileToString;
import org.apache.jmeter.protocol.http.control.Header;
import org.apache.jmeter.protocol.http.control.HeaderManager;
import org.apache.jmeter.protocol.http.control.gui.HttpTestSampleGui;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.testbeans.gui.TestBeanGUI;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jmeter.threads.gui.ThreadGroupGui;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

import java.io.*;
import java.util.*;

public class JMeterFromScratch {
    static String resultsDir;

    public void run() throws IOException {
    	org.apache.jmeter.functions.FileToString fileToString = new FileToString();

        InputStream file = this.getClass().getClassLoader().getResourceAsStream("Props/jmeter.properties");

        InputStream filePaths = this.getClass().getClassLoader().getResourceAsStream("Props/filePaths.properties");

        Properties fileProp = new Properties();

        fileProp.load(filePaths);

        File jmeterHome = new File(fileProp.getProperty("jmeterHome")); // need to provide relative path

        System.out.println("jmeterHome = " + jmeterHome);

        String slash = System.getProperty("file.separator");

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("Props/filePaths.properties");
        Properties property = new Properties();
        property.load(inputStream);
        resultsDir = property.getProperty("resultsDir");

        if (jmeterHome.exists()) {

            System.out.println("jmeterHome Exists");

            File jmeterProperties = new File(fileProp.getProperty("jmeterprops"));

            if (jmeterProperties.exists()) {

                // JMeter Engine
                StandardJMeterEngine jmeter = new StandardJMeterEngine();

                System.out.println("jmeterProperties Exists");

                // JMeter initialization (properties, log levels, locale, etc)
                JMeterUtils.setJMeterHome(jmeterHome.getPath());
                JMeterUtils.loadJMeterProperties(jmeterProperties.getPath());
                JMeterUtils.setProperty("search_paths", System.getProperty("java.class.path"));
                System.out.println("searchPath = "+System.getProperty("java.class.path"));
                //JMeterUtils.initLogging();// you can comment this line out to see extra log messages of i.e. DEBUG level
                JMeterUtils.initLocale();

                // Test Plan
                TestPlan testPlan = new TestPlan(apiName);// API NAME
                testPlan.setEnabled(true);
                testPlan.setProperty("TestPlan.comments", "");
                testPlan.setProperty("TestPlan.functional_mode", false);
                testPlan.setProperty("TestPlan.tearDown_on_shutdown", true);
                testPlan.setProperty("TestPlan.serialize_threadgroups", true);
                testPlan.setProperty(TestElement.TEST_CLASS, TestPlan.class.getName());
                testPlan.setProperty(TestElement.GUI_CLASS, TestPlanGui.class.getName());
                testPlan.setUserDefinedVariables((Arguments) new ArgumentsPanel().createTestElement());
                testPlan.setProperty("TestPlan.user_define_classpath", "");

                // LoopController
                LoopController loopController = new LoopController();
                loopController.setLoops(1);
                loopController.setFirst(true);
                loopController.setProperty(TestElement.TEST_CLASS, LoopController.class.getName());
                loopController.setProperty(TestElement.GUI_CLASS, LoopControlPanel.class.getName());
                loopController.setName("Loop Controller");
                loopController.setEnabled(true);
                loopController.initialize();

                // Thread Group
                ThreadGroup threadGroup = new ThreadGroup();
                threadGroup.setName("Thread Group");
                threadGroup.setEnabled(true);
                threadGroup.setProperty("ThreadGroup.on_sample_error", "continue");
                threadGroup.setProperty(TestElement.TEST_CLASS, ThreadGroup.class.getName());
                threadGroup.setProperty(TestElement.GUI_CLASS, ThreadGroupGui.class.getName());
                threadGroup.setSamplerController(loopController);
                threadGroup.setNumThreads(threadGroupVal);
                threadGroup.setRampUp(rampUpTime);
                threadGroup.setProperty("ThreadGroup.scheduler", true);
                threadGroup.setProperty("ThreadGroup.duration", durationTime);
                threadGroup.setProperty("ThreadGroup.delay", delayTime);

                // HTTP Sampler
                HTTPSamplerProxy httpSampler = new HTTPSamplerProxy();

                httpSampler = getHTTPSamplerProxy();

                /*
                 * // HeaderManager HeaderManager headerManager = new HeaderManager();
                 * headerManager.setName("HTTP Header Manager"); headerManager.setEnabled(true);
                 * headerManager.setProperty(TestElement.TEST_CLASS,
                 * HeaderManager.class.getName());
                 * headerManager.setProperty(TestElement.GUI_CLASS, "HeaderPanel");
                 *
                 * for (Map.Entry<String, String> map : reqHeadMap.entrySet()) { String key =
                 * map.getKey(); String value = map.getValue(); // System.out.println("in for
                 * for(Map.Entry<String, String> // map:reqHeadMap.entrySet()) "+key+""+ value);
                 * headerManager.add(new Header(key, value)); }
                 * headerAndCsvDataHashTree.add(headerManager);
                 */

                /*
                 * // Construct Test Plan from previously initialized elements
                 * testPlanTree.add(testPlan); HashTree threadGroupHashTree =
                 * testPlanTree.add(testPlan, threadGroup); // testPlanTree.add //
                 * threadGroupHashTree.add(blazemetercomSampler);
                 * threadGroupHashTree.add(httpSampler); testPlanTree.add(testPlan); HashTree
                 * threadGroupHashTree = new HashTree(); threadGroupHashTree =
                 * testPlanTree.add(testPlan,threadGroup); HashTree HttpSamplerHashTree =
                 * threadGroupHashTree.add(httpSampler); HttpSamplerHashTree.add(headerManager);
                 * HttpSamplerHashTree.add(csvDataset);
                 */

                HashTree TestPlanHashTree = new HashTree();
                TestPlanHashTree.add(testPlan);
                HashTree threadGroupHashTree = new HashTree();
                threadGroupHashTree = TestPlanHashTree.add(testPlan);
                threadGroupHashTree.add(threadGroup);
                HashTree httpSamplerHashTree = new HashTree();
                httpSamplerHashTree = threadGroupHashTree.add(threadGroup);
                httpSamplerHashTree.add(httpSampler);
                HashTree headerAndCsvDataHashTree = new HashTree();
                headerAndCsvDataHashTree = httpSamplerHashTree.add(httpSampler);
                // headerAndCsvDataHashTree.add(headerManager);

                /*
                 * if (csvDataset == null) {
                 * System.out.println("csvDataSet is not added to HashTree");
                 *
                 * } else { headerAndCsvDataHashTree.add(csvDataset); }
                 */

                switch (method) {
                    case "GET":
                        CSVDataSet csvDataset = null;
                        System.out.println("csvVariableNames size = " + csvVariableNames.size());
                        if (csvVariableNames.size() == 0) {
                            System.out.println("no dynamicVariable Names");
                        } else {
                            csvDataset = new CSVDataSet();
                            csvDataset = getCSVData();
                            headerAndCsvDataHashTree.add(csvDataset);
                        }

                        // HeaderManager
                        HeaderManager headerManager = new HeaderManager();
                        headerManager.setName("HTTP Header Manager");
                        headerManager.setEnabled(true);
                        headerManager.setProperty(TestElement.TEST_CLASS, HeaderManager.class.getName());
                        headerManager.setProperty(TestElement.GUI_CLASS, "HeaderPanel");

                        for (Map.Entry<String, String> map : reqHeadMap.entrySet()) {
                            String key = map.getKey();
                            String value = map.getValue();
                            // System.out.println("in for for(Map.Entry<String, String>
                            // map:reqHeadMap.entrySet()) "+key+""+ value);
                            headerManager.add(new Header(key, value));
                        }
                        headerAndCsvDataHashTree.add(headerManager);

                        break;
                    case "POST":

                        String jsonFile = System.getProperty("user.dir") + File.separator + "results" + File.separator
                                + "index.csv";
                        CSVDataSet csv = new CSVDataSet();
                        csv.setName("CSV_Data");
                        csv.setProperty(TestElement.TEST_CLASS, CSVDataSet.class.getName());
                        csv.setProperty(TestElement.GUI_CLASS, TestBeanGUI.class.getName());
                        csv.setEnabled(true);
                        csv.setProperty("filename", jsonFile);

                        csv.setProperty("variableNames", "jsonFile");
                        csv.setProperty("fileEncoding", "");
                        csv.setProperty("ignoreFirstLine", false);
                        csv.setProperty("delimiter", ",");
                        csv.setProperty("quotedData", false);
                        csv.setProperty("recycle", true);
                        csv.setProperty("stopThread", false);
                        csv.setProperty("shareMode", "shareMode.all");
                        headerAndCsvDataHashTree.add(csv);


                        // HeaderManager
                        HeaderManager headerManager1 = new HeaderManager();
                        headerManager1.setName("HTTP Header Manager");
                        headerManager1.setEnabled(true);
                        headerManager1.setProperty(TestElement.TEST_CLASS, HeaderManager.class.getName());
                        headerManager1.setProperty(TestElement.GUI_CLASS, "HeaderPanel");

                        for (Map.Entry<String, String> map : reqHeadMap.entrySet()) {
                            String key = map.getKey();
                            String value = map.getValue();
                            System.out.println(
                                    "in for for(Map.Entry<String, String> map:reqHeadMap.entrySet()) " + key + "" + value);
                            headerManager1.add(new Header(key, value));
                        }
                        headerAndCsvDataHashTree.add(headerManager1);

                        break;

                    default:
                        break;
                }

                try {
                    String fileName = apiName + "_Jmx.jmx";
                    String worDir = System.getProperty("user.dir");
                    String abPath = worDir + File.separator + resultsDir + File.separator + fileName;

                    File jmxFile = new File(abPath);

                    jmxFile.setWritable(true);
                    jmxFile.setReadable(true);
                    jmxFile.setExecutable(true);

                    if (jmxFile.createNewFile()) {

                        System.out.println(fileName + "is created. ");
                    } else {
                        System.out.println(fileName + "is Not created. ");
                    }

                    SaveService.saveTree(TestPlanHashTree, new FileOutputStream(jmxFile));

                    System.out.println(fileName + "file created successfully");

                    TestPlanHashTree.clear();
                    TestPlanHashTree = SaveService.loadTree(jmxFile);
                    System.out.println(fileName + " is loaded Successfully");
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch blockj
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                // add Summarizer output to get test progress in stdout like:
                // summary = 2 in 1.3s = 1.5/s Avg: 631 Min: 290 Max: 973 Err: 0 (0.00%)
                Summariser summer = null;
                String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");
                if (summariserName.length() > 0) {
                    summer = new Summariser(summariserName);
                }

                // Store execution results into a .jtl file

                // String logFile = jmeterHome + slash + "exampleres.jtl";

                String logFile = System.getProperty("user.dir") + File.separator + resultsDir + File.separator + apiName
                        + "_Jtl.jtl";

                System.out.println(logFile + " is created");

                ResultCollector logger = new ResultCollector(summer);
                logger.setFilename(logFile);
                TestPlanHashTree.add(TestPlanHashTree.getArray()[0], logger);

                // Run Test Plan

                jmeter.configure(TestPlanHashTree);

                jmeter.run();


                Results displayResults = new Results();
                displayResults.setApiName(apiName);
                displayResults.convertCsvToXlsx();
                displayResults.displayResults();


            }

        } else {
            System.err.println("jmeter.home property is not set or pointing to incorrect location");
            System.exit(1);
        }

    }

    private static CSVDataSet getCSVData() {

        // TODO Auto-generated method stub

        String fiName = apiName + ".csv";
        String wrDir = System.getProperty("user.dir");

        String abPathName = wrDir + File.separator + resultsDir + File.separator + fiName;

        CSVDataSet csvDataset = new CSVDataSet();
        csvDataset.setName("CSV_Data");
        csvDataset.setProperty(TestElement.TEST_CLASS, CSVDataSet.class.getName());
        csvDataset.setProperty(TestElement.GUI_CLASS, TestBeanGUI.class.getName());
        csvDataset.setEnabled(true);
        csvDataset.setProperty("filename", abPathName);

        String dynamicVarNames = "";

        Iterator<String> it = csvVariableNames.iterator();

        while (it.hasNext()) {
            dynamicVarNames = dynamicVarNames + it.next();
            dynamicVarNames = dynamicVarNames + ",";
        }

        System.out.println("Dynamic Variable Names = " + dynamicVarNames);

        csvDataset.setProperty("variableNames", dynamicVarNames);
        csvDataset.setProperty("fileEncoding", "");
        csvDataset.setProperty("ignoreFirstLine", false);
        csvDataset.setProperty("delimiter", ",");
        csvDataset.setProperty("quotedData", false);
        csvDataset.setProperty("recycle", true);
        csvDataset.setProperty("stopThread", false);
        csvDataset.setProperty("shareMode", "shareMode.all");

        return csvDataset;
    }

    public static String getApiName() {
        return apiName;
    }

    private static HTTPSamplerProxy getHTTPSamplerProxy() {
        // TODO Auto-generated method stub

        HTTPSamplerProxy httpSampler = new HTTPSamplerProxy();

        httpSampler.setName(apiName);
        httpSampler.setProperty(TestElement.TEST_CLASS, HTTPSamplerProxy.class.getName());
        httpSampler.setProperty(TestElement.GUI_CLASS, HttpTestSampleGui.class.getName());
        httpSampler.setEnabled(true);

        switch (method) {
            case "GET":
                httpSampler.setMethod(method);
                for (String queryKey : queryParamsMap.keySet()) {
                    httpSampler.addNonEncodedArgument(queryKey, queryParamsMap.get(queryKey), "=");

                }
                break;
            case "POST":
                httpSampler.setMethod(method);
                httpSampler.setPostBodyRaw(true);
                String jsonPath = ""+System.getProperty("user.dir") + File.separator + "results" ;
                httpSampler.addNonEncodedArgument("",
                        "${__FileToString(${jsonFile},,)}",
                        "="); // ${__FileToString(${JSON_FILE},,)}


                // httpSampler.setContentEncoding("UTF-8");
                // HeaderManager hm = new HeaderManager();
                // hm.setProperty("Content-Type", "application/json");
                // httpSampler.setHeaderManager(hm);
                // httpSampler.set
                // httpSampler.addNonEncodedArgument("",
                // "{\"sid\":7,\"name\":\"srikanth\",\"age\":\"21\",\"dept\":\"ui\",\"address\":null,\"accounts\":[],\"lap\":[]}",
                // "=");

                break;

            default:
                break;
        }

        // httpSampler.setc
        httpSampler.setDomain(domain);
      httpSampler.setProperty("HTTPSampler.port", "8080");
        httpSampler.setProtocol(protocol);
        httpSampler.setProperty("HTTPSampler.contentEncoding", "");
        httpSampler.setPath(path);
        // httpSampler.setMethod(method);
        httpSampler.setFollowRedirects(true);
        httpSampler.setAutoRedirects(false);
        httpSampler.setUseKeepAlive(true);
        httpSampler.setDoMultipartPost(false);
        httpSampler.setEmbeddedUrlRE("");
        httpSampler.setConnectTimeout("");
        httpSampler.setResponseTimeout("");

        return httpSampler;

    }

    private int threadGroupVal;
    private int durationTime;
    private int rampUpTime;
    private int delayTime;

    private static String environment;
    private static String apiName;
    private static String protocol;
    private static String method;
    private static String domain;
    private static Map<String, String> queryParamsMap = new LinkedHashMap<String, String>();

    private static String path;

    private static Set<String> csvVariableNames;

    Map<String, String> reqHeadMap = new LinkedHashMap<String, String>();

    public void setQueryParamsMap(Map<String, String> queryParamsMap) {
        this.queryParamsMap = queryParamsMap;
    }

    public void setReqHeadMap(Map<String, String> reqHeadMap) {
        this.reqHeadMap = reqHeadMap;
    }

    public void setThreadGroupVal(int threadGroupVal) {
        this.threadGroupVal = threadGroupVal;
    }

    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }

    public void setRampUpTime(int rampUpTime) {
        this.rampUpTime = rampUpTime;
    }

    public void setDelayTime(int delayTime) {
        this.delayTime = delayTime;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setCsvVariableNames(Set<String> csvVariableNames) {
        this.csvVariableNames = csvVariableNames;
    }

    public void setPath(String path) {
        this.path = path;
    }

}