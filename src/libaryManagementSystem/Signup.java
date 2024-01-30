package libaryManagementSystem;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Signup extends JFrame {
	Connection connect;
	ResultSet rs;
	PreparedStatement pst;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {
		super("Sign Up");
		connect = JavaConnect.ConnecttoDB();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 128, 0), new Color(160, 160, 160)), "Create new account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 128, 0)));
		panel.setBounds(16, 11, 394, 331);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(44, 16, 70, 30);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(44, 57, 70, 30);
		panel.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setBounds(167, 18, 168, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(167, 59, 168, 30);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(44, 98, 70, 30);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblSecurityQuestion = new JLabel("Security Question");
		lblSecurityQuestion.setBounds(44, 139, 108, 30);
		panel.add(lblSecurityQuestion);
		lblSecurityQuestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(44, 180, 70, 30);
		panel.add(lblAnswer);
		lblAnswer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_4 = new JTextField();
		textField_4.setBounds(167, 182, 168, 30);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(167, 141, 168, 30);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"What is your favorite movie ?", "What is your school name ?", "What car do you use ?", "Is AK best weapon is cs2 ?", "What is ligma ?"}));
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "Insert into Account (Username,Name,Password,SecretQ,Answer) values (?,?,?,?,?) " ;
					pst = connect.prepareStatement(sql);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4, (String) comboBox.getSelectedItem());
					pst.setString(5, textField_4.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "New Account Created Successfully");
				}catch(Exception eve) {
					JOptionPane.showMessageDialog(null, eve);
				}
			}
		});
		btnNewButton.setBounds(91, 254, 89, 37);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			    Login ob = new Login();
			    ob.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(251, 254, 89, 37);
		panel.add(btnNewButton_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(167, 100, 168, 30);
		panel.add(textField_2);
	}
}
