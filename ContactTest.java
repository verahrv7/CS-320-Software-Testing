package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

	@Test
	void testContactCreated() {
		Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
		assertEquals("1", c.getContactId());
		assertEquals("John", c.getFirstName());
		assertEquals("Doe", c.getLastName());
		assertEquals("1234567890", c.getPhone());
		assertEquals("123 Main St", c.getAddress());
	}

	// ----- Constructor validation tests -----

	@Test
	void testContactIdNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "John", "Doe", "1234567890", "123 Main St");
		});
	}

	@Test
	void testContactIdTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
		});
	}

	@Test
	void testFirstNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", null, "Doe", "1234567890", "123 Main St");
		});
	}

	@Test
	void testFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "ThisNameIsTooLong", "Doe", "1234567890", "123 Main St");
		});
	}

	@Test
	void testLastNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "John", null, "1234567890", "123 Main St");
		});
	}

	@Test
	void testLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "John", "ThisLastNameIsTooLong", "1234567890", "123 Main St");
		});
	}

	@Test
	void testPhoneNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "John", "Doe", null, "123 Main St");
		});
	}

	@Test
	void testPhoneNotTenDigits() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "John", "Doe", "123", "123 Main St");
		});
	}

	@Test
	void testPhoneHasLetters() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "John", "Doe", "12345abcde", "123 Main St");
		});
	}

	@Test
	void testAddressNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "John", "Doe", "1234567890", null);
		});
	}

	@Test
	void testAddressTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "John", "Doe", "1234567890",
					"1234567890123456789012345678901"); // 31 chars
		});
	}

	// ----- Setter validation tests -----

	@Test
	void testSetFirstNameSuccess() {
		Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
		c.setFirstName("Jane");
		assertEquals("Jane", c.getFirstName());
	}

	@Test
	void testSetFirstNameInvalid() {
		Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class, () -> {
			c.setFirstName(null);
		});
	}

	@Test
	void testSetLastNameSuccess() {
		Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
		c.setLastName("Smith");
		assertEquals("Smith", c.getLastName());
	}

	@Test
	void testSetLastNameInvalid() {
		Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class, () -> {
			c.setLastName(null);
		});
	}

	@Test
	void testSetPhoneSuccess() {
		Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
		c.setPhone("1112223333");
		assertEquals("1112223333", c.getPhone());
	}

	@Test
	void testSetPhoneInvalid() {
		Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class, () -> {
			c.setPhone("12");
		});
	}

	@Test
	void testSetAddressSuccess() {
		Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
		c.setAddress("999 New Address");
		assertEquals("999 New Address", c.getAddress());
	}

	@Test
	void testSetAddressInvalid() {
		Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class, () -> {
			c.setAddress(null);
		});
	}
}

