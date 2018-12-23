package contact_manager;

public class ContactForm {
	
	int id;
	private String lastName;
	private String firstName;
	private String middleName;
	private String hstreet;
	private String hcity;
	private String hstate;
	private String hzipcode;
	private String wstreet;
	private String wcity;
	private String wstate;
	private String wzipcode;
	private String harea_code;
	private String hnumber;
	private String warea_code;
	private String wnumber;
	private String carea_code;
	private String cnumber;
	private String dayformat;
	private String bdate;
	
	private String addresses;
	private String phones;


	public ContactForm(int iden,String fname, String mname, String lname,String addresses,String phone,String bday) {
		super();
		this.id=iden;
		this.lastName = lname;
		this.firstName = fname;
		this.middleName = mname;
		this.addresses=addresses;
		this.phones = phone;
		this.bdate=bday;

	}


	public ContactForm(String fname, String mname, String lname,String hstreet,String hcity,String hstate,String hzip,
			String wstreet,String wcity,String wstate,String wzip,String carea,String cphone,String harea,String hphone,String warea,String wphone,
			String format,String bday) {
		super();
		this.lastName = lname;
		this.firstName = fname;
		this.middleName = mname;
		this.hstreet=hstreet;
		this.hcity=hcity;
		this.hstate=hstate;
		this.hzipcode=hzip;
		this.wstreet=wstreet;
		this.wcity=wcity;
		this.wstate=wstate;
		this.wzipcode=wzip;
		this.carea_code=carea;
		this.cnumber=cphone;
		this.harea_code=harea;
		this.hnumber=hphone;
		this.warea_code=warea;
		this.wnumber=wphone;
		this.dayformat=format;
		this.bdate=bday;

	}


	public int getID() {
		return id;
	}
	
	public void setID(int iden) {
		iden=id;
	}
	

	public String getFirstName() {
		return firstName;
	}
	
	
	public void setFirstName(String s) {
		firstName=s;
	}
	
	

	public String getLastName() {
		return lastName;
	}
	
	
	public void setLastName(String s) {
		lastName=s;
	}

	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String s) {
		middleName=s;
	}


	public String getHomeStreet() {
		return hstreet;
	}

	public void setHomeStreet(String s) {
		 hstreet=s;
	}
	
	public String getHomeCity() {
		return hcity;
	}

	public void setHomeCity(String s) {
		 hcity=s;
	}
	
	public String getHomeState() {
		return hstate;
	}

	public void setHomeState(String s) {
		 hstate=s;
	}
	
	public String getHomeZIP() {
		return hzipcode;
	}

	public void setHomeZIP(String s) {
		 hzipcode=s;
	}

	
	public String getWorkStreet() {
		return wstreet;
	}

	public void setWorkStreet(String s) {
		 wstreet=s;
	}
	
	public String getWorkCity() {
		return wcity;
	}

	public void setWorkCity(String s) {
		 wcity=s;
	}
	
	public String getWorkState() {
		return wstate;
	}

	public void setWorkState(String s) {
		 wstate=s;
	}
	
	public String getWorkZIP() {
		return wzipcode;
	}

	public void setWorkZIP(String s) {
		 wzipcode=s;
	}



	public String getCellAreaCode() {
		return carea_code;
	}
	
	public void setCellAreaCode(String s) {
		carea_code=s;
	}
	
	public String getCellPhone() {
		return cnumber;
	}
	
	public void setCellPhone(String s) {
		cnumber=s;
	}

	
	public String getHomeAreaCode() {
		return harea_code;
	}
	public void setHomeAreaCode(String s) {
		harea_code=s;
	}
	
	
	public String getHomePhone() {
		return hnumber;
	}
	
	public void setHomePhone(String s) {
		hnumber=s;
	}
	
	
	
	public String getWorkAreaCode() {
		return warea_code;
	}
	public void setWorkAreaCode(String s) {
		warea_code=s;
	}
	
	public String getWorkPhone() {
		return wnumber;
	}
	
	public void setWorkPhone(String s) {
		wnumber=s;
	}
	
	
	public String getFormat() {
		return dayformat;
	}
	public void setFormat(String s) {
		dayformat=s;
	}
	
	
	public String getBD() {
		return bdate;
	}
	
	public void setBD(String s) {
		bdate=s;
	}


	public String getAddresses() {
		return addresses;
	}
	public String getPhones() {
		return phones;
	}


	@Override
	public String toString() {
		return String
				.format("Employee [firstName=%s, middleName=%s,lastName=%s]",id,
						 firstName, middleName, lastName);
	}

}
