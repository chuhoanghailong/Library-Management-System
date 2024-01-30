package libaryManagementSystem;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudent extends JFrame {
	Connection connect;
	ResultSet rs;
	PreparedStatement pst;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox;
	private JTextField textField_3;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
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
	public AddStudent() {
		super("AddStudent");
		connect = JavaConnect.ConnecttoDB();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 160), 3, true), "Add Student", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 160)));
		panel.setBounds(22, 11, 300, 360);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setBounds(25, 30, 80, 22);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(25, 72, 80, 22);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Surname");
		lblNewLabel_2.setBounds(25, 114, 80, 22);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3 = new JLabel("Course");
		lblNewLabel_3.setBounds(25, 156, 80, 22);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_4 = new JLabel("Branch\r\n");
		lblNewLabel_4.setBounds(25, 198, 80, 22);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setBounds(124, 30, 146, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(124, 72, 146, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(124, 114, 146, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(124, 156, 146, 22);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CS", "BA", "MBA", "BSc", "BFA"}));
		
		textField_3 = new JTextField();
		textField_3.setBounds(124, 198, 146, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(124, 240, 146, 22);
		panel.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(124, 282, 146, 22);
		panel.add(comboBox_2);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql ="Insert into Student(Student_ID,Name,Surname,Course,Branch,Year,Semester) values (?,?,?,?,?,?,?)";
				try {
					pst = connect.prepareStatement(sql);
					pst.setString(1,textField.getText());
					pst.setString(2,textField_1.getText());
					pst.setString(3,textField_2.getText());
					pst.setString(4,(String)comboBox.getSelectedItem());
					pst.setString(5,textField_3.getText());
					pst.setString(6,(String)comboBox_1.getSelectedItem());
					pst.setString(7,(String)comboBox_2.getSelectedItem());
					pst.execute();
					JOptionPane.showMessageDialog(null, "New Student Registered");
					
				}catch(Exception evt) {
					JOptionPane.showMessageDialog(null, evt);
				}
			}
		});
		btnNewButton.setBounds(38, 326, 80, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home ob = new Home();
				ob.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(162, 326, 80, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Year");
		lblNewLabel_4_1.setBounds(25, 240, 80, 22);
		panel.add(lblNewLabel_4_1);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Semester");
		lblNewLabel_4_1_1.setBounds(25, 282, 80, 22);
		panel.add(lblNewLabel_4_1_1);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		Random();
	}
	
	public void Random() {
		Random rd = new Random();
		textField.setText(""+rd.nextInt(1000+1));
	}
}
