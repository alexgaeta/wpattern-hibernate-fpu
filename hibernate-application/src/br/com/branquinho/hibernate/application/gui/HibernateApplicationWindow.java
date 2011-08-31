package br.com.branquinho.hibernate.application.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class HibernateApplicationWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					HibernateApplicationWindow window = new HibernateApplicationWindow();
					window.frame.setVisible(true);
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
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 800, 600);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
