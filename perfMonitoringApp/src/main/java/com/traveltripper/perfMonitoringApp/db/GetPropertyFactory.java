package com.traveltripper.perfMonitoringApp.db;

public class GetPropertyFactory {

    public DbProperty getProperty(String PropType) {

        if (PropType == null) {
            System.out.println("Proptype = " + PropType);
            return null;
        }

        if (PropType.equalsIgnoreCase("Dev")) {
            System.out.println("getting Dev Property Obj");
            return new DevDbProperty();
        } else if (PropType.equalsIgnoreCase("PREf")) {

            return new PerfDbProperty();

        } else if (PropType.equalsIgnoreCase("TT-QA")) {
            return new TestDbProperty();
        }

        return null;
    }

}
