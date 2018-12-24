package contact_manager;

import java.util.*;
import java.sql.*;
import java.io.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import contact_manager.ContactForm;

public class ContactDAO {
	
	private int crecords;
	private int check;
	private String f,m,l,hstreet,hcity,hstate,hzip,wstreet,wcity,wstate,wzip,carea,cphone,harea,hphone,warea,wphone,dformat,date;

	private Connection myConn;

	public ContactDAO() throws Exception{
		String user="root";
		String password="SIDdharth_85";
		String dburl="jdbc:mysql://localhost:3306/contact_list?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


		 myConn = DriverManager.getConnection(dburl,user,password);
	System.out.println("Database connected successfully");
	}



	
	// Method for getting all contacts in the database
	public List<ContactForm> getAllContacts() throws Exception
	{
		List<ContactForm> manager = new ArrayList<>();
		Statement myStmt=null;
		ResultSet myRs=null;

		try
		{
			myStmt=myConn.createStatement();
			myRs=myStmt.executeQuery("select C.contact_id,C.Fname,C.Mname,C.Lname,\n" + 
					"IFNULL(group_concat(Distinct concat(A.address_type,': ',A.address_street,',',A.city, ',',A.state, ',',A.zipcode,' \\n')),\"\") as Address,\n" + 
					"IFNULL(group_concat(Distinct concat(P.phone_type,': ',P.area_code,',',P.pnumber,'\\n')) ,\"\") as Phone,\n" + 
					"IFNULL(ANY_VALUE(D.date_birth),\"\") as  Birthday\n" + 
					"from (((contact C  left join address A on C.contact_id=A.contac_id)\n" + 
					"left join phone P on C.contact_id=P.c_id)\n" + 
					"left join Date D on C.contact_id=D.con_id)\n" + 
					"	group by C.contact_id");
			while(myRs.next())
			{
				ContactForm temp = convertRowtoContact(myRs);
				manager.add(temp);
			}
			return manager;
		}
		finally
		{
			close(myStmt,myRs);
		}

	}

	private ContactForm convertRowtoContact(ResultSet myRs) throws SQLException
	{
		int id= myRs.getInt("contact_id");
		String fname= myRs.getString("Fname");
		String mname= myRs.getString("Mname");
		String lname = myRs.getString("Lname");
		String addresses = myRs.getString("Address");
		String phones = myRs.getString("Phone");
		String birthday = myRs.getString("Birthday");


		ContactForm temp = new ContactForm(id,fname,mname,lname,addresses,phones,birthday);
		return temp;

	}



	public List<ContactForm> searchForContact(String l) throws Exception
	{
		List<ContactForm> list = new ArrayList<>();
		PreparedStatement myStmt=null;
		ResultSet myRs=null;

		try
		{

			myStmt=myConn.prepareStatement("select C.contact_id,C.Fname,C.Mname,C.Lname,\n" +
					"group_concat(Distinct concat(A.address_type,': ',A.address_street,',',A.city, ',',A.state, ',',A.zipcode,' \\n')) as Address,\n" +
					"group_concat(Distinct concat(P.phone_type,': ',P.area_code,'-',P.pnumber,'\\n'))  as Phone,\n" +
					"ANY_VALUE(D.date_birth) as Birthday\n" +
					"from (((contact C  left  join address A on C.contact_id=A.contac_id) \n" +
					"left  join phone P on C.contact_id=P.c_id)\n" +
					"left  join Date D on C.contact_id=con_id)\n" +
					"\n" +
					"where C.Fname like ? or C.Mname like ? or C.Lname like ?\n"
					+"or A.address_street like ? or A.city like ? or A.state like ? or A.zipcode like ? \n"
					+"or P.area_code like ? or P.pnumber like ?\n"
					+" or D.date_birth like ?\n"
					+"group by contact_id\n" +
					"");
			myStmt.setString(1, "%" + l +"%");
			myStmt.setString(2, "%" + l +"%");
			myStmt.setString(3, "%" + l +"%");
			myStmt.setString(4, "%" + l +"%");
			myStmt.setString(5, "%" + l +"%");
			myStmt.setString(6, "%" + l +"%");
			myStmt.setString(7, "%" + l +"%");
			myStmt.setString(8, "%" + l +"%");
			myStmt.setString(9, "%" + l +"%");
			myStmt.setString(10, "%" + l +"%");
			myRs=myStmt.executeQuery();

			while(myRs.next())
			{
				ContactForm temp=convertRowtoContact(myRs);
				list.add(temp);
			}
			return list;
		}
		finally
		{
			close(myStmt,myRs);
		}
	}


	private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {

		}

