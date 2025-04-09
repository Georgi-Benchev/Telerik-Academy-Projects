package codingTasks;

import java.util.ArrayList;
import java.util.Scanner;

public class SmallConsoleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] menuOutputs = {" Menu: Dial only one digit:", " 1 - Create Order", " 2 - List of Your Orders", " 3 - Request Help with an Order", " 4 - Cancel an Order", " 0 - Exit the program"};

        ArrayList<String> allOrders = new ArrayList<>();

        String userInput = "";
        while (!userInput.equals("0")) {

            System.out.println();
            System.out.println("********************************");
            System.out.println();

            for (String out : menuOutputs) {
                System.out.println(out);
            }
            System.out.println();

            userInput = scanner.nextLine();
            switch (userInput) {
                case "1":  // making of a new order
                    System.out.println("Enter the 2 digit product code or 00 to finish the order");
                    System.out.println("Here are the products and their codes:");
                    System.out.println("[01-Potato, 02-Fish, 03-Apple, 04-Orange, 05-Milk, 06-Music]");


                    // making of a new order
                    ArrayList<String> tempOrder = new ArrayList<>();

                    String answer = "";
                    while (!answer.equals("00")) {

                        answer = scanner.nextLine();

                        switch (answer) {
                            case "01":
                                tempOrder.add("01");
                                System.out.println("Adding Potato to the order");
                                break;
                            case "02":
                                tempOrder.add("02");
                                System.out.println("Adding Fish to the order");
                                break;
                            case "03":
                                tempOrder.add("03");
                                System.out.println("Adding Apple to the order");
                                break;
                            case "04":
                                tempOrder.add("04");
                                System.out.println("Adding Orange to the order");
                                break;
                            case "05":
                                tempOrder.add("05");
                                System.out.println("Adding Milk to the order");
                                break;
                            case "06":
                                tempOrder.add("06");
                                System.out.println("Adding Music to the order");
                                break;
                            case "00":
                                if (tempOrder.isEmpty()) {
                                    System.out.println("Can't add an empty order");
                                } else {
                                    System.out.println("Order accepted");
                                    allOrders.add(String.join(" ", tempOrder));
                                }
                                break;
                            default:
                                System.out.println("wrong code");
                        }
                    }


                    break;
                case "2":
                    if (allOrders.isEmpty()) {
                        System.out.println("You have 0 orders yet");
                    }
                    System.out.println("Here are your orders");
                    for (int i = 1; i <= allOrders.size(); i++) {
                        System.out.printf("Order #%d: Order: %s%n", i, allOrders.get(i - 1));
                    }
                    System.out.println();
                    System.out.println("press ENTER to go back to the main menu.");
                    String nothing1 = scanner.nextLine();
                    break;
                case "3":
                    System.out.println("You can find useful information on our website - www.armenskipop.com");
                    System.out.println("or call us anytime - 098 765 43 21");
                    System.out.println();
                    System.out.println("Press ENTER to go back to the main menu.");
                    String nothing2 = scanner.nextLine();
                    break;
                case "4":
                    if (allOrders.isEmpty()) {
                        System.out.println("You have 0 orders yet");
                    } else {
                        System.out.println("Please enter the number of the order that you want to cansel");
                        for (int i = 1; i <= allOrders.size(); i++) {
                            System.out.printf("Order #%d: Items: %s%n", i, allOrders.get(i - 1));
                        }


                        int n = Integer.parseInt(scanner.nextLine());
                        if (allOrders.size() >= n && n > 0) {
                            System.out.println("Order #" + n + " was removed successfully");
                            allOrders.remove(n - 1);
                        } else {
                            System.out.println("Invalid order number please try again");
                        }

                    }
                    System.out.println();
                    System.out.println("Press ENTER to go back to the main menu.");
                    String nothing3 = scanner.nextLine();

                    break;
                case "0":
                    System.out.println("Thank you for ordering with us");
                    if (!allOrders.isEmpty()) {
                        System.out.println("Your order is on its way");
                    }
                    break;
                default:
                    System.out.println("Please enter a valid number or exit the program by pressing 0");
                    break;
            }

        }
    }
}
