package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

	@Test
	void testAddContactSuccess() {
		ContactService service = new ContactService();
		Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

		service.addContact(c);

		assertNotNull(service.getContact("1"));
	}

	@Test
	void testAddDuplicateContactFails() {
		ContactService service = new ContactService();

		service.addContact(new Contact("1", "John", "Doe", "1234567890", "123 Main St"));

		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(new Contact("1", "Jane", "Smith", "0987654321", "456 Ave"));
		});
	}

	@Test
	void testDeleteContactSuccess() {
		ContactService service = new ContactService();
		service.addContact(new Contact("1", "John", "Doe", "1234567890", "123 Main St"));

		service.deleteContact("1");

		assertNull(service.getContact("1"));
	}

	@Test
	void testDeleteContactNotFound() {
		ContactService service = new ContactService();

		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("999");
		});
	}

	@Test
	void testUpdateFirstName() {
		ContactService service = new ContactService();
		service.addContact(new Contact("1", "John", "Doe", "1234567890", "123 Main St"));

		service.updateFirstName("1", "Jane");

		assertEquals("Jane", service.getContact("1").getFirstName());
	}

	@Test
	void testUpdateLastName() {
		ContactService service = new ContactService();
		service.addContact(new Contact("1", "John", "Doe", "1234567890", "123 Main St"));

		service.updateLastName("1", "Smith");

		assertEquals("Smith", service.getContact("1").getLastName());
	}

	@Test
	void testUpdatePhone() {
		ContactService service = new ContactService();
		service.addContact(new Contact("1", "John", "Doe", "1234567890", "123 Main St"));

		service.updatePhone("1", "1112223333");

		assertEquals("1112223333", service.getContact("1").getPhone());
	}

	@Test
	void testUpdateAddress() {
		ContactService service = new ContactService();
		service.addContact(new Contact("1", "John", "Doe", "1234567890", "123 Main St"));

		service.updateAddress("1", "999 New Address");

		assertEquals("999 New Address", service.getContact("1").getAddress());
	}

	@Test
	void testUpdateNotFoundFails() {
		ContactService service = new ContactService();

		assertThrows(IllegalArgumentException.class, () -> {
			service.updatePhone("999", "1112223333");
		});
	}
}

