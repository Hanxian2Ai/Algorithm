package competition;

class Solution100119 {
    private static final int MOD = 1_000_000_007;

    public int maximumXorProduct(long a, long b, int n) {
        if(a > b){
            long tem = a;
            a = b;
            b = tem;
        }
        long x = 0;
        int lastDiff = -1;
        boolean sol2 = (b > (1L << n) -1) && ((a >> n) < (b >> n));
        for (int i = 0; i < n ; i++) {
            long aVal = (a >> i) & 1;
            long bVal = (b >> i) & 1;
            if (aVal == bVal || sol2){
                x |= ((aVal ^ 1) << i);
            }else{
                x |= (aVal) << i;
                lastDiff = Math.max(lastDiff, i);
            }
        }
        if (!sol2 && lastDiff > -1){
            long mask = 1L << lastDiff;
            x ^= mask;
        }

        return (int) (((a ^ x) % MOD) * ((b ^ x) % MOD) % MOD);
    }
}