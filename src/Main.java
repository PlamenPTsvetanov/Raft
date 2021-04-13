import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int goats = scanner.nextInt();
        int trips = scanner.nextInt();

        int[] goatSizes = new int[goats];
        for (int i = 0; i < goats; i++) {
            goatSizes[i] = scanner.nextInt();
        }

        int courseMedium = Arrays.stream(goatSizes).sum() / trips;


        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < trips; i++) {
            int leftSum = getMax(goatSizes);

            int counter = goatSizes.length - 1;
            do {
                if (counter == -1) {
                    break;
                }

                if (goatSizes[counter] == 0) {
                    counter--;
                    continue;
                }
                if (goatSizes[counter] + leftSum <= courseMedium || i == trips - 1) {
                    leftSum += goatSizes[counter];
                    goatSizes[counter] = 0;
                }
                counter--;
            } while (leftSum <= courseMedium);
            list.add(leftSum);
        }
        System.out.println("Raft size: " + Collections.max(list, null));
    }

    private static int getMax(int[] arr) {
        Arrays.sort(arr);
        int max = arr[arr.length - 1];
        arr[arr.length - 1] = 0;
        return max;
    }

}
