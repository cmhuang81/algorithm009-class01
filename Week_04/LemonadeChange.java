class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 1, ten = 0;
        if (bills[0] > 5) {
            return false;
        }
        for (int i = 1; i < bills.length; i ++) {
            if (5 == bills[i]) {
                five ++;
            } else if (10 == bills[i]) {
                if (five > 0) {
                    five --;
                    ten ++ ;
                } else {
                    return false;
                }
            } else {
                if (five > 0 && ten > 0) {
                    five --;
                    ten --;
                } else if (five > 3){
                    five = five - 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}