package gui;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import exceptions.invalidID;
import exceptions.invalidPW;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;


import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;
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
import javax.swing.JTextPane;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;

public class UserLoginGUI extends JFrame {

	private JPanel contentPane;
	private HintTextField usernameTextField;
	private JPasswordField passwordField;
	
	JLabel usernameErrorLabel = new JLabel("");
	JLabel passErrorLabel = new JLabel("");
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public UserLoginGUI() {
		setBounds(600, 200, 486, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{39, 63, 8, 20, 77, 65, 91, 20, 20, 0};
		gbl_contentPane.rowHeights = new int[]{20, 41, 25, 30, 30, 15, 30, 30, 0, 25, 20, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
				
						
				JLabel usernameIconLabel=null;
				try {
					usernameIconLabel = new JLabel(new ImageIcon(ImageIO.read(new File("images/usericon1.png"))
					           .getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
						JLabel usernameLabel = new JLabel("User Login\r\n");
						usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
						usernameLabel.setFont(new Font("Dialog", Font.BOLD, 20));
						GridBagConstraints gbc_usernameLabel = new GridBagConstraints();
						gbc_usernameLabel.fill = GridBagConstraints.BOTH;
						gbc_usernameLabel.insets = new Insets(0, 0, 5, 5);
						gbc_usernameLabel.gridwidth = 8;
						gbc_usernameLabel.gridx = 1;
						gbc_usernameLabel.gridy = 1;
						contentPane.add(usernameLabel, gbc_usernameLabel);
				GridBagConstraints gbc_usernameIconLabel = new GridBagConstraints();
				gbc_usernameIconLabel.fill = GridBagConstraints.HORIZONTAL;
				gbc_usernameIconLabel.gridheight = 3;
				gbc_usernameIconLabel.insets = new Insets(0, 0, 5, 5);
				gbc_usernameIconLabel.gridx = 1;
				gbc_usernameIconLabel.gridy = 2;
				contentPane.add(usernameIconLabel, gbc_usernameIconLabel);
		
				usernameTextField = new HintTextField("Username");
				usernameTextField.setColumns(10);
				GridBagConstraints gbc_usernameTextField = new GridBagConstraints();
				gbc_usernameTextField.fill = GridBagConstraints.BOTH;
				gbc_usernameTextField.insets = new Insets(0, 0, 5, 5);
				gbc_usernameTextField.gridwidth = 5;
				gbc_usernameTextField.gridx = 3;
				gbc_usernameTextField.gridy = 3;
				contentPane.add(usernameTextField, gbc_usernameTextField);
		
				JButton loginButton = new JButton("Login");
				loginButton.setFont(new Font("Dialog", Font.BOLD, 16));
				loginButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						BLFacade facade = MainGUI.getBusinessLogic();
						usernameErrorLabel.setText("");
						passErrorLabel.setText("");
						String user = usernameTextField.getText();
						String pass =  new String (passwordField.getPassword());
						try {
							int privilege = facade.checkCredentials(user, pass);
							if ( privilege == 0) {
								JFrame m = new UserMainGUI();
								m.setVisible(true);
								dispose();
							}
							else if(privilege == 1){
								JFrame m = new AdminMainGUI();
								m.setVisible(true);
								dispose();
							}
						} catch (invalidID e) {
							usernameErrorLabel.setText(e.getMessage());
						} catch (invalidPW e) {
							passErrorLabel.setText(e.getMessage());
						}
					}
				});
						
						JLabel passIconLabel=null;
						try {
							passIconLabel = new JLabel(new ImageIcon(ImageIO.read(new File("images/passicon.png"))
							           .getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						usernameErrorLabel.setVerticalAlignment(SwingConstants.TOP);
						usernameErrorLabel.setHorizontalAlignment(SwingConstants.TRAILING);
						

						usernameErrorLabel.setForeground(new Color(255, 51, 51));
						GridBagConstraints gbc_usernameErrorLabel = new GridBagConstraints();
						gbc_usernameErrorLabel.anchor = GridBagConstraints.NORTHWEST;
						gbc_usernameErrorLabel.gridwidth = 5;
						gbc_usernameErrorLabel.insets = new Insets(0, 0, 5, 5);
						gbc_usernameErrorLabel.gridx = 3;
						gbc_usernameErrorLabel.gridy = 4;
						contentPane.add(usernameErrorLabel, gbc_usernameErrorLabel);
						GridBagConstraints gbc_passIconLabel = new GridBagConstraints();
						gbc_passIconLabel.anchor = GridBagConstraints.SOUTH;
						gbc_passIconLabel.fill = GridBagConstraints.HORIZONTAL;
						gbc_passIconLabel.gridheight = 2;
						gbc_passIconLabel.insets = new Insets(0, 0, 5, 5);
						gbc_passIconLabel.gridx = 1;
						gbc_passIconLabel.gridy = 5;
						contentPane.add(passIconLabel, gbc_passIconLabel);
				
						passwordField = new JPasswordField();
						GridBagConstraints gbc_passwordField = new GridBagConstraints();
						gbc_passwordField.fill = GridBagConstraints.BOTH;
						gbc_passwordField.insets = new Insets(0, 0, 5, 5);
						gbc_passwordField.gridwidth = 5;
						gbc_passwordField.gridx = 3;
						gbc_passwordField.gridy = 6;
						contentPane.add(passwordField, gbc_passwordField);
				passErrorLabel.setVerticalAlignment(SwingConstants.TOP);
				passErrorLabel.setHorizontalAlignment(SwingConstants.LEFT);
				

				passErrorLabel.setForeground(new Color(255, 51, 51));
				GridBagConstraints gbc_passErrorLabel = new GridBagConstraints();
				gbc_passErrorLabel.anchor = GridBagConstraints.NORTHWEST;
				gbc_passErrorLabel.gridwidth = 5;
				gbc_passErrorLabel.insets = new Insets(0, 0, 5, 5);
				gbc_passErrorLabel.gridx = 3;
				gbc_passErrorLabel.gridy = 7;
				contentPane.add(passErrorLabel, gbc_passErrorLabel);
				GridBagConstraints gbc_loginButton = new GridBagConstraints();
				gbc_loginButton.anchor = GridBagConstraints.EAST;
				gbc_loginButton.fill = GridBagConstraints.VERTICAL;
				gbc_loginButton.insets = new Insets(0, 0, 5, 5);
				gbc_loginButton.gridx = 4;
				gbc_loginButton.gridy = 9;
				contentPane.add(loginButton, gbc_loginButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new MainGUI();
				frame.setVisible(true);
				dispose();
			}
		});
		cancelButton.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.insets = new Insets(0, 0, 5, 5);
		gbc_cancelButton.anchor = GridBagConstraints.WEST;
		gbc_cancelButton.fill = GridBagConstraints.VERTICAL;
		gbc_cancelButton.gridx = 6;
		gbc_cancelButton.gridy = 9;
		contentPane.add(cancelButton, gbc_cancelButton);
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
