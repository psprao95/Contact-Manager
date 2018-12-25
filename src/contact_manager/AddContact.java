package contact_manager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;


import contact_manager.ContactForm;
public class AddContact extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField fNametextField;

	/**
	 * Launch the application.
	 */
	private ContactDAO contactDAO;
	private ContactManagerApp contactManagerApp;
	private JTextField mnameTextField;
	private JTextField lnameTextField;
	private JTextField hzipTextField;
	private JTextField hcitytextField;
	private JTextField dformatTextField;
	private JTextField hstateTextField;
	private JTextField bdayTextField;
	private JTextField homephoneTextField;
	private JTextField homeareaTextField;
	
	
	
	private ContactForm prevContact=null;
	private boolean updateMode=false;
	private JTextField hstreettextField;
	private JLabel lblWorkStreetCity;
	private JLabel lblStateZip_1;
	private JLabel lblWorkPhone;
	private JTextField workareatextField;
	private JTextField workphonetextField;
	private JLabel lblCellPhoneArea;
	private JTextField wstreetTextField;
	private JTextField wcitytextField;
	private JTextField wstatetextField;
	private JTextField cellareaTextField;
	private JTextField wziptextField;
	private JTextField cellphoneTextField;
	
	
	
	public AddContact(ContactManagerApp theContactManagerApp,ContactDAO theContactDAO,ContactForm theContact,boolean theUpdateMode) throws Exception
	{
		this();
		contactDAO = theContactDAO;
		contactManagerApp = theContactManagerApp;
		prevContact=theContact;
		updateMode=theUpdateMode;
		if(updateMode) {
			setTitle("Modify Employee");
			int id=prevContact.getID();
			ContactForm temp= theContactDAO.getSpecificContact(id);
			populateGui(temp);
			
		}
	}
	private void populateGui(ContactForm temp) {

		fNametextField.setText(temp.getFirstName());
		mnameTextField.setText(temp.getMiddleName());
		lnameTextField.setText(temp.getLastName());
		hstreettextField.setText(temp.getHomeStreet());
		hcitytextField.setText(temp.getHomeCity());
		hstateTextField.setText(temp.getHomeState());
		hzipTextField.setText(temp.getHomeZIP());
		wstreetTextField.setText(temp.getWorkStreet());
		wcitytextField.setText(temp.getWorkCity());
		wstatetextField.setText(temp.getWorkState());
		wziptextField.setText(temp.getWorkZIP());
		cellareaTextField.setText(temp.getCellAreaCode());
		cellphoneTextField.setText(temp.getCellPhone());
		homeareaTextField.setText(temp.getHomeAreaCode());
		homephoneTextField.setText(temp.getHomePhone());
		workareatextField.setText(temp.getWorkAreaCode());
		workphonetextField.setText(temp.getWorkPhone());
		dformatTextField.setText(temp.getFormat());
		bdayTextField.setText(temp.getBD());
	}
	

	
	public AddContact(ContactManagerApp theContactManagerApp,ContactDAO theContactDAO)
	{
		this();
		contactDAO = theContactDAO;
		contactManagerApp = theContactManagerApp;
	}

	/**
	 * Create the dialog.
	 */
	public AddContact() {
		setTitle("Add New Contact");
		setBounds(100, 100, 565, 497);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblFirstName = new JLabel("First Name");
			GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
			gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
			gbc_lblFirstName.gridx = 0;
			gbc_lblFirstName.gridy = 0;
			contentPanel.add(lblFirstName, gbc_lblFirstName);
		}
		{
			fNametextField = new JTextField();
			GridBagConstraints gbc_fNametextField = new GridBagConstraints();
			gbc_fNametextField.gridwidth = 3;
			gbc_fNametextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_fNametextField.insets = new Insets(0, 0, 5, 5);
			gbc_fNametextField.gridx = 1;
			gbc_fNametextField.gridy = 0;
			contentPanel.add(fNametextField, gbc_fNametextField);
			fNametextField.setColumns(10);
		}
		{
			JLabel lblMiddleName = new JLabel("Middle Name");
			GridBagConstraints gbc_lblMiddleName = new GridBagConstraints();
			gbc_lblMiddleName.insets = new Insets(0, 0, 5, 5);
			gbc_lblMiddleName.gridx = 0;
			gbc_lblMiddleName.gridy = 1;
			contentPanel.add(lblMiddleName, gbc_lblMiddleName);
		}
		{
			mnameTextField = new JTextField();
			GridBagConstraints gbc_mnameTextField = new GridBagConstraints();
			gbc_mnameTextField.gridwidth = 3;
			gbc_mnameTextField.insets = new Insets(0, 0, 5, 5);
			gbc_mnameTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_mnameTextField.gridx = 1;
			gbc_mnameTextField.gridy = 1;
			contentPanel.add(mnameTextField, gbc_mnameTextField);
			mnameTextField.setColumns(10);
		}
		{
			JLabel lblLastName = new JLabel("Last Name");
			GridBagConstraints gbc_lblLastName = new GridBagConstraints();
			gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
			gbc_lblLastName.gridx = 0;
			gbc_lblLastName.gridy = 2;
			contentPanel.add(lblLastName, gbc_lblLastName);
		}
		{
			lnameTextField = new JTextField();
			GridBagConstraints gbc_lnameTextField = new GridBagConstraints();
			gbc_lnameTextField.gridwidth = 3;
			gbc_lnameTextField.insets = new Insets(0, 0, 5, 5);
			gbc_lnameTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_lnameTextField.gridx = 1;
			gbc_lnameTextField.gridy = 2;
			contentPanel.add(lnameTextField, gbc_lnameTextField);
			lnameTextField.setColumns(10);
		}
		{
			JLabel lblStreetCity = new JLabel("Home Address: Street, City");
			GridBagConstraints gbc_lblStreetCity = new GridBagConstraints();
			gbc_lblStreetCity.insets = new Insets(0, 0, 5, 5);
			gbc_lblStreetCity.gridx = 0;
			gbc_lblStreetCity.gridy = 3;
			contentPanel.add(lblStreetCity, gbc_lblStreetCity);
		}
		{
			hstreettextField = new JTextField();
			GridBagConstraints gbc_hstreettextField = new GridBagConstraints();
			gbc_hstreettextField.gridwidth = 3;
			gbc_hstreettextField.insets = new Insets(0, 0, 5, 5);
			gbc_hstreettextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_hstreettextField.gridx = 1;
			gbc_hstreettextField.gridy = 3;
			contentPanel.add(hstreettextField, gbc_hstreettextField);
			hstreettextField.setColumns(10);
		}
		{
			hcitytextField = new JTextField();
			GridBagConstraints gbc_hcitytextField = new GridBagConstraints();
			gbc_hcitytextField.gridwidth = 2;
			gbc_hcitytextField.insets = new Insets(0, 0, 5, 0);
			gbc_hcitytextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_hcitytextField.gridx = 4;
			gbc_hcitytextField.gridy = 3;
			contentPanel.add(hcitytextField, gbc_hcitytextField);
			hcitytextField.setColumns(10);
		}
		{
			JLabel lblStateZip = new JLabel("Home Address: State, Zip");
			GridBagConstraints gbc_lblStateZip = new GridBagConstraints();
			gbc_lblStateZip.insets = new Insets(0, 0, 5, 5);
			gbc_lblStateZip.gridx = 0;
			gbc_lblStateZip.gridy = 4;
			contentPanel.add(lblStateZip, gbc_lblStateZip);
		}
		{
			hstateTextField = new JTextField();
			GridBagConstraints gbc_hstateTextField = new GridBagConstraints();
			gbc_hstateTextField.gridwidth = 2;
			gbc_hstateTextField.insets = new Insets(0, 0, 5, 5);
			gbc_hstateTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_hstateTextField.gridx = 1;
			gbc_hstateTextField.gridy = 4;
			contentPanel.add(hstateTextField, gbc_hstateTextField);
			hstateTextField.setColumns(10);
		}
		{
			hzipTextField = new JTextField();
			GridBagConstraints gbc_hzipTextField = new GridBagConstraints();
			gbc_hzipTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_hzipTextField.insets = new Insets(0, 0, 5, 5);
			gbc_hzipTextField.gridx = 3;
			gbc_hzipTextField.gridy = 4;
			contentPanel.add(hzipTextField, gbc_hzipTextField);
			hzipTextField.setColumns(10);
		}
		{
			lblWorkStreetCity = new JLabel("Work Address: Street, City");
			GridBagConstraints gbc_lblWorkStreetCity = new GridBagConstraints();
			gbc_lblWorkStreetCity.insets = new Insets(0, 0, 5, 5);
			gbc_lblWorkStreetCity.gridx = 0;
			gbc_lblWorkStreetCity.gridy = 5;
			contentPanel.add(lblWorkStreetCity, gbc_lblWorkStreetCity);
		}
		{
			wstreetTextField = new JTextField();
			GridBagConstraints gbc_wstreetTextField = new GridBagConstraints();
			gbc_wstreetTextField.gridwidth = 3;
			gbc_wstreetTextField.insets = new Insets(0, 0, 5, 5);
			gbc_wstreetTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_wstreetTextField.gridx = 1;
			gbc_wstreetTextField.gridy = 5;
			contentPanel.add(wstreetTextField, gbc_wstreetTextField);
			wstreetTextField.setColumns(10);
		}
		{
			wcitytextField = new JTextField();
			GridBagConstraints gbc_wcitytextField = new GridBagConstraints();
			gbc_wcitytextField.gridwidth = 2;
			gbc_wcitytextField.insets = new Insets(0, 0, 5, 0);
			gbc_wcitytextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_wcitytextField.gridx = 4;
			gbc_wcitytextField.gridy = 5;
			contentPanel.add(wcitytextField, gbc_wcitytextField);
			wcitytextField.setColumns(10);
		}
		{
			lblStateZip_1 = new JLabel("Work Address: State, Zip");
			GridBagConstraints gbc_lblStateZip_1 = new GridBagConstraints();
			gbc_lblStateZip_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblStateZip_1.gridx = 0;
			gbc_lblStateZip_1.gridy = 6;
			contentPanel.add(lblStateZip_1, gbc_lblStateZip_1);
		}
		{
			wstatetextField = new JTextField();
			GridBagConstraints gbc_wstatetextField = new GridBagConstraints();
			gbc_wstatetextField.gridwidth = 2;
			gbc_wstatetextField.insets = new Insets(0, 0, 5, 5);
			gbc_wstatetextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_wstatetextField.gridx = 1;
			gbc_wstatetextField.gridy = 6;
			contentPanel.add(wstatetextField, gbc_wstatetextField);
			wstatetextField.setColumns(10);
		}
		{
			wziptextField = new JTextField();
			GridBagConstraints gbc_wziptextField = new GridBagConstraints();
			gbc_wziptextField.insets = new Insets(0, 0, 5, 5);
			gbc_wziptextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_wziptextField.gridx = 3;
			gbc_wziptextField.gridy = 6;
			contentPanel.add(wziptextField, gbc_wziptextField);
			wziptextField.setColumns(10);
		}
		{
			lblCellPhoneArea = new JLabel("Cell Phone: Area Code, Number");
			GridBagConstraints gbc_lblCellPhoneArea = new GridBagConstraints();
			gbc_lblCellPhoneArea.fill = GridBagConstraints.VERTICAL;
			gbc_lblCellPhoneArea.insets = new Insets(0, 0, 5, 5);
			gbc_lblCellPhoneArea.gridx = 0;
			gbc_lblCellPhoneArea.gridy = 7;
			contentPanel.add(lblCellPhoneArea, gbc_lblCellPhoneArea);
		}
		{
			cellareaTextField = new JTextField();
			GridBagConstraints gbc_cellareaTextField = new GridBagConstraints();
			gbc_cellareaTextField.gridwidth = 2;
			gbc_cellareaTextField.insets = new Insets(0, 0, 5, 5);
			gbc_cellareaTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_cellareaTextField.gridx = 1;
			gbc_cellareaTextField.gridy = 7;
			contentPanel.add(cellareaTextField, gbc_cellareaTextField);
			cellareaTextField.setColumns(10);
		}
		{
			cellphoneTextField = new JTextField();
			GridBagConstraints gbc_cellphoneTextField = new GridBagConstraints();
			gbc_cellphoneTextField.gridwidth = 2;
			gbc_cellphoneTextField.insets = new Insets(0, 0, 5, 0);
			gbc_cellphoneTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_cellphoneTextField.gridx = 3;
			gbc_cellphoneTextField.gridy = 7;
			contentPanel.add(cellphoneTextField, gbc_cellphoneTextField);
			cellphoneTextField.setColumns(10);
		}
		{
			JLabel lblArea = new JLabel("Home Phone: Area Code, Number");
			GridBagConstraints gbc_lblArea = new GridBagConstraints();
			gbc_lblArea.insets = new Insets(0, 0, 5, 5);
			gbc_lblArea.anchor = GridBagConstraints.EAST;
			gbc_lblArea.gridx = 0;
			gbc_lblArea.gridy = 8;
			contentPanel.add(lblArea, gbc_lblArea);
		}
		{
			homeareaTextField = new JTextField();
			GridBagConstraints gbc_homeareaTextField = new GridBagConstraints();
			gbc_homeareaTextField.gridwidth = 2;
			gbc_homeareaTextField.insets = new Insets(0, 0, 5, 5);
			gbc_homeareaTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_homeareaTextField.gridx = 1;
			gbc_homeareaTextField.gridy = 8;
			contentPanel.add(homeareaTextField, gbc_homeareaTextField);
			homeareaTextField.setColumns(10);
		}
		{
			homephoneTextField = new JTextField();
			GridBagConstraints gbc_homephoneTextField = new GridBagConstraints();
			gbc_homephoneTextField.gridwidth = 2;
			gbc_homephoneTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_homephoneTextField.insets = new Insets(0, 0, 5, 0);
			gbc_homephoneTextField.gridx = 3;
			gbc_homephoneTextField.gridy = 8;
			contentPanel.add(homephoneTextField, gbc_homephoneTextField);
			homephoneTextField.setColumns(10);
		}
		{
			lblWorkPhone = new JLabel("Work Phone : Area Code, Number");
			GridBagConstraints gbc_lblWorkPhone = new GridBagConstraints();
			gbc_lblWorkPhone.anchor = GridBagConstraints.EAST;
			gbc_lblWorkPhone.insets = new Insets(0, 0, 5, 5);
			gbc_lblWorkPhone.gridx = 0;
			gbc_lblWorkPhone.gridy = 9;
			contentPanel.add(lblWorkPhone, gbc_lblWorkPhone);
		}
		{
			workareatextField = new JTextField();
			GridBagConstraints gbc_workareatextField = new GridBagConstraints();
			gbc_workareatextField.gridwidth = 2;
			gbc_workareatextField.insets = new Insets(0, 0, 5, 5);
			gbc_workareatextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_workareatextField.gridx = 1;
			gbc_workareatextField.gridy = 9;
			contentPanel.add(workareatextField, gbc_workareatextField);
			workareatextField.setColumns(10);
		}
		{
			workphonetextField = new JTextField();
			GridBagConstraints gbc_workphonetextField = new GridBagConstraints();
			gbc_workphonetextField.gridwidth = 2;
			gbc_workphonetextField.insets = new Insets(0, 0, 5, 0);
			gbc_workphonetextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_workphonetextField.gridx = 3;
			gbc_workphonetextField.gridy = 9;
			contentPanel.add(workphonetextField, gbc_workphonetextField);
			workphonetextField.setColumns(10);
		}
		{
			JLabel lblBirthday = new JLabel("Date Format, Birthday");
			GridBagConstraints gbc_lblBirthday = new GridBagConstraints();
			gbc_lblBirthday.insets = new Insets(0, 0, 5, 5);
			gbc_lblBirthday.gridx = 0;
			gbc_lblBirthday.gridy = 10;
			contentPanel.add(lblBirthday, gbc_lblBirthday);
		}
		{
			dformatTextField = new JTextField();
			GridBagConstraints gbc_dformatTextField = new GridBagConstraints();
			gbc_dformatTextField.gridwidth = 2;
			gbc_dformatTextField.insets = new Insets(0, 0, 5, 5);
			gbc_dformatTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_dformatTextField.gridx = 1;
			gbc_dformatTextField.gridy = 10;
			contentPanel.add(dformatTextField, gbc_dformatTextField);
			dformatTextField.setColumns(10);
		}
		{
			bdayTextField = new JTextField();
			GridBagConstraints gbc_bdayTextField = new GridBagConstraints();
			gbc_bdayTextField.insets = new Insets(0, 0, 5, 0);
			gbc_bdayTextField.gridwidth = 2;
			gbc_bdayTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_bdayTextField.gridx = 3;
			gbc_bdayTextField.gridy = 10;
			contentPanel.add(bdayTextField, gbc_bdayTextField);
			bdayTextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						saveContact();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						}
					
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	protected void saveContact()
	{
		String f=fNametextField.getText();
		String m=mnameTextField.getText();
		String l=lnameTextField.getText();
		String hstreet=hstreettextField.getText();
		String hcity=hcitytextField.getText();
		String hstate=hstateTextField.getText();
		String hzip=hzipTextField.getText();
		String wstreet=wstreetTextField.getText();
		String wcity=wcitytextField.getText();
		String wstate=wstatetextField.getText();
		String wzip=wziptextField.getText();
		String carea=cellareaTextField.getText();
		String cphone=cellphoneTextField.getText();
		String harea=homeareaTextField.getText();
		String hphone=homephoneTextField.getText();
		String warea=workareatextField.getText();
		String wphone=workphonetextField.getText();

		String format=dformatTextField.getText();
		String bday=bdayTextField.getText();
		ContactForm temp;
		try
		
		{
		if(updateMode)
			{
			temp= prevContact;
			temp.setFirstName(f);
			temp.setMiddleName(m);
			temp.setLastName(l);
			temp.setHomeStreet(hstreet);
			temp.setHomeCity(hcity);
			temp.setHomeState(hstate);
			temp.setHomeZIP(hzip);
			temp.setWorkStreet(wstreet);
			temp.setWorkCity(wcity);
			temp.setWorkState(wstate);
			temp.setWorkZIP(wzip);
			temp.setCellAreaCode(carea);
			temp.setCellPhone(cphone);
			temp.setHomeAreaCode(harea);
			temp.setHomePhone(hphone);
			temp.setWorkAreaCode(warea);
			temp.setWorkPhone(wphone);
			temp.setFormat(format);
			temp.setBD(bday);
			}
			
		else
		{
			temp = new ContactForm(f,m,l,hstreet,hcity,hstate,hzip,wstreet,wcity,wstate,wzip,carea,cphone,harea,hphone,warea,wphone,format,bday);
		}
		
		if(updateMode)
			{
				contactDAO.modifyContact(temp);
				setVisible(false);
				dispose();
				contactManagerApp.RefreshEmployeesView();
				JOptionPane.showMessageDialog(contactManagerApp,"Contact modified succesfully!","Contact Modified",JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				
			contactDAO.addContact(temp);
			setVisible(false);
			dispose();
			
			contactManagerApp.RefreshEmployeesView();
			JOptionPane.showMessageDialog(contactManagerApp,"Contact added succesfully!","Contact Added",JOptionPane.INFORMATION_MESSAGE);
			}
	}
		catch(Exception exc)
		{
			JOptionPane.showMessageDialog(contactManagerApp, "Error: "+exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
