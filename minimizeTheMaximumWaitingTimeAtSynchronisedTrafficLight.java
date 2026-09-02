class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int maxGreen = Arrays.stream(lights).max().orElse(0);
        int lo = 0, hi = period;
        while (lo < hi) {
            int max = lo + (hi - lo) / 2;
            if (check(period, maxGreen, arrivalTime, max)) {
                hi = max;
            } else {
                lo = max + 1;
            }
        }
        return lo;
    }
    private boolean check(int period, int maxGreen, int[] arrivalTime, int max) {
        for (int i = 0; i < arrivalTime.length; i++) {
            int r = arrivalTime[i] % period;
            if (r < maxGreen) continue;
            int wait = period - r;
            if (wait > max) {
                return false;
            }
        }

        return true;
    }
}