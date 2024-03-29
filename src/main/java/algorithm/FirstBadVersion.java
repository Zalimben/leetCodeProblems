package main.java.algorithm;

/**
 * 278. First Bad Version
 *
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of
 * your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find
 * the first bad version. You should minimize the number of calls to the API.
 * <p>
 * Example 1:
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * <p>
 * Example 2:
 * Input: n = 1, bad = 1
 * Output: 1
 * <p>
 * Constraints:
 * 1 <= bad <= n <= 231 - 1
 */
public class FirstBadVersion
{
    public static void main(String[] args)
    {
        // Number of versions
        int versions = 36;
        System.out.println(firstBadVersion(versions));
    }

    public static int firstBadVersion(int versions)
    {
        int startVersion = 0;
        int endVersion = versions;
        int midVersion = startVersion + (endVersion - startVersion) / 2;

        while(startVersion <= endVersion) {
            if(isBadVersion(midVersion) && !isBadVersion(midVersion - 1)) {
                return midVersion;
            } else if(isBadVersion(midVersion)) {
                endVersion = midVersion - 1;
            } else {
                startVersion = midVersion + 1;
            }
            midVersion = startVersion + (endVersion - startVersion) / 2;
        }
        return -1;
    }

    /**
     * Dummy method to check if version is a bad one
     *
     * @param minVersion version to test
     * @return true, if version is a bad version
     */
    private static boolean isBadVersion(int minVersion)
    {
        return minVersion >= 7;
    }
}
