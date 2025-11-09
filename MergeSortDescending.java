public class MergeSortDescending {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = (arr[i] >= arr[j]) ? arr[i++] : arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (i = 0; i < temp.length; i++) arr[left + i] = temp[i];
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 23, 8, 15, 3, 19, 7};

        System.out.println("Sebelum sorting:");
        for (int num : arr) System.out.print(num + " ");
        System.out.println();

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Setelah sorting (terbesar ke terkecil):");
        for (int num : arr) System.out.print(num + " ");
    }
}