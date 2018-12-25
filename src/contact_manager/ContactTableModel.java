package contact_manager;


import contact_manager.ContactForm;

import java.util.List;

import javax.swing.table.AbstractTableModel;
public class ContactTableModel extends AbstractTableModel  {
	public static final int OBJECT_COL = -1;
	private static final int  FIRST_NAME_COL=0;
	private static final int MIDDLE_NAME_COL=1;
	private static final int LAST_NAME_COL=2;
	private static final int ADD_RES_COL=3;
	private static final int PHO_RES_COL=4;
	private static final int BDA_RES_COL=5;



	private String[] columnNames= {"First Name","Middle Name", "Last Name", "Address","Phone","Birthday"};
	private List<ContactForm> contacts;

	public ContactTableModel(List<ContactForm> theContacts)
	{
		contacts=theContacts;
	}

	@Override
	public int getColumnCount()
	{
		return columnNames.length;
	}

	@Override
	public int getRowCount()
	{
		return contacts.size();
	}

	@Override
	public String getColumnName(int col)

	{
		return columnNames[col];
	}

	
	@Override
	public Object getValueAt(int row ,int col)
	{
		ContactForm temp=contacts.get(row);
		switch(col)
		{
		case FIRST_NAME_COL:
			return temp.getFirstName();
		case MIDDLE_NAME_COL:
			return temp.getMiddleName();
		case LAST_NAME_COL:
			return temp.getLastName();
		case ADD_RES_COL:
			return temp.getAddresses();
		case PHO_RES_COL:
			return temp.getPhones();
		case BDA_RES_COL:
			return temp.getBD();
		case OBJECT_COL:
			return temp;
		default:
			return temp.getLastName();
		}

	}
	
@Override

	public Class getColumnClass(int c)
	{
		return getValueAt(0,c).getClass();
	}

}
