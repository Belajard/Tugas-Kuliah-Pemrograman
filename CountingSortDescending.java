public class CountingSortDescending {
    public static void countingSort(int[] arr) {
        int max = arr[0], min = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];

        for (int num : arr) count[num - min]++;

        for (int i = range - 2; i >= 0; i--) count[i] += count[i + 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {27, 63, 14, 89, 42, 56, 71, 35};

        System.out.println("Sebelum sorting:");
        for (int num : arr) System.out.print(num + " ");
        System.out.println();

        countingSort(arr);

        System.out.println("Setelah sorting (terbesar ke terkecil):");
        for (int num : arr) System.out.print(num + " ");
    }
}