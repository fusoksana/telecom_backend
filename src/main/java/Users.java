/**
 * Created by yurko on 20.08.17.
 */
public class Users {
    private String id;
    private String firstName;
    private String lastName;
    public  Users(String id,String firstName,String lastName){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
    }
    @Override
    public String toString(){
        return id +" "+firstName+" "+lastName;
    }

}
