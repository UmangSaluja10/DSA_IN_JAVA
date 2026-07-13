class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;

        int base = 256;          // number of possible characters
        int mod = 1000000007;    // large prime to avoid overflow

        int m = needle.length();
        int n = haystack.length();

        long patternHash = 0;
        long windowHash = 0;
        long highestPower = 1; // base^(m-1)

        // Compute highestPower = base^(m-1) % mod
        for (int i = 0; i < m - 1; i++) {
            highestPower = (highestPower * base) % mod;
        }

        // Compute initial hashes
        for (int i = 0; i < m; i++) {
            patternHash = (patternHash * base + needle.charAt(i)) % mod;
            windowHash = (windowHash * base + haystack.charAt(i)) % mod;
        }

        // Sliding window
        for (int i = 0; i <= n - m; i++) {

            // If hash matches, verify manually
            if (patternHash == windowHash) {
                if (haystack.substring(i, i + m).equals(needle)) {
                    return i;
                }
            }

            // Roll the hash
            if (i < n - m) {
                windowHash = (windowHash - haystack.charAt(i) * highestPower % mod + mod) % mod;
                windowHash = (windowHash * base + haystack.charAt(i + m)) % mod;
            }
        }

        return -1;
    }
}