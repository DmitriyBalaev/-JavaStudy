import java.util.Objects;

public class PlayerWithObjectsHash {
    private String firstName;
    private String lastName;
    private String position;

    public PlayerWithObjectsHash(String firstName, String lastName, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    /*
        Если заглянуть в метод Objects.hush(), то видно что значения помещаются в массив и у него вызывается
        метод Arrays.hashCode();
     */
    @Override
    public int hashCode(){
        return Objects.hash(firstName, lastName, position);
    }
}
