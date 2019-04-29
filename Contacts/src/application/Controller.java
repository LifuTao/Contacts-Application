package application;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Controller {

	List<Image> imageList = new ArrayList<Image>();
	private boolean showImages = false;
	private int itemIndex = 0;
	private int size = 0; // keep track of number of items in the list, for reindexing items during removal
	private List<Contact> contactItems;
	@FXML
	private ListView<Contact> contactsListView;

	@FXML
    private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField emailField;
	@FXML
	private TextField phoneNumberField;
	@FXML
    private Button addContactButton;
	@FXML
	private Button deleteContactButton;
	@FXML
	private Button updateContactButton;
	@FXML
	private Button activateCustomListView;
	@FXML
	private ImageView contactImage;

	public void initialize(){
		Contact item1 = new Contact("Li Fu","Tao","lifutao07@gmail.com","347-706-5660",itemIndex++);
		Contact item2 = new Contact("Allan","Yu","allanyu027@gmail.com","917-706-5660",itemIndex++);
		Contact item3 = new Contact("Sam","Barobhuiya","samb@gmail.com","504-706-8660",itemIndex++);
		Contact item4 = new Contact("Kevin","Yu","kevyu07@gmail.com","718-726-5660",itemIndex++);
		Contact item5 = new Contact("BKJ","VLOGS","bkjbookings@gmail.com","347-726-9660",itemIndex++);
		size += 5;
		//We gotta initialize the arraylist
		contactItems = new ArrayList<Contact>();
		contactItems.add(item1);
		contactItems.add(item2);
		contactItems.add(item3);
		contactItems.add(item4);
		contactItems.add(item5);

		contactsListView.getItems().setAll(contactItems); //todoItems: a List with the items
		contactsListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		contactsListView.getSelectionModel().selectFirst(); // select the first item when program runs
	}
	@FXML
	public void handleClickListView(){
		Contact item = (Contact) contactsListView.getSelectionModel().getSelectedItem(); // get the current item selected in the ListView
		firstNameField.setText(item.getFirstName());
		lastNameField.setText(item.getLastName());
		emailField.setText(item.getEmail());
		phoneNumberField.setText(item.getPhoneNumber());

		int imageIndex = item.getItemIndex() % 5;
		if(showImages){ //if custom view is on show images
			contactImage.setImage(imageList.get(imageIndex)); // set the image according to the id
		}
	}
	@FXML
	public void onAddContactButtonClick(){
		/*Take first_name, last_name, email, and phone number from fields and create Contact object
		 * then add that object to the list */
		String firstName, lastName, email, phoneNumber;
		//Get Contact Info from the fields
		firstName = firstNameField.getText();
		lastName = lastNameField.getText();
		email = emailField.getText();
		phoneNumber = phoneNumberField.getText();
		//create contact and add it to the list
		Contact newContact = new Contact(firstName,lastName,email,phoneNumber,itemIndex++);

		contactItems.add(newContact);
		size++;
		contactsListView.getItems().setAll(contactItems); //todoItems: a List with the items
		contactsListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}
	@FXML
	public void onUpdateContactButtonClick(){
		/*Take first_name, last_name, email, and phone number from fields and update the contact Contact object
		 * then add that object to the list */
		Contact item = (Contact) contactsListView.getSelectionModel().getSelectedItem();
		String firstName, lastName, email, phoneNumber;
		int itemIndex;
		//Get Contact Info from the fields
		firstName = firstNameField.getText();
		lastName = lastNameField.getText();
		email = emailField.getText();
		phoneNumber = phoneNumberField.getText();
		itemIndex = item.getItemIndex();
		//Get the object and update
		contactItems.get(itemIndex).setFirstName(firstName);
		contactItems.get(itemIndex).setLastName(lastName);
		contactItems.get(itemIndex).setEmail(email);
		contactItems.get(itemIndex).setPhoneNumber(phoneNumber);
	}

	//on delete button, item index delete
	@FXML
	public void onDeleteContactButtonClick(){
		//Delete the contact
		//Get the index of that button and delete
		Contact item = (Contact) contactsListView.getSelectionModel().getSelectedItem();
		int tempItemIndex = item.getItemIndex();
		contactItems.remove(tempItemIndex);
		size--;

		for(int i = 0; i < size; i++){
			contactItems.get(i).setItemIndex(i); // redo the numbers
		}
		contactsListView.getItems().setAll(contactItems); //todoItems: a List with the items
		//delete the number and update all indices of the list
	}
	@FXML
	public void onActivateCustomListViewButtonClick(){
		Collections.sort(contactItems,new ContactsCompare());
		showImages = true; //Toggle view
		javafx.scene.image.Image image0 = new javafx.scene.image.Image(getClass().getResource("iPhone.JPG").toExternalForm());
		javafx.scene.image.Image image1 = new javafx.scene.image.Image(getClass().getResource("lifu.JPG").toExternalForm());
		javafx.scene.image.Image image2 = new javafx.scene.image.Image(getClass().getResource("nike.JPG").toExternalForm());
		javafx.scene.image.Image image3 = new javafx.scene.image.Image(getClass().getResource("nyc.JPG").toExternalForm());
		javafx.scene.image.Image image4 = new javafx.scene.image.Image(getClass().getResource("turtle.jpg").toExternalForm());
		imageList.add(image0);
		imageList.add(image1);
		imageList.add(image2);
		imageList.add(image3);
		imageList.add(image4);
		contactsListView.getItems().setAll(contactItems);
	}
}


