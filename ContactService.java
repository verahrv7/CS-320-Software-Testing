package contact;



import java.util.HashMap;



public class ContactService {



	private HashMap<String, Contact> contactList = new HashMap<String, Contact>();



	public void addContact(Contact contact) {



		if (contact == null) {

			throw new IllegalArgumentException("contact cannot be null");

		}



		String id = contact.getContactId();



		if (contactList.containsKey(id)) {

			throw new IllegalArgumentException("contactId already exists");

		}



		contactList.put(id, contact);

	}



	public void deleteContact(String contactId) {



		if (contactId == null) {

			throw new IllegalArgumentException("contactId cannot be null");

		}



		if (!contactList.containsKey(contactId)) {

			throw new IllegalArgumentException("contactId not found");

		}



		contactList.remove(contactId);

	}



	public void updateFirstName(String contactId, String firstName) {



		if (!contactList.containsKey(contactId)) {

			throw new IllegalArgumentException("contactId not found");

		}



		Contact contact = contactList.get(contactId);

		contact.setFirstName(firstName);

	}



	public void updateLastName(String contactId, String lastName) {



		if (!contactList.containsKey(contactId)) {

			throw new IllegalArgumentException("contactId not found");

		}



		Contact contact = contactList.get(contactId);

		contact.setLastName(lastName);

	}



	public void updatePhone(String contactId, String phone) {



		if (!contactList.containsKey(contactId)) {

			throw new IllegalArgumentException("contactId not found");

		}



		Contact contact = contactList.get(contactId);

		contact.setPhone(phone);

	}



	public void updateAddress(String contactId, String address) {



		if (!contactList.containsKey(contactId)) {

			throw new IllegalArgumentException("contactId not found");

		}



		Contact contact = contactList.get(contactId);

		contact.setAddress(address);

	}



	// This is just to help tests check the stored contact

	public Contact getContact(String contactId) {

		return contactList.get(contactId);

	}

}

