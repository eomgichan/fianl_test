import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SignupFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupFrame frame = new SignupFrame();
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
	public SignupFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(164, 108, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(164, 139, 116, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(164, 170, 116, 21);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("회원 가입");
		btnNewButton.setBounds(174, 201, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("중복" + "\r\n" + "확인");
		btnNewButton_1.setBounds(289, 107, 90, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Home");
		btnNewButton_2.setBounds(174, 24, 97, 59);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("I           D");
		lblNewLabel.setBounds(97, 111, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(97, 142, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setBounds(97, 173, 57, 15);
		contentPane.add(lblNewLabel_1_1);
	}
	
	class MyActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("회원 가입")) {
				String enteredID = typeId.getText();				
				String enteredPassword = "";
				for(int i=0; i<typePassword.getPassword().length; i++) {
					enteredPassword = enteredPassword+typePassword.getPassword()[i];
				}
			if(mainOperator.connector.sendSignupInformation(enteredID, enteredPassword)) {
				mainOperator.home.setVisible(true);
				dispose();
			}else {
				System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
				typeId.setText("");
				typePassword.setText("");
			}
			}
		}
	}
}
