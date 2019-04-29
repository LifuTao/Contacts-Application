package application;

import java.util.Comparator;

public class ContactsCompare implements Comparator<Contact> {
	//to sort alphabetically
	@Override
	public int compare(Contact contact1, Contact contact2) {
		// TODO Auto-generated method stub

		return contact1.getLastName().compareTo(contact2.getLastName());
	}

}
