package libaryManagementSystem;

import java.util.Random;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.ComponentOrientation;
import javax.swing.UIManager;

public class AddBook extends JFrame {
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
					AddBook frame = new AddBook();
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
	public AddBook() {
		super("Add Book");
		connect = JavaConnect.ConnecttoDB();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 0), 4), "Add Book", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		panel.setBounds(25, 11, 274, 358);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book ID");
		lblNewLabel.setBounds(27, 14, 63, 22);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(27, 58, 63, 22);
		panel.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setBounds(27, 104, 63, 22);
		panel.add(lblEdition);
		lblEdition.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setBounds(27, 149, 63, 22);
		panel.add(lblPublisher);
		lblPublisher.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPrices = new JLabel("Price");
		lblPrices.setBounds(27, 196, 63, 22);
		panel.add(lblPrices);
		lblPrices.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPages = new JLabel("Pages");
		lblPages.setBounds(27, 243, 63, 22);
		panel.add(lblPages);
		lblPages.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setBounds(100, 16, 146, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(100, 60, 146, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(100, 151, 146, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(100, 198, 146, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(100, 243, 146, 22);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(100, 106, 146, 22);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql ="Insert into Book(Book_ID,Name,Edition,Publisher,Price,Pages) values (?,?,?,?,?,?)"; 
				try {
					pst = connect.prepareStatement(sql);
					pst.setString(1,textField.getText());
					pst.setString(2,textField_1.getText());
					pst.setString(3,(String)comboBox.getSelectedItem());
					pst.setString(4,textField_2.getText());
					pst.setString(5,textField_3.getText());
					pst.setString(6,textField_4.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "New Book Added");
					
				}catch(Exception evt) {
					JOptionPane.showMessageDialog(null, evt);
				}
			}
		});
		btnNewButton.setBounds(26, 298, 80, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(158, 298, 80, 23);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home ob = new Home();
				ob.setVisible(true);
			}
		});
		
		Random();
	}
	
	public void Random() {
		Random rd = new Random();
		textField.setText(""+rd.nextInt(1000+1));
	}
	
}
