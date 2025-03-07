import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Ticket {

    //Private instance variables to store ticket information.
    private String row;
    private int seat;
    private double price;
    private Person person;

    //Constructor for Ticket object with row, seat, price and personal information.
    public Ticket(String row, int seat, double price, Person person){
        this.row=row;
        this.seat=seat;
        this.price=price;
        this.person = person;
    }

    //Getter to retrieve the row
    public String getRow(){
        return row;
    }

    //Setter to update the row
    public void setRow(String row){
        this.row = row;
    }

    //Getter to retrieve the seat
    public int getSeat(){
        return seat;
    }

    //Setter to update the seat
    public void setSeat(int seat){
        this.seat=seat;
    }

    //Getter to retrieve the seat price
    public double getPrice(){
        return price;
    }

    //Setter to update the seat price
    public void setPrice(double price){
        this.price=price;
    }

    //Getter to retrieve the person
    public Person getPerson(){
        return person;
    }

    //Setter method to update the person
    public void setPerson(Person person){
        this.person=person;
    }

    //Returning the  ticket object as a string
    public String toString() {
        return "\nTicket Information:\n" +
                "Row: " + row + "\n" +
                "Seat Number: " + seat + "\n" +
                "Price: £ " + price + "\n" +
                "\nPersonal Information:\n" + getPerson().toString();
    }

    //Saving the ticket information to a text file.
    public void save(){
        String file_name = row + seat + ".txt";

        try {
            FileWriter file_write = new FileWriter(file_name);
            file_write.write("Ticket Information\n");
            file_write.write("Row : " + row + "\n");
            file_write.write("Seat number : " + seat + "\n");
            file_write.write("Price : £ " + price + "\n");
            file_write.write("\nPersonal Information\n");
            file_write.write(person.toString() + "\n");
            file_write.close();

            System.out.println("Ticket information saved to file : " + file_name);
        }
        catch (IOException e){
            System.out.println("An error occurred.");
        }

    }

    //Deleting the ticket when the cancel seat is given.
    public void delete(){
        String file_name = row + seat + ".txt";
        File delete_file = new File(file_name);
        if (delete_file.delete()) {
            System.out.println("Ticket information is deleted.");
        }
        else{
            System.out.println("File doesn't exist");
        }
    }
}

