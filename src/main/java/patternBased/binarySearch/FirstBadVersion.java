package patternBased.binarySearch;
//The isBadVersion API is defined in the parent class VersionControl.
      //boolean isBadVersion(int version);
//278. First Bad Version

/**
 * Example 1:
 *
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * Example 2:
 *
 * Input: n = 1, bad = 1
 * Output: 1
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 1; int right = n;

        while(left <right){
            int mid = left + (right - left)/2;
            if(isBadVersion(mid)){
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
//hypothetical method
    private boolean isBadVersion(int num) {
        return true;
    }
    //find last bad version??
    public int lastBadVersion(int n){
        int left = 1; int right = n;
        while (left < right) {
            int mid = left + (right - left + 1) / 2; //<===== CHECK THIS
            if (isBadVersion(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
/**
 1  2  3  4  5  6  7
 F  F  F  T  T  T  T
 We want the 1st true

 When loop exits: left > right
 At this moment:
 right is last known GOOD
 left is first BAD
 So we return left. */

