import java.util.*;

public class PlaneManagement {
    //Array to represent the seating plan.
    static char [][] rows = {
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O'},
            {'O','O','O','O','O','O','O','O','O','O','O','O','O','O'}
    };

    //Array to store the ticket information with the size of 52.
    static Ticket [] tickets = new Ticket[52];
    //Variable to track the ticket count.
    static int ticket_count = 0;
    //Variable to store the total ticket count.
    static double total_sales = 0;

    //Method to validate the row letter
    public static String row_letter_validation() {

        Scanner input = new Scanner(System.in); //Scanner object to get the row letter.

        System.out.print("Enter the row letter. (A, B, C, D) : ");
        String row_letter = input.nextLine().toUpperCase(); //Storing the user input to the row letter variable.

        //Condition to check whether the user input is A,B,C or D.
        if (!row_letter.equals("A") && !row_letter.equals("B") && !row_letter.equals("C") && !row_letter.equals("D")) {
            System.out.println("Invalid row. Please enter a valid row letter.\n");
            return row_letter_validation();
        }
        return row_letter;
    }

    //Method to validate the row number
    public static int row_number_validation(String row_letter) {
        int row_number;
        try {
            Scanner row_input = new Scanner(System.in);// Scanner object to get the row number.

            System.out.print("Enter the row number : ");
            row_number = row_input.nextInt();

            int row_length = 0;

            //Switch statement to determine length of row according to the row letter.
            switch (row_letter) {
                case "A":
                    row_length = rows[0].length;
                    break;
                case "B":
                    row_length = rows[1].length;
                    break;
                case "C":
                    row_length = rows[2].length;
                    break;
                case "D":
                    row_length = rows[3].length;
                    break;
            }

            //Condition to check if the row number is greater than the length of the row.
            if (row_number > row_length) {
                System.out.println("Please enter a correct row number.\n");
                return row_number_validation(row_letter);
            }
            //Catch block to check if the user input is not an integer.
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number\n");
            return row_number_validation(row_letter);
        }
        return row_number;
    }

    //Method to buy the seat.
    public static void buy_seat() {

        boolean is_booked = false;

        String row_letter = row_letter_validation(); //Assigning the correct user input to row letter variable.
        int row_number = row_number_validation(row_letter);//Assigning the correct user input to row number variable.

        //Switch case to check if the user's desired seat is booked or not.
        switch (row_letter) {
            case "A" -> {
                if (rows[0][row_number - 1] == 'O') {
                    rows[0][row_number - 1] = 'X';
                    System.out.println("The seat is booked successfully");
                    is_booked = true;
                } else {
                    System.out.println("The selected seat is already booked");
                }
            }
            case "B" -> {
                if (rows[1][row_number - 1] == 'O') {
                    rows[1][row_number - 1] = 'X';
                    System.out.println("The seat is booked successfully");
                    is_booked = true;
                } else {
                    System.out.println("The selected seat is already booked");
                }
            }
            case "C" -> {
                if (rows[2][row_number - 1] == 'O') {
                    rows[2][row_number - 1] = 'X';
                    System.out.println("The seat is booked successfully");
                    is_booked = true;
                } else {
                    System.out.println("The selected seat is already booked");
                }
            }
            case "D" -> {
                if (rows[3][row_number - 1] == 'O') {
                    rows[3][row_number - 1] = 'X';
                    System.out.println("The seat is booked successfully");
                    is_booked = true;
                } else {
                    System.out.println("The selected seat is already booked");
                }
            }
        }

        if(is_booked) {
            System.out.println("\nPlease enter your personal information.\n");

            Person person = personal_information(); //Prompting the user to enter personal information if the seat is booked.

            double price = calculate_ticket_price(row_letter, row_number); //Assigning the seat price after calculating it.

            Ticket ticket = new Ticket(row_letter, row_number, price, person); //Creating a ticket at the end of buy method.

            ticket.save(); //Saving the ticket information using the save() method in Ticket class.

            tickets[ticket_count++] = ticket; //Storing the ticket in the tickets array.
        }
    }

    //Method to cancel the seat
    public static void cancel_seat(){

        boolean is_cancel = false;

        String row_letter = row_letter_validation(); //Assigning the correct user input to row letter variable.
        int row_number = row_number_validation(row_letter); //Assigning the correct user input to row number variable.

        //Switch statement to check if the seat is already booked inorder to cancel.
        switch (row_letter) {
            case "A" -> {
                if (rows[0][row_number - 1] == 'X') {
                    rows[0][row_number - 1] = 'O';
                    System.out.println("The seat is cancelled successfully");
                    is_cancel = true;

                } else {
                    System.out.println("The selected seat is not booked");
                }
            }
            case "B" -> {
                if (rows[1][row_number - 1] == 'X') {
                    rows[1][row_number - 1] = 'O';
                    System.out.println("The seat is cancelled successfully");
                    is_cancel = true;
                } else {
                    System.out.println("The selected seat is not booked");
                }
            }
            case "C" -> {
                if (rows[2][row_number - 1] == 'X') {
                    rows[2][row_number - 1] = 'O';
                    System.out.println("The seat is cancelled successfully");
                    is_cancel = true;
                } else {
                    System.out.println("The selected seat is not booked");
                }
            }
            case "D" -> {
                if (rows[3][row_number - 1] == 'X') {
                    rows[3][row_number - 1] = 'O';
                    System.out.println("The seat is cancelled successfully");
                    is_cancel = true;
                } else {
                    System.out.println("The selected seat is not booked");
                }
            }
        }

        //Condition to remove the ticket information from tickets array if the user cancels the seat.
        if(is_cancel){
            for (int i = 0; i < ticket_count; i++) {
                if (tickets[i].getRow().equals(row_letter) && tickets[i].getSeat() == row_number) {
                    total_sales-=tickets[i].getPrice();
                    tickets[i].delete();

                    for (int j = i; j < ticket_count - 1; j++) {
                        tickets[j] = tickets[j + 1];
                    }
                    ticket_count--;
                    break;
                }
            }
        }
    }

