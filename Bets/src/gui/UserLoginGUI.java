package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class UserLoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTextField;
	private JTextField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLoginGUI frame = new UserLoginGUI();
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
	public UserLoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Dialog", Font.BOLD, 16));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		usernameTextField = new JTextField();
		usernameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(161)
					.addComponent(loginButton, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addGap(162))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(usernameTextField, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
					.addGap(45))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(passwordTextField, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
					.addGap(45))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(passwordLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(341))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(usernameLabel, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
					.addGap(317))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(usernameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(31)
					.addComponent(usernameTextField)
					.addGap(35)
					.addComponent(passwordLabel)
					.addGap(18)
					.addComponent(passwordTextField, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
					.addGap(34)
					.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
