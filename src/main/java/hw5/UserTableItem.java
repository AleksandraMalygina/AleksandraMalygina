package hw5;

public class UserTableItem {

    private int number;
    private String user;
    private String description;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String makeStringFromThisUser() {
        return this.getNumber() + " " + this.getUser() + " " + this.getDescription();
    }
}
