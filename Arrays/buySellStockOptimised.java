//maximum profit from buying and selling stocks with an optimized approach.

public class buySellStockOptimised {
    public int stockbuySell(int[] prices) {
        int minPriceSoFar = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int PotentialProfit = prices[i] - minPriceSoFar;  //profit if we sell at current price
            maxProfit = Math.max(maxProfit, PotentialProfit);  //update max profit if current potential profit is greater
            minPriceSoFar = Math.min(minPriceSoFar, prices[i]); //update min price if current price is lower
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        buySellStockOptimised sol = new buySellStockOptimised();
        int result = sol.stockbuySell(prices);
        System.out.println(result);
    }
}
