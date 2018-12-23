package contact_manager;


import java.sql.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class PopulateDatabase {
	
	private static Connection myConn;
	private static int record_id;

	public PopulateDatabase() throws Exception{
		String user="root";
		String password="SIDdharth_85";
		String dburl="jdbc:mysql://localhost:3306/contact_list?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		myConn = DriverManager.getConnection(dburl,user,password);
		System.out.println("Database connected successfully");
	}
	
	
	
	public static void main(String[] args) throws Exception
	{
		PopulateDatabase p = new PopulateDatabase();
		PreparedStatement myStmt=null;
		Statement my=null;
		
		String csvFile="contacts.csv";
		BufferedReader br=null;
		String line="";
		
		
		try
		{
			br=new BufferedReader(new FileReader(csvFile));
			int k=0;
			while((line=br.readLine())!=null)
			{
				k++;
				if(k==1)
				{
					continue;
				}
				
				String[] contact = line.split(",",-1);
				
				// Adding a contact's  name to the contact table in our contacts database
				String fname=contact[1];
				String mname=contact[2];
				String lname=contact[3];
				myStmt=myConn.prepareStatement("insert into contact (Fname,Mname,Lname) values (?,?,?)");
				myStmt.setString(1, fname);
				myStmt.setString(2, mname);
				myStmt.setString(3, lname);
				myStmt.executeUpdate();
				
				// Adding a contact's phone details to the phone table in our contacts database
				my=myConn.createStatement();
				ResultSet res=null;
				res=my.executeQuery("select max(contact_id) as record_id from contact");
				while(res.next())
				{
					record_id=res.getInt("record_id");
				}
				
				// Adding a cell phone number, if it exists
				if(!contact[4].equals(""))
				{
					String hphone=contact[4];
					String area_code=hphone.substring(0,3);
					String pnumber= hphone.substring (4,12);
					myStmt=myConn.prepareStatement("insert into phone (c_id,phone_type,area_code,pnumber) values (?,'home',?,?)");
					myStmt.setInt(1, record_id);
					myStmt.setString(2, area_code);
					myStmt.setString(3, pnumber);
					myStmt.executeUpdate();
				}
				
				// Adding a home phone number, if it exists
				if(!contact[5].equals(""))
				{	
					String cphone=contact[5];
					String area_code=cphone.substring(0,3);
					String pnumber= cphone.substring (4,12);
					myStmt=myConn.prepareStatement("insert into phone (c_id,phone_type,area_code,pnumber) values (?,'cell',?,?)");
					myStmt.setInt(1, record_id);
					myStmt.setString(2, area_code);
					myStmt.setString(3, pnumber);
					myStmt.executeUpdate();
				
				}
				
				
				// Adding a work phone, if it exists
				if(!contact[10].equals(""))
				{
					String wphone = contact[10];
					String area_code = wphone.substring(0,3);
					String pnumber = wphone.substring (4,12);
					myStmt=myConn.prepareStatement("insert into phone (c_id,phone_type,area_code,pnumber) values (?,'work',?,?)");
					myStmt.setInt(1, record_id);
					myStmt.setString(2, area_code);
					myStmt.setString(3, pnumber);
					myStmt.executeUpdate();
				}
				
				
				//Adding a home address, if it exists
				if(!contact[6].equals("") || !contact[7].equals("") || !contact[8].equals("") || !contact[9].equals(""))
				{
					String home_address = contact[6];
					String home_city = contact[7];
					String home_state = contact[8];
					String home_zip = contact[9];
					myStmt=myConn.prepareStatement("insert into address (contac_id,address_type,address_street,city,state,zipcode) values (?,'home',?,?,?,?)");
					myStmt.setInt(1, record_id);
					myStmt.setString(2, home_address);
					myStmt.setString(3, home_city);
					myStmt.setString(4, home_state);
					myStmt.setString(5, home_zip);
					
					myStmt.executeUpdate();
				}
				
				
				// Adding a work address, if it exists
				if(!contact[11].equals("") || !contact[12].equals("") || !contact[13].equals("") || !contact[14].equals(""))
				{
					String work_address = contact[11];
					String work_city = contact[12];
					String work_state = contact[13];
					String work_zip = contact[14];
					myStmt=myConn.prepareStatement("insert into address (contac_id,address_type,address_street,city,state,zipcode) values (?,'work',?,?,?,?)");
					myStmt.setInt(1, record_id);
					myStmt.setString(2, work_address);
					myStmt.setString(3, work_city);
					myStmt.setString(4, work_state);
					myStmt.setString(5, work_zip);
					
					myStmt.executeUpdate();
				}
				
				
			if(!contact[15].equals(""))
			{
				myStmt=myConn.prepareStatement("insert into Date (con_id,date_type,date_birth) values (?,'YYY-MM-DD',?)");	
				myStmt.setInt(1, record_id);
				myStmt.setString(2, contact[15]);
				
				myStmt.executeUpdate();
			}
			
		
			}
		}
		catch(IndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}
