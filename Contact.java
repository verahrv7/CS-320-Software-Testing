package contact;

public class Contact {

	private final String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;

	public Contact(String contactId, String firstName, String lastName, String phone, String address) {

		// contactId checks
		if (contactId == null) {
			throw new IllegalArgumentException("contactId cannot be null");
		}
		if (contactId.length() > 10) {
			throw new IllegalArgumentException("contactId too long");
		}

		// firstName checks
		if (firstName == null) {
			throw new IllegalArgumentException("firstName cannot be null");
		}
		if (firstName.length() > 10) {
			throw new IllegalArgumentException("firstName too long");
		}

		// lastName checks
		if (lastName == null) {
			throw new IllegalArgumentException("lastName cannot be null");
		}
		if (lastName.length() > 10) {
			throw new IllegalArgumentException("lastName too long");
		}

		// phone checks
		if (phone == null) {
			throw new IllegalArgumentException("phone cannot be null");
		}
		if (phone.length() != 10) {
			throw new IllegalArgumentException("phone must be 10 digits");
		}
		for (int i = 0; i < phone.length(); i++) {
			if (!Character.isDigit(phone.charAt(i))) {
				throw new IllegalArgumentException("phone must contain only digits");
			}
		}

		// address checks
		if (address == null) {
			throw new IllegalArgumentException("address cannot be null");
		}
		if (address.length() > 30) {
			throw new IllegalArgumentException("address too long");
		}

		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}

	public String getContactId() {
		return contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("invalid firstName");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("invalid lastName");
		}
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (phone == null) {
			throw new IllegalArgumentException("phone cannot be null");
		}
		if (phone.length() != 10) {
			throw new IllegalArgumentException("phone must be 10 digits");
		}
		for (int i = 0; i < phone.length(); i++) {
			if (!Character.isDigit(phone.charAt(i))) {
				throw new IllegalArgumentException("phone must contain only digits");
			}
		}
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("invalid address");
		}
		this.address = address;
	}
}
