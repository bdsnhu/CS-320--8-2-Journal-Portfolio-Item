//Ben Douglas
//10-10-2024
package contact;
public class Contact {
    private final String contactId; // required unique ID
    private String firstName; // required
    private String lastName; // required
    private String phone; // required, exactly 10 digits
    private String address; // required, max 30 characters

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10) throw new IllegalArgumentException("Invalid contact ID");
        if (firstName == null || firstName.length() > 10) throw new IllegalArgumentException("Invalid first name");
        if (lastName == null || lastName.length() > 10) throw new IllegalArgumentException("Invalid last name");
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) throw new IllegalArgumentException("Invalid phone number");
        if (address == null || address.length() > 30) throw new IllegalArgumentException("Invalid address");

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
    // Updatable fields
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must be non-null and up to 10 characters.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must be non-null and up to 10 characters.");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be a 10-digit number.");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must be non-null and up to 30 characters.");
        }
        this.address = address;
    }
}
