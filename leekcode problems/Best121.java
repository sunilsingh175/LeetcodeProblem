 import java.util.*;


public class Best121
  {
       public static void main(String[] args)
    {
       int[] prices = {7,1,5,3,6,4};
             System.out.println(maxProfit(prices));

    }
      
        public static int maxProfit(int[]  prices)
        {
          int buy = prices[0];
          int profit = 0;

             for(int i = 1; i< prices.length; i++)
           {
              int current_profit = prices[i]-buy;
               if(current_profit > profit)
              {
                profit = current_profit;
              }
               if( prices[i] < buy)
              {
                buy = prices[i];
              }
            }
              return profit;
         }
   }
