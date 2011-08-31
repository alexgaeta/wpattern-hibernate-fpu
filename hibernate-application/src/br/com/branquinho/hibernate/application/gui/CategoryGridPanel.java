package br.com.branquinho.hibernate.application.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import net.miginfocom.swing.MigLayout;

public class CategoryGridPanel extends JPanel {

	private static final long serialVersionUID = -3127985955124406559L;

	private final JTable table;

	/**
	 * Create the panel.
	 */
	public CategoryGridPanel() {
		String[] colunas = new String []{ "ID", "Name", "Description"};
		String[][] dados = new String [][] {
				{ "1", "1", "1" },
				{ "2", "2", "2" }
		};

		setLayout(new MigLayout("", "[grow][grow]", "[grow][grow]"));

		this.table = new JTable(dados, colunas);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.table.setCellSelectionEnabled(true);

		add(this.table, "cell 0 0 2 2,grow");
		add(this.table.getTableHeader(), BorderLayout.NORTH);
	}

}
