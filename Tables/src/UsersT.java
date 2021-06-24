public class UsersT {
    int userID;
    Roles role;

    public UsersT(int userID, Roles role) {
        this.userID = userID;
        this.role = role;
    }
}
enum Roles{
    REGULAR("Рядовой работник"),
    DIRECTOR("Директор"),
    ADMIN("Завхоз");

    public final String name;
    Roles(String s) {
        name = s;
    }
}
