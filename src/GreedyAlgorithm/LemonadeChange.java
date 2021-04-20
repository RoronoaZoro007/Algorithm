package GreedyAlgorithm;

public class LemonadeChange {

    /**
     * 860.在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
     * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
     * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
     * 注意，一开始你手头没有任何零钱。
     * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int fiveCnt = 0, tenCnt = 0, twentyCnt = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5)
                fiveCnt++;
            else if (bills[i] == 10) {
                if (fiveCnt <= 0)
                    return false;
                fiveCnt--;
                tenCnt++;
            } else {
                if (tenCnt == 0) {
                    if (fiveCnt < 3)
                        return false;
                    fiveCnt -= 3;
                } else {
                    if (fiveCnt < 1)
                        return false;
                    tenCnt--;
                    fiveCnt--;
                }
            }
        }
        return true;
    }
}
