import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class InsertionSort2 {



    public static void insertionSort2(int n, List<Integer> arr) {

        for (int i = 1; i < n; i++) {

            int key = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j--;
            }

            arr.set(j + 1, key);

            for (int k = 0; k < n; k++) {
                System.out.print(arr.get(k) + " ");
            }

            System.out.println();
        }
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(
                        bufferedReader.readLine()
                                .replaceAll("\\s+$", "")
                                .split(" ")
                )
                .map(Integer::parseInt)
                .collect(toList());

        InsertionSort2.insertionSort2(n, arr);

        bufferedReader.close();
    }
}