import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class StringProcessor {

    private static boolean isDigit(char c) {
        return c >= 48 && c <= 57;
    }

    private static boolean isLetter(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }

    private static boolean stringChecker(String str) {
        char c;

        if (str == null)
            return false;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (!isDigit(c) && !isLetter(c) && c != ']' && c != '[') return false;
        }
        return true;
    }

    private static void printOutput(String str) {
        char c;
        int printTimes;
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            printTimes = 0;
            output.setLength(0);
            c = str.charAt(i);

            while (isDigit(c)) {
                printTimes = printTimes * 10 + (c - 48);
                c = str.charAt(++i);
            }
            if (c == '[') {
                c = str.charAt(++i);
                if (isDigit(c)) {
                    i = str.lastIndexOf(']');
                    for (; printTimes > 0; printTimes--) printOutput(str.substring(str.indexOf('[') + 1, i));
                    c = str.charAt(i);
                }
                while (isLetter(c)) {
                    output.append(c);
                    c = str.charAt(++i);
                }
                for (; printTimes > 0; printTimes--) System.out.print(output);
            } else if (c != ']' && printTimes == 0) System.out.print(c);
            else if (c != ']') System.out.printf("%d%c", printTimes, c);
        }
    }

    public static void blocksParser(String str) {
        List<String> listOfBlocks = new ArrayList<>();
        char c;
        int printTimes;
        int openBracket;
        int closeBracket;
        int endOfBlock;
        int startOfBlock;

        for (int i = 0; i < str.length(); ) {
            printTimes = 0;
            openBracket = 0;
            closeBracket = 0;

            c = str.charAt(i);
            while (isDigit(c)) {
                printTimes = printTimes * 10 + (c - 48);
                c = str.charAt(++i);
            }

            if (c == '[') {
                openBracket++;
                startOfBlock = i++;
                for (; openBracket != closeBracket && i < str.length(); i++) {
                    c = str.charAt(i);
                    if (c == '[') openBracket++;
                    if (c == ']') closeBracket++;
                }
                endOfBlock = i;
                if (printTimes != 0)
                    listOfBlocks.add("" + printTimes + str.substring(startOfBlock, endOfBlock));
                else
                    listOfBlocks.add(str.substring(startOfBlock, endOfBlock));
            } else {
                if (printTimes != 0) listOfBlocks.add("" + printTimes + c);
                else listOfBlocks.add("" + c);
                i++;
            }
        }
        listOfBlocks.forEach(StringProcessor::printOutput);
    }

    public static void main(String[] args) {
        String str;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Введите строку, содержащую только : aA-zZ, 0-9, [, ].");
            str = scan.nextLine();
        } while (!stringChecker(str));
        System.out.print("\nРезультат: ");
        blocksParser(str);
    }
}
