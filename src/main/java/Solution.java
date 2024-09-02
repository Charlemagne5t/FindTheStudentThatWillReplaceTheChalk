class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;

        long[] ps = new long[n];
        ps[0] = chalk[0];
        for (int i = 1; i < n; i++) {
            ps[i] = ps[i - 1] + chalk[i];
        }
        long t = (long) k % ps[n - 1];
        return bs(ps, t);
    }

    int bs(long[] ps, long target) {
        int l = 0;
        int r = ps.length - 1;
        int mid;
        int res = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (ps[mid] > target) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}