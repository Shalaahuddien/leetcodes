class Solution {
    // private int[] prices;
    // private Integer[] cache;
    public int maxProfit(int[] prices) {
        // this.prices = prices;
        int n = prices.length;
        int [] maxProfitBuyStartAt = new int[n];
        for(int buy = n - 2; buy >= 0; buy--)
        {
            for(int sell = buy + 1; sell < n; sell++)
            {
                if(prices[sell] < prices[buy]) continue;
                int profit = prices[sell] - prices[buy];
                if(sell + 2 < n)
                {
                    profit += maxProfitBuyStartAt[sell + 2];
                } 
      maxProfitBuyStartAt[buy] = Math.max(maxProfitBuyStartAt[buy],profit);

            }
             maxProfitBuyStartAt[buy] = Math.max(maxProfitBuyStartAt[buy], maxProfitBuyStartAt[buy + 1] );
        }
            return maxProfitBuyStartAt[0];
        // this.cache = new Integer[n];
        // return dfs(0);
    }
    // private int dfs(int index)
    // {
        // int n = prices.length;
        // if(index >= n) return 0;
        // if(cache[index] != null) return cache[index];
        // //Buy
        // cache[index] = 0;
        // for(int buy = index; buy < n; buy++)
        // {
            //sell
            // int max = 0;
            // for(int sell = index + 1; sell < n; sell++)
            // {
                // if(prices[sell] < prices[buy]) continue;
                // max = Math.max(max, prices[sell] - prices[buy] + dfs(2+sell));
            // }
            //what`s the max profit if i start buy at current position
        // }
        
    }




/**

    [1,2,3,0,2]
     ^ ^

    [1,2,3,0,2]
           ^ ^
 */