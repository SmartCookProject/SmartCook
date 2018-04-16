package smart.lytn.smartcook.model;

/**
 * Created by ivans on 29/01/2018.
 */

public class User {

    private int id;
    private String name;
    private String firstname;
    private String lastname;
    private String mail;
    private String password;
    private byte photo;
    private Fridge userFridge;

    public User(){}

    public User(int id, String name, String firstname, String lastname, String mail, String password, byte photo, Fridge userFridge){
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.password = password;
        this.photo = photo;
        this.userFridge = userFridge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getPhoto(){ return photo; }

    public void setPhoto(byte photo){ this.photo = photo; }

    public Fridge getUserFridge() {
        return userFridge;
    }

    public void setUserFridge(Fridge userFridge) {
        this.userFridge = userFridge;
    }
}
