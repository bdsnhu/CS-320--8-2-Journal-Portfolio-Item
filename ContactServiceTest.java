//Ben Douglas
//10-10-2024
package tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contact.Contact;
import contact.ContactService;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertNotNull(contactService.getContact("1"));
    }

    @Test
    public void testAddDuplicateContact() {
        Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact1);
        Contact contact2 = new Contact("1", "Jane", "Doe", "0987654321", "456 Elm St");
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact2));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.deleteContact("1");
        assertNull(contactService.getContact("1"));
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateContact("1", "Jane", null, null, null);
        assertEquals("Jane", contactService.getContact("1").getFirstName());
        assertEquals("Doe", contactService.getContact("1").getLastName());
    }

    @Test
    public void testUpdateNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> contactService.updateContact("2", "Jane", null, null, null));
    }

    @Test
    public void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("2"));
    }
}

