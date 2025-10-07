import java.util.Scanner;
import java.util.regex.Pattern;

public class SafeInput {
    private static final Scanner in = new Scanner(System.in);

    public static String getNonZeroLenString(String prompt) {
        String retVal;
        do {
            System.out.print(prompt);
            retVal = in.nextLine().trim();
        } while (retVal.length() == 0);
        return retVal;
    }

    public static int getRangedInt(String prompt, int low, int high) {
        int retVal = 0;
        boolean done = false;
        do {
            System.out.printf("%s [%d..%d]: ", prompt, low, high);
            if (in.hasNextInt()) {
                retVal = in.nextInt();
                in.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("Error: input out of range.");
                }
            } else {
                System.out.println("Error: please enter an integer.");
                in.nextLine();
            }
        } while (!done);
        return retVal;
    }

    public static String getRegExString(String prompt, String regEx) {
        String retVal;
        boolean gotAValue = false;
        do {
            System.out.print(prompt);
            retVal = in.nextLine().trim();
            if (Pattern.matches(regEx, retVal)) {
                gotAValue = true;
            } else {
                System.out.println("Error: input does not match pattern.");
            }
        } while (!gotAValue);
        return retVal;
    }

    public static boolean getYNConfirm(String prompt) {
        String resp = getRegExString(prompt, "[YyNn]");
        return resp.equalsIgnoreCase("Y");
    }
}

