class CountInversionBrute {
    static long countInversions(int[] arr) {
        long count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {8, 4, 2, 1};
        System.out.println(countInversions(arr));
    }
}
