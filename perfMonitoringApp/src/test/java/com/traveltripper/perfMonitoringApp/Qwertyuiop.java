/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.traveltripper.perfMonitoringApp;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
 

/**
 * 
 *
 * @author TT123
 */
public class Qwertyuiop extends javax.swing.JFrame {

    /**
     * Creates new form First_Ui
     */
    public Qwertyuiop() {
        initComponents();
         delayLabel.setFocusable(true);
         setIcon();
    }

    public void setIcon()
    {
    	Image image = new ImageIcon(this.getClass().getClassLoader().getResource("images/TraveltripperICon.png"))
				.getImage();
		setIconImage(image);
	}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        ContentPanel = new javax.swing.JPanel();
        delayLabel = new javax.swing.JPanel();
        apiNameLabel = new javax.swing.JLabel();
        methodLabel = new javax.swing.JLabel();
        domainLabel = new javax.swing.JLabel();
        threadGroupLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        rampUpTimeLabel = new javax.swing.JLabel();
        apiNameTf = new javax.swing.JTextField();
        domainTf = new javax.swing.JTextField();
        threadGroupTf = new javax.swing.JTextField();
        timeTf = new javax.swing.JTextField();
        rampUpTimeTf = new javax.swing.JTextField();
        methodTf = new javax.swing.JComboBox<>();
        rampUpTimeLabel1 = new javax.swing.JLabel();
        delayTf = new javax.swing.JTextField();
        pathLabel = new javax.swing.JLabel();
        pathTf = new javax.swing.JTextField();
        environmentLabel = new javax.swing.JLabel();
        environmentTf = new javax.swing.JComboBox<>();
        ProtocolLabel = new javax.swing.JLabel();
        protocolTf = new javax.swing.JComboBox<>();
        buttonPanel = new javax.swing.JPanel();
        submitButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        submitButton1 = new javax.swing.JButton();
        ImagePanel = new javax.swing.JPanel();
        ImageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Performance Monitoring Report Travel Tripper");
        setResizable(false);

        apiNameLabel.setText("API Name");

        methodLabel.setText("Method");

        domainLabel.setText("Domain");

        threadGroupLabel.setText("Thread Group");

        timeLabel.setText("Time");

        rampUpTimeLabel.setText("Ramp Up");

