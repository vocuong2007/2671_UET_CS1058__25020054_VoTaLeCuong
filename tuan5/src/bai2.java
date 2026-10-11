import java.util.Arrays;
import java.util.Random;

public class bai2 {

    // =========================
    // INSERTION SORT
    // =========================
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // =========================
    // MERGE SORT
    // =========================
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }

        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {

            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }

            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    // =========================
    // TẠO DỮ LIỆU
    // =========================

    // Dữ liệu ngẫu nhiên
    public static int[] randomArray(int n) {
        Random random = new Random();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100000);
        }

        return arr;
    }

    // Dữ liệu đã tăng dần
    public static int[] sortedArray(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        return arr;
    }

    // Dữ liệu giảm dần
    public static int[] reversedArray(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }

        return arr;
    }

    // =========================
    // ĐO THỜI GIAN
    // =========================

    public static long measureInsertionSort(int[] original) {

        int[] arr = Arrays.copyOf(original, original.length);

        long start = System.nanoTime();

        insertionSort(arr);

        long end = System.nanoTime();

        return end - start;
    }

    public static long measureMergeSort(int[] original) {

        int[] arr = Arrays.copyOf(original, original.length);

        long start = System.nanoTime();

        mergeSort(arr, 0, arr.length - 1);

        long end = System.nanoTime();

        return end - start;
    }

    // =========================
    // MAIN
    // =========================

    public static void main(String[] args) {

        int[] sizes = {
                1000,
                5000,
                10000,
                20000,
                50000
        };

        System.out.println(
                "Size\tLoai du lieu\tInsertion Sort (ms)\tMerge Sort (ms)"
        );

        System.out.println(
                "-------------------------------------------------------------"
        );

        for (int n : sizes) {

            // =========================
            // RANDOM
            // =========================

            int[] random = randomArray(n);

            long insertionTime = measureInsertionSort(random);
            long mergeTime = measureMergeSort(random);

            System.out.println(
                    n + "\tRandom\t\t"
                            + insertionTime / 1_000_000.0 + "\t\t"
                            + mergeTime / 1_000_000.0
            );


            // =========================
            // SORTED
            // =========================

            int[] sorted = sortedArray(n);

            insertionTime = measureInsertionSort(sorted);
            mergeTime = measureMergeSort(sorted);

            System.out.println(
                    n + "\tTang dan\t"
                            + insertionTime / 1_000_000.0 + "\t\t"
                            + mergeTime / 1_000_000.0
            );


            // =========================
            // REVERSED
            // =========================

            int[] reversed = reversedArray(n);

            insertionTime = measureInsertionSort(reversed);
            mergeTime = measureMergeSort(reversed);

            System.out.println(
                    n + "\tGiam dan\t"
                            + insertionTime / 1_000_000.0 + "\t\t"
                            + mergeTime / 1_000_000.0
            );
        }
    }
}