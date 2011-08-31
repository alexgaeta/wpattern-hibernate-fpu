package br.com.branquinho.hibernate.application.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import br.com.branquinho.hibernate.utils.database.beans.CategoryBean;

public class CategoryGridPanel extends JPanel {

	private static final long serialVersionUID = -3127985955124406559L;

	private final JTable table;

	private final DefaultTableModel tableModel;

	/**
	 * Create the panel.
	 */
	public CategoryGridPanel() {
		String[] columnNames = new String []{ "ID", "Name", "Description"};

		this.tableModel = new DefaultTableModel(columnNames, 0);

		setLayout(new MigLayout("", "[grow][grow]", "[grow][grow]"));

		this.table = new JTable(this.tableModel);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.table.setCellSelectionEnabled(true);

		add(this.table, "cell 0 0 2 2,grow");
		add(this.table.getTableHeader(), BorderLayout.NORTH);
	}

	public void addCategoryRow(CategoryBean category) {
		this.tableModel.addRow(new String[] {
				String.valueOf(category.getId()),
				category.getName(),
				category.getDescription() });
	}

}
