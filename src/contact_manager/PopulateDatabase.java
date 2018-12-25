package contact_manager;


import java.sql.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class PopulateDatabase {
	
	

	String fname,mname,lname,haddress,hstate,hcity,hzip,waddress,wcity,wstate,wzip,carea,cphone,harea,hphone,warea,wphone,format,bday;
	
	
	
	public static void main(String[] args) throws Exception
	{
		ContactDAO c = new ContactDAO();
		PreparedStatement myStmt=null;
		Statement my=null;
		
		String csvFile="contacts.csv";
		BufferedReader br=null;
		String line="";
		
		
		try
		{
			String fname,mname,lname,haddress,hstate,hcity,hzip,waddress,wcity,wstate,wzip,carea,cphone,harea,hphone,warea,wphone,format,bday;
			br=new BufferedReader(new FileReader(csvFile));
			int k=0;
			while((line=br.readLine())!=null)
			{
				k++;
				if(k==1)
				{
					continue;
				}
				
				
				fname=mname=lname=haddress=hstate=hcity=hzip=waddress=wcity=wstate=wzip=carea=cphone=harea=hphone=warea=wphone=bday="";
				format = "yyyy-mm-dd";
				String[] contact = line.split(",",-1);
				
				/* Adding a contact's  name to the contact table in our contacts database */
				fname=contact[1];
				mname=contact[2];
				lname=contact[3];
				
				
				// Parsing home phone number */
				if(!contact[4].equals(""))
				{
				harea=contact[4].substring(0,3);
					hphone= contact[4].substring (4,12);
				}
				
				/* Parsing the cell phone number */
				if(!contact[5].equals(""))
				{
				
					 carea=contact[5].substring(0,3);
					 cphone= contact[5].substring (4,12);
				}
				
				/* Parsing the work phone */
				if(!contact[10].equals(""))
				{
					warea=contact[10].substring(0,3);
					wphone= contact[10].substring (4,12);
				}
				
				
				/* Parsing home address */
				 haddress = contact[6];
				 hcity = contact[7];
				 hstate = contact[8];
				 hzip = contact[9];
				
				
				/* Parsing the home address */
				 waddress = contact[11];
				 wcity = contact[12];
				 wstate = contact[13];
				 wzip = contact[14];
			
				/* Parsing the birthday */
				bday = contact[15];
				
				ContactForm temp = new ContactForm(fname,mname,lname,haddress,hstate,hcity,hzip,waddress,wcity,wstate,wzip,
						carea,cphone,harea,hphone,warea,wphone,format,bday);
				c.addContact(temp);
				
			
		
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
