package Contact;


public class person {

	
	public String icon;
	
	private String firstname;
	
	private String note;

	private String lastname;

	private String email;
	
	private sex sex;

	private String address;

	private String phone;
	
	private String birthday;
	

	public String getIcon() {
	 	 return icon; 
	}

	public void setIcon(String icon) { 
		 this.icon = icon; 
	}

	public String getFirstname() {
	 	 return firstname; 
	}

	public void setFirstname(String firstname) { 
		 this.firstname = firstname; 
	}

	public String getNote() {
	 	 return note; 
	}

	public void setNote(String note) { 
		 this.note = note; 
	}

	public String getLastname() {
	 	 return lastname; 
	}

	public void setLastname(String lastname) { 
		 this.lastname = lastname; 
	}
	
	public String getEmail() {
	 	 return email; 
	}

	public void setEmail(String email) { 
		 this.email = email; 
	}
	
	public sex getSex() {
	 	 return sex; 
	}

	public void setSex(sex sex) { 
		 this.sex = sex; 
	}
	
	public String getAddress() {
	 	 return address; 
	}
	
	public void setAddress(String address) { 
		 this.address = address; 
	}

	public String getPhone() {
	 	 return phone; 
	}
	
	public void setPhone(String phone) { 
		 this.phone = phone; 
	}
	
	public String getbirthday() {
	 	 return birthday; 
	}

	public void setbirthday(String birthday) { 
		 this.birthday = birthday; 
	}
	
	public  person(String phone, String lastname, String firstname) { 
		this.phone = phone;
		this.lastname = lastname;
		this.firstname = firstname;
		
	 }



	public  person(String phone, String birthday, String firstname, String lastname) { 
		this.phone = phone;
		this.lastname = lastname;
		this.firstname = firstname;
		this.birthday = birthday;
	 }

	public  person(String address, String firstname, String birthday, String note, String phone, String lastname, sex sex, String icon) { 
		this.phone = phone;
		this.lastname = lastname;
		this.firstname = firstname;
		this.birthday = birthday;
		this.address = address;
		this.icon = icon;
		this.sex = sex;
		this.note = note;
		
	 }

	

}
