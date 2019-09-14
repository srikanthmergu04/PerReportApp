/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.traveltripper.perfMonitoringApp;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.List;
import java.util.*;

/**
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
        setVisible(true);
        setIcon();
    }

    public void setIcon() {
        Image image = new ImageIcon(this.getClass().getClassLoader().getResource("images/TraveltripperICon.png"))
                .getImage();
        setIconImage(image);
    }

    public void convertCsvToXlsx() {
        // TODO Auto-generated method stub

        table.setAutoResizeMode(table.AUTO_RESIZE_OFF);

        // DefaultTableModel model =
        model = (DefaultTableModel) table.getModel();

        model.setColumnIdentifiers(new Object[]{"timeStamp", "elapsed", "label", "responseCode", "responseMessage",
                "threadName", "dataType", "success", "failureMessage", "bytes", "sentBytes", "grpThreads", "allThreads",
                "URL", "Latency", "IdleTime", "Connect"});

        // open input file
        BufferedReader br;

        try {
            System.out.println("apiName = " + apiName);
            br = new BufferedReader(new FileReader(new File(System.getProperty("user.dir") + File.separator + resultsDir
                    + File.separator + apiName + "_Jtl.jtl")));//  apiName + "_Jtl.jtl"

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

                model.insertRow(row.getRowNum(), items);

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

            FileOutputStream out = new FileOutputStream(System.getProperty("user.dir") + File.separator + resultsDir
                    + File.separator + apiName + "PerfResults" + ".xlsx");
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

    public void displayResults() {
        // TODO Auto-generated method stub

        /*
         * table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
         *
         * // DefaultTableModel model = model = (DefaultTableModel) table.getModel();
         *
         * model.setColumnIdentifiers(new Object[] { "timeStamp", "elapsed", "label",
         * "responseCode", "responseMessage", "threadName", "dataType", "success",
         * "failureMessage", "bytes", "sentBytes", "grpThreads", "allThreads", "URL",
         * "Latency", "IdleTime", "Connect" });
         */

        try {
            File exFile = new File(System.getProperty("user.dir") + File.separator + resultsDir + File.separator
                    + apiName + "PerfResults" + ".xlsx");
            System.out.println(" File xlsx opened in display Results Method ");
            FileInputStream exFis = new FileInputStream(exFile);
            BufferedInputStream exBis = new BufferedInputStream(exFis);
            XSSFWorkbook excel = new XSSFWorkbook(exBis);
            XSSFSheet exSheet = excel.getSheetAt(0);

            /*
             * for (int row = 0; row < exSheet.getLastRowNum() + 1; row++) { XSSFRow exRow =
             * exSheet.getRow(row);
             *
             * XSSFCell timeStamp = exRow.getCell(0); XSSFCell elapsed = exRow.getCell(1);
             * XSSFCell label = exRow.getCell(2); XSSFCell responseCode = exRow.getCell(3);
             * XSSFCell responseMessage = exRow.getCell(4); XSSFCell threadName =
             * exRow.getCell(5); XSSFCell dataType = exRow.getCell(6); XSSFCell success =
             * exRow.getCell(7); XSSFCell failureMessage = exRow.getCell(8); XSSFCell bytes
             * = exRow.getCell(9); XSSFCell sentBytes = exRow.getCell(10); XSSFCell
             * grpThreads = exRow.getCell(11); XSSFCell allThreads = exRow.getCell(12);
             * XSSFCell URL = exRow.getCell(13); XSSFCell Latency = exRow.getCell(14);
             * XSSFCell IdleTime = exRow.getCell(15); XSSFCell Connect = exRow.getCell(16);
             *
             * // coloring cells in jtable
             *
             * model.insertRow(row, new Object[] { timeStamp, elapsed, label, responseCode,
             * responseMessage, threadName, dataType, success, failureMessage, bytes,
             * sentBytes, grpThreads, allThreads, URL, Latency, IdleTime, Connect });
             *
             *
             *
             * }
             */

            int iSECount = 0;
            int timeOutCount = 0;
            int successCount = 0;

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

                if ((exRow.getCell(3).getStringCellValue()).equalsIgnoreCase("200")) {

                    latencyRowMap.put(Integer.valueOf(exRow.getCell(14).getStringCellValue()), exRow.getRowNum());
                    successCount++;

                }

            }

            failedIseReqValLabel.setText(iSECount + "");
            failedGatewayTimoutReqValLabel.setText(timeOutCount + "");
            failReqValLabel.setText((iSECount + timeOutCount) + "");
            successReqValLabel.setText(successCount + "");

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
                for (Iterator<Cell> ri = row.cellIterator(); ri.hasNext(); ) {
                    Cell cell = ri.next();
                    cell.setCellStyle(cellstyle);
                }
            }

            CellStyle cellstyle1 = exSheet.getWorkbook().createCellStyle();
            cellstyle1.setFillForegroundColor(IndexedColors.BLUE.getIndex());
            cellstyle1.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            XSSFRow row = exSheet.getRow(latencyRow);

            for (Iterator<Cell> ri = row.cellIterator(); ri.hasNext(); ) {
                Cell cell = ri.next();
                cell.setCellStyle(cellstyle1);
            }

            FileOutputStream out;
            out = new FileOutputStream(new File(
                    path + File.separator + resultsDir + File.separator + apiName + "PerfResults-Highlighted" + ".xlsx"));
            excel.write(out);
            out.close();

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
        statisticsPanel = new javax.swing.JPanel();
        statisticsLabel = new javax.swing.JLabel();
        failReqLabel = new javax.swing.JLabel();
        failedIseReqLabel = new javax.swing.JLabel();
        failReqValLabel = new javax.swing.JLabel();
        failedIseReqValLabel = new javax.swing.JLabel();
        failedGatewayTimoutReqLabel = new javax.swing.JLabel();
        failedGatewayTimoutReqValLabel = new javax.swing.JLabel();
        successReqLabel = new javax.swing.JLabel();
        successReqValLabel = new javax.swing.JLabel();
        tableTitleLabel = new javax.swing.JLabel();
        cellPopUpMenu = new javax.swing.JPopupMenu();
        model = new DefaultTableModel();
        cellDialog = new JDialog();

        setTitle("Performance Monitoring Tool - travel tripper");
        io = this.getClass().getClassLoader().getResourceAsStream("Props/filePaths.properties");
        try {
            prop.load(io);
            resultsDir = prop.getProperty("resultsDir");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        // contentPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new
        // java.awt.Color(102, 255, 51)));

        tableScrollPane.setAutoscrolls(true);

        table.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{

        }, new String[]{

        }));
        tableScrollPane.setViewportView(table);

        table.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

                System.out.println("mouse is clicked on jtable");
                int selCol = table.getSelectedColumn();
                int selRow = table.getSelectedRow();

                String selCell = model.getValueAt(selRow, selCol).toString();

            }
        });

        // statisticsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new
        // java.awt.Color(255, 51, 51)));

        statisticsLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        statisticsLabel.setText("Statistics");

        failReqLabel.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        failReqLabel.setText("No of Failure Requests  :");

        failedIseReqLabel.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        failedIseReqLabel.setText("No of  Failure Requests due to Internal Server Error  :");

        failReqValLabel.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        failReqValLabel.setText("jLabel3");

        failedIseReqValLabel.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        failedIseReqValLabel.setText("jLabel4");

        failedGatewayTimoutReqLabel.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        failedGatewayTimoutReqLabel.setText("No of  Failure Requests due to GATEWAY_TIMEOUT :");

        failedGatewayTimoutReqValLabel.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        failedGatewayTimoutReqValLabel.setText("jLabel4");

        successReqLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        successReqLabel.setText("No of succeed Requests  :");

        successReqValLabel.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        successReqValLabel.setText("jLabel3");

        javax.swing.GroupLayout statisticsPanelLayout = new javax.swing.GroupLayout(statisticsPanel);
        statisticsPanel.setLayout(statisticsPanelLayout);
        statisticsPanelLayout.setHorizontalGroup(statisticsPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(statisticsPanelLayout.createSequentialGroup().addGap(34, 34, 34)
                        .addGroup(statisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(statisticsPanelLayout.createSequentialGroup().addGroup(statisticsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(statisticsPanelLayout.createSequentialGroup()
                                                .addComponent(failedIseReqLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(failedIseReqValLabel))
                                        .addGroup(statisticsPanelLayout.createSequentialGroup()
                                                .addComponent(failedGatewayTimoutReqLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(failedGatewayTimoutReqValLabel)))
                                        .addGap(18, 18, Short.MAX_VALUE))
                                .addGroup(statisticsPanelLayout.createSequentialGroup().addComponent(failReqLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(failReqValLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162,
                                                Short.MAX_VALUE)
                                        .addComponent(successReqLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(successReqValLabel).addGap(59, 59, 59))))
                .addGroup(statisticsPanelLayout.createSequentialGroup().addGap(260, 260, 260)
                        .addComponent(statisticsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        statisticsPanelLayout.setVerticalGroup(statisticsPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(statisticsPanelLayout.createSequentialGroup()
                        .addComponent(statisticsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(statisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(failReqLabel).addComponent(failReqValLabel).addComponent(successReqLabel)
                                .addComponent(successReqValLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(statisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(failedIseReqLabel).addComponent(failedIseReqValLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(statisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(failedGatewayTimoutReqLabel).addComponent(failedGatewayTimoutReqValLabel))
                        .addGap(0, 18, Short.MAX_VALUE)));

        tableTitleLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tableTitleLabel.setText("Performance Test Results");

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(contentPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contentPanelLayout.createSequentialGroup().addContainerGap()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(statisticsPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tableScrollPane))
                        .addContainerGap())
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        contentPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tableTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 208,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(229, 229, 229)));
        contentPanelLayout
                .setVerticalGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(contentPanelLayout.createSequentialGroup().addGap(5, 5, 5)
                                .addComponent(tableTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 451,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18).addComponent(statisticsPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addContainerGap().addComponent(contentPanel,
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
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel failReqLabel;
    private javax.swing.JLabel failReqValLabel;
    private javax.swing.JLabel failedGatewayTimoutReqLabel;
    private javax.swing.JLabel failedGatewayTimoutReqValLabel;
    private javax.swing.JLabel failedIseReqLabel;
    private javax.swing.JLabel failedIseReqValLabel;
    private javax.swing.JLabel statisticsLabel;
    private javax.swing.JPanel statisticsPanel;
    private javax.swing.JLabel successReqLabel;
    private javax.swing.JLabel successReqValLabel;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JLabel tableTitleLabel;
    private javax.swing.JPopupMenu cellPopUpMenu;
    private DefaultTableModel model;
    private javax.swing.JDialog cellDialog;

    private String apiName;

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    // End of variables declaration

}
