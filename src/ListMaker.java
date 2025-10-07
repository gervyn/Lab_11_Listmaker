import java.util.ArrayList;

public class ListMaker {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        boolean done = false;
        while (!done) {
            printMenuAndList(list);
            String choice = SafeInput.getRegExString("Enter command [A/D/I/P/Q]: ", "[AaDdIiPpQq]").toUpperCase();

            switch (choice) {
                case "A":
                    doAdd(list);
                    break;
                case "D":
                    doDelete(list);
                    break;
                case "I":
                    doInsert(list);
                    break;
                case "P":
                    doPrint(list);
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm("Are you sure you want to quit? (Y/N): ")) {
                        done = true;
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            System.out.println();
        }

        System.out.println("Goodbye!");
    }

    private static void printMenuAndList(ArrayList<String> list) {
        System.out.println("========== LISTMAKER ==========");
        if (list.isEmpty()) {
            System.out.println("[List is empty]");
        } else {
            printNumberedList(list);
        }
        System.out.println("----------- MENU --------------");
        System.out.println("A – Add an item to the end");
        System.out.println("D – Delete an item by number");
        System.out.println("I – Insert an item at a position");
        System.out.println("P – Print the list");
        System.out.println("Q – Quit (with confirmation)");
        System.out.println("--------------------------------");
    }

    private static void doPrint(ArrayList<String> list) {
        System.out.println("----- CURRENT LIST -----");
        if (list.isEmpty()) {
            System.out.println("[List is empty]");
        } else {
            printNumberedList(list);
        }
        System.out.println("------------------------");
    }

    private static void printNumberedList(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, list.get(i));
        }
    }

    private static void doAdd(ArrayList<String> list) {
        String item = SafeInput.getNonZeroLenString("Enter the item to ADD: ");
        list.add(item);
        System.out.println("Added to end.");
    }

    private static void doDelete(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("Nothing to delete. The list is empty.");
            return;
        }
        printNumberedList(list);
        int choice = SafeInput.getRangedInt("Enter item number to DELETE", 1, list.size());
        String removed = list.remove(choice - 1);
        System.out.println("Deleted: " + removed);
    }

    private static void doInsert(ArrayList<String> list) {
        String item = SafeInput.getNonZeroLenString("Enter the item to INSERT: ");
        int maxPos = list.size() + 1;
        int pos = SafeInput.getRangedInt("Enter position to INSERT at (1.." + maxPos + ")", 1, maxPos);
        list.add(pos - 1, item);
        System.out.println("Inserted at position " + pos + ".");
    }
}
