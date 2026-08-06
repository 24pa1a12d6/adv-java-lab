import java.util.Scanner;

public class calculator{

    static void senderHi() {
        System.out.println("Sender: Hi");
    }

    static void receiverReply(Scanner sc) {
        System.out.print("Receiver: ");
        String msg = sc.nextLine();
    }

    static void calculation(Scanner sc) {
        System.out.println("What calculation do you want?");
        System.out.print("Enter (+, -, *, /, add, sub, mul, div, 1, 2, 3, 4): ");
        String ch = sc.next();

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        switch (ch) {
            case "+":
            case "add":
            case "1":
                System.out.println("Result = " + (a + b));
                break;

            case "-":
            case "sub":
            case "2":
                System.out.println("Result = " + (a - b));
                break;

            case "*":
            case "mul":
            case "3":
                System.out.println("Result = " + (a * b));
                break;

            case "/":
            case "div":
            case "4":
                System.out.println("Result = " + (a / b));
                break;

            default:
                System.out.println("Invalid choice");
        }
    }

    static void senderThankYou() {
        System.out.println("Sender: Thank You");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Advanced Java Lab");

        senderHi();

        System.out.print("Receiver: ");
        sc.nextLine();

        calculation(sc);

        sc.nextLine(); // clear buffer
        System.out.print("Receiver: ");
        sc.nextLine();

        senderThankYou();

        sc.close();
    }
}
