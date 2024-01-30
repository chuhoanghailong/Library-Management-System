package libaryManagementSystem;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JPasswordField;

public class ForgotPass extends JFrame {
	Connection connect;
	ResultSet rs;
	PreparedStatement pst;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPass frame = new ForgotPass();
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

	public ForgotPass() {
		super("Forgot password");
		connect = JavaConnect.ConnecttoDB();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.RAISED, new Color(255, 128, 64), new Color(255, 128, 64)),
				"Forgot Password", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 128, 64)));
		panel.setBounds(16, 16, 439, 321);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(23, 60, 70, 30);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(23, 101, 70, 30);
		panel.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblSecurityQuestion = new JLabel("Security Question");
		lblSecurityQuestion.setBounds(23, 142, 115, 30);
		panel.add(lblSecurityQuestion);
		lblSecurityQuestion.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(23, 183, 70, 30);
		panel.add(lblAnswer);
		lblAnswer.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewPassword = new JLabel("Your Password");
		lblNewPassword.setBounds(23, 224, 115, 30);
		panel.add(lblNewPassword);
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textField = new JTextField();
		textField.setBounds(152, 60, 168, 30);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(152, 101, 168, 30);
		panel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(152, 141, 168, 30);
		panel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(152, 185, 168, 30);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(330, 60, 88, 30);
		panel.add(btnNewButton);

		JButton btnRetrieve = new JButton("Retrieve");
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Retrive();
			}
		});
		btnRetrieve.setBounds(330, 185, 88, 30);
		panel.add(btnRetrieve);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login ob = new Login();
				ob.setVisible(true);
			}
		});
		btnBack.setBounds(335, 280, 89, 30);
		panel.add(btnBack);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(152, 226, 168, 30);
		panel.add(textField_4);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search();
			}
		});
	}

	public void Search() {
		String a1 = textField.getText();
		String sql = "select * from Account where Username ='" + a1 + "'";
		try {
			pst = connect.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				textField_1.setText(rs.getString(2));
				textField_2.setText(rs.getString(4));
				rs.close();
				pst.close();
			} else {
				JOptionPane.showMessageDialog(null, "Incorect Username!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void Retrive() {
		String a1 = textField.getText();
		String a2 = textField_3.getText();
		String sql = "select * from Account where Answer ='" + a2 + "'";
		try {
			pst = connect.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				textField_4.setText(rs.getString(3));
			} 
			
		} catch (Exception e) {
			
		}
	}
}
