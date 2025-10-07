package DynamicProgramming.SubsequenceSubarraySubset;

class CutRod {
    public int cutRod(int[] price) {
        // code here
        int capacity = price.length;
         int[] memory = new int[capacity+1];
        //Arrays.fill(memory, -1);
        for(int i=1; i<=price.length; i++){
            int[] temp = new int[capacity+1];
            for(int rodLength=1; rodLength<=capacity ; rodLength++){
                int take = 0;
                if(rodLength-i>=0){
                    take =  price[i-1] + temp[rodLength-i];
                }
                int nottake =  memory[rodLength];
                
                temp[rodLength] = Math.max(take, nottake);
            }
            memory=temp;
        }
            
        return memory[capacity];
    }
}
