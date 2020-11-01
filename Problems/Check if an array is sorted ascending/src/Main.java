import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[scanner.nextInt()];
        boolean result = true;

        array[0] = scanner.nextInt();
        for (int i = 1; i < array.length; i++) {
            array[i] = scanner.nextInt();
            if (array[i] < array[i - 1]) {
                result = false;
            }
        }

        System.out.println(result);
    }
}