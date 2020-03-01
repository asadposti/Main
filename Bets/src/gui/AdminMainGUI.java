package gui;

/**
 * @author Software Engineering teachers
 */


import javax.swing.*;

import domain.Event;
import domain.User;
import businessLogic.BLFacade;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class AdminMainGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private User user; //logged user
	
	private JPanel jContentPane = null;
	private JButton JButtonCheckProfile = null;
	private JButton jButtonQueryQueries = null;
	private JButton JButtonManageUsers = null;
	private JButton JButtonCreateQueries = null;
	private JButton  btnLogOut = null;
	private JButton  btnRegister = null; 
	private static BLFacade appFacadeInterface;

	public static BLFacade getBusinessLogic(){
		return appFacadeInterface;
	}

	public static void setBussinessLogic (BLFacade afi){
		appFacadeInterface=afi;
	}
	protected JLabel jLabelSelectOption;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JPanel panel;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * This is the default constructor
	 */
	public AdminMainGUI(User u) {
		super();
		this.user = u;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					//if (ConfigXML.getInstance().isBusinessLogicLocal()) facade.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("Error: "+e1.toString()+" , probably problems with Business Logic or Database");
				}
				System.exit(1);
			}
		});

		initialize();
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}



	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		// this.setSize(271, 295);
		this.setBounds(600, 200, 495, 290);
		this.setContentPane(getJContentPane());
		this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("MainTitle"));
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			
			
			GroupLayout gl_jContentPane = new GroupLayout(jContentPane);
			gl_jContentPane.setHorizontalGroup(
				gl_jContentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(getLblNewLabel(), GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE)
					.addComponent(getPanel(), GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_jContentPane.createSequentialGroup()
						.addContainerGap(13, Short.MAX_VALUE)
						.addGroup(gl_jContentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(getBoton4(), GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
							.addComponent(getBoton5(), GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jContentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_jContentPane.createSequentialGroup()
								.addGap(10)
								.addComponent(getBoton2(), GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
							.addGroup(gl_jContentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(getBoton3(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addContainerGap())
			);
			gl_jContentPane.setVerticalGroup(
				gl_jContentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_jContentPane.createSequentialGroup()
						.addGap(1)
						.addComponent(getLblNewLabel(), GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_jContentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(getBoton4(), GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addComponent(getBoton3(), GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_jContentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(getBoton5(), GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addComponent(getBoton2(), GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getPanel(), GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
			);
			jContentPane.setLayout(gl_jContentPane);
		}
		return jContentPane;
	}


	/**
	 * This method initializes boton2
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBoton2() {
		if (JButtonCheckProfile == null) {
			JButtonCheckProfile = new JButton();
			JButtonCheckProfile.setText(ResourceBundle.getBundle("Etiquetas").getString("CheckProfile")); //$NON-NLS-1$ //$NON-NLS-2$
			JButtonCheckProfile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			JButtonCheckProfile.setEnabled(true);
			if (JButtonCheckProfile.isEnabled()) {
				JButtonCheckProfile.setText(ResourceBundle.getBundle("Etiquetas").getString("CheckProfile"));
				JButtonCheckProfile.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						BLFacade facade=MainGUI.getBusinessLogic();
						//Vector<Event> events=facade.getAllEvents();
						JDialog a = new UserProfileGUI(user);
						a.setVisible(true);
					}
				});
			}

		}
		return JButtonCheckProfile;
	}

	/**
	 * This method initializes boton3
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBoton3() {
		if (jButtonQueryQueries == null) {
			jButtonQueryQueries = new JButton();
			jButtonQueryQueries.setText(ResourceBundle.getBundle("Etiquetas").getString("QueryQueries")); //$NON-NLS-1$ //$NON-NLS-2$
			jButtonQueryQueries.setEnabled(true);
			jButtonQueryQueries.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JDialog a = new UserFindQuestionsGUI(user);

					a.setVisible(true);
				}
			});
		}
		return jButtonQueryQueries;
	}

	/**
	 * This method initializes boton4
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBoton4() {
		if (JButtonCreateQueries == null) {
			JButtonCreateQueries = new JButton();
			JButtonCreateQueries.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateQuery")); //$NON-NLS-1$ //$NON-NLS-2$
			JButtonCreateQueries.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			JButtonCreateQueries.setEnabled(true);
			if (JButtonCreateQueries.isEnabled()) {
				JButtonCreateQueries.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateQuery"));
				JButtonCreateQueries.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						BLFacade facade=MainGUI.getBusinessLogic();
						//Vector<Event> events=facade.getAllEvents();
						JDialog a = new CreateQuestionGUI(new Vector<Event>());
						a.setVisible(true);
					}
				});
			}

		}
		return JButtonCreateQueries;
	}
	
	/**
	 * This method initializes boton5
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBoton5() {
		if (JButtonManageUsers == null) {
			JButtonManageUsers = new JButton();
			JButtonManageUsers.setText(ResourceBundle.getBundle("Etiquetas").getString("ManageUsers")); //$NON-NLS-1$ //$NON-NLS-2$
			JButtonManageUsers.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JDialog a = new UserManagementGUI();

					a.setVisible(true);
				}
			});
		}
		return JButtonManageUsers;
	}
	



	private JLabel getLblNewLabel() {
		if (jLabelSelectOption == null) {
			jLabelSelectOption = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("SelectOption"));
			jLabelSelectOption.setFont(new Font("Tahoma", Font.BOLD, 13));
			jLabelSelectOption.setForeground(Color.BLACK);
			jLabelSelectOption.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabelSelectOption;
	}
	private JRadioButton getRdbtnNewRadioButton() {
		if (rdbtnNewRadioButton == null) {
			rdbtnNewRadioButton = new JRadioButton("English");
			rdbtnNewRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Locale.setDefault(new Locale("en"));
					System.out.println("Locale: "+Locale.getDefault());
					redibujar();				}
			});
			buttonGroup.add(rdbtnNewRadioButton);
		}
		return rdbtnNewRadioButton;
	}
	private JRadioButton getRdbtnNewRadioButton_1() {
		if (rdbtnNewRadioButton_1 == null) {
			rdbtnNewRadioButton_1 = new JRadioButton("Euskara");
			rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Locale.setDefault(new Locale("eus"));
					System.out.println("Locale: "+Locale.getDefault());
					redibujar();				}
			});
			buttonGroup.add(rdbtnNewRadioButton_1);
		}
		return rdbtnNewRadioButton_1;
	}
	private JRadioButton getRdbtnNewRadioButton_2() {
		if (rdbtnNewRadioButton_2 == null) {
			rdbtnNewRadioButton_2 = new JRadioButton("Castellano");
			rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Locale.setDefault(new Locale("es"));
					System.out.println("Locale: "+Locale.getDefault());
					redibujar();
				}
			});
			buttonGroup.add(rdbtnNewRadioButton_2);
		}
		return rdbtnNewRadioButton_2;
	}
	
	public  void hideLogInRegister() {
		btnLogOut.setEnabled(false);
		btnLogOut.setVisible(false);
		btnRegister.setEnabled(false);
		btnRegister.setVisible(false);
	}
	
	private JButton getBtnLogOut() {
		if (btnLogOut == null) {
			btnLogOut = new JButton(ResourceBundle.getBundle("Etiquetas").getString("LogOut")); //$NON-NLS-1$ //$NON-NLS-2$
			btnLogOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JFrame user = new MainGUI();
					user.setVisible(true);
					AdminMainGUI.super.dispose();
				}
			});
			btnLogOut.setBounds(36, 36, 117, 25);
		}
		return btnLogOut;
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getRdbtnNewRadioButton_1());
			panel.add(getRdbtnNewRadioButton_2());
			panel.add(getRdbtnNewRadioButton());
			panel.add(getBtnLogOut());
		}
		return panel;
	}

	private void redibujar() {
		jLabelSelectOption.setText(ResourceBundle.getBundle("Etiquetas").getString("SelectOption"));
		jButtonQueryQueries.setText(ResourceBundle.getBundle("Etiquetas").getString("QueryQueries"));
		JButtonCheckProfile.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateQuery"));
		this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("MainTitle"));
	}
} // @jve:decl-index=0:visual-constraint="0,0"

