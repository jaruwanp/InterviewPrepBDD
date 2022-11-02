package data.pojos;

public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String batch;


    public Person(String firstName, String lastName, String email, String role, String batch) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.batch = batch;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", batch='" + batch + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
}
