/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;

import org.apache.commons.lang.math.NumberUtils;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.traveltripper.perfMonitoringApp.db.DbProperty;
import com.traveltripper.perfMonitoringApp.db.GetPropertyFactory;

import temp.HashMapToJsons;
import temp.JsonOperations;

/**
 *
 * @author TT124
 */
public class PostScreen_Jeevan extends javax.swing.JFrame {

	/**
	 * Creates new form PostScreen
	 */

	// String path = System.getProperty("user.dir");

	Properties prop = new Properties();
	ArrayList<ArrayList<String>> dlist = new ArrayList<ArrayList<String>>();
	int limit = 20;

	public PostScreen_Jeevan() {
		initComponents();
		setIcon();
		setVisible(true);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */

	public void setIcon() {
		Image image = new ImageIcon(this.getClass().getClassLoader().getResource("images/TraveltripperICon.png"))
				.getImage();

		setIconImage(image);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		inputPanel = new javax.swing.JPanel();
		bodyTaJScrollPane = new javax.swing.JScrollPane();
		bodyTa = new javax.swing.JTextArea();
		bindingTaJScrollPane = new javax.swing.JScrollPane();
		bindingTa = new javax.swing.JTextArea();
		bodyLabel = new javax.swing.JLabel();
		bindingLabel = new javax.swing.JLabel();
		buttonPanel = new javax.swing.JPanel();
		submitBt = new javax.swing.JButton();
		resetBt = new javax.swing.JButton();
		closeBt = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Performance Monitoring Tool - travel tripper");
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setName("postScreenJFrame"); // NOI18N
		setResizable(false);

		bodyTa.setColumns(20);
		bodyTa.setRows(5);
		bodyTaJScrollPane.setViewportView(bodyTa);

		bindingTa.setColumns(20);
		bindingTa.setRows(5);
		bindingTaJScrollPane.setViewportView(bindingTa);

		bodyLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		bodyLabel.setText("Body");

		bindingLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		bindingLabel.setText("Binding");

		javax.swing.GroupLayout inputPanelLayout = new javax.swing.GroupLayout(inputPanel);
		inputPanel.setLayout(inputPanelLayout);
		inputPanelLayout.setHorizontalGroup(inputPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(inputPanelLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(inputPanelLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(bindingLabel)
						.addComponent(bodyLabel)
						.addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(bindingTaJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 606,
										Short.MAX_VALUE)
								.addComponent(bodyTaJScrollPane)))
						.addContainerGap(17, Short.MAX_VALUE)));
		inputPanelLayout
				.setVerticalGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(inputPanelLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(bodyLabel)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(bodyTaJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 212,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(bindingLabel)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(bindingTaJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 156,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));

		submitBt.setText("Submit");
		submitBt.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					submitBtActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		resetBt.setText("Reset");
		resetBt.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				resetBtActionPerformed(evt);
			}
		});

		closeBt.setText("Close");
		closeBt.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				closeBtActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
		buttonPanel.setLayout(buttonPanelLayout);
		buttonPanelLayout.setHorizontalGroup(buttonPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(buttonPanelLayout.createSequentialGroup().addGap(41, 41, 41).addComponent(submitBt)
						.addGap(187, 187, 187).addComponent(resetBt)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
						.addComponent(closeBt).addGap(34, 34, 34)));
		buttonPanelLayout.setVerticalGroup(buttonPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(submitBt).addComponent(resetBt).addComponent(closeBt))
						.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(inputPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(inputPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>

	private void closeBtActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		System.exit(0);
	}

	private void resetBtActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		bodyTa.setText("");
		bindingTa.setText("");
	}

	private void submitBtActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
		// TODO add your handling code here:
		/*
		 * System.out.println("Submit Button Clicked!"); // storing .json input to
		 * String body String body = bodyTa.getText();
		 * 
		 * // converting String body to .json File File jsonFile = strToJsonFile(body);
		 * 
		 * // Storing binding parameter to String binding. String binding =
		 * bindingTa.getText();
		 * 
		 * Map<String, List<String>> keyValueMap = new LinkedHashMap<String,
		 * List<String>>(); keyValueMap = generateKeyValueMap(binding, keyValueMap);
		 * 
		 * List<ArrayList<String>> keyList = new ArrayList<ArrayList<String>>(); keyList
		 * = generateKeyList(keyValueMap.get("key"));
		 * 
		 * List<ArrayList<String>> valueList = new ArrayList<ArrayList<String>>();
		 * valueList = differentiate(keyValueMap);
		 * 
		 * HashMap<String, Object> jsonMap = jsonToHashMap();
		 * System.out.println("jsonMap::" + jsonMap); System.out.println("keyList::" +
		 * keyList); System.out.println("valueList::" + valueList);
		 * 
		 * hashMapToJsons(jsonMap, keyList, valueList); // calling Jmeter
		 */

		System.out.println("Submit Button Clicked!");
		// storing .json input to String body
		String body = bodyTa.getText();

		// converting String body to .json File
		File jsonFile = strToJsonFile(body);

		// Storing binding parameter to String binding.
		String binding = bindingTa.getText();

		Map<String, List<String>> keyValueMap = new LinkedHashMap<String, List<String>>();
		keyValueMap = generateKeyValueMap(binding, keyValueMap);

		List<ArrayList<String>> keyList = new ArrayList<ArrayList<String>>();
		keyList = generateKeyList(keyValueMap.get("key"));

		List<ArrayList<String>> valueList = new ArrayList<ArrayList<String>>();
		valueList = differentiate(keyValueMap);

		
		//HashMap<String, Object> jsonMap = jsonToHashMap();
		System.out.println("calling jsonToHashMap method");
		JsonOperations jsonToObj = new JsonOperations();
		Object object = jsonToObj.jsonToHashMap();
		System.out.println("In PostScreen Class :: json Object = " + object);

		System.out.println("calling HashMapToJsons");
		Integer noOfJsons = 20;
		JsonOperations hashMapObj = new JsonOperations();
		hashMapObj.hashMapToJsons(object, keyList, valueList , noOfJsons);
		System.out.println("N no of Jsons are created!!");
		 

		/*
		 * JMeterFromScratch jm = new JMeterFromScratch();
		 * 
		 * jm.setApiName(apiName); jm.setDelayTime(delayTime); jm.setDomain(domain);
		 * jm.setPath(path); jm.setDurationTime(durationTime);
		 * jm.setEnvironment(environment); jm.setMethod(method);
		 * jm.setProtocol(protocol); jm.setRampUpTime(rampUpTime);
		 * jm.setThreadGroupVal(threadGroupVal); jm.setReqHeadMap(reqHeadMap);
		 * 
		 * jm.run();
		 */
	}

	public List<ArrayList<String>> differentiate(Map<String, List<String>> keyValueMap) {
		List<String> value = keyValueMap.get("value");
		List<String> key = keyValueMap.get("key");
		List<String> arrList = new ArrayList<String>();
		List<String> depList = new ArrayList<String>();
		Map<String, List<String>> keyList = new LinkedHashMap<String, List<String>>();
		int index, num, count;
		String[] split;
		String s;

		System.out.println("in differentiate");
		System.out.println("value:::" + value);
		System.out.println("Key::" + key);
		List<String> list;
		List<String> list1;
		Iterator itr, itr1;

		itr = value.iterator();
		while (itr.hasNext()) {
			// Object object = (Object) itr.next();
			list = new ArrayList<String>();
			s = (String) itr.next();
			System.out.println("s:::" + s);
			if (s.toUpperCase().startsWith("SELECT")) {// or SELECT
				System.out.println("In Select");
				list = queryValuesFromDb(s);

				index = value.indexOf(s);
				keyList.put(keyValueMap.get("key").get(index), list);

				dlist.add((ArrayList<String>) list);

			} else if (s.contains(",")) {
				System.out.println("In (s.contains(,)");
				list = commaSep(s);

				index = value.indexOf(s);
				keyList.put(keyValueMap.get("key").get(index), list);

				dlist.add((ArrayList<String>) list);

			} else if (s.contains("-")) {
				System.out.println("In Dates '-' :");
				split = s.split("\\-");
				num = Integer.valueOf(split[1]);
				List<String> keys = keyValueMap.get("key");

				if (split.length == 3) {
					arrList = generateArrDates(s);

					index = value.indexOf(s);
					keyList.put(keyValueMap.get("key").get(index), arrList);
					dlist.add((ArrayList<String>) arrList);
				} else {

					list1 = keyList.get(split[0]);
					itr1 = list1.iterator();
					while (itr1.hasNext()) {
						int val = Integer.valueOf((String) itr1.next());
						list.add(String.valueOf((val - num)));
					}

					index = value.indexOf(s);
					keyList.put(keys.get(index), list);

					dlist.add((ArrayList<String>) list);
				}
			} else if (s.contains("+")) {

				System.out.println("--->Plus Value");
				split = s.split("\\+");
				num = Integer.valueOf(split[1]);
				List<String> keys = keyValueMap.get("key");
				index = keys.indexOf(split[0]);
				String subVal = value.get(index);
				String[] split1 = subVal.split("\\-");

				if (subVal.contains("-") && split1.length == 3) {

					if (split1.length == 3) {
						System.out.println(" value "+split[0]);
						arrList = keyList.get(split[0]);
						System.out.println("arrival List sending to genarateDep list : "+arrList);
						depList = generateDepDates(arrList, num);

						index = value.indexOf(s);
						keyList.put(keys.get(index), depList);

						dlist.add((ArrayList<String>) depList);
					}
				} else {

					split = s.split("\\+");
					list1 = keyList.get(split[0]);
					itr1 = list1.iterator();
					while (itr1.hasNext()) {
						int val = Integer.valueOf((String) itr1.next());
						list.add(String.valueOf((val + num)));
					}

					index = value.indexOf(s);
					keyList.put(keys.get(index), list);
					dlist.add((ArrayList<String>) list);

				}
			} else if (NumberUtils.isNumber(s)) {// it only works for numbers, if you want this code to work for strings
													// then remove the if condition
				list.add(s);

				list = generateStringsByLimit(list, limit, list.size());

				index = value.indexOf(s);
				keyList.put(keyValueMap.get("key").get(index), list);

				dlist.add((ArrayList<String>) list);
			}
			System.out.println("keyList::");
			
			for (List<String> tempList : keyList.values()) {
				System.out.println(tempList);
			}
			
		
			
		}
		System.out.println("Value List");
		for (ArrayList<String> tmpList : dlist) {
			System.out.println(tmpList);
			
		}
		return dlist;
	}

	private List<String> generateArrDates(String date) {
		// TODO Auto-generated method stub

		List<String> arraivalList = new ArrayList<String>();

		Random rand = new Random();
		Date arrivalDate;
		try {
			arrivalDate = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(date);
			LocalDate dateformate = arrivalDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			for (int i = 0; i < limit; i++) {

				LocalDate arrivalDate1 = dateformate.plusDays(rand.nextInt(90));
				DateTimeFormatter formatters = DateTimeFormatter.ofPattern("uuuu-MM-dd");
				String text = arrivalDate1.format(formatters);

				arraivalList.add(text);

			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("arrivalList is null"+arraivalList);
		return arraivalList;
	}

	public List<String> generateDepDates(List<String> arrList, int num) {
		List<String> departureList = new ArrayList<String>();
		System.out.println("In generateDepDates");

		for (int i = 0; i < arrList.size(); i++) {
			String arrstr = arrList.get(i);
			Date departureDate;
			try {
				departureDate = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(arrstr);
				LocalDate dateform = departureDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

				LocalDate departureDate1 = dateform.plusDays(num);

				DateTimeFormatter formatters = DateTimeFormatter.ofPattern("uuuu-MM-dd");
				String text = departureDate1.format(formatters);

				departureList.add(text);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return departureList;

	}

	public ArrayList<String> queryValuesFromDb(String query) {

		/*
		 * Iterator<String> itr = query.iterator(); while (itr.hasNext()) { String sql =
		 * (String) itr.next();
		 */
		ArrayList<String> list = new ArrayList<String>();
		GetPropertyFactory propFactory = new GetPropertyFactory();
		DbProperty prop = propFactory.getProperty("Dev");
		Connection con = prop.getConnection();
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int count = 0;
			while (rs.next()) {
				String str = rs.getString(1);
				list.add(str);
				count++;
			}
			list = (ArrayList<String>) generateStringsByLimit(list, limit, count);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	private List<String> generateStringsByLimit(List<String> list, int limit, int count) {
		// TODO Auto-generated method stub

		Random rand = new Random();
		int i = count;
		while (limit > i) {
			list.add(list.get(rand.nextInt(count)));
			i++;
		}
		while (list.size() != limit) {
			list.remove(0);
		}
		return list;
	}

	public void hashMapToJsons(Map<String, Object> myMap, java.util.List<ArrayList<String>> keyList,
			List<ArrayList<String>> valueList) throws JsonGenerationException, JsonMappingException, IOException {

		String userDir = System.getProperty("user.dir");
		File outputDir = new File("results");
		outputDir.mkdir();

		ObjectMapper mapper = new ObjectMapper();

		java.util.List<HashMap<String, Object>> mapList = new ArrayList<HashMap<String, Object>>();
		mapList.add((HashMap<String, Object>) myMap);

		HashMap<String, Object> test = new HashMap<String, Object>();

		java.util.List<String> keys = new ArrayList<String>();
		List<String> values = new ArrayList<String>();

		Integer i = 0;
		while (i < 20) {
			Integer k = 0;
			while (k < keyList.size()) {
				keys = keyList.get(k);
				values = valueList.get(k);
				Integer j = 0;
				mapList.clear();
				mapList.add((HashMap<String, Object>) myMap);
				while (j < keys.size() - 1) {
					test = new HashMap<String, Object>();
					test = mapList.get(j);
					test = (HashMap<String, Object>) test.get(keys.get(j));
					mapList.add(test);
					j++;
				}
				mapList.get(j).put(keys.get(j), values.get(i));
				k++;
			}
			i++;
			mapper.writeValue(
					new File(userDir + File.separator + outputDir + File.separator + "output" + (i + 1) + ".txt"),
					myMap);
		}
		System.out.println(".json files created , check your results folder in your current working directory.");
	}

	public HashMap<String, Object> jsonToHashMap() {

		String userDir = System.getProperty("user.dir");
		File outputDir = new File("results");
		outputDir.mkdir();

		ObjectMapper mapper = new ObjectMapper();
		try {
			Map<String, Object> myMap = mapper.readValue(
					new File(userDir + File.separator + outputDir + File.separator + "input.json"),
					new TypeReference<Map<String, Object>>() {
					});
			System.out.println("jsonMap = " + myMap);
			System.out.println("input.json is converted to HashMap.");
			return (HashMap<String, Object>) myMap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	private Map<String, List<String>> generateKeyValueMap(String binding, Map<String, List<String>> keyValueMap) {
		// TODO Auto-generated method stub

		String[] bindingSplit = binding.split("\n");
		int i = 0;
		List<String> keyList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		while (i < bindingSplit.length) {
			String[] split = bindingSplit[i].split("=");
			keyList.add(split[0]);
			valueList.add(split[1]);
			i++;
		}

		keyValueMap.put("key", keyList);
		keyValueMap.put("value", valueList);
		System.out.println("keyAndValueMap = " + keyValueMap);
		return keyValueMap;
	}

	public ArrayList<String> commaSep(String commSep) {

		String[] inputList = commSep.split("\\s*,\\s*");
		ArrayList<String> list = new ArrayList<String>();
		int i = 0;
		while (i < inputList.length) {
			list.add(inputList[i]);
			i++;
		}
		i = 0;

		list = (ArrayList<String>) generateStringsByLimit(list, limit, list.size());

		return list;

	}

	public List<ArrayList<String>> generateKeyList(List<String> keyList) {
		List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		int i = 0;
		while (i < keyList.size()) {
			List<String> keys = new ArrayList<String>();
			String[] keysSplit = (keyList.get(i)).split("\\.");
			int j = 0;
			while (j < keysSplit.length) {
				keys.add(keysSplit[j]);
				j++;
			}
			list.add((ArrayList<String>) keys);
			i++;
		}
		
		System.out.println("keyList = "+list);
		
		return list;
	}

	public File strToJsonFile(String body) throws IOException {

		String userDir = System.getProperty("user.dir");
		File outputDir = new File("results");
		outputDir.mkdir();
		FileWriter writer = new FileWriter(
				new File(userDir + File.separator + outputDir + File.separator + "input.json"));
		BufferedWriter buffer = new BufferedWriter(writer);
		buffer.write(body);
		buffer.close();
		System.out.println("input.json created , check results folder in your current working directory.");
		return new File(userDir + File.separator + outputDir + File.separator + "input.json");

	}

	public File strToPropertyFile(String binding) throws FileNotFoundException {
		try (PrintStream out = new PrintStream(new FileOutputStream("binding.properties"))) {
			System.out.println("saved in property file");
			out.print(binding);
		}
		return new File("binding.properties");
	}

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
			java.util.logging.Logger.getLogger(PostScreen_Jeevan.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(PostScreen_Jeevan.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(PostScreen_Jeevan.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(PostScreen_Jeevan.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PostScreen_Jeevan().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JLabel bindingLabel;
	private javax.swing.JTextArea bindingTa;
	private javax.swing.JScrollPane bindingTaJScrollPane;
	private javax.swing.JLabel bodyLabel;
	private javax.swing.JTextArea bodyTa;
	private javax.swing.JScrollPane bodyTaJScrollPane;
	private javax.swing.JPanel buttonPanel;
	private javax.swing.JButton closeBt;
	private javax.swing.JPanel inputPanel;
	private javax.swing.JButton resetBt;
	private javax.swing.JButton submitBt;

	// variables from 1st Screen
	private static String apiName;
	private static String environment;
	private static String protocol;
	private static String method;
	private static String domain;
	private static String path;
	private static int threadGroupVal;
	private static int durationTime;
	private static int rampUpTime;
	private static int delayTime;

	// Request Headers
	Map<String, String> reqHeadMap = new LinkedHashMap<String, String>();

	public Map<String, String> getReqHeadMap() {
		return reqHeadMap;
	}

	public void setReqHeadMap(Map<String, String> reqHeadMap) {
		this.reqHeadMap = reqHeadMap;
	}

	public static String getApiName() {
		return apiName;
	}

	public static void setApiName(String apiName) {
		PostScreen_Jeevan.apiName = apiName;
	}

	public static String getEnvironment() {
		return environment;
	}

	public static void setEnvironment(String environment) {
		PostScreen_Jeevan.environment = environment;
	}

	public static String getProtocol() {
		return protocol;
	}

	public static void setProtocol(String protocol) {
		PostScreen_Jeevan.protocol = protocol;
	}

	public static String getMethod() {
		return method;
	}

	public static void setMethod(String method) {
		PostScreen_Jeevan.method = method;
	}

	public static String getDomain() {
		return domain;
	}

	public static void setDomain(String domain) {
		PostScreen_Jeevan.domain = domain;
	}

	public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		PostScreen_Jeevan.path = path;
	}

	public static int getThreadGroupVal() {
		return threadGroupVal;
	}

	public static void setThreadGroupVal(int threadGroupVal) {
		PostScreen_Jeevan.threadGroupVal = threadGroupVal;
	}

	public static int getDurationTime() {
		return durationTime;
	}

	public static void setDurationTime(int durationTime) {
		PostScreen_Jeevan.durationTime = durationTime;
	}

	public static int getRampUpTime() {
		return rampUpTime;
	}

	public static void setRampUpTime(int rampUpTime) {
		PostScreen_Jeevan.rampUpTime = rampUpTime;
	}

	public static int getDelayTime() {
		return delayTime;
	}

	public static void setDelayTime(int delayTime) {
		PostScreen_Jeevan.delayTime = delayTime;
	}

	// End of variables declaration
}
//changes need to do in this