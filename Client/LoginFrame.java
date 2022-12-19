import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class LoginFrame extends JFrame{
	JPanel panel = new JPanel(new FlowLayout());
	JButton enter = new JButton("Login");
	JButton cancel = new JButton("Cancel");
	JButton signup = new JButton("Singup");
	JTextField typeId = new JTextField();
	JPasswordField typePassword = new JPasswordField();
	JLabel id = new JLabel("I      D");
	JLabel password = new JLabel("Password");
	
	Operator mainOperator = null;
	
	LoginFrame(Operator _o){
		mainOperator = _o;
		MyActionListener ml = new MyActionListener();
		setTitle("LOGIN with Server");
//		mainOperator.mf.setVisible(true);
		
		id.setPreferredSize(new Dimension(70, 30));
		typeId.setPreferredSize(new Dimension(300, 30));
		password.setPreferredSize(new Dimension(70, 30));
		typePassword.setPreferredSize(new Dimension(300, 30));
		enter.setPreferredSize(new Dimension(185, 30));
		cancel.setPreferredSize(new Dimension(185, 30));
		signup.setPreferredSize(new Dimension(185, 30));
		panel.add(id);
		panel.add(typeId);
		panel.add(password);
		panel.add(typePassword);
		panel.add(enter);
		panel.add(cancel);
		panel.add(signup);
		enter.addActionListener(ml);
		cancel.addActionListener(ml);
		
		setContentPane(panel);
		
		setResizable(false);
		setSize(400, 150);
		
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		
		setVisible(true);
	}
	
	
	class MyActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Login")) {
				String enteredID = typeId.getText();				
				String enteredPassword = "";
				for(int i=0; i<typePassword.getPassword().length; i++) {
					enteredPassword = enteredPassword+typePassword.getPassword()[i];
				}
				
//				System.out.println(enteredID + "/////" + enteredPassword);
				
				if(mainOperator.connector.sendLoginInformation(enteredID, enteredPassword)) {
					mainOperator.home.setVisible(true);
					dispose();
				}else {
					System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
					typeId.setText("");
					typePassword.setText("");
				}
				
				
				
			}else if(b.getText().equals("Cancel")) {
				typeId.setText("");
				typePassword.setText("");
			}else if(b.getText().equals("Signup")) {
				mainOperator.signup.setVisible(true);
				dispose();
			}
		}
	}
}
