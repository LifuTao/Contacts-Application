package application;

public class Contact {
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private int itemIndex;

	Contact(String firstName, String lastName, String email, String phoneNumber,int itemIndex){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.itemIndex = itemIndex;
		//add some code to tell the display that the contact has been added
	}
	//Insert Constructor if needed
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	public void setItemIndex(int itemIndex){
		this.itemIndex = itemIndex;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public String getEmail(){
		return email;
	}
	public String getPhoneNumber(){
		return phoneNumber;
	}
	public int getItemIndex(){
		return itemIndex;
	}
	@Override
	public String toString(){
		return (Integer.toString(itemIndex) + ": " + lastName);
	}
}