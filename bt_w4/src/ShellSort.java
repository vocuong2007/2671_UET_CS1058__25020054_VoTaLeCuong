import java.util.Arrays;

class ShellSort {

    void shellSort(int array[], int n) {

        for (int interval = n / 2; interval > 0; interval /= 2) {

            for (int i = interval; i < n; i++) {

                int temp = array[i];
                int j;


                for (j = i;
                     j >= interval && array[j - interval] > temp;
                     j -= interval) {

                    array[j] = array[j - interval];
                }

                array[j] = temp;
            }


            System.out.println("Gap = " + interval + ": "
                    + Arrays.toString(array));
        }
    }

    public static void main(String args[]) {

        int[] data = {9, 8, 3, 7, 5, 6, 4, 1};

        int size = data.length;

        ShellSort ss = new ShellSort();

        System.out.println("Mang ban dau: "
                + Arrays.toString(data));

        System.out.println("\nCac buoc Shell Sort:");

        ss.shellSort(data, size);

        System.out.println("\nMang sau khi sap xep:");
        System.out.println(Arrays.toString(data));
    }
}