    //Method to find the first seat available.
    public static void first_seat_available(){
        System.out.println("\nFirst seat available\n");
        //Loop to loop through the rows array to find the first free seat.
        for (int i=0; i<4; i++) {
            for (int j = 0; j < rows[i].length; j++) {
                if (rows[i][j] == 'O') {
                    //Getting the row letter by adding index 'i' to the current character and row number from index 'j'.
                    System.out.println("First seat available is : " + (char) ('A' + i) + (j + 1));
                    return;
                }
            }
        }
    }

    //Method to show the seating plan.
    public static void show_seating_plan() {
        System.out.println("\nSeating Plan\n");
        //Displaying the rows array to show the seating plan and show which seats are booked and which are not.
        for (int i=0;i<4;i++){
            System.out.println(rows[i]);
        }
        System.out.println();
    }

    //Method to search the ticket.
    public static void search_ticket(){
        boolean ticket_available = false;

        String row_letter = row_letter_validation(); //Assigning the correct user input to row letter variable.
        int row_number = row_number_validation(row_letter); //Assigning the correct user input to row number variable.

        //Looping through the tickets array to search for the seat.
        for (int i=0; i<ticket_count;i++){
            Ticket ticket = tickets[i];

            //If the ticket is available displaying the ticket information.
            if(tickets[i].getRow().equals(row_letter) && tickets[i].getSeat() == row_number){
                System.out.println("Ticket info\n");
                System.out.println(ticket);
                ticket_available = true;
            }
        }
        //If the ticket is not available displaying not available
        if(!ticket_available){
            System.out.println("This seat is available.");
        }
    }

    //Method to calculate the ticket price.
    public static int calculate_ticket_price(String row_letter, int row_number) {
        int seat_price = 0;
        int row_length = 0;

        switch (row_letter) {
            case "A":
                row_length = rows[0].length;
                break;
            case "B":
                row_length = rows[1].length;
                break;
            case "C":
                row_length = rows[2].length;
                break;
            case "D":
                row_length = rows[3].length;
                break;
        }

        //Condition to check the price according to row number.
        if (row_letter.equals("A") || row_letter.equals("B") || row_letter.equals("C") || row_letter.equals("D")) {
            if (row_number >= 1 && row_number <= 5) {
                seat_price = 200;
            } else if (row_number > 5 && row_number <= 9) {
                seat_price = 150;
            } else if (row_number > 9 && row_number <= row_length) {
                seat_price = 180;
            }
        }
        total_sales +=seat_price; //Assigning the seat price to total_sales.

        return seat_price;
    }

    //Method to get the personal information.
    public static Person personal_information(){
        Scanner info_input = new Scanner(System.in);

        //Getting the user's personal information.
        System.out.print("Enter your name : ");
        String name = info_input.nextLine();

        System.out.print("Enter your surname : ");
        String surname = info_input.nextLine();

        System.out.print("Enter your email : ");
        String email = info_input.nextLine();

        return new Person(name,surname,email); //Returning Person object with the entered name, surname and email.
    }

    //Method to print the ticket information.
    public static void print_tickets_info(){
        System.out.println("\nTickets Information");

        //Loop to loop through the tickets array to display ticket information.
        for (int i = 0; i < ticket_count; i++) {
            System.out.println(tickets[i]);
            System.out.println("*".repeat(50));
        }
        System.out.println("Total amount payable : £ " + total_sales);
    }

    //Main method
    public static void main (String[]args) {
        System.out.println("\n" + "*".repeat(5) + " Welcome to the Plane Management System " + "*".repeat(5));

        //Display the menu options.
        while (true) {
            System.out.println("\n" + "*".repeat(50) + "\n*" + " ".repeat(16) +
                    "MENU OPTIONS" +
                    " ".repeat(19) + " *\n" + "*".repeat(50) +
                    "\n1) Buy a seat " +
                    "\n2) Cancel a seat " +
                    "\n3) Find first available seat " +
                    "\n4) Show seating plan " +
                    "\n5) Plane ticket information and total sales " +
                    "\n6) Search ticket " +
                    "\n0) Quit \n" +
                    "*".repeat(50));

            Scanner input = new Scanner(System.in);

            try {
                System.out.print("Please select an option : ");
                int user_option = input.nextInt();

                //Switch case to run the user's desired option.
                switch (user_option) {
                    case 1:
                        buy_seat();
                        break;
                    case 2:
                        cancel_seat();
                        break;
                    case 3:
                        first_seat_available();
                        break;
                    case 4:
                        show_seating_plan();
                        break;
                    case 5:
                        print_tickets_info();
                        break;
                    case 6:
                        search_ticket();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            }
            //Checking if the user's input is valid.
            catch(InputMismatchException e){
                System.out.println("Invalid option");
            }
        }
    }
}