        apiNameTf.setText("Api Name");
        apiNameTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                apiNameTfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                apiNameTfFocusLost(evt);
            }
        });
        apiNameTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apiNameTfActionPerformed(evt);
            }
        });

        domainTf.setText("Domain");
        domainTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                domainTfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                domainTfFocusLost(evt);
            }
        });
        domainTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                domainTfActionPerformed(evt);
            }
        });

        threadGroupTf.setText("Thread Group");
        threadGroupTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                threadGroupTfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                threadGroupTfFocusLost(evt);
            }
        });
        threadGroupTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threadGroupTfActionPerformed(evt);
            }
        });

        timeTf.setText("Time In Seconds");
        timeTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                timeTfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                timeTfFocusLost(evt);
            }
        });
        timeTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeTfActionPerformed(evt);
            }
        });

        rampUpTimeTf.setText("Ramp Up In Seconds ");
        rampUpTimeTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rampUpTimeTfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rampUpTimeTfFocusLost(evt);
            }
        });
        rampUpTimeTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rampUpTimeTfActionPerformed(evt);
            }
        });

        methodTf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Get", "Post", "Put", "Delete", "Patch", "Options" }));
        methodTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                methodTfActionPerformed(evt);
            }
        });

        rampUpTimeLabel1.setText("Delay");

        delayTf.setText("Delay In Seconds");
        delayTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                delayTfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                delayTfFocusLost(evt);
            }
        });
        delayTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delayTfActionPerformed(evt);
            }
        });

        pathLabel.setText("Path");

        pathTf.setText("Path");
        pathTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pathTfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pathTfFocusLost(evt);
            }
        });
        pathTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathTfActionPerformed(evt);
            }
        });

        environmentLabel.setText("Environment");

        environmentTf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dev", "TT-QA", "PREF" }));
        environmentTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                environmentTfActionPerformed(evt);
            }
        });

        ProtocolLabel.setText("Protocol");

        protocolTf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "http", "https" }));

        javax.swing.GroupLayout delayLabelLayout = new javax.swing.GroupLayout(delayLabel);
        delayLabel.setLayout(delayLabelLayout);
        delayLabelLayout.setHorizontalGroup(
            delayLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(delayLabelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(delayLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(delayLabelLayout.createSequentialGroup()
                        .addComponent(ProtocolLabel)
                        .addGap(68, 68, 68)
                        .addComponent(protocolTf, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(delayLabelLayout.createSequentialGroup()
                        .addGroup(delayLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(delayLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(apiNameLabel)
                                .addComponent(threadGroupLabel)
                                .addComponent(timeLabel)
                                .addComponent(rampUpTimeLabel)
                                .addComponent(rampUpTimeLabel1)
                                .addComponent(domainLabel)
                                .addComponent(pathLabel))
                            .addComponent(environmentLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(delayLabelLayout.createSequentialGroup()
                                .addComponent(methodLabel)
                                .addGap(31, 31, 31)))
                        .addGroup(delayLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(delayLabelLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(delayLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rampUpTimeTf, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                    .addComponent(apiNameTf)
                                    .addComponent(threadGroupTf)
                                    .addComponent(timeTf)))
                            .addComponent(pathTf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(domainTf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(methodTf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(environmentTf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delayTf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        delayLabelLayout.setVerticalGroup(
            delayLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(delayLabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(delayLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apiNameLabel)
                    .addComponent(apiNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(delayLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(environmentTf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(environmentLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(delayLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(protocolTf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProtocolLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(delayLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(methodTf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(methodLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(delayLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(domainTf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(domainLabel))
                .addGap(11, 11, 11)
                .addGroup(delayLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathTf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pathLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(delayLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(threadGroupTf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threadGroupLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(delayLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeTf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(delayLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rampUpTimeTf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rampUpTimeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(delayLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delayTf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rampUpTimeLabel1))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        submitButton.setText("SUBMIT");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        resetButton.setText("RESET");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        closeButton.setText("CLOSE");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        submitButton1.setText("Add Request Header");
        submitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submitButton1)
                .addGap(27, 27, 27)
                .addComponent(submitButton)
                .addGap(18, 18, 18)
                .addComponent(resetButton)
                .addGap(18, 18, 18)
                .addComponent(closeButton)
                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(resetButton)
                    .addComponent(closeButton)
                    .addComponent(submitButton1))
                .addGap(25, 25, 25))
        );

        ImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("images/perfIcon.jpg"))); // NOI18N

        javax.swing.GroupLayout ImagePanelLayout = new javax.swing.GroupLayout(ImagePanel);
        ImagePanel.setLayout(ImagePanelLayout);
        ImagePanelLayout.setHorizontalGroup(
            ImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImagePanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(ImageLabel)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        ImagePanelLayout.setVerticalGroup(
            ImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ImagePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ImageLabel)
                .addGap(70, 70, 70))
        );

        javax.swing.GroupLayout ContentPanelLayout = new javax.swing.GroupLayout(ContentPanel);
        ContentPanel.setLayout(ContentPanelLayout);
        ContentPanelLayout.setHorizontalGroup(
            ContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContentPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(ImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(delayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContentPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        ContentPanelLayout.setVerticalGroup(
            ContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void domainTfActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void timeTfActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        System.exit(0);
    }                                           

    private void apiNameTfFocusGained(java.awt.event.FocusEvent evt) {                                      
        // TODO add your handling code here:
         if(apiNameTf.getText().trim().equals("Api Name")){
           apiNameTf.setText("");
       }
    }                                     

    private void apiNameTfFocusLost(java.awt.event.FocusEvent evt) {                                    
        // TODO add your handling code here:
        if(apiNameTf.getText().trim().equals("")){
           apiNameTf.setText("Api Name");
        }
    }                                   

    private void domainTfFocusGained(java.awt.event.FocusEvent evt) {                                     
        // TODO add your handling code here:
         if(domainTf.getText().trim().equals("Domain")){
           domainTf.setText("");
       }
    }                                    

    private void domainTfFocusLost(java.awt.event.FocusEvent evt) {                                   
        // TODO add your handling code here:
        if(domainTf.getText().trim().equals("")){
           domainTf.setText("Domain");
        }
    }                                  

    private void threadGroupTfFocusGained(java.awt.event.FocusEvent evt) {                                          
        // TODO add your handling code here:
         if(threadGroupTf.getText().trim().equals("Thread Group")){
           threadGroupTf.setText("");
       }
    }                                         

    private void threadGroupTfFocusLost(java.awt.event.FocusEvent evt) {                                        
        // TODO add your handling code here:
         if(threadGroupTf.getText().trim().equals("")){
           threadGroupTf.setText("Thread Group");
        }
    }                                       

    private void timeTfFocusGained(java.awt.event.FocusEvent evt) {                                   
         // TODO add your handling code here:
         if(timeTf.getText().trim().equals("Time In Seconds")){
           timeTf.setText("");
       }
    }                                  

    private void timeTfFocusLost(java.awt.event.FocusEvent evt) {                                 
        // TODO add your handling code here:
         if(timeTf.getText().trim().equals("")){
           timeTf.setText("Time In Seconds");
        }
    }                                

    private void rampUpTimeTfFocusGained(java.awt.event.FocusEvent evt) {                                         
        // TODO add your handling code here:
         if(rampUpTimeTf.getText().trim().equals("Ramp Up In Seconds")){
           rampUpTimeTf.setText("");
       }
    }                                        

    private void rampUpTimeTfFocusLost(java.awt.event.FocusEvent evt) {                                       
        // TODO add your handling code here:
         if(rampUpTimeTf.getText().trim().equals("")){
           rampUpTimeTf.setText("Ramp Up In Seconds");
        }
    }                                      

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        apiNameTf.setText("Api Name");
        domainTf.setText("Domain");
        threadGroupTf.setText("Thread Group");
        timeTf.setText("Time");
        rampUpTimeTf.setText("Ramp Up");
        
        
    }                                           

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        
        
                     System.out.println(apiNameTf.getText());
                    System.out.println(protocolTf.getSelectedItem());
                    System.out.println(methodTf.getSelectedItem());
                    System.out.println(domainTf.getText());
        
                      
                 
                        
                         if(methodTf.getSelectedItem().equals("Post"))
                       {
                            setVisible(false);   
                           // PostActionPanel p=new PostActionPanel();
                            // p.setVisible(true);
                        
                       }
                         else 
                         {
                             setVisible(false);  
                             GetActionJFrame g=new GetActionJFrame();
                             g.setVisible(true);
                                 
                         }
                        // Always close files.
          
        
      //  System.exit(0);
      
        
    }                                            

    private void apiNameTfActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void environmentTfActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void threadGroupTfActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void delayTfFocusGained(java.awt.event.FocusEvent evt) {                                    
        // TODO add your handling code here:
         if(delayTf.getText().trim().equals("Delay In Seconds")){
           delayTf.setText("");
       }
        
    }                                   

    private void delayTfFocusLost(java.awt.event.FocusEvent evt) {                                  
        // TODO add your handling code here:
        
          if(delayTf.getText().trim().equals("")){
           delayTf.setText("Delay In Seconds");
        }
        
    }                                 

    private void submitButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void delayTfActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void rampUpTimeTfActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void pathTfFocusGained(java.awt.event.FocusEvent evt) {                                   
        // TODO add your handling code here:
    }                                  

    private void pathTfFocusLost(java.awt.event.FocusEvent evt) {                                 
        // TODO add your handling code here:
    }                                

    private void pathTfActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void methodTfActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Qwertyuiop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Qwertyuiop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Qwertyuiop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Qwertyuiop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Qwertyuiop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JLabel ImageLabel;
    private javax.swing.JPanel ImagePanel;
    private javax.swing.JLabel ProtocolLabel;
    private javax.swing.JLabel apiNameLabel;
    private javax.swing.JTextField apiNameTf;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel delayLabel;
    private javax.swing.JTextField delayTf;
    private javax.swing.JLabel domainLabel;
    private javax.swing.JTextField domainTf;
    private javax.swing.JLabel environmentLabel;
    private javax.swing.JComboBox<String> environmentTf;
    private javax.swing.JLabel methodLabel;
    private javax.swing.JComboBox<String> methodTf;
    private javax.swing.JLabel pathLabel;
    private javax.swing.JTextField pathTf;
    private javax.swing.JComboBox<String> protocolTf;
    private javax.swing.JLabel rampUpTimeLabel;
    private javax.swing.JLabel rampUpTimeLabel1;
    private javax.swing.JTextField rampUpTimeTf;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JButton submitButton1;
    private javax.swing.JLabel threadGroupLabel;
    private javax.swing.JTextField threadGroupTf;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JTextField timeTf;
    // End of variables declaration                   

    
}
