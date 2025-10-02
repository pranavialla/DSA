


public class FindTheDuplicate {
    public FindTheDuplicate(int[] nums) {
        int slowPointer = nums[0];
        System.out.println(slowPointer);
        Boolean firstPointer=true;
        int fastPointer = nums[0];
        while (slowPointer != fastPointer || firstPointer) {
            if (firstPointer){
                firstPointer=false;
            }
            slowPointer = nums[slowPointer];
            fastPointer = nums[nums[fastPointer]];
        }
        fastPointer = nums[0];
        while (fastPointer != slowPointer) {
            slowPointer = nums[slowPointer];
            fastPointer = nums[fastPointer];
        }
        System.out.println(fastPointer);
    }
}

