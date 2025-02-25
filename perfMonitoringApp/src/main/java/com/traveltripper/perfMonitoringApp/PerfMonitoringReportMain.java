/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.traveltripper.perfMonitoringApp;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import javax.swing.ImageIcon;

/**
 * 
 *
 * @author TT123
 */
public class PerfMonitoringReportMain extends javax.swing.JFrame {

	public PerfMonitoringReportMain() {
		initComponents();
		inputPanel.setFocusable(true);
		setIcon();
	}

	public void setIcon() {
		Image image = new ImageIcon(this.getClass().getClassLoader().getResource("images/TraveltripperICon.png"))
				.getImage();
		setIconImage(image);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">

	private void initComponents() {

		io = this.getClass().getClassLoader().getResourceAsStream("Props/Perfmonitoring.properties");
		prop = new Properties();

		try {
			prop.load(io);
		} catch (IOException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

		contentPanel = new javax.swing.JPanel();
		inputPanel = new javax.swing.JPanel();
		imagePanel = new javax.swing.JPanel();
		buttonPanel = new javax.swing.JPanel();

		apiNameLabel = new javax.swing.JLabel();
		protocolLabel = new javax.swing.JLabel();
		methodLabel = new javax.swing.JLabel();
		domainLabel = new javax.swing.JLabel();
		environmentLabel = new javax.swing.JLabel();
		threadGroupLabel = new javax.swing.JLabel();
		timeLabel = new javax.swing.JLabel();
		rampUpTimeLabel = new javax.swing.JLabel();
		delayLabel = new javax.swing.JLabel();
		imageLabel = new javax.swing.JLabel();
		pathLabel = new javax.swing.JLabel();

		apiNameTf = new javax.swing.JTextField();
		domainTf = new javax.swing.JTextField();
		threadGroupTf = new javax.swing.JTextField();
		timeTf = new javax.swing.JTextField();
		rampUpTimeTf = new javax.swing.JTextField();
		delayTf = new javax.swing.JTextField();
		pathTf = new javax.swing.JTextField();

		protocolDd = new javax.swing.JComboBox<>();
		methodDd = new javax.swing.JComboBox<>();
		environmentDd = new javax.swing.JComboBox<>();

		submitButton = new javax.swing.JButton();
		resetButton = new javax.swing.JButton();
		closeButton = new javax.swing.JButton();
		addRequestHeaderButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle(prop.getProperty("title"));
		setResizable(false);

		apiNameLabel.setText(prop.getProperty("apiNameLabel"));

		protocolLabel.setText(prop.getProperty("apiNameLabel"));

		methodLabel.setText(prop.getProperty("methodLabel"));

		domainLabel.setText(prop.getProperty("domainLabel"));

		environmentLabel.setText(prop.getProperty("environmentLabel"));

		threadGroupLabel.setText(prop.getProperty("threadGroupLabel"));

		timeLabel.setText(prop.getProperty("timeLabel"));

		rampUpTimeLabel.setText(prop.getProperty("rampUpTimeLabel"));

		pathLabel.setText(prop.getProperty("pathLabel"));

		delayLabel.setText(prop.getProperty("delayLabel"));

		ListenerForTfAndButton handle = new ListenerForTfAndButton();

		apiNameTf.setText(prop.getProperty("apiNameTf"));
		apiNameTf.addFocusListener(handle);

		domainTf.setText(prop.getProperty("domainTf"));
		domainTf.addFocusListener(handle);

		threadGroupTf.setText(prop.getProperty("threadGroupTf"));
		threadGroupTf.addFocusListener(handle);

		timeTf.setText(prop.getProperty("timeTf"));
		timeTf.addFocusListener(handle);

		rampUpTimeTf.setText(prop.getProperty("rampUpTimeTf"));
		rampUpTimeTf.addFocusListener(handle);

		delayTf.setText(prop.getProperty("delayTf"));
		delayTf.addFocusListener(handle);

		pathTf.setText(prop.getProperty("pathTf"));
		pathTf.addFocusListener(handle);

		String protocolDd1 = prop.getProperty("protocolDd1");
		String protocolDd2 = prop.getProperty("protocolDd2");
		protocolDd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { protocolDd1, protocolDd2 }));
		protocolDd.setActionCommand("protocolDd");
		protocolDd.addActionListener(handle);

		String methodDd1 = prop.getProperty("methodDd1");
		String methodDd2 = prop.getProperty("methodDd2");
		String methodDd3 = prop.getProperty("methodDd3");
		String methodDd4 = prop.getProperty("methodDd4");
		String methodDd5 = prop.getProperty("methodDd5");
		String methodDd6 = prop.getProperty("methodDd6");
		methodDd.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { methodDd1, methodDd2, methodDd3, methodDd4, methodDd5, methodDd6 }));
		methodDd.setActionCommand("methodDd");
		methodDd.addActionListener(handle);

		String environmentDd1 = prop.getProperty("environmentDd1");
		String environmentDd2 = prop.getProperty("environmentDd2");
		String environmentDd3 = prop.getProperty("environmentDd3");
		environmentDd.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { environmentDd1, environmentDd2, environmentDd3 }));
		environmentDd.setActionCommand("environmentDd");
		environmentDd.addActionListener(handle);

		javax.swing.GroupLayout inputPanelLayout = new javax.swing.GroupLayout(inputPanel);
		inputPanel.setLayout(inputPanelLayout);
		inputPanelLayout.setHorizontalGroup(inputPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(inputPanelLayout.createSequentialGroup().addGap(32, 32, 32).addGroup(inputPanelLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(inputPanelLayout.createSequentialGroup().addGroup(inputPanelLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(apiNameLabel).addComponent(threadGroupLabel).addComponent(timeLabel)
								.addComponent(rampUpTimeLabel).addComponent(delayLabel).addComponent(environmentLabel)
								.addComponent(protocolLabel).addComponent(pathLabel))
								.addGroup(inputPanelLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(inputPanelLayout.createSequentialGroup().addGap(41, 41, 41)
												.addGroup(inputPanelLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(rampUpTimeTf).addComponent(apiNameTf)
														.addComponent(threadGroupTf).addComponent(timeTf)
														.addComponent(delayTf)
														.addComponent(environmentDd, 0,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(protocolDd,
																javax.swing.GroupLayout.PREFERRED_SIZE, 148,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												inputPanelLayout.createSequentialGroup()
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(pathTf, javax.swing.GroupLayout.PREFERRED_SIZE,
																148, javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(inputPanelLayout.createSequentialGroup().addComponent(domainLabel)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(domainTf, javax.swing.GroupLayout.PREFERRED_SIZE, 148,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										inputPanelLayout.createSequentialGroup().addComponent(methodLabel)
												.addGap(72, 72, 72).addComponent(methodDd,
														javax.swing.GroupLayout.PREFERRED_SIZE, 148,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(118, Short.MAX_VALUE)));
		inputPanelLayout.setVerticalGroup(inputPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(inputPanelLayout.createSequentialGroup().addContainerGap()
						.addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(apiNameLabel).addComponent(apiNameTf,
										javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(inputPanelLayout.createSequentialGroup().addGap(23, 23, 23)
										.addComponent(environmentLabel))
								.addGroup(inputPanelLayout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(environmentDd, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(13, 13, 13)
						.addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(protocolDd, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(protocolLabel))
						.addGap(15, 15, 15)
						.addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(methodDd, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(methodLabel))
						.addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(inputPanelLayout.createSequentialGroup().addGap(22, 22, 22)
										.addComponent(domainLabel))
								.addGroup(inputPanelLayout.createSequentialGroup().addGap(12, 12, 12).addComponent(
										domainTf, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(pathTf, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(pathLabel))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
						.addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(threadGroupTf, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(threadGroupLabel))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(timeTf, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(timeLabel))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(rampUpTimeTf, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(rampUpTimeLabel))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(delayTf, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(delayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		submitButton.setText(prop.getProperty("submitButton"));
		submitButton.addActionListener(handle);

		resetButton.setText(prop.getProperty("resetButton"));
		resetButton.addActionListener(handle);

		closeButton.setText(prop.getProperty("closeButton"));
		closeButton.addActionListener(handle);

		addRequestHeaderButton.setText(prop.getProperty("addRequestHeaderButton"));
		addRequestHeaderButton.addActionListener(handle);

		javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
		buttonPanel.setLayout(buttonPanelLayout);
		buttonPanelLayout.setHorizontalGroup(buttonPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(buttonPanelLayout.createSequentialGroup().addContainerGap()
						.addComponent(addRequestHeaderButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
						.addComponent(submitButton).addGap(18, 18, 18).addComponent(resetButton).addGap(18, 18, 18)
						.addComponent(closeButton).addContainerGap()));
		buttonPanelLayout.setVerticalGroup(buttonPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(submitButton).addComponent(resetButton).addComponent(closeButton)
								.addComponent(addRequestHeaderButton))
						.addGap(25, 25, 25)));

		imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("images/perfIcon.jpg"))); // NOI18N

		javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
		imagePanel.setLayout(imagePanelLayout);
		imagePanelLayout
				.setHorizontalGroup(imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(imagePanelLayout.createSequentialGroup().addGap(28, 28, 28).addComponent(imageLabel)
								.addContainerGap(30, Short.MAX_VALUE)));
		imagePanelLayout
				.setVerticalGroup(imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								imagePanelLayout.createSequentialGroup()
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(imageLabel).addGap(43, 43, 43)));

		javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
		contentPanel.setLayout(contentPanelLayout);
		contentPanelLayout
				.setHorizontalGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(contentPanelLayout.createSequentialGroup().addGap(14, 14, 14)
								.addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addGroup(contentPanelLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(inputPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap(18, Short.MAX_VALUE)));
		contentPanelLayout.setVerticalGroup(contentPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(contentPanelLayout.createSequentialGroup().addContainerGap().addGroup(contentPanelLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(contentPanelLayout.createSequentialGroup()
								.addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(67, 67, 67))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								contentPanelLayout.createSequentialGroup()
										.addComponent(inputPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
												javax.swing.GroupLayout.PREFERRED_SIZE)))));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap().addComponent(contentPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

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
		if (apiNameTf.getText().trim().equals(prop.getProperty("apiNameTf"))) {
			apiNameTf.setText("");
		}
	}

	private void apiNameTfFocusLost(java.awt.event.FocusEvent evt) {
		// TODO add your handling code here:
		if (apiNameTf.getText().trim().equals("")) {
			apiNameTf.setText(prop.getProperty("apiNameTf"));
		}
	}

	private void domainTfFocusGained(java.awt.event.FocusEvent evt) {
		// TODO add your handling code here:
		if (domainTf.getText().trim().equals(prop.getProperty("domainTf"))) {
			domainTf.setText("");
		}
	}

	private void domainTfFocusLost(java.awt.event.FocusEvent evt) {
		// TODO add your handling code here:
		if (domainTf.getText().trim().equals("")) {
			domainTf.setText(prop.getProperty("domainTf"));
		}
	}

	private void threadGroupTfFocusGained(java.awt.event.FocusEvent evt) {
		// TODO add your handling code here:
		if (threadGroupTf.getText().trim().equals(prop.getProperty("threadGroupTf"))) {
			threadGroupTf.setText("");
		}
	}

	private void threadGroupTfFocusLost(java.awt.event.FocusEvent evt) {
		// TODO add your handling code here:
		if (threadGroupTf.getText().trim().equals("")) {
			threadGroupTf.setText(prop.getProperty("threadGroupTf"));
		}
	}

	private void timeTfFocusGained(java.awt.event.FocusEvent evt) {
		// TODO add your handling code here:
		if (timeTf.getText().trim().equals(prop.getProperty("timeTf"))) {
			timeTf.setText("");
		}
	}

	private void timeTfFocusLost(java.awt.event.FocusEvent evt) {
		// TODO add your handling code here:
		if (timeTf.getText().trim().equals("")) {
			timeTf.setText(prop.getProperty("timeTf"));
		}
	}

	private void rampUpTimeTfFocusGained(java.awt.event.FocusEvent evt) {
		// TODO add your handling code here:
		if (rampUpTimeTf.getText().trim().equals(prop.getProperty("rampUpTimeTf"))) {
			rampUpTimeTf.setText("");
		}
	}

	private void rampUpTimeTfFocusLost(java.awt.event.FocusEvent evt) {
		// TODO add your handling code here:
		if (rampUpTimeTf.getText().trim().equals("")) {
			rampUpTimeTf.setText(prop.getProperty("rampUpTimeTf"));
		}
	}

	private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:

		apiNameTf.setText(prop.getProperty("apiNameTf"));
		domainTf.setText(prop.getProperty("domainTf"));
		threadGroupTf.setText(prop.getProperty("threadGroupTf"));
		timeTf.setText(prop.getProperty("timeTf"));
		rampUpTimeTf.setText(prop.getProperty("rampUpTimeTf"));
		delayTf.setText(prop.getProperty("delayTf"));
		pathTf.setText(prop.getProperty("pathTf"));
		environmentDd.setSelectedItem(prop.getProperty("environmentDd1"));
		protocolDd.setSelectedItem(prop.getProperty("protocolDd1"));
		methodDd.setSelectedItem(prop.getProperty("methodDd1"));

	}

	private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:

		// TODO add your handling code here:
		String apiName = apiNameTf.getText();
		String protocol = protocolDd.getSelectedItem().toString();
		String method = methodDd.getSelectedItem().toString();
		String domain = domainTf.getText();
		String environment = environmentDd.getSelectedItem().toString();
		String path = pathTf.getText();

		int threadGroup = Integer.parseInt(threadGroupTf.getText());
		int time = Integer.parseInt(timeTf.getText());
		int rampUpTime = Integer.parseInt(rampUpTimeTf.getText());
		int delay = Integer.parseInt(delayTf.getText());

		System.out.println(apiName + "::" + protocol + "::" + method + "::" + domain + "::" + environment + "::"
				+ threadGroup + "::" + time + "::" + rampUpTime + "::" + delay);

		switch ((String) methodDd.getSelectedItem()) {
		case "POST":
			setVisible(false);
			break;

		case "GET":
			setVisible(false);
			GetActionJFrame g = new GetActionJFrame();

			g.setApiName(apiName);
			g.setProtocol(protocol);
			g.setMethod(method);
			g.setDomain(domain);
			g.setEnvironment(environment);
			g.setThreadGroupVal(threadGroup);
			g.setDurationTime(time);
			g.setRampUpTime(rampUpTime);
			g.setDelayTime(delay);
			g.setPath(path);
			g.setReqHeadMap(reqHeadMap);

			g.setVisible(true);
			break;

		case "PUT":

			break;

		case "DELETE":

			break;

		case "PATCH":

			break;

		case "OPTIONS":

			break;

		default:
			break;
		}

	}

	private void apiNameTfActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void environmentDdActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void threadGroupTfActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void delayTfFocusGained(java.awt.event.FocusEvent evt) {
		// TODO add your handling code here:
		if (delayTf.getText().trim().equals(prop.getProperty("delayTf"))) {
			delayTf.setText("");
		}

	}

	private void delayTfFocusLost(java.awt.event.FocusEvent evt) {
		// TODO add your handling code here:

		if (delayTf.getText().trim().equals("")) {
			delayTf.setText(prop.getProperty("delayTf"));
		}

	}

	private void addRequestHeaderButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		RequestHeaderJFrame requestHeader = new RequestHeaderJFrame();

		requestHeader.setVisible(true);
		setVisible(false);

		requestHeader.setPerfObj(this);

	}

	private void delayTfActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void methodDdActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void protocolDdActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void pathTfFocusGained(java.awt.event.FocusEvent evt) {
		// TODO add your handling code here:
		if (pathTf.getText().trim().equals(prop.getProperty("pathTf"))) {
			pathTf.setText("");
		}

	}

	private void pathTfFocusLost(java.awt.event.FocusEvent evt) {
		// TODO add your handling code here:
		if (pathTf.getText().trim().equals("")) {
			pathTf.setText(prop.getProperty("pathTf"));
		}
	}

	private void pathTfActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	public static void main(String args[]) {
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
			java.util.logging.Logger.getLogger(PerfMonitoringReportMain.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(PerfMonitoringReportMain.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(PerfMonitoringReportMain.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(PerfMonitoringReportMain.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PerfMonitoringReportMain().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton addRequestHeaderButton;
	private javax.swing.JLabel apiNameLabel;
	private javax.swing.JTextField apiNameTf;
	private javax.swing.JPanel buttonPanel;
	private javax.swing.JButton closeButton;
	private javax.swing.JPanel contentPanel;
	private javax.swing.JLabel delayLabel;
	private javax.swing.JTextField delayTf;
	private javax.swing.JLabel domainLabel;
	private javax.swing.JTextField domainTf;
	private javax.swing.JComboBox<String> environmentDd;
	private javax.swing.JLabel environmentLabel;
	private javax.swing.JLabel imageLabel;
	private javax.swing.JPanel imagePanel;
	private javax.swing.JPanel inputPanel;
	private javax.swing.JComboBox<String> methodDd;
	private javax.swing.JLabel methodLabel;
	private javax.swing.JLabel pathLabel;
	private javax.swing.JTextField pathTf;
	private javax.swing.JComboBox<String> protocolDd;
	private javax.swing.JLabel protocolLabel;
	private javax.swing.JLabel rampUpTimeLabel;
	private javax.swing.JTextField rampUpTimeTf;
	private javax.swing.JButton resetButton;
	private javax.swing.JButton submitButton;
	private javax.swing.JLabel threadGroupLabel;
	private javax.swing.JTextField threadGroupTf;
	private javax.swing.JLabel timeLabel;
	private javax.swing.JTextField timeTf;
	// End of variables declaration

	Map<String, String> reqHeadMap;

	InputStream io;
	Properties prop;

	public void setReqHeadMap(Map<String, String> reqHeadMap) {
		this.reqHeadMap = reqHeadMap;
	}

	private class ListenerForTfAndButton implements ActionListener, FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			/*
			 * System.out.println(rampUpTimeTf); Object obj=e.getSource();
			 * System.out.println("obj.getClass().getName:::::::"+obj.getClass().getName());
			 * System.out.println("rampUpTimeTf.getClass().getName()::::::::"+rampUpTimeTf.
			 * getClass().getName()); //CLAZZ z =
			 * CLAZZ.valueOf(this.getClass().getSimpleName()); Object obj1=rampUpTimeTf;
			 * String str=(String) obj; String str1=(String) obj1;
			 */
			if (e.getSource() == apiNameTf) {
				apiNameTfFocusGained(e);
			} else if (e.getSource() == domainTf) {
				domainTfFocusGained(e);
			} else if (e.getSource() == threadGroupTf) {
				threadGroupTfFocusGained(e);

			} else if (e.getSource() == timeTf) {
				timeTfFocusGained(e);
			} else if (e.getSource() == rampUpTimeTf) {
				rampUpTimeTfFocusGained(e);
			} else if (e.getSource() == delayTf) {
				delayTfFocusGained(e);
			} else if (e.getSource() == pathTf) {
				pathTfFocusGained(e);
			}
		}

		@Override
		public void focusLost(FocusEvent evt) {
			// TODO Auto-generated method stub
			if (evt.getSource() == apiNameTf) {
				apiNameTfFocusLost(evt);
			} else if (evt.getSource() == domainTf) {
				domainTfFocusLost(evt);
			} else if (evt.getSource() == threadGroupTf) {
				threadGroupTfFocusLost(evt);
			} else if (evt.getSource() == timeTf) {
				timeTfFocusLost(evt);
			} else if (evt.getSource() == rampUpTimeTf) {
				rampUpTimeTfFocusLost(evt);
			} else if (evt.getSource() == delayTf) {
				delayTfFocusLost(evt);
			} else if (evt.getSource() == pathTf) {
				pathTfFocusLost(evt);
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switch (e.getActionCommand()) {
			case "Submit":
				submitButtonActionPerformed(e);
				break;

			case "Reset":
				resetButtonActionPerformed(e);
				break;

			case "Close":
				closeButtonActionPerformed(e);
				break;

			case "Add Request Header":
				addRequestHeaderButtonActionPerformed(e);
				break;

			case "protocolDd":
				protocolDdActionPerformed(e);
				break;

			case "methodDd":
				methodDdActionPerformed(e);
				break;

			case "environmentDd":
				environmentDdActionPerformed(e);
				break;

			default:
				break;
			}
		}
	}

}
