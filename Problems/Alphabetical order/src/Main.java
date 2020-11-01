import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean result = true;

        String input = scanner.nextLine();
        String[] array = input.split(" ");

        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(array[i - 1]) < 0) {
                result = false;
            }
        }
        System.out.println(result);

    }
}