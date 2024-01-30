package libaryManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class Login extends JFrame {
	Connection connect;
	ResultSet rs;
	PreparedStatement pst;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
					Login frame = new Login();
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
	public Login() {
		super("Login");
		connect = JavaConnect.ConnecttoDB();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 128, 0), new Color(255, 128, 0)), "Login", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 128, 0)));
		panel.setBounds(61, 81, 373, 269);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(0, 44, 96, 28);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(0, 99, 96, 28);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setBounds(97, 46, 204, 28);
		panel.add(textField);
		textField.setForeground(new Color(0, 0, 0));
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(97, 101, 204, 28);
		panel.add(passwordField);
		passwordField.setForeground(new Color(0, 0, 0));
		
		JButton btnNewButton = new JButton("Forgot password ?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ForgotPass ob = new ForgotPass();
				ob.setVisible(true);
			}
		});
		btnNewButton.setBounds(114, 221, 151, 23);
		panel.add(btnNewButton);
		btnNewButton.setForeground(new Color(0, 0, 0));
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*setVisible(false);
				Login ob = new Login();
				ob.setVisible(true);*/
				String sql = "select * from Account where Username=? and Password=?";
				try {
					pst = connect.prepareStatement(sql);
					pst.setString(1, textField.getText());
					pst.setString(2, passwordField.getText());
					rs = pst.executeQuery();
					if(rs.next()) {
						rs.close();
						pst.close();
						setVisible(false);
						Loading ob = new Loading();
						ob.setUpLd();
						ob.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null,"Incorrect Username and Password!");
					}
					
				}catch(Exception evt) {
					JOptionPane.showMessageDialog(null, evt);
				}
				finally {
					try {
						rs.close();
						pst.close();
					} catch(Exception evt) {
						
					}
				}
			}
			
		});
		btnNewButton_1.setBounds(86, 172, 89, 23);
		panel.add(btnNewButton_1);
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		
		JButton btnNewButton_2 = new JButton("Signup");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Signup ob = new Signup();
				ob.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(199, 172, 89, 23);
		panel.add(btnNewButton_2);
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Libary Management System");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(61, 11, 356, 49);
		contentPane.add(lblNewLabel_2);
	}
}
