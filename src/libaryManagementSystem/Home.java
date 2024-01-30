package libaryManagementSystem;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.Component;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import com.jtattoo.plaf.About;

import javax.swing.border.LineBorder;
import javax.swing.JMenuItem;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		super("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 750);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Log out");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login ob = new Login();
				ob.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("About");
		mntmNewMenuItem_2.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("E:\\EclipseWorkplaces\\libaryManagementSystem\\image\\library.PNG"));
		lblNewLabel.setBounds(10, 11, 156, 66);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 128, 64), 2), "Operation", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 128, 64)));
		panel.setBounds(10, 143, 669, 221);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(31, 45, 140, 140);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddBook ob = new AddBook();
				ob.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon("E:\\EclipseWorkplaces\\libaryManagementSystem\\image\\book_blue_add.png"));
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Statistics ob = new Statistics();
				ob.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(260, 45, 140, 140);
		panel.add(btnNewButton_1);
		btnNewButton_1.setIcon(new ImageIcon("E:\\EclipseWorkplaces\\libaryManagementSystem\\image\\stat.jpg"));
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddStudent ob = new AddStudent();
				ob.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(493, 45, 140, 140);
		panel.add(btnNewButton_2);
		btnNewButton_2.setIcon(new ImageIcon("E:\\EclipseWorkplaces\\libaryManagementSystem\\image\\addStudent.png"));
		
		JLabel lblNewLabel_1 = new JLabel("Add Book");
		lblNewLabel_1.setBounds(31, 196, 140, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("Statistics");
		lblNewLabel_2.setBounds(260, 196, 140, 14);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_3 = new JLabel("Add Student\r\n");
		lblNewLabel_3.setBounds(493, 196, 140, 14);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_4 = new JLabel("Hello!");
		lblNewLabel_4.setIcon(new ImageIcon("E:\\EclipseWorkplaces\\libaryManagementSystem\\image\\nerd.jpg"));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setForeground(new Color(128, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(443, 11, 187, 100);
		contentPane.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "Action", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_1.setBounds(10, 440, 669, 221);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				IssueBook ob = new IssueBook();
				ob.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(31, 45, 140, 140);
		panel_1.add(btnNewButton_3);
		btnNewButton_3.setIcon(new ImageIcon("E:\\EclipseWorkplaces\\libaryManagementSystem\\image\\issueBook.jpg"));
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ReturnBook ob = new ReturnBook();
				ob.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(260, 45, 140, 140);
		panel_1.add(btnNewButton_4);
		btnNewButton_4.setIcon(new ImageIcon("E:\\EclipseWorkplaces\\libaryManagementSystem\\image\\returnBook.jpg"));
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AboutMe ob = new AboutMe();
				ob.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(493, 45, 140, 140);
		panel_1.add(btnNewButton_5);
		btnNewButton_5.setIcon(new ImageIcon("E:\\EclipseWorkplaces\\libaryManagementSystem\\image\\AboutMe.png"));
		
		JLabel lblNewLabel_1_1 = new JLabel("Issue Book\r\n");
		lblNewLabel_1_1.setBounds(31, 196, 140, 14);
		panel_1.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_2 = new JLabel("Return Book\r\n");
		lblNewLabel_1_2.setBounds(264, 196, 140, 14);
		panel_1.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_3 = new JLabel("About");
		lblNewLabel_1_3.setBounds(493, 196, 140, 14);
		panel_1.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}
}
