package utils;

import java.util.Scanner;

public class CLIUtil {
    private static Scanner sc;

    static {
        sc = new Scanner(System.in);
    }

    public static int getInt() {
        int input = sc.nextInt();
        sc.nextLine();

        return input;
    }

    public static String getString() {
        return sc.nextLine();
    }

    public static double getDouble() {
        double input = sc.nextDouble();
        sc.nextLine();

        return input;
    }
}
