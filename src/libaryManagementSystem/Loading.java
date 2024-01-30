package libaryManagementSystem;
import java.sql.*;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.ProgressBarUI;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Window.Type;

public class Loading extends JFrame implements Runnable {
	Connection connect;
	int x = 0;
	Thread th;
	
	private JProgressBar progressBar;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loading frame = new Loading();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Loading() {
		super("Loading");
		th = new Thread((Runnable)this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 128, 0)));
		panel.setBounds(26, 11, 454, 322);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Library Management System");
		lblNewLabel.setBounds(0, 16, 454, 42);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		progressBar = new JProgressBar();
		progressBar.setBounds(141, 128, 191, 20);
		panel.add(progressBar);
		progressBar.setStringPainted(true);
		
		lblNewLabel_1 = new JLabel("Please wait...");
		lblNewLabel_1.setBounds(151, 112, 181, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(151, 159, 172, 125);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("E:\\EclipseWorkplaces\\libaryManagementSystem\\image\\bookicon.gif"));
	}
	
	public void run() {
		try {
			for(int i=1; i<=200; i++) {
				x = x + 1;
				int m = progressBar.getMaximum();
				int v = progressBar.getValue();
				if(v<m) {
					progressBar.setValue(progressBar.getValue()+1);
				}
				else {
					i = 201;
					setVisible(false);
					Home ob = new Home();
					ob.setVisible(true);
				}Thread.sleep(50);
			}
				
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void setUpLd() {
		setVisible(false);
		th.start();
	}
	
	
}


