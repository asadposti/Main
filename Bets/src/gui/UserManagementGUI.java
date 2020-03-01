package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalFileChooserUI.FilterComboBoxRenderer;

import businessLogic.BLFacade;
import domain.User;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class UserManagementGUI extends JDialog{

	private JPanel contentPane;
	private JTextField searchField;
	
	private JButton btnSearch = new JButton();
	String[] filters = { "ID", "Name", "Surname", "E-mail"};
	private JComboBox filterComboBox = new JComboBox(filters);
	
	private String[] columnNamesUsers = new String[] {
			ResourceBundle.getBundle("Etiquetas").getString("ID"), 
			ResourceBundle.getBundle("Etiquetas").getString("Name"), 
			ResourceBundle.getBundle("Etiquetas").getString("Surname"), 
			ResourceBundle.getBundle("Etiquetas").getString("Email"), 
			ResourceBundle.getBundle("Etiquetas").getString("Status"), 
			"", ""
	};
	
	private NonEditableTableModel userTableModel = new NonEditableTableModel(null, columnNamesUsers);
	private JTable userTable;

	List<User> searchresult;
	
	
	
	
	
	/** 
	 * Create the frame.
	 */	
		public UserManagementGUI()
		{
			try
			{
				jbInit();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
		private void jbInit() throws Exception{
		
		this.setModal(true);
		
			userTable = new JTable();
			userTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Name", "Surname", "E-mail", "Status"
				}
			));
		
		

		BLFacade facade=MainGUI.getBusinessLogic();

				btnSearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						//restart model
						userTableModel.setDataVector(null, columnNamesUsers);
						userTableModel.setColumnCount(7); 
						
						String searchText = searchField.getText();
						int filter = filterComboBox.getSelectedIndex();
						
						//perform search and create the table model with the results
						List<domain.User> searchResult=facade.searchByCriteria(searchText,filter);
						for (domain.User u : searchResult){
							Vector<Object> row = new Vector<Object>();
							row.add(u.getID());
							row.add(u.getName());
							row.add(u.getSurname());
							row.add(u.getEmail());
							if(u.isAdmin()) {
								row.add("Admin.");
							}
							else {
								row.add("User");
							}
							try {
								row.add(new ImageIcon(ImageIO.read(new File("images/edit1.png"))));
								row.add(new ImageIcon(ImageIO.read(new File("images/delete.png"))));
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							userTableModel.addRow(row);		
						}
						userTable.getColumnModel().getColumn(0).setPreferredWidth(75);
						userTable.getColumnModel().getColumn(1).setPreferredWidth(75);
						userTable.getColumnModel().getColumn(2).setPreferredWidth(75);
						userTable.getColumnModel().getColumn(3).setPreferredWidth(160);
						userTable.getColumnModel().getColumn(4).setPreferredWidth(50);
						userTable.getColumnModel().getColumn(5).setPreferredWidth(20);
						userTable.getColumnModel().getColumn(6).setPreferredWidth(20);
						
						Action delete = new AbstractAction()
						{
						    public void actionPerformed(ActionEvent e)
						    {
						        facade.removeUser((String)userTable.getValueAt(userTable.getSelectedRow(), 0));
						        int modelRow = Integer.valueOf( e.getActionCommand() );
						        ((DefaultTableModel)userTable.getModel()).removeRow(modelRow);
						        
						    }
						};
						Action update = new AbstractAction()
						{
						    public void actionPerformed(ActionEvent e)
						    {
						    	int row = userTable.getSelectedRow();
						    	EditUserGUI j = new EditUserGUI((String)userTable.getValueAt(row, 0), (String)userTable.getValueAt(row, 1), 
						    			(String)userTable.getValueAt(row, 2),(String)userTable.getValueAt(row, 3), (String)userTable.getValueAt(row, 4));
						    	j.setVisible(true);
						    	
						    	//update row with new info
						    	String[] newData = j.newData();
						    	userTable.setValueAt(newData[0], row, 0);
						    	userTable.setValueAt(newData[1], row, 1);
						    	userTable.setValueAt(newData[2], row, 2);
						    	userTable.setValueAt(newData[3], row, 3);
						    	userTable.setValueAt(newData[4], row, 4);
						    }
						};

						ButtonColumn updateButtonColumn = new ButtonColumn(userTable, update, 5);
						ButtonColumn deleteButtonColumn = new ButtonColumn(userTable, delete, 6);
						deleteButtonColumn.setMnemonic(KeyEvent.VK_D);
					}
				});
				
			

		
		
		userTable.setModel(userTableModel);
		userTable.getTableHeader().setReorderingAllowed(false);
		userTable.getTableHeader().setResizingAllowed(false);
		userTable.setRowHeight(25);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 881, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{30, 30, 30, 30, 30, 0, 20, 70, 47, 70, 20, 30, 60, 66, 20, 20, 20, 0};
		gbl_panel.rowHeights = new int[]{0, 20, 20, 0, 20, 0, 30, 30, 30, 30, 20, 0, 20, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("User management");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblSearch = new JLabel("Search:");
		GridBagConstraints gbc_lblSearch = new GridBagConstraints();
		gbc_lblSearch.anchor = GridBagConstraints.WEST;
		gbc_lblSearch.insets = new Insets(0, 0, 5, 5);
		gbc_lblSearch.gridx = 1;
		gbc_lblSearch.gridy = 3;
		panel.add(lblSearch, gbc_lblSearch);
		
		searchField = new JTextField();
		GridBagConstraints gbc_searchField = new GridBagConstraints();
		gbc_searchField.gridwidth = 3;
		gbc_searchField.insets = new Insets(0, 0, 5, 5);
		gbc_searchField.fill = GridBagConstraints.HORIZONTAL;
		gbc_searchField.gridx = 2;
		gbc_searchField.gridy = 3;
		panel.add(searchField, gbc_searchField);
		searchField.setColumns(10);
		
		
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch.gridx = 5;
		gbc_btnSearch.gridy = 3;
		panel.add(btnSearch, gbc_btnSearch);
		btnSearch.setIcon(new ImageIcon(ImageIO.read(new File("images/searchicon2.png"))));
		
		
		JLabel lblSearchBy = new JLabel("Search by:");
		GridBagConstraints gbc_lblSearchBy = new GridBagConstraints();
		gbc_lblSearchBy.insets = new Insets(0, 0, 5, 5);
		gbc_lblSearchBy.anchor = GridBagConstraints.EAST;
		gbc_lblSearchBy.gridx = 7;
		gbc_lblSearchBy.gridy = 3;
		panel.add(lblSearchBy, gbc_lblSearchBy);

		GridBagConstraints gbc_filterComboBox = new GridBagConstraints();
		gbc_filterComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_filterComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_filterComboBox.gridx = 8;
		gbc_filterComboBox.gridy = 3;

		filterComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"ID", "Name", "Surname", "E-mail"}));
		panel.add(filterComboBox, gbc_filterComboBox);
		
		JButton btnAddAUser = new JButton("Add a user");
		btnAddAUser.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				RegisterGUI j = new RegisterGUI(true);
				j.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnAddAUser = new GridBagConstraints();
		gbc_btnAddAUser.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddAUser.gridx = 13;
		gbc_btnAddAUser.gridy = 3;
		panel.add(btnAddAUser, gbc_btnAddAUser);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.gridwidth = 14;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		panel.add(scrollPane, gbc_scrollPane);
		
		
		userTable.getColumnModel().getColumn(3).setPreferredWidth(80);
		userTable.getColumnModel().getColumn(3).setMinWidth(160);
		scrollPane.setViewportView(userTable);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.gridwidth = 2;
		gbc_cancelButton.insets = new Insets(0, 0, 5, 5);
		gbc_cancelButton.gridx = 13;
		gbc_cancelButton.gridy = 11;
		panel.add(cancelButton, gbc_cancelButton);
	}
		
	
		public class NonEditableTableModel extends DefaultTableModel
		{	private static final long serialVersionUID = 1L;

			public NonEditableTableModel(Object[][] data, Object[] columnNames) {
				super(data, columnNames);
			}

			public boolean isCellEditable (int row, int column)
			   {
					if(column == 5 || column==6) {
						return true;
					}
			       return false;
			   }
		}
}
