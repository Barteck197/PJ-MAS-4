public class Player extends ObjectPlus4{
    private String firstName;
    private String lastName;
    private String nationality;

    public Player(String firstName, String lastName, String nationality) {
        super();
        setFirstName(firstName);
        setLastName(lastName);
        setNationality(nationality);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
