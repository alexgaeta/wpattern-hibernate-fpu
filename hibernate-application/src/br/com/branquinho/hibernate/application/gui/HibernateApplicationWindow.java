package br.com.branquinho.hibernate.application.gui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;

import br.com.branquinho.hibernate.database.ServicesFactory;
import br.com.branquinho.hibernate.utils.database.beans.CategoryBean;
import br.com.branquinho.hibernate.utils.database.interfaces.IServicesFactory;

public class HibernateApplicationWindow {

	private JFrame frmHibernateSample;

	private static final IServicesFactory serviceFactory = new ServicesFactory();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					HibernateApplicationWindow window = new HibernateApplicationWindow();
					window.frmHibernateSample.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HibernateApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.frmHibernateSample = new JFrame();
		this.frmHibernateSample.setTitle("Hibernate Sample");
		this.frmHibernateSample.setBounds(100, 100, 800, 600);
		this.frmHibernateSample.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frmHibernateSample.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

		CategoryGridPanel categoryGridPanel = new CategoryGridPanel();
		this.frmHibernateSample.getContentPane().add(categoryGridPanel);

		loadCategories(categoryGridPanel);
	}

	private void loadCategories(CategoryGridPanel categoryGridPanel) {

		List<CategoryBean> categories = serviceFactory.getCategoryService().findAllCategories();

		for (CategoryBean category : categories) {
			categoryGridPanel.addCategoryRow(category);
		}
	}

}