		if (myConn != null) {
			myConn.close();
		}
	}

	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);
	}

	
	
	
	// Method for adding a contact to our contacts database
	public void addContact(ContactForm theContact) throws Exception
	{
		PreparedStatement myStmt=null;
		Statement my=null;
		ResultSet res=null;
		try
		{
		
		
		// Adding a contact's name to the contact table in our database
		myStmt=myConn.prepareStatement("insert into contact (Fname,Mname,Lname) values (?,?,?) ");
		myStmt.setString(1, theContact.getFirstName());
		myStmt.setString(2, theContact.getMiddleName());
		myStmt.setString(3, theContact.getLastName());
		myStmt.executeUpdate();
		
		//Getting the contact id of our new contact
		my = myConn.createStatement();
		res = my.executeQuery("select max(contact_id) as total from contact");
		while(res.next())
		{
			crecords=res.getInt("total");
		}

		// Adding a home address, if it exists
		if(!theContact.getHomeStreet().equals(""))
		{
		myStmt = myConn.prepareStatement("insert into address(contac_id,address_type,address_street,city,state,zipcode) values (?,'home',?,?,?,?)");
		
		myStmt.setInt(1, crecords);
		myStmt.setString(2, theContact.getHomeStreet());
		myStmt.setString(3, theContact.getHomeCity());
		myStmt.setString(4, theContact.getHomeState());
		myStmt.setString(5, theContact.getHomeZIP());
		myStmt.executeUpdate();
		}
		
		// Adding a work address, if it exists
		if(!theContact.getWorkStreet().equals(""))
		{
		myStmt = myConn.prepareStatement("insert into address(contac_id,address_type,address_street,city,state,zipcode) values (?,'work',?,?,?,?)");
		myStmt.setInt(1, crecords);
		myStmt.setString(2, theContact.getWorkStreet());
		myStmt.setString(3, theContact.getWorkCity());
		myStmt.setString(4, theContact.getWorkState());
		myStmt.setString(5, theContact.getWorkZIP());
		myStmt.executeUpdate();
		}
		
		
		// Adding a cell phone, if it exists
		if(!theContact.getCellAreaCode().equals(""))
		{
		myStmt = myConn.prepareStatement("insert into phone(c_id,phone_type,area_code,pnumber) values (?,'cell',?,?)");	
		myStmt.setInt(1, crecords);
		myStmt.setString(2, theContact.getCellAreaCode());
		myStmt.setString(3, theContact.getCellPhone());
		myStmt.executeUpdate();
			}
		
		
		if(!theContact.getHomeAreaCode().equals("")) 
		{
			myStmt = myConn.prepareStatement("insert into phone(c_id,phone_type,area_code,pnumber) values (?,'home',?,?)");
		myStmt.setInt(1, crecords);
		myStmt.setString(2, theContact.getHomeAreaCode());
		myStmt.setString(3, theContact.getHomePhone());
		myStmt.executeUpdate();
		}
		
		
		
		if(!theContact.getWorkAreaCode().equals("")) 
		{
		myStmt = myConn.prepareStatement("insert into phone(c_id,phone_type,area_code,pnumber) values (?,'work',?,?)");
		
		myStmt.setInt(1, crecords);
		myStmt.setString(2, theContact.getWorkAreaCode());
		myStmt.setString(3, theContact.getWorkPhone());
		myStmt.executeUpdate();
		}

		if(!theContact.getFormat().equals(""))
		{
			myStmt = myConn.prepareStatement("insert into Date(con_id,date_type,date_birth) values (?,?,?,?)");
			myStmt.setInt(1, crecords);
			myStmt.setString(2, theContact.getFormat());
			myStmt.setString(3, theContact.getBD());
			myStmt.executeUpdate();
		}



		}
		finally
		{
			close(myStmt,null);
		}
	}
	
	
	
	public void modifyContact(ContactForm theContact) throws Exception
	{
		PreparedStatement myStmt=null;
		ResultSet res=null;
		
		
		// Updating contact name
		myStmt = myConn.prepareStatement("update contact set Fname=?,Mname=?,Lname=? where contact_id=?");
		myStmt.setString(1, theContact.getFirstName());
		myStmt.setString(2, theContact.getMiddleName());
		myStmt.setString(3, theContact.getLastName());
		myStmt.setInt(4, theContact.getID());
		myStmt.executeUpdate();
		
		
		// Updating home phone
		if(!theContact.getHomeAreaCode().equals(""))
		{
			myStmt=myConn.prepareStatement("select count(*) from phone where c_id=? and phone_type='home'");
			myStmt.setInt(1,theContact.getID());
			res=myStmt.executeQuery();
			while(res.next())
			{
				check=res.getInt("count(*)");
			}
			if(check==1)
			{
				myStmt = myConn.prepareStatement("update phone set area_code=?,pnumber=? where c_id=? and phone_type='home'");
				myStmt.setString(1, theContact.getHomeAreaCode());
				myStmt.setString(2, theContact.getHomePhone());
				myStmt.setInt(3, theContact.getID());
				myStmt.executeUpdate();
			}
			else
			{
				myStmt = myConn.prepareStatement("insert into phone(c_id,phone_type,area_code,pnumber) values(?,'home',?,?)");
				myStmt.setInt(1, theContact.getID());
				myStmt.setString(2, theContact.getHomeAreaCode());
				myStmt.setString(3, theContact.getHomePhone());
				
				myStmt.executeUpdate();
			}
		}
		
		
		// Updating cell phone
		if(!theContact.getCellAreaCode().equals(""))
		{
			myStmt=myConn.prepareStatement("select count(*) from phone  where c_id=? and phone_type='cell'");
			myStmt.setInt(1,theContact.getID());
			res=myStmt.executeQuery();
			while(res.next())
			{
				check=res.getInt("count(*)");
			}
			if(check==1)
			{
				myStmt = myConn.prepareStatement("update phone set area_code=?,pnumber=? where c_id=? and phone_type='cell'");
				myStmt.setString(1, theContact.getCellAreaCode());
				myStmt.setString(2, theContact.getCellPhone());
				myStmt.setInt(3, theContact.getID());
				myStmt.executeUpdate();
			}
			else
			{
				myStmt = myConn.prepareStatement("insert into phone(c_id,phone_type,area_code,pnumber) values(?,'cell',?,?)");
				myStmt.setInt(1, theContact.getID());
				myStmt.setString(2, theContact.getCellAreaCode());
				myStmt.setString(3, theContact.getCellPhone());
				
				myStmt.executeUpdate();
			}
		}
		
		
		if(!theContact.getWorkAreaCode().equals(""))
		{
			myStmt=myConn.prepareStatement("select count(*) from phone where c_id=? and phone_type='work'");
			myStmt.setInt(1,theContact.getID());
			res=myStmt.executeQuery();
			while(res.next())
			{
				check=res.getInt("count(*)");
			}
			if(check==1)
			{
				myStmt = myConn.prepareStatement("update phone set area_code=?,pnumber=? where c_id=? and phone_type='work'");
				myStmt.setString(1, theContact.getWorkAreaCode());
				myStmt.setString(2, theContact.getWorkPhone());
				myStmt.setInt(3, theContact.getID());
				myStmt.executeUpdate();
			}
			else
			{
				myStmt = myConn.prepareStatement("insert into phone(c_id,phone_type,area_code,pnumber) values(?,'work',?,?)");
				myStmt.setInt(1, theContact.getID());
				myStmt.setString(2, theContact.getWorkAreaCode());
				myStmt.setString(3, theContact.getWorkPhone());
				myStmt.executeUpdate();
			}
		}
		
		
		
		// Modifying work address
		if(!theContact.getWorkStreet().equals(""))
		{
			myStmt=myConn.prepareStatement("select count(*) from address where contac_id=? and address_type='work'");
			myStmt.setInt(1,theContact.getID());
			res=myStmt.executeQuery();
			while(res.next())
			{
				check=res.getInt("count(*)");
			}
			if(check==1)
			{
				myStmt = myConn.prepareStatement("update address set address_street=?,city=?,state=?,zipcode=? where contac_id=? and address_type='work'");
				myStmt.setString(1, theContact.getWorkStreet());
				myStmt.setString(2, theContact.getWorkCity());
				myStmt.setString(3, theContact.getWorkState());
				myStmt.setString(4, theContact.getWorkZIP());
				myStmt.setInt(5, theContact.getID());
				myStmt.executeUpdate();
			}
			else
			{
				myStmt = myConn.prepareStatement("insert into address(contac_id,address_type,address_street,city,state,zipcode) values(?,'work',?,?,?,?)");
				myStmt.setInt(1, theContact.getID());
				myStmt.setString(2, theContact.getWorkStreet());
				myStmt.setString(3, theContact.getWorkCity());
				myStmt.setString(4, theContact.getWorkState());
				myStmt.setString(5, theContact.getWorkZIP());
				
				myStmt.executeUpdate();
			}
		}
		
		
		// Mpdifying home work address
		if(!theContact.getHomeStreet().equals(""))
		{
			myStmt=myConn.prepareStatement("select count(*) from address where contac_id=? and address_type='home'");
			myStmt.setInt(1,theContact.getID());
			res=myStmt.executeQuery();
			while(res.next())
			{
				check=res.getInt("count(*)");
			}
			if(check==1)
			{
				myStmt = myConn.prepareStatement("update address set address_street=?,city=?,state=?,zipcode=? where contac_id=? and address_type='home'");
				myStmt.setString(1, theContact.getHomeStreet());
				myStmt.setString(2, theContact.getHomeCity());
				myStmt.setString(3, theContact.getHomeState());
				myStmt.setString(4, theContact.getHomeZIP());
				myStmt.setInt(5, theContact.getID());
				myStmt.executeUpdate();
			}
			else
			{
				myStmt = myConn.prepareStatement("insert into address(contac_id,address_type,address_street,city,state,zipcode) values(?,'home',?,?,?,?)");
				myStmt.setInt(1, theContact.getID());
				myStmt.setString(2, theContact.getHomeStreet());
				myStmt.setString(3, theContact.getHomeCity());
				myStmt.setString(4, theContact.getHomeState());
				myStmt.setString(5, theContact.getHomeZIP());
				
				myStmt.executeUpdate();
			}
		}
	}
	
	
	
	
	public void deleteContact(ContactForm theContact) throws Exception
	
	{
		PreparedStatement myStmt;
		myStmt = myConn.prepareStatement("delete from contact where contact_id=?");
		myStmt.setInt(1, theContact.getID());
		myStmt.executeUpdate();
		
	}
	
	public ContactForm getSpecificContact(int id) throws Exception
	{
		PreparedStatement myStmt=null;
		Statement my=null;
		ResultSet res=null;
		
		try
		{
			myStmt = myConn.prepareStatement("select * from contact where contact_id=?");
			myStmt.setInt(1, id);
			res=myStmt.executeQuery();
			while(res.next())
				{
				f=res.getString("Fname");
				
			 m=res.getString("Mname");
			l=res.getString("Lname");
				}
			
			
			myStmt = myConn.prepareStatement("select * from address where contac_id=? and address_type=?");
			myStmt.setInt(1, id);
			myStmt.setString(2, "home");
			res=myStmt.executeQuery();
			while(res.next()) {
				hstreet=res.getString("address_street");
			hcity=res.getString("city");
			hstate=res.getString("state");
			 hzip=res.getString("zipcode");
			}
			
			myStmt = myConn.prepareStatement("select * from address where contac_id=? and address_type=?");
			myStmt.setInt(1, id);
			myStmt.setString(2, "work");
			res=myStmt.executeQuery();
			while(res.next())
			{
				
				 wstreet=res.getString("address_street");
				 wcity=res.getString("city");
				 wstate=res.getString("state");
				 wzip=res.getString("zipcode");
			}
			
			
			myStmt = myConn.prepareStatement("select * from phone where c_id=? and phone_type=?");
			myStmt.setInt(1, id);
			myStmt.setString(2, "cell");
			res=myStmt.executeQuery();
			while(res.next()) {
				carea=res.getString("area_code");
			
			 cphone=res.getString("pnumber");
			}
			
			myStmt = myConn.prepareStatement("select * from phone where c_id=? and phone_type=?");
			myStmt.setInt(1, id);
			myStmt.setString(2, "home");
			res=myStmt.executeQuery();
			while(res.next()) {
			 harea=res.getString("area_code");
			 hphone=res.getString("pnumber");
			}
			
			myStmt = myConn.prepareStatement("select * from phone where c_id=? and phone_type=?");
			myStmt.setInt(1, id);
			myStmt.setString(2, "work");
			res=myStmt.executeQuery();
			while(res.next()) {
			warea=res.getString("area_code");
			 wphone=res.getString("pnumber");
			}
			
			
			myStmt = myConn.prepareStatement("select * from Date where con_id=?");
			myStmt.setInt(1, id);
			
			res=myStmt.executeQuery();
			while(res.next()) {
			dformat=res.getString("date_type");
			date=res.getString("date_birth");
			}
			
			ContactForm temp=new ContactForm(f,m,l,hstreet,hcity,hstate,hzip,wstreet,wcity,wstate,wzip,carea,cphone,harea,hphone,warea,wphone,dformat,date);
			System.out.println(f+","+m+","+l);
			return temp;
			
		}
		finally
		{
			close(myStmt,null);
		}
	
	}

	public static void main(String[] args) throws Exception {
		ContactDAO emp = new ContactDAO();
		
		//System.out.println(emp.getAllContacts());
		//System.out.println(emp.searchForContact("McH"));
		//ContactForm test=new ContactForm("shyam","siddharth","rao","home","7777mc","dallas","tx","75252","cell","040","27741931","dd-yy-mm","1995-09-14");
		//test.id=1007;
		//emp.modifyContact(test);
		emp.getSpecificContact(1005);

	}




}
