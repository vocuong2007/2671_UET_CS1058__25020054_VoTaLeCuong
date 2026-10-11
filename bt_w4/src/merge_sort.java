public class merge_sort {

    // In một đoạn của mảng
    static void printArray(int[] arr, int p, int r) {
        for (int i = p; i <= r; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Merge hai mảng con
    static void merge(int[] arr, int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;

        int[] L = new int[n1];
        int[] M = new int[n2];

        // Copy dữ liệu vào L
        for (int i = 0; i < n1; i++) {
            L[i] = arr[p + i];
        }

        // Copy dữ liệu vào M
        for (int j = 0; j < n2; j++) {
            M[j] = arr[q + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = p;

        // So sánh L và M
        while (i < n1 && j < n2) {

            if (L[i] <= M[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = M[j];
                j++;
            }

            k++;
        }

        // Nếu L còn phần tử
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Nếu M còn phần tử
        while (j < n2) {
            arr[k] = M[j];
            j++;
            k++;
        }

        // In kết quả sau mỗi lần merge
        System.out.print("Merge [" + p + ".." + r + "]: ");
        printArray(arr, p, r);
    }

    // Merge Sort
    static void mergeSort(int[] arr, int p, int r) {

        if (p < r) {

            int q = (p + r) / 2;

            // Chia nửa trái
            mergeSort(arr, p, q);

            // Chia nửa phải
            mergeSort(arr, q + 1, r);

            // Gộp hai nửa
            merge(arr, p, q, r);
        }
    }

    public static void main(String[] args) {

        int[] arr = {8, 3, 5, 1, 7, 2};

        System.out.print("Mang ban dau: ");
        printArray(arr, 0, arr.length - 1);

        System.out.println("\nCac buoc Merge Sort:");

        mergeSort(arr, 0, arr.length - 1);

        System.out.print("\nMang sau khi sap xep: ");
        printArray(arr, 0, arr.length - 1);
    }
}