package libaryManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class IssueBook extends JFrame {
	Connection connect;
	ResultSet rs;
	PreparedStatement pst;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField StextField;
	private JTextField StextField_1;
	private JTextField StextField_2;
	private JTextField StextField_3;
	private JTextField StextField_4;
	private JTextField StextField_5;
	private JTextField StextField_6;
	private JDateChooser dateChooser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBook frame = new IssueBook();
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
	public IssueBook() {
		super("Issue");
		connect = JavaConnect.ConnecttoDB();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 128, 64), 3, true), "Book Detail", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 128, 64)));
		panel.setBounds(20, 25, 360, 380);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Book ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(27, 67, 63, 22);
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(27, 112, 63, 22);
		panel.add(lblName);
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEdition.setBounds(27, 157, 63, 22);
		panel.add(lblEdition);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPublisher.setBounds(27, 202, 63, 22);
		panel.add(lblPublisher);
		
		JLabel lblPrices = new JLabel("Price");
		lblPrices.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrices.setBounds(27, 247, 63, 22);
		panel.add(lblPrices);
		
		JLabel lblPages = new JLabel("Pages");
		lblPages.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPages.setBounds(27, 292, 63, 22);
		panel.add(lblPages);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(100, 67, 146, 22);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(100, 112, 146, 22);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(100, 157, 146, 22);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(100, 202, 146, 22);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(100, 247, 146, 22);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(100, 292, 146, 22);
		panel.add(textField_5);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql ="select * from Book where Book_ID = ?";
				try {
					pst =connect.prepareStatement(sql);
					pst.setString(1, textField.getText());
					rs = pst.executeQuery();
						if(rs.next()) {
							String str1 = rs.getString("Name");
							textField_1.setText(str1);
							String str2 = rs.getString("Edition");
							textField_2.setText(str2);
							String str3 = rs.getString("Publisher");
							textField_3.setText(str3);
							String str4 = rs.getString("Price");
							textField_4.setText(str4);
							String str5 = rs.getString("Pages");
							textField_5.setText(str5);
							rs.close();
							pst.close();
						}
						else {
						JOptionPane.showMessageDialog(null, "Book ID Not Found!");
						}
					
					} catch(Exception evt) {
						JOptionPane.showMessageDialog(null, evt);
					} finally {
						try {
						rs.close();
						pst.close();
						
							} catch(Exception eve) {
						
					}
				}
			}
		});
		btnNewButton.setBounds(261, 66, 89, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 160), 3, true), "Student Detail", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 160)));
		panel_1.setBounds(400, 25, 400, 380);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(25, 35, 80, 22);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(25, 80, 80, 22);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Surname");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(25, 125, 80, 22);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Course");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(25, 170, 80, 22);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Branch\r\n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(25, 215, 80, 22);
		panel_1.add(lblNewLabel_4);
		
		StextField = new JTextField();
		StextField.setColumns(10);
		StextField.setBounds(124, 35, 146, 22);
		panel_1.add(StextField);
		
		StextField_1 = new JTextField();
		StextField_1.setColumns(10);
		StextField_1.setBounds(124, 80, 146, 22);
		panel_1.add(StextField_1);
		
		StextField_2 = new JTextField();
		StextField_2.setColumns(10);
		StextField_2.setBounds(124, 125, 146, 22);
		panel_1.add(StextField_2);
		
		StextField_3 = new JTextField();
		StextField_3.setBounds(124, 170, 146, 22);
		panel_1.add(StextField_3);
		
		StextField_4 = new JTextField();
		StextField_4.setColumns(10);
		StextField_4.setBounds(124, 215, 146, 22);
		panel_1.add(StextField_4);
		
		StextField_5 = new JTextField();
		StextField_5.setBounds(124, 260, 146, 22);
		panel_1.add(StextField_5);
		
		StextField_6 = new JTextField();
		StextField_6.setBounds(124, 305, 146, 22);
		panel_1.add(StextField_6);
		
		JLabel lblNewLabel_4_1 = new JLabel("Year");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(25, 260, 80, 22);
		panel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Semester");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1_1.setBounds(25, 305, 80, 22);
		panel_1.add(lblNewLabel_4_1_1);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql ="select * from Student where Student_ID = ?";
				try {
					pst =connect.prepareStatement(sql);
					pst.setString(1, StextField.getText());
					rs = pst.executeQuery();
						if(rs.next()) {
							String str1 = rs.getString("Name");
							StextField_1.setText(str1);
							String str2 = rs.getString("Surname");
							StextField_2.setText(str2);
							String str3 = rs.getString("Course");
							StextField_3.setText(str3);
							String str4 = rs.getString("Branch");
							StextField_4.setText(str4);
							String str5 = rs.getString("Year");
							StextField_5.setText(str5);
							String str6 = rs.getString("Semester");
							StextField_6.setText(str6);
							rs.close();
							pst.close();
						}
						else {
						JOptionPane.showMessageDialog(null, "Student ID Not Found!");
						}
					
					} catch(Exception evt) {
						JOptionPane.showMessageDialog(null, evt);
					} finally {
						try {
						rs.close();
						pst.close();
						
							} catch(Exception eve) {
						
					}
				}
			}
		});
		btnNewButton_1.setBounds(290, 35, 89, 23);
		panel_1.add(btnNewButton_1);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(409, 427, 117, 20);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel_5 = new JLabel("Date of issue");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(307, 427, 92, 20);
		contentPane.add(lblNewLabel_5);
		
		JButton btnIssue = new JButton("Issue");
		btnIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql ="insert into Issue(Book_ID,Name,Edition,Publisher,Price,Pages,Student_ID,S_Name,S_Surname,Course,Branch,Year,Semester,DateOfIssue) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
						pst=connect.prepareStatement(sql);
						pst.setString(1, textField.getText());
						pst.setString(2, textField_1.getText());
						pst.setString(3, textField_2.getText());
						pst.setString(4, textField_3.getText());
						pst.setString(5, textField_4.getText());
						pst.setString(6, textField_5.getText());
						pst.setString(7, StextField.getText());
						pst.setString(8, StextField_1.getText());
						pst.setString(9, StextField_2.getText());
						pst.setString(10, StextField_3.getText());
						pst.setString(11, StextField_4.getText());
						pst.setString(12, StextField_5.getText());
						pst.setString(13, StextField_6.getText());
						pst.setString(14, ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
						pst.execute();
						JOptionPane.showMessageDialog(null, "Book Issued Successfully!");
					}catch(Exception eve) {
						JOptionPane.showMessageDialog(null, eve);
						
					}
			}
		});
		btnIssue.setBounds(307, 458, 73, 23);
		contentPane.add(btnIssue);
		
		JButton btnNewButton_2_1 = new JButton("Back\r\n");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home ob = new Home();
				ob.setVisible(true);
			}
		});
		btnNewButton_2_1.setBounds(419, 458, 73, 23);
		contentPane.add(btnNewButton_2_1);
	}
}
