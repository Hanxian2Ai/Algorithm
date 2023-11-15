package competition;

class Solution2929 {
    public long distributeCandies(int n, int limit) {
        return C(n + 2) - (3 * C(n- (limit + 1) + 2) - 3 * C(n - 2 * (limit + 1) + 2) + C(n - 3 * (limit + 1) + 2));
    }

    public long C(int n){
        if(n <= 1){
            return 0;
        }
        return (long)n * (n - 1) / 2;
    }
}
