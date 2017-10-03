import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by yurko on 02.10.17.
 */
@XmlRootElement
public class Users {
    private List<User> user;
    public Users(){};
    public Users(List<User> user){
        this.user=user;

    }
    @XmlElement
    public List<User> getUser() {
        return user;
    }
    public void setUsers (List<User> user) {
        this.user = user;
    }
}
