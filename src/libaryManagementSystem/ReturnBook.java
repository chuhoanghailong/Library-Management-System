package libaryManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnBook extends JFrame {
	Connection connect;
	ResultSet rs;
	PreparedStatement pst;
	private JPanel contentPane;
	private JTextField StextField;
	private JTextField StextField_1;
	private JTextField StextField_2;
	private JTextField StextField_3;
	private JTextField StextField_4;
	private JTextField StextField_5;
	private JTextField StextField_6;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook frame = new ReturnBook();
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
	public ReturnBook() {
		super("Return Book");
		connect = JavaConnect.ConnecttoDB();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 0), 2), "Return Book", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		panel.setBounds(10, 35, 775, 379);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setBounds(96, 48, 80, 22);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setBounds(96, 93, 80, 22);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Surname");
		lblNewLabel_2.setBounds(96, 139, 80, 22);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3 = new JLabel("Course");
		lblNewLabel_3.setBounds(96, 183, 80, 22);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_4 = new JLabel("Branch\r\n");
		lblNewLabel_4.setBounds(96, 228, 80, 22);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		StextField = new JTextField();
		StextField.setBounds(195, 48, 146, 22);
		panel.add(StextField);
		StextField.setColumns(10);
		
		StextField_1 = new JTextField();
		StextField_1.setBounds(195, 93, 146, 22);
		panel.add(StextField_1);
		StextField_1.setColumns(10);
		
		StextField_2 = new JTextField();
		StextField_2.setBounds(195, 138, 146, 22);
		panel.add(StextField_2);
		StextField_2.setColumns(10);
		
		StextField_3 = new JTextField();
		StextField_3.setBounds(195, 183, 146, 22);
		panel.add(StextField_3);
		
		StextField_4 = new JTextField();
		StextField_4.setBounds(195, 228, 146, 22);
		panel.add(StextField_4);
		StextField_4.setColumns(10);
		
		StextField_5 = new JTextField();
		StextField_5.setBounds(195, 273, 146, 22);
		panel.add(StextField_5);
		
		StextField_6 = new JTextField();
		StextField_6.setBounds(195, 318, 146, 22);
		panel.add(StextField_6);
		
		JLabel lblNewLabel_4_1 = new JLabel("Year");
		lblNewLabel_4_1.setBounds(96, 273, 80, 22);
		panel.add(lblNewLabel_4_1);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Semester");
		lblNewLabel_4_1_1.setBounds(96, 318, 80, 22);
		panel.add(lblNewLabel_4_1_1);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql ="select * from Issue where Student_ID = ?";
				try {
					pst = connect.prepareStatement(sql);
					pst.setString(1, StextField.getText());
					rs = pst.executeQuery();
					if(rs.next()) {
						String str1 = rs.getString("S_Name");
						StextField_1.setText(str1);
						String str2 = rs.getString("S_Surname");
						StextField_2.setText(str2);
						String str3 = rs.getString("Course");
						StextField_3.setText(str3);
						String str4 = rs.getString("Branch");
						StextField_4.setText(str4);
						String str5 = rs.getString("Year");
						StextField_5.setText(str5);
						String str6 = rs.getString("Semester");
						StextField_6.setText(str6);
						String str7 = rs.getString("Book_ID");
						textField.setText(str7);
						String str8 = rs.getString("Name");
						textField_1.setText(str8);
						String str9 = rs.getString("Edition");
						textField_2.setText(str9);
						String str10 = rs.getString("Publisher");
						textField_3.setText(str10);
						String str11 = rs.getString("Price");
						textField_4.setText(str11);
						String str12 = rs.getString("Pages");
						textField_5.setText(str12);
						String str13 = rs.getString("DateOfIssue");
						textField_6.setText(str13);
						
						rs.close();
						pst.close();
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Book is not Issued with this Student ID!");
					}
					
				} catch(Exception eve) {
					JOptionPane.showMessageDialog(null, eve);
				} finally {
					try {
						rs.close();
						pst.close();
					}catch (Exception evt) {
						
					}
				}
			}
		});
		btnNewButton_1.setBounds(355, 48, 86, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Book ID");
		lblNewLabel_1_2.setBounds(459, 48, 80, 22);
		panel.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Name");
		lblNewLabel_1_1_1.setBounds(459, 93, 80, 22);
		panel.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2_1 = new JLabel("Edition");
		lblNewLabel_2_1.setBounds(459, 138, 80, 22);
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3_1 = new JLabel("Publisher");
		lblNewLabel_3_1.setBounds(459, 183, 80, 22);
		panel.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_4_2 = new JLabel("Price");
		lblNewLabel_4_2.setBounds(459, 228, 80, 22);
		panel.add(lblNewLabel_4_2);
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setBounds(548, 48, 146, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(548, 93, 146, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(548, 138, 146, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(548, 183, 146, 22);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(548, 228, 146, 22);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(548, 273, 146, 22);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(548, 318, 146, 22);
		panel.add(textField_6);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("Pages");
		lblNewLabel_4_1_2.setBounds(459, 273, 80, 22);
		panel.add(lblNewLabel_4_1_2);
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Date of Issue");
		lblNewLabel_4_1_1_1.setBounds(458, 318, 80, 22);
		panel.add(lblNewLabel_4_1_1_1);
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(517, 425, 129, 20);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel = new JLabel("Return Date");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(424, 423, 94, 20);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1_1 = new JButton("Return");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete();
				UpdateReturn();
			}
		});
		btnNewButton_1_1.setBounds(412, 456, 83, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Back");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home ob = new Home();
				ob.setVisible(true);
			}
		});
		btnNewButton_1_2.setBounds(527, 456, 83, 23);
		contentPane.add(btnNewButton_1_2);
	}
	
	public void Delete() {
		String sql = "delete from Issue where Student_ID=?";
		try {
			pst = connect.prepareStatement(sql);
			pst.setString(1, StextField.getText());
			pst.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public void UpdateReturn() {
		String sql = "insert into Return(Student_ID,S_Name,S_Surname,Course,Branch,Year,Semester,Book_ID,Name,Edition,Publisher,Price,Pages,DateOfIsse,DateOfReturn) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pst=connect.prepareStatement(sql);
			pst.setString(1, StextField.getText());
			pst.setString(2, StextField_1.getText());
			pst.setString(3, StextField_2.getText());
			pst.setString(4, StextField_3.getText());
			pst.setString(5, StextField_4.getText());
			pst.setString(6, StextField_5.getText());
			pst.setString(7, StextField_6.getText());
			pst.setString(8, textField.getText());
			pst.setString(9, textField_1.getText());
			pst.setString(10, textField_2.getText());
			pst.setString(11, textField_3.getText());
			pst.setString(12, textField_4.getText());
			pst.setString(13, textField_5.getText());
			pst.setString(14, textField_6.getText());
			pst.setString(15, ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Book Successfully Returned!");
			
			
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	
}
