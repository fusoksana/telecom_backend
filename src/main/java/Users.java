/**
 * Created by yurko on 20.08.17.
 */
public class Users {
    private int ID;
    private String firstName;
    private String lastName;
    public Users(int ID, String firstName, String lastName){
        this.ID=ID;
        this.firstName=firstName;
        this.lastName=lastName;
    }
    @Override
    public String toString(){return ID +" "+firstName+" "+lastName;
    }

}
