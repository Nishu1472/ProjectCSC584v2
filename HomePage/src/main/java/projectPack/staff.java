package projectPack;

public class staff{

	String staffUsername;
	String staffPassword;
	
	public staff() {}
	
	public void setStaffUsername(String staffUsername){this.staffUsername = staffUsername;}
	public String getStaffUsername(){return staffUsername;}
	
	public void setStaffPassword(String staffPassword){this.staffPassword = staffPassword;}
	public String getStaffPassword(){return staffPassword;}
	
	public boolean validate(String s1, String s2)
	{
		if(s1.equals(staffUsername)&&s2.equals(staffPassword))
			return true;
		else
			return false;
	}
}