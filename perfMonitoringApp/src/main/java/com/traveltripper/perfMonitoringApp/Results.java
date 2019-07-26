/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.traveltripper.perfMonitoringApp;

import java.awt.Color;
import java.awt.Component;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table;

/**
 *
 * @author TT124
 */
public class Results extends javax.swing.JFrame {

	/**
	 * Creates new form Results
	 */

	String path = System.getProperty("user.dir");
	
	InputStream io = null;
	Properties prop = new Properties();
	String resultsDir = "";

	public Results() {
		initComponents();

		convertCsvToXlsx();

		// System.out.println("working directory
		// :"+(this.getClass().getClassLoader().getResource("props/jmeter.properties").toString()));

		// displayResultsFromCsvFile();

		displayResults();

	}

	private void convertCsvToXlsx() {
		// TODO Auto-generated method stub

		// open input file
		BufferedReader br;

		try {
			br = new BufferedReader(
					new FileReader(new File(System.getProperty("user.dir") + File.separator +resultsDir+File.separator+ "perfResultsJtl.jtl")));

			System.out.println("reading .jtl file" + br);

			// System.out.println(path+"/results/jmeterResults.jtl");

			// create sheet
			Workbook wb = new XSSFWorkbook();
			Sheet sheet = wb.createSheet();
			// read from file
			br.readLine(); // ignore first line
			String line = br.readLine();
			for (int rows = 0; line != null; rows++) {
				// create one row per line
				Row row = sheet.createRow(rows);
				// split by semicolon
				String[] items = line.split(",");
				// ignore first item
				for (int i = 0, col = 0; i < items.length; i++) {
					// strip quotation marks
					String item = items[i];
					Cell cell = row.createCell(col++);
					// set item
					cell.setCellValue(item);
				}
				// read next line
				line = br.readLine();
			}
			// write to xlsx

			FileOutputStream out = new FileOutputStream(
					System.getProperty("user.dir") + File.separator +resultsDir+File.separator+"perfResultsxlsx.xlsx");
			wb.write(out);

			System.out.println(" xlsx file is created");

			// close resources
			br.close();
			out.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void displayResults() {
		// TODO Auto-generated method stub

		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		model.setColumnIdentifiers(new Object[] { "timeStamp", "elapsed", "label", "responseCode", "responseMessage",
				"threadName", "dataType", "success", "failureMessage", "bytes", "sentBytes", "grpThreads", "allThreads",
				"URL", "Latency", "IdleTime", "Connect" });

		try {
			File exFile = new File(System.getProperty("user.dir") + File.separator +resultsDir+File.separator+ "perfResultsxlsx.xlsx");

			System.out.println(" File xlsx opened in display Results Method ");

			FileInputStream exFis = new FileInputStream(exFile);
			BufferedInputStream exBis = new BufferedInputStream(exFis);
			XSSFWorkbook excel = new XSSFWorkbook(exBis);

			XSSFSheet exSheet = excel.getSheetAt(0);

			for (int row = 0; row < exSheet.getLastRowNum() + 1; row++) {
				XSSFRow exRow = exSheet.getRow(row);

				XSSFCell timeStamp = exRow.getCell(0);
				XSSFCell elapsed = exRow.getCell(1);
				XSSFCell label = exRow.getCell(2);
				XSSFCell responseCode = exRow.getCell(3);
				XSSFCell responseMessage = exRow.getCell(4);
				XSSFCell threadName = exRow.getCell(5);
				XSSFCell dataType = exRow.getCell(6);
				XSSFCell success = exRow.getCell(7);
				XSSFCell failureMessage = exRow.getCell(8);
				XSSFCell bytes = exRow.getCell(9);
				XSSFCell sentBytes = exRow.getCell(10);
				XSSFCell grpThreads = exRow.getCell(11);
				XSSFCell allThreads = exRow.getCell(12);
				XSSFCell URL = exRow.getCell(13);
				XSSFCell Latency = exRow.getCell(14);
				XSSFCell IdleTime = exRow.getCell(15);
				XSSFCell Connect = exRow.getCell(16);

				// coloring cells in jtable

				model.insertRow(row,
						new Object[] { timeStamp, elapsed, label, responseCode, responseMessage, threadName, dataType,
								success, failureMessage, bytes, sentBytes, grpThreads, allThreads, URL, Latency,
								IdleTime, Connect });

			}

			int iSECount = 0;
			int timeOutCount = 0;

			List<Integer> iSERows = new ArrayList<Integer>();
			List<Integer> timeOutRows = new ArrayList<Integer>();
			// List<Integer> latency = new ArrayList<Integer>();

			TreeMap<Integer, Integer> latencyRowMap = new TreeMap<Integer, Integer>();

			for (int r = 0; r < exSheet.getLastRowNum() + 1; r++) {
				XSSFRow exRow = exSheet.getRow(r);

				// System.out.println(" result = "+exRow.getCell(4).getStringCellValue());

				if ((exRow.getCell(4).getStringCellValue()).equalsIgnoreCase("Internal Server Error")) {
					// System.out.println("hello");

					iSECount = iSECount + 1;
					iSERows.add(exRow.getRowNum());

				}
				if ((exRow.getCell(4).getStringCellValue()).equalsIgnoreCase("GATEWAY_TIMEOUT")) {

					timeOutCount = timeOutCount + 1;
					timeOutRows.add(exRow.getRowNum());
				}

				if ((exRow.getCell(4).getStringCellValue()).equalsIgnoreCase("OK")) {

					latencyRowMap.put(Integer.valueOf(exRow.getCell(14).getStringCellValue()), exRow.getRowNum());

				}

			}

			System.out.println(" Internal Server Error Count = " + iSECount);
			System.out.println(" Gate Way TimeOut Count =  " + timeOutCount);

			System.out.print("max latency = " + latencyRowMap.lastKey());

			int latencyRow = latencyRowMap.get(latencyRowMap.lastKey());

			TableColorCellRenderer renderer = new TableColorCellRenderer();

			renderer.setLatencyRow(latencyRow);

			table.setDefaultRenderer(Object.class, renderer);

			System.out.println(" latencyRow =  " + latencyRow);

			CellStyle cellstyle = exSheet.getWorkbook().createCellStyle();
			cellstyle.setFillForegroundColor(IndexedColors.RED.getIndex());
			cellstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			Iterator<Integer> it = timeOutRows.iterator();

			while (it.hasNext()) {

				XSSFRow row = exSheet.getRow(it.next());

				for (Iterator<Cell> ri = row.cellIterator(); ri.hasNext();) {
					Cell cell = ri.next();
					cell.setCellStyle(cellstyle);
				}

			}

			CellStyle cellstyle1 = exSheet.getWorkbook().createCellStyle();
			cellstyle1.setFillForegroundColor(IndexedColors.BLUE.getIndex());
			cellstyle1.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			XSSFRow row = exSheet.getRow(latencyRow);

			for (Iterator<Cell> ri = row.cellIterator(); ri.hasNext();) {
				Cell cell = ri.next();
				cell.setCellStyle(cellstyle1);
			}

			FileOutputStream out;
			out = new FileOutputStream(new File(path + File.separator +resultsDir+File.separator+ "PerfResutlsHighlightedExcelFile.xlsx"));
			excel.write(out);
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void displayResultsFromCsvFile() {
		// TODO Auto-generated method stub

		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(new Object[] { "timeStamp", "elapsed", "label", "responseCode", "responseMessage",
				"threadName", "dataType", "success", "failureMessage", "bytes", "sentBytes", "grpThreads", "allThreads",
				"URL", "Latency", "IdleTime", "Connect" });

		String line = "";
		String[] data = null;

		int count = 0;

		try {
			FileReader file = new FileReader(path + "/results/jmeterResults.jtl");

			BufferedReader br = new BufferedReader(file);

			line = br.readLine();

			while ((line = br.readLine()) != null) {

				data = line.split(",");

				// System.out.println("data size = "+data.length);

				model.insertRow(count,
						new Object[] { data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8],
								data[9], data[10], data[11], data[12], data[13], data[14], data[15], data[16] });

				count++;

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		contentPanel = new javax.swing.JPanel();
		tableScrollPane = new javax.swing.JScrollPane();
		table = new javax.swing.JTable();
		buttonPanel = new javax.swing.JPanel();
		horizontalScrollBar = new JScrollBar();
		
		
		io = this.getClass().getClassLoader().getResourceAsStream("Props/filePaths.properties");
		try {
			prop.load(io);
			resultsDir = prop.getProperty("resultsDir");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(true);

		contentPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 51)));

		tableScrollPane.setAutoscrolls(true);

		table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] {

		}));
		tableScrollPane.setViewportView(table);

		buttonPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

		javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
		buttonPanel.setLayout(buttonPanelLayout);
		buttonPanelLayout.setHorizontalGroup(buttonPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
		buttonPanelLayout.setVerticalGroup(buttonPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 77, Short.MAX_VALUE));

		javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
		contentPanel.setLayout(contentPanelLayout);
		contentPanelLayout.setHorizontalGroup(contentPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(contentPanelLayout.createSequentialGroup().addContainerGap()
						.addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 657,
										Short.MAX_VALUE))
						.addContainerGap()));
		contentPanelLayout.setVerticalGroup(contentPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(contentPanelLayout.createSequentialGroup().addGap(46, 46, 46)
						.addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
						.addGap(18, 18, 18)
						.addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(contentPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(contentPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Results().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JPanel buttonPanel;
	private javax.swing.JPanel contentPanel;
	private javax.swing.JTable table;
	private javax.swing.JScrollPane tableScrollPane;

	// End of variables declaration

	private javax.swing.JScrollBar horizontalScrollBar;
}
