import java.util.Scanner;
public class shape {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Square");
        System.out.println("4. Triangle");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter radius: ");
                double r = sc.nextDouble();
                System.out.println("Area = " + (3.14 * r * r));
                break;

            case 2:
                System.out.print("Enter length and breadth: ");
                double l = sc.nextDouble();
                double b = sc.nextDouble();
                System.out.println("Area = " + (l * b));
                break;

            case 3:
                System.out.print("Enter side: ");
                double s = sc.nextDouble();
                System.out.println("Area = " + (s * s));
                break;

            case 4:
                System.out.print("Enter base and height: ");
                double h = sc.nextDouble();
                double ht = sc.nextDouble();
                System.out.println("Area = " + (0.5 * h * ht));
                break;

            default:
                System.out.println("Invalid choice");
        }

    }
}
