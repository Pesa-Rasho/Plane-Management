public class Person {

    //Private instance variables to store personal information.
    private String name;
    private String surname;
    private String email;

    //Constructor for Person object with name,surname and email.
    public Person(String name, String surname, String email){
        this.name=name;
        this.surname=surname;
        this.email=email;
    }

    //Getters and setters
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public String toString() {
        return "Name: " + getName() + "\nSurname: " + getSurname() + "\nEmail: " + getEmail();
    }
}
