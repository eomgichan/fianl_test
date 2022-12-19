import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.*;

public class MainFrame extends JFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	
	public MainFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setBounds(12, 10, 97, 23);
		getContentPane().add(btnNewButton);
		
		String[] City1 = {"서울특별시", "인천광역시", "부산광역시", "경기도",	"경상남도"};
		JComboBox comboBox = new JComboBox(City1);
		comboBox.setBounds(12, 60, 79, 23);
		getContentPane().add(comboBox);
		String[] City2 = {"송파구", "강서구", "강남구", "노원구", 
				"관악구", "서구", "남동구", "부평구", "미추홀구", 
				"연수구", "해운대구", "부산진구", "사하구", "북구", "동래구", 
				"수원시", "용인시", "고양시", "성남시", "화성시"};
		JComboBox comboBox_1 = new JComboBox(City2);
		comboBox_1.setBounds(103, 60, 79, 23);
		getContentPane().add(comboBox_1);
		
		textField_1 = new JTextField("베스트 자취방");
		textField_1.setBounds(12, 93, 84, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("조회");
		btnNewButton_1.setBounds(194, 60, 97, 23);
		getContentPane().add(btnNewButton_1);
		
		JTextArea textArea = new JTextArea("1. 서울특별시 송파구 / 5점" + "\r\n" +
				"2. 경기도 수원시 / 4.9점" + "\r\n" +
				"3. 경기도 성남시 / 4.5점" + "\r\n" +
				"4. 인천광역시 서구 / 4.3점");
		textArea.setBounds(12, 124, 410, 127);
		getContentPane().add(textArea);

	}
	class MyActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("조회")) {
				mainOperator.connector.send
				if(mainOperator.connector.sendLoginInformation(enteredID, enteredPassword)) {
					mainOperator.mf.setVisible(true);
					dispose();
				}else {
					System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
					typeId.setText("");
					typePassword.setText("");
				}
				
				
				
			}else if(b.getText().equals("Cancel")) {
				typeId.setText("");
				typePassword.setText("");
			}
		}
	}
}
