package libaryManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AboutMe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutMe frame = new AboutMe();
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
	public AboutMe() {
		super("About");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\EclipseWorkplaces\\libaryManagementSystem\\image\\iconMe.jpg"));
		lblNewLabel.setBounds(10, 11, 270, 245);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Library Management System");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(381, 40, 233, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Author : Chu Hoang Hai Long\r\n");
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.BOLD, 17));
		lblNewLabel_2.setBounds(330, 81, 323, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("and a random Idian dude on youtube");
		lblNewLabel_2_1.setFont(new Font("Segoe Print", Font.BOLD, 17));
		lblNewLabel_2_1.setBounds(399, 116, 328, 28);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home ob = new Home();
				ob.setVisible(true);
			}
		});
		btnNewButton.setBounds(606, 209, 89, 23);
		contentPane.add(btnNewButton);
	}
}
