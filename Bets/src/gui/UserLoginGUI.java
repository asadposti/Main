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
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class UserLoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTextField;
	private JPasswordField passwordField;
	
	JTextArea usernameError = new JTextArea();
	JTextArea passwordError = new JTextArea();
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public UserLoginGUI() {
		setBounds(600, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Dialog", Font.BOLD, 16));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BLFacade facade = MainGUI.getBusinessLogic();
				usernameError.setText("");
				passwordError.setText("");
				String user = usernameTextField.getText();
				String passs =  new String (passwordField.getPassword());
				try {
					if (facade.checkCredentials(user, passs)) {
						JFrame m = new MainGUI();
						((MainGUI) m).hideLogInRegister();
						m.setVisible(true);
						UserLoginGUI.super.dispose();
					}
					else {
						passwordError.setText("Incorrect password");
					}
				} catch (invalidID e) {
					usernameError.setText(e.getMessage());
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
		usernameError.setEditable(false);
		
		
		usernameError.setBackground(UIManager.getColor("InternalFrame.minimizeIconBackground"));
		usernameError.setForeground(new Color(255, 51, 51));
		passwordError.setEditable(false);
		

		passwordError.setForeground(new Color(255, 51, 51));
		passwordError.setBackground(SystemColor.menu);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame user = new MainGUI();
				user.setVisible(true);
				UserLoginGUI.super.dispose();
			}
		});
		cancelButton.setFont(new Font("Dialog", Font.BOLD, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(161)
					.addComponent(loginButton, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
					.addGap(51)
					.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(30, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(usernameError, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
						.addComponent(usernameTextField, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
						.addComponent(usernameLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
						.addComponent(passwordError, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE))
					.addGap(45))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addComponent(usernameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(usernameError, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(passwordLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(passwordError, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(12))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
