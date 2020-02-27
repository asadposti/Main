package gui;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import exceptions.invalidID;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;


import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;


import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class UserLoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTextField;

	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public UserLoginGUI() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Dialog", Font.BOLD, 16));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BLFacade facade = MainGUI.getBusinessLogic();
				String user = usernameTextField.getText();
				String passs =  new String (passwordField.getPassword());
				try {
					if (facade.checkCredentials(user, passs)) {
						UserLoginGUI.super.dispose();
					}
				} catch (invalidID e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		usernameTextField = new JTextField();
		usernameTextField.setColumns(10);

		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Dialog", Font.BOLD, 16));

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Dialog", Font.BOLD, 16));

		passwordField = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(161)
						.addComponent(loginButton, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
						.addGap(162))
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(usernameLabel, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
						.addGap(317))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addGap(12)
														.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
												.addComponent(usernameTextField, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))
										.addGap(45))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(passwordLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(341))))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(usernameLabel, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
						.addGap(31)
						.addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(35)
						.addComponent(passwordLabel)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(passwordField)
						.addGap(44)
						.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGap(18))
				);
		contentPane.setLayout(gl_contentPane);
	}
}
