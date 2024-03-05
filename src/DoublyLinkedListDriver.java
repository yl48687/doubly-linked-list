import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Contructs a driver program for {@code DoublyLinkedList}. Handles three list types: integer,
 * double, and string. Based on the list type given, the program creates a new
 * {@code DoublyLinkedList} and handles command input by the user.
 */
public class DoublyLinkedListDriver {
    /**
     * Runs the driver by reading the file given by {@code args}. The program will read commands
     * provided by the user and give appropriate outputs.
     *
     * @param args The path of the file.
     */
    public static void main(String[] args) {
        String filePath;

        // Initializes three lists for different types that are available: integer, double, or
        // string.
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<Integer>();
        DoublyLinkedList<Double> list2 = new DoublyLinkedList<Double>();
        DoublyLinkedList<String> list3 = new DoublyLinkedList<String>();

        // Stores the first command-line argument as the path to the file. If no command-line
        // argument is given, the program exits.
        if (args.length > 0) {
            filePath = args[0];
        } else {
            System.out.print("Please provide a path to the file as a command-line argument.");
            return;
        } // if

        // Reads the user input for the list type.
        System.out.print("Enter list type (i - int, d - double, s - string): ");
        Scanner scanner = new Scanner(System.in);
        String listType = scanner.nextLine();

        // Tries to find the file through the given path. If file is not found, the program throws
        // FileNotFoundException and exits.
        try {
            File inputFile = new File(filePath);
            Scanner scanner2 = new Scanner(inputFile);
            // Reads the values from the input file.
            while (scanner2.hasNext()) {
                if (listType.equalsIgnoreCase("i")) {
                    int number = scanner2.nextInt();
                    list1.insertItem(number);
                } else if (listType.equalsIgnoreCase("d")) {
                    double number = scanner2.nextDouble();
                    list2.insertItem(number);
                } else if (listType.equalsIgnoreCase("s")) {
                    String word = scanner2.next();
                    list3.insertItem(word);
                } // if
            } // while
            scanner2.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            return;
        } // try

        System.out.println("Commands:\n");
        System.out.println("(i) - Insert value");
        System.out.println("(d) - Delete value");
        System.out.println("(p) - Print list");
        System.out.println("(l) - Length");
        System.out.println("(t) - Print reverse");
        System.out.println("(r) - Reverse list");
        System.out.println("(b) - Delete Subsection");
        System.out.println("(s) - Swap Alternate");
        System.out.println("(q) - Quit program");

        char command;
        do {
            System.out.print("Enter a command: ");
            command = scanner.next().charAt(0);
            scanner.nextLine();
            switch (command) {
            case 'i':
                // Handles Insert value (i) command by inserting a desired value into the list and
                // printing the resulting and reverse list.
                if (listType.equalsIgnoreCase("i")) {
                    System.out.print("The list is : ");
                    list1.print();
                    System.out.print("Enter a number to insert: ");
                    int num = scanner.nextInt();
                    // Inserts the desired item into the list if the list does not contain the item.
                    // Otherwise, prints an error message.
                    if (!list1.contains(num)) {
                        list1.insertItem(num);
                        scanner.nextLine();
                    } else if (list1.contains(num)) {
                        System.out.println("Item already exists");
                    } // if
                    System.out.print("The list is: ");
                    list1.print();
                    System.out.print("The reverse list: ");
                    list1.printReverse();
                } else if (listType.equalsIgnoreCase("d")) {
                    System.out.print("The list is : ");
                    list2.print();
                    System.out.print("Enter a number to insert: ");
                    double num = scanner.nextDouble();
                    if (!list2.contains(num)) {
                        list2.insertItem(num);
                        scanner.nextLine();
                    } else if (list2.contains(num)) {
                        System.out.println("Item already exist");
                    } // if
                    System.out.print("The list is: ");
                    list2.print();
                    System.out.print("The reverse list: ");
                    list2.printReverse();
                } else if (listType.equalsIgnoreCase("s")) {
                    System.out.print("The list is : ");
                    list3.print();
                    System.out.print("Enter a number to insert: ");
                    String str = scanner.next();
                    if (!list3.contains(str)) {
                        list3.insertItem(str);
                        scanner.nextLine();
                    } else if (list3.contains(str)) {
                        System.out.println("Item already exists");
                    } // if
                    System.out.print("The list is: ");
                    list3.print();
                    System.out.print("The reverse list: ");
                    list3.printReverse();
                } // if
                break;
            case 'd':
                // Handles Delete value (d) command by deleting the desired item from the list and
                // printing the resulting and reverse list.
                if (listType.equalsIgnoreCase("i")) {
                    // Does not print the list if the current list is empty.
                    if (list1.length() > 0) {
                        System.out.print("The list is : ");
                        list1.print();
                    } // if
                    System.out.print("Enter a number to delete: ");
                    int num = scanner.nextInt();
                    // Prints error message if item does not exist or the user tries to delete from
                    // an empty list. Otherwise, proceeds to delete the item.
                    if (!list1.contains(num) && list1.length() > 0) {
                        System.out.println("The item is not present in the list");
                    } else if (!list1.contains(num) && list1.length() == 0) {
                        System.out.println("You cannot delete from an empty list");
                    } else if (list1.contains(num)) {
                        list1.deleteItem(num);
                        scanner.nextLine();
                    } // if
                    // Does not print the final list if the list is empty.
                    if (list1.length() > 0) {
                        System.out.print("The list is: ");
                        list1.print();
                        System.out.print("The reverse list: ");
                        list1.printReverse();
                    } // if
                } else if (listType.equalsIgnoreCase("d")) {
                    if (list2.length() > 0) {
                        System.out.print("The list is : ");
                        list2.print();
                    } // if
                    System.out.print("Enter a number to delete: ");
                    double num = scanner.nextDouble();
                    if (!list2.contains(num) && list2 != null) {
                        System.out.println("The item is not present in the list");
                    } else if (!list2.contains(num) && list2 == null) {
                        System.out.println("You cannot delete from an empty list");
                    } else if (list2.contains(num)) {
                        list2.deleteItem(num);
                        scanner.nextLine();
                    } // if
                    if (list2.length() > 0) {
                        System.out.print("The list is: ");
                        list2.print();
                        System.out.print("The reverse list: ");
                        list2.printReverse();
                    } // if
                } else if (listType.equalsIgnoreCase("s")) {
                    if (list3.length() > 0) {
                        System.out.print("The list is : ");
                        list3.print();
                    } // if
                    System.out.print("Enter a number to delete: ");
                    String str = scanner.next();
                    if (!list3.contains(str) && list3 != null) {
                        System.out.println("The item is not present in the list");
                    } else if (!list3.contains(str) && list3 == null) {
                        System.out.println("You cannot delete from an empty list");
                    } else if (list3.contains(str)) {
                        list3.deleteItem(str);
                        scanner.nextLine();
                    } // if
                    if (list3.length() > 0) {
                        System.out.print("The list is: ");
                        list3.print();
                        System.out.print("The reverse list: ");
                        list3.printReverse();
                    } // if
                } // if
                break;
            case 'p':
                // Handles Print list (p) command by printing the list.
                System.out.print("The list is : ");
                if (listType.equalsIgnoreCase("i")) {
                    list1.print();
                } else if (listType.equalsIgnoreCase("d")) {
                    list2.print();
                } else if (listType.equalsIgnoreCase("s")) {
                    list3.print();
                } // if
                break;
            case 'l':
                // Handles Length (l) command by printing the length of the list.
                if (listType.equalsIgnoreCase("i")) {
                    System.out.println("The length of the list is " + list1.length());
                } else if (listType.equalsIgnoreCase("d")) {
                    System.out.println("The length of the list is " + list2.length());
                } else if (listType.equalsIgnoreCase("s")) {
                    System.out.println("The length of the list is " + list3.length());
                } // if
                break;
            case 't':
                // Handles Print reverse (t) command by printing the reverse of the list.
                System.out.print("The reverse list: ");
                if (listType.equalsIgnoreCase("i")) {
                    list1.printReverse();
                } else if (listType.equalsIgnoreCase("d")) {
                    list2.printReverse();
                } else if (listType.equalsIgnoreCase("s")) {
                    list3.printReverse();
                } // if
                break;
            case 'r':
                // Handles Reverse list (r) command by reversing the list and printing the original
                // and reversed lists.
                System.out.print("The original list: ");
                if (listType.equalsIgnoreCase("i")) {
                    list1.print();
                    list1.reverseList();
                    System.out.print("The reversed list: ");
                    list1.print();
                } else if (listType.equalsIgnoreCase("d")) {
                    list2.print();
                    list2.reverseList();
                    System.out.print("The reversed list: ");
                    list2.print();
                } else if (listType.equalsIgnoreCase("s")) {
                    list3.print();
                    list3.reverseList();
                    System.out.print("The reversed list: ");
                    list3.print();
                } // if
                break;
            case 'b':
                // Handles Delete Subsection (b) command by deleting the subsections requested by
                // the user and printing the original, modified, and reversed lists.
                System.out.print("Enter the lower bound: ");
                if (listType.equalsIgnoreCase("i")) {
                    int lowerBound = scanner.nextInt();
                    System.out.print("Enter the upper bound: ");
                    int upperBound = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("The original list: ");
                    list1.print();
                    list1.deleteSubsection(lowerBound, upperBound);
                    System.out.print("The modified list: ");
                    list1.print();
                    System.out.print("The reverse list: ");
                    list1.printReverse();
                    if (list1.length() == 0) {
                        System.out.println("");
                    } // if
                } else if (listType.equalsIgnoreCase("d")) {
                    double lowerBound = scanner.nextDouble();
                    System.out.print("Enter the upper bound: ");
                    double upperBound = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("The original list: ");
                    list2.print();
                    list2.deleteSubsection(lowerBound, upperBound);
                    System.out.print("The modified list: ");
                    list2.print();
                    System.out.print("The reverse list: ");
                    list2.printReverse();
                    if (list2.length() == 0) {
                        System.out.println("");
                    } // if
                } else if (listType.equalsIgnoreCase("s")) {
                    String lowerBound = scanner.next();
                    System.out.print("Enter the upper bound: ");
                    String upperBound = scanner.next();
                    scanner.nextLine();
                    System.out.print("The original list: ");
                    list3.print();
                    list3.deleteSubsection(lowerBound, upperBound);
                    System.out.print("The modified list: ");
                    list3.print();
                    System.out.print("The reverse list: ");
                    list3.printReverse();
                    if (list3.length() == 0) {
                        System.out.println("");
                    } // if
                } // if
                break;
            case 's':
                // Handles Swap Alternate (s) command by swapping the alternate inputs and printing
                // the original, modified, and reverse lists.
                System.out.print("The original list: ");
                if (listType.equalsIgnoreCase("i")) {
                    list1.print();
                    list1.swapAlternate();
                    System.out.print("The modified list: ");
                    list1.print();
                    System.out.print("The reverse list: ");
                    list1.reverseList();
                    list1.print();
                    list1.reverseList();
                } else if (listType.equalsIgnoreCase("d")) {
                    list2.print();
                    list2.swapAlternate();
                    System.out.print("The modified list: ");
                    list2.print();
                    System.out.print("The reverse list: ");
                    list2.reverseList();
                    list2.print();
                    list2.reverseList();
                } else if (listType.equalsIgnoreCase("s")) {
                    list3.print();
                    list3.swapAlternate();
                    System.out.print("The modified list: ");
                    list3.print();
                    System.out.print("The reverse list: ");
                    list3.reverseList();
                    list3.print();
                    list3.reverseList();
                } // if
                break;
            case 'q':
                // Handles Quit program (q) command by exiting the program and printing the exiting
                // message.
                System.out.println("Exiting the program...");
                break;
            default:
                System.out.println("Invalid command. Try again. ");
            } // switch
        } while (command != 'q'); // while
        scanner.close();
    } // main
} // DoublyLinkedListDriver
