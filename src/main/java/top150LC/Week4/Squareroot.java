package org.Week4;

public class Squareroot {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        while(l<=r){
            int mid = l+(r-l)/2;
            if ((long)mid*mid == x){
                return mid;
            }
            else if ((long)mid*mid > x){
                r = mid - 1;
            } else {
                l = mid+1;
            }
        }
        return r;
    }
    public int mySqrt1(int x) {
        int l = 0;
        int r = x;
        int res = 0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if ((long)mid*mid == x){
                return mid;
            }
            else if ((long)mid*mid > x){
                r = mid - 1;
            } else {
                l = mid+1;
                res = mid;
            }
        }
        return res;
    }
}
