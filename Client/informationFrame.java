import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class informationFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					informationFrame frame = new informationFrame();
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
	public informationFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setBounds(12, 10, 97, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("월세");
		lblNewLabel.setBounds(32, 74, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("    "+"자취방목록");
		lblNewLabel_1.setBounds(235, 74, 89, 15);
		contentPane.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea("    "+"20~25" + "\r\n" + "\r\n" +
				"    "+"26~30" + "\r\n" + "\r\n" +
				"    "+"31~35" + "\r\n" + "\r\n" +
				"    "+"36~40" + "\r\n" + "\r\n" +
				"    "+"41~45" + "\r\n");
		textArea.setBounds(12, 96, 97, 155);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea("1. 서울 특별시 / 5점" + "\r\n" + "\r\n" +
				"2. 서울 특별시 / 5점" + "\r\n" + "\r\n" +
				"3. 서울 특별시 / 4.5점" + "\r\n" + "\r\n" +
				"4. 서울 특별시 / 4.9점" + "\r\n" + "\r\n" +
				"5. 서울 특별시 / 4.7점" + "\r\n" + "\r\n");
		textArea_1.setBounds(135, 96, 287, 155);
		contentPane.add(textArea_1);
	}

}
