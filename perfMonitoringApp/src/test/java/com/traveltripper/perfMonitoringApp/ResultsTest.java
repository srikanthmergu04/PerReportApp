package com.traveltripper.perfMonitoringApp;

public class ResultsTest {

    public static void main(String args[]) {
        Results results = new Results();
        results.convertCsvToXlsx();
        results.displayResults();
    }

}
