package codingTasks.tasks_03_optimized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Task04_Bounce_FastestSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        StringTokenizer st = new StringTokenizer(line);
        short rows = Short.parseShort(st.nextToken());
        short cols = Short.parseShort(st.nextToken());

        reader.close();

        long sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if ((row + col) % 2 == 0) {
                    sum += 1 + (3 * (row + col));
                }
                if ((col % 2 == 1 && row % 2 == 1 && row != rows - 1 && col != cols - 1)
                        || (col % 2 == 0 && row % 2 == 0 && row != rows - 1 && row != 0 && col != 0 && col != cols - 1)) {
                    sum += 1 + (3 * (row + col));
                }
            }
        }

        System.out.print(sum);
    }
}