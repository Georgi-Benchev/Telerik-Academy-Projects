package codingTasks;

import java.util.Scanner;

public class PracticeMethods {
    public static void main(String[] args) {
        String resetColor = "\u001B[0m";
        String redColor = "\u001B[31m";
        String greenColor = "\u001B[32m";

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String[][] usersData = new String[4][2];

        // main loop
        while (!command.equals("end")) {
            String[] commandArgs = command.split(" ");
            switch (commandArgs[0]) {
                case "register":
                    registrationProcess(commandArgs, redColor, resetColor, usersData, greenColor);
                    break;
                case "delete": {
                    deleteAccountProcess(commandArgs, redColor, resetColor, usersData, greenColor);
                }
            }

            // read next command
            command = scanner.nextLine();
        }
    }

    private static void registrationProcess(String[] commandArgs, String redColor, String resetColor, String[][] usersData, String greenColor) {
        // validate arguments
        if (validArguments(commandArgs, redColor, resetColor)) return;

        String username = commandArgs[1];
        String password = commandArgs[2];

        // validate username
        // validate password
        if (usernameAndPasswordCheck(username, password, redColor, resetColor)) return;


        // check if username exists
        if (usernameExists(usersData, username, redColor, resetColor)) return;

        // find free slot
        int freeSlotIndex = getFreeSlotIndex(usersData);

        // no free slots
        if (freeSlotIndex == -1) {
            System.out.println(redColor + "The system supports a maximum number of 4 users." + resetColor);
            return;
        }

        // save user
        usersData[freeSlotIndex][0] = username;
        usersData[freeSlotIndex][1] = password;

        System.out.println(greenColor + "Registered user." + resetColor);
    }

    private static void deleteAccountProcess(String[] commandArgs, String redColor, String resetColor, String[][] usersData, String greenColor) {
        if (validArguments(commandArgs, redColor, resetColor)) return;

        String username = commandArgs[1];
        String password = commandArgs[2];

        // validate username
        // validate password
        if (usernameAndPasswordCheck(username, password, redColor, resetColor)) return;


        // find account to delete
        validationProcess(usersData, username, password, redColor, resetColor, greenColor);
    }

    private static boolean usernameAndPasswordCheck(String username, String password, String redColor, String resetColor) {
        if (username.length() < 3) {
            System.out.println(redColor + "Username must be at least 3 characters long." + resetColor);
            return true;
        }
        if (password.length() < 3) {
            System.out.println(redColor + "Password must be at least 3 characters long." + resetColor);
            return true;
        }
        return false;
    }

    private static void validationProcess(String[][] usersData, String username, String password, String redColor, String resetColor, String greenColor) {
        int accountIndex = -1;
        for (int i = 0; i < usersData.length; i++) {
            if (username.equals(usersData[i][0]) && password.equals(usersData[i][1])) {
                accountIndex = i;
            }
        }

        if (accountIndex == -1) {
            System.out.println(redColor + "Invalid account/password." + resetColor);
            return;
        }

        usersData[accountIndex][0] = null;
        usersData[accountIndex][1] = null;

        System.out.println(greenColor + "Deleted account." + resetColor);
    }

    private static boolean usernameExists(String[][] usersData, String username, String redColor, String resetColor) {
        boolean usernameExists = false;
        for (String[] usersDatum : usersData) {
            if (username.equals(usersDatum[0])) {
                usernameExists = true;
                break;
            }
        }

        if (usernameExists) {
            System.out.println(redColor + "Username already exists." + resetColor);
            return true;
        }
        return false;
    }

    private static int getFreeSlotIndex(String[][] usersData) {
        int freeSlotIndex = -1;
        for (int i = 0; i < usersData.length; i++) {
            if (usersData[i][0] == null) {
                freeSlotIndex = i;
            }
        }
        return freeSlotIndex;
    }

    private static boolean validArguments(String[] commandArgs, String redColor, String resetColor) {
        if (commandArgs.length < 3) {
            System.out.println(redColor + "Too few parameters." + resetColor);
            return true;
        }
        return false;
    }
}