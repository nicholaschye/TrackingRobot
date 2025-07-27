import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); 
        int x = scanner.nextInt(); 
        int y = scanner.nextInt(); 

        int[] itemX = new int[n];
        int[] itemY = new int[n];
        boolean[] picked = new boolean[n];
        int[] sequence = new int[n];

        for (int i = 0; i < n; i++) {
            itemX[i] = scanner.nextInt();
            itemY[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int minDist = 1000000;
            int index = -1;

            for (int j = 0; j < n; j++) {
                if (!picked[j]) {
                    int dist = Math.abs(x - itemX[j]) + Math.abs(y - itemY[j]);
                    if (dist < minDist) {
                        minDist = dist;
                        index = j;
                    }
                }
            }

            picked[index] = true;
            x = itemX[index];
            y = itemY[index];
            sequence[i] = index + 1; 
        }

        System.out.print("Pickup Sequence: ");
        for (int i = 0; i < n; i++) {
            System.out.print(sequence[i] + " ");
        }

        scanner.close();
    }
}
