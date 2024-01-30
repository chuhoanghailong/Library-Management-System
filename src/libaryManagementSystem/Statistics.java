package libaryManagementSystem;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Statistics extends JFrame {
	Connection connect;
	ResultSet rs;
	PreparedStatement pst;
	private JPanel contentPane;
	private JPanel panel_1;
	private JTable Header;
	private JTable Jtable1;
	private JTable Header_2;
	private JTable Jtable2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statistics frame = new Statistics();
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
	public Statistics() {
		super("Statistics Detail");
		connect = JavaConnect.ConnecttoDB();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 635);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 192), 3), "Issue Detail", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 192)));
		panel.setBounds(10, 23, 650, 249);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 24, 606, 203);
		panel.add(scrollPane);
		
		Header = new JTable();
		scrollPane.setColumnHeaderView(Header);
		
		Jtable1 = new JTable();
		scrollPane.setViewportView(Jtable1);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 64), 3), "Return Detail", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 64)));
		panel_1.setBounds(10, 283, 650, 249);
		contentPane.add(panel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 22, 606, 203);
		panel_1.add(scrollPane_1);
		
		Header_2 = new JTable();
		scrollPane_1.setColumnHeaderView(Header_2);
		
		Jtable2 = new JTable();
		scrollPane_1.setViewportView(Jtable2);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home ob = new Home();
				ob.setVisible(true);
			}
		});
		btnNewButton.setBounds(547, 562, 89, 23);
		contentPane.add(btnNewButton);
		
		Jtable1();
		Jtable2();
	}
	
	public void Jtable1() {
		try {
			String sql = "select Book_ID,Name,Edition,Publisher,Price,Pages from Issue";
			pst = connect.prepareStatement(sql);
			rs = pst.executeQuery();
			Jtable1.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void Jtable2() {
		try {
			String sql = "select Student_ID,S_Name,S_Surname,Course,Branch,Year from Return";
			pst = connect.prepareStatement(sql);
			rs = pst.executeQuery();
			Jtable2.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
