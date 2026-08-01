//given an array of prices where prices[i] is the price of a given stock on an ith day. 
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. 
// If you cannot achieve any profit, return 0.

public class StockBruteforce {
     public int stockbuySell(int[] prices) {
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++){
            for (int j=i+1; j<prices.length; j++){
                int profit = prices[j] - prices[i];
                if(profit > maxProfit){
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        StockBruteforce sol = new StockBruteforce();
        int result = sol.stockbuySell(prices);
System.out.println(result);
}
}