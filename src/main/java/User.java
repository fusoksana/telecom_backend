import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by yurko on 20.08.17.
 */

public class User {
    private int ID;
    private String firstName;
    private String lastName;
    public User(int ID, String firstName, String lastName){
        this.ID=ID;
        this.firstName=firstName;
        this.lastName=lastName;
    }
    public User(){

    }
    @Override
    public String toString(){return ID +" "+firstName+" "+lastName;
    }
    @XmlElement
    public int getID() {
        return ID;
    }
    @XmlElement
    public String getFirstName() {
        return firstName;
    }
    @XmlElement
    public String getLastName() {
        return lastName;
    }
}
