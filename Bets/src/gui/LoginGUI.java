package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import businessLogic.BLFacade;
import exceptions.invalidID;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.ComponentOrientation;

public class LoginGUI extends JFrame {


	private JTextField usernameTextField;
	private HintTextField emailTextField;
	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JPasswordField passwordField;
	private JPasswordField passwordConfirmField;
	
	JTextArea usernameErrorArea = new JTextArea();
	JTextArea pwErrorArea = new JTextArea();
	JTextArea confirmPwErrorArea = new JTextArea();
	JTextArea nameErrorArea = new JTextArea();
	JTextArea surnameErrorArea = new JTextArea();
	JTextArea emailErrorArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setBounds(600, 200, 455,474);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{35, 20, 148, 20, 25, 20, 152, 20, 35, 0};
		gridBagLayout.rowHeights = new int[]{20, 15, 20, 12, 14, 0, 20, 14, 0, 20, 14, 0, 0, 0, 0, 23, 25, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblInsertRegistrationData = new JLabel("Insert registration data");
		lblInsertRegistrationData.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblInsertRegistrationData = new GridBagConstraints();
		gbc_lblInsertRegistrationData.gridwidth = 5;
		gbc_lblInsertRegistrationData.insets = new Insets(0, 0, 5, 5);
		gbc_lblInsertRegistrationData.gridx = 2;
		gbc_lblInsertRegistrationData.gridy = 1;
		getContentPane().add(lblInsertRegistrationData, gbc_lblInsertRegistrationData);
		
		JLabel lblUsername = new JLabel("Username:");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.gridwidth = 3;
		gbc_lblUsername.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 3;
		getContentPane().add(lblUsername, gbc_lblUsername);
		
		usernameTextField = new JTextField();
		usernameTextField.setColumns(10);
		GridBagConstraints gbc_usernameTextField = new GridBagConstraints();
		gbc_usernameTextField.gridwidth = 3;
		gbc_usernameTextField.anchor = GridBagConstraints.NORTH;
		gbc_usernameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_usernameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_usernameTextField.gridx = 1;
		gbc_usernameTextField.gridy = 4;
		getContentPane().add(usernameTextField, gbc_usernameTextField);
		
		
		usernameErrorArea.setBackground(SystemColor.menu);
		usernameErrorArea.setForeground(new Color(255, 51, 51));
		usernameErrorArea.setEditable(false);
		GridBagConstraints gbc_usernameErrorArea = new GridBagConstraints();
		gbc_usernameErrorArea.insets = new Insets(0, 0, 5, 5);
		gbc_usernameErrorArea.fill = GridBagConstraints.BOTH;
		gbc_usernameErrorArea.gridx = 2;
		gbc_usernameErrorArea.gridy = 5;
		getContentPane().add(usernameErrorArea, gbc_usernameErrorArea);
		
		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.gridwidth = 3;
		gbc_lblPassword.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 6;
		getContentPane().add(lblPassword, gbc_lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm password:");
		GridBagConstraints gbc_lblConfirmPassword = new GridBagConstraints();
		gbc_lblConfirmPassword.gridwidth = 3;
		gbc_lblConfirmPassword.anchor = GridBagConstraints.WEST;
		gbc_lblConfirmPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmPassword.gridx = 5;
		gbc_lblConfirmPassword.gridy = 6;
		getContentPane().add(lblConfirmPassword, gbc_lblConfirmPassword);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BLFacade facade = MainGUI.getBusinessLogic();
				
				usernameErrorArea.setText("");
				pwErrorArea.setText("");
				confirmPwErrorArea.setText("");
				nameErrorArea.setText("");
				surnameErrorArea.setText("");
				emailErrorArea.setText("");
				
				//retrieve input field data and check validity
				String username = usernameTextField.getText();
				String pass = new String(passwordField.getPassword());
				String passconfirm = new String(passwordConfirmField.getPassword());
				String name = nameTextField.getText();
				String surname = surnameTextField.getText();
				String email = emailTextField.getText();
				
				if (username.equals("") || pass.equals("") || name.equals("") || surname.equals("") || email.equals("")) {
					emailErrorArea.setText("Fill all areas");
				}
				else if(pass.length()<8) {
					pwErrorArea.setText("Min. password length : 8");
				}
				else if(!passconfirm.equals(pass)){
					confirmPwErrorArea.setText("Passwords don't match");
				}
				else {	
					try {
						facade.registerUser(username, pass, name, surname, email, false);
						JFrame m = new MainGUI();
						((MainGUI) m).hideLogInRegister();
						m.setVisible(true);
						LoginGUI.super.dispose();	
					}
					catch (invalidID e) {
						usernameErrorArea.setText(e.getMessage());
					}
				}
			}
		});	
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame user = new MainGUI();
				user.setVisible(true);
				LoginGUI.super.dispose();
			}
		});
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 3;
		gbc_passwordField.anchor = GridBagConstraints.NORTH;
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 7;
		getContentPane().add(passwordField, gbc_passwordField);
		
		passwordConfirmField = new JPasswordField();
		GridBagConstraints gbc_passwordConfirmField = new GridBagConstraints();
		gbc_passwordConfirmField.gridwidth = 3;
		gbc_passwordConfirmField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordConfirmField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordConfirmField.gridx = 5;
		gbc_passwordConfirmField.gridy = 7;
		getContentPane().add(passwordConfirmField, gbc_passwordConfirmField);
		

		pwErrorArea.setForeground(new Color(255, 51, 51));
		pwErrorArea.setEditable(false);
		pwErrorArea.setBackground(SystemColor.menu);
		GridBagConstraints gbc_pwErrorArea = new GridBagConstraints();
		gbc_pwErrorArea.anchor = GridBagConstraints.WEST;
		gbc_pwErrorArea.gridwidth = 2;
		gbc_pwErrorArea.insets = new Insets(0, 0, 5, 5);
		gbc_pwErrorArea.fill = GridBagConstraints.VERTICAL;
		gbc_pwErrorArea.gridx = 1;
		gbc_pwErrorArea.gridy = 8;
		getContentPane().add(pwErrorArea, gbc_pwErrorArea);
		
		
		confirmPwErrorArea.setForeground(new Color(255, 51, 51));
		confirmPwErrorArea.setEditable(false);
		confirmPwErrorArea.setBackground(SystemColor.menu);
		GridBagConstraints gbc_confirmPwErrorArea = new GridBagConstraints();
		gbc_confirmPwErrorArea.insets = new Insets(0, 0, 5, 5);
		gbc_confirmPwErrorArea.fill = GridBagConstraints.BOTH;
		gbc_confirmPwErrorArea.gridx = 6;
		gbc_confirmPwErrorArea.gridy = 8;
		getContentPane().add(confirmPwErrorArea, gbc_confirmPwErrorArea);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.gridwidth = 3;
		gbc_lblName.anchor = GridBagConstraints.NORTH;
		gbc_lblName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 9;
		getContentPane().add(lblName, gbc_lblName);
		
		JLabel lblSurname = new JLabel("Surname:");
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.gridwidth = 3;
		gbc_lblSurname.anchor = GridBagConstraints.NORTH;
		gbc_lblSurname.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.gridx = 5;
		gbc_lblSurname.gridy = 9;
		getContentPane().add(lblSurname, gbc_lblSurname);
		
		nameTextField = new JTextField();
		nameTextField.setToolTipText("");
		nameTextField.setForeground(new Color(0, 0, 0));
		nameTextField.setColumns(10);
		GridBagConstraints gbc_nameTextField = new GridBagConstraints();
		gbc_nameTextField.gridwidth = 3;
		gbc_nameTextField.anchor = GridBagConstraints.NORTH;
		gbc_nameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_nameTextField.gridx = 1;
		gbc_nameTextField.gridy = 10;
		getContentPane().add(nameTextField, gbc_nameTextField);
		
		surnameTextField = new JTextField();
		surnameTextField.setColumns(10);
		GridBagConstraints gbc_surnameTextField = new GridBagConstraints();
		gbc_surnameTextField.gridwidth = 3;
		gbc_surnameTextField.anchor = GridBagConstraints.NORTH;
		gbc_surnameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_surnameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_surnameTextField.gridx = 5;
		gbc_surnameTextField.gridy = 10;
		getContentPane().add(surnameTextField, gbc_surnameTextField);
		
		
		nameErrorArea.setForeground(new Color(255, 51, 51));
		nameErrorArea.setEditable(false);
		nameErrorArea.setBackground(SystemColor.menu);
		GridBagConstraints gbc_nameErrorArea = new GridBagConstraints();
		gbc_nameErrorArea.insets = new Insets(0, 0, 5, 5);
		gbc_nameErrorArea.fill = GridBagConstraints.BOTH;
		gbc_nameErrorArea.gridx = 2;
		gbc_nameErrorArea.gridy = 11;
		getContentPane().add(nameErrorArea, gbc_nameErrorArea);
		
		
		surnameErrorArea.setForeground(new Color(255, 51, 51));
		surnameErrorArea.setEditable(false);
		surnameErrorArea.setBackground(SystemColor.menu);
		GridBagConstraints gbc_surnameErrorArea = new GridBagConstraints();
		gbc_surnameErrorArea.insets = new Insets(0, 0, 5, 5);
		gbc_surnameErrorArea.fill = GridBagConstraints.BOTH;
		gbc_surnameErrorArea.gridx = 6;
		gbc_surnameErrorArea.gridy = 11;
		getContentPane().add(surnameErrorArea, gbc_surnameErrorArea);
		
		JLabel lblEmail = new JLabel("E-mail:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.gridwidth = 3;
		gbc_lblEmail.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 12;
		getContentPane().add(lblEmail, gbc_lblEmail);
		
		emailTextField = new HintTextField("example@emailprovider.com");
		emailTextField.setToolTipText("");
		emailTextField.setColumns(10);
		GridBagConstraints gbc_emailTextField = new GridBagConstraints();
		gbc_emailTextField.gridwidth = 7;
		gbc_emailTextField.anchor = GridBagConstraints.NORTH;
		gbc_emailTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailTextField.insets = new Insets(0, 0, 5, 5);
		gbc_emailTextField.gridx = 1;
		gbc_emailTextField.gridy = 13;
		getContentPane().add(emailTextField, gbc_emailTextField);
		emailErrorArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		
		emailErrorArea.setForeground(new Color(255, 51, 51));
		emailErrorArea.setEditable(false);
		emailErrorArea.setBackground(SystemColor.menu);
		GridBagConstraints gbc_emailErrorArea = new GridBagConstraints();
		gbc_emailErrorArea.gridwidth = 6;
		gbc_emailErrorArea.insets = new Insets(0, 0, 5, 5);
		gbc_emailErrorArea.fill = GridBagConstraints.VERTICAL;
		gbc_emailErrorArea.gridx = 1;
		gbc_emailErrorArea.gridy = 14;
		getContentPane().add(emailErrorArea, gbc_emailErrorArea);
		GridBagConstraints gbc_registerButton = new GridBagConstraints();
		gbc_registerButton.insets = new Insets(0, 0, 5, 5);
		gbc_registerButton.anchor = GridBagConstraints.NORTH;
		gbc_registerButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_registerButton.gridx = 2;
		gbc_registerButton.gridy = 15;
		getContentPane().add(registerButton, gbc_registerButton);
		
		
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_cancelButton.insets = new Insets(0, 0, 5, 5);
		gbc_cancelButton.gridx = 6;
		gbc_cancelButton.gridy = 15;
		getContentPane().add(cancelButton, gbc_cancelButton);	
			}
	
	/**
	 * Auxiliary class for textfields with an initial hint text
	 *
	 */
	class HintTextField extends JTextField implements FocusListener {
		private static final long serialVersionUID = 1L;
		
		private final String hint;
		  private boolean showingHint;

		  public HintTextField(final String hint) {
		    super(hint);
		    this.hint = hint;
		    this.showingHint = true;
		    super.addFocusListener(this);
		    this.setForeground(new Color(169, 169, 169));
		  }

		  @Override
		  public void focusGained(FocusEvent e) {
		    if(this.getText().isEmpty()) {
		      super.setText("");
		      showingHint = false;
		      this.setForeground(new Color(0, 0, 0));
		    }
		  }
		  @Override
		  public void focusLost(FocusEvent e) {
		    if(this.getText().isEmpty()) {
		      super.setText(hint);
		      showingHint = true;
		      this.setForeground(new Color(169, 169, 169));
		    }
		  }

		  @Override
		  public String getText() {
		    return showingHint ? "" : super.getText();
		  }
		}
}
