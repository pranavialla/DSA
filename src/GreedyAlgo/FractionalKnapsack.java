

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}



public class FractionalKnapsack {
    double fractionalKnapsack(int w, Item arr[], int n){

        Comparator<Item> comparator=new Comparator<Item>(){
            @Override
            public int compare(Item item1, Item item2){
                double unitValuePriceOfItem1= (double)item1.value/(double)item1.weight;
                double unitValuePriceOfItem2=(double)item2.value/(double)item2.weight;
                if (unitValuePriceOfItem1>unitValuePriceOfItem2){
                    return -1;
                }
                else if (unitValuePriceOfItem1<unitValuePriceOfItem2){
                    return 1;
                }
                else{
                    return 0;
                }

            }
        };
        Arrays.sort(arr, comparator);
        double remainingCapacityOfKnapSack=w;
        double totalValue=0;
        int index=0;
        while (remainingCapacityOfKnapSack!=0 & index<n){
            double currentMaximumValueOfItem=arr[index].weight;
            if(currentMaximumValueOfItem<=remainingCapacityOfKnapSack){
                remainingCapacityOfKnapSack=remainingCapacityOfKnapSack-currentMaximumValueOfItem;
                totalValue+=arr[index].value;
            }
            else {
                totalValue+=(((double)arr[index].value/(double)arr[index].weight))*(double) remainingCapacityOfKnapSack;
                remainingCapacityOfKnapSack=0;
            }
            index+=1;
        }
        return totalValue;
        // Your code here
    }
}

