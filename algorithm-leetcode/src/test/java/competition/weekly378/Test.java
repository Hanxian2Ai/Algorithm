package competition.weekly378;

public class Test {
    public int find(int n, int[] nums){
        int x = 0;

        for (int i = 1; i <= n; i++) {
            x ^= i;
        }

        for (int num : nums) {
            x ^= num;
        }
        return x;
    }
}
