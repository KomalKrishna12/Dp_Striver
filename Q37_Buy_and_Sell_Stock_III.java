// in Q36 we are required to buy and sell multiple stocks by using the rules that we cannot buy again if
// we already have one buy stock so BS BS property have to be followed (BS : Buy - Sell)
// in this ques we have to buy atmost 2 stocks so use one cap variable whenever cap become 0 
// stop buying the stocks and return max profit
// three variables we use
// buy (0/1) 0 means we can sell stock and 1 means we can buy
// cap (0-2) buy atmost 2 stocks
// idx (0 to n)
public class Q37_Buy_and_Sell_Stock_III {

    public static int f(int idx, int buy, int cap, int[] prices, int n) {

        if (idx == n || cap == 0)
            return 0;

        if (buy == 1) {
            return Math.max(-prices[idx] + f(idx + 1, 0, cap, prices, n),
                    0 + f(idx + 1, 1, cap, prices, n));
        }

        return Math.max(prices[idx] + f(idx + 1, 1, cap - 1, prices, n),
                0 + f(idx + 1, 0, cap, prices, n));

    }

    public static void main(String[] args) {

        int[] prices = { 5, 4, 3, 2, 1 };

        int n = prices.length;

        System.out.println(f(0, 1, 2, prices, n));

    }
}
