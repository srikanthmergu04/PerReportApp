package main.java.temp;

import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

import java.io.File;

public class JmxFileTest {

    public static void main(String[] argv) throws Exception {
        // JMeter Engine
        StandardJMeterEngine jmeter = new StandardJMeterEngine();

        // Initialize Properties, logging, locale, etc.
        JMeterUtils.loadJMeterProperties("C:/Users/TT124/Installations/apache-jmeter-5.1.1/bin/jmeter.properties");
        JMeterUtils.setJMeterHome("C:/Users/TT124/Installations/apache-jmeter-5.1.1");
        JMeterUtils.setProperty("search_paths", System.getProperty("java.class.path")); //jmeter search java.class.path for libraries
        // JMeterUtils.initLogging();// you can comment this line out to see extra log
        // messages of i.e. DEBUG level
        JMeterUtils.initLocale();
        // Initialize JMeter SaveService
        SaveService.loadProperties();
        String worDir = System.getProperty("user.dir");
        String abPath = worDir + File.separator + "results" + File.separator + "regStudent_Jmx.jmx";
        // Load existing .jmx Test Plan
        HashTree testPlanTree = SaveService.loadTree(new File(abPath));
        // in.close();
        // Run JMeter Test
        jmeter.configure(testPlanTree);


        Summariser summer = null;
        String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");//$NON-NLS-1$
        if (summariserName.length() > 0) {
            summer = new Summariser(summariserName);
        }

        String logFile = "results/testReports.jtl";
        ResultCollector logger = new ResultCollector(summer);
        logger.setFilename(logFile);
        testPlanTree.add(testPlanTree.getArray()[0], logger);
        jmeter.run();

        System.out.println("Test Completed! , check testReports.jtl in results folder for results");
        System.exit(1);

    }
}