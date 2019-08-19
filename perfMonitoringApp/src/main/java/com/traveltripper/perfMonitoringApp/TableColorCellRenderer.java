package com.traveltripper.perfMonitoringApp;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import java.awt.*;

public class TableColorCellRenderer implements TableCellRenderer {

	private int latencyRow;

	public void setLatencyRow(int latencyRow) {
		this.latencyRow = latencyRow;
	}

	public static final TableCellRenderer renderer = new DefaultTableCellRenderer();

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		// System.out.println("in tableColorCellRenderer");

		// TODO Auto-generated method stub
		Component c = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		if (table.getValueAt(row, 4).toString().equalsIgnoreCase("GATEWAY_TIMEOUT")) {

			Color color = Color.RED;

			// c.setForeground(color);
			c.setBackground(color);

		} else if (row == latencyRow) {

			c.setBackground(Color.BLUE);
			// c.setForeground(table.getForeground());

		}

		else {
			c.setBackground(table.getBackground());
			c.setForeground(table.getForeground());
		}

		return c;
	}
}
