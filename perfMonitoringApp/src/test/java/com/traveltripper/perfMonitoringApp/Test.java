package com.traveltripper.perfMonitoringApp;

public class Test {
	
	public static void main(String args[])
	{
		Results rs = new Results();
		
		rs.setApiName("multiPropertyApi");
		rs.convertCsvToXlsx();
		rs.displayResults();
		rs.setVisible(true);
		
	}

}
