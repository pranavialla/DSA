class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> nums[i2]-nums[i1]);
        int n= nums.length;
        int[] output = new int[n-k+1];
        int outputIndex = 0;
        for(int i=0; i<nums.length; i++) {
            while(!pq.isEmpty() && pq.peek()<i-k+1) { // remove out of bound indices from root
                pq.remove();
            }
            pq.add(i); // add current element index to pq; this either goes to root or root remains unchanged
            
            if(i-k+1>=0) {
                output[outputIndex++] = nums[pq.peek()];
            }
        }
        
        return output;
       
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int outIndex = 0;

        for (int i = 0; i < n; i++) {
            // Remove indices out of the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices whose values are less than current value
            //it maintains strictly decreasing order
            //top element is always higher
            //when the latest element comes than the element less that that has no use so we remove them
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Record max value for the window
            if (i >= k - 1) {
                output[outIndex++] = nums[deque.peekFirst()];
            }
        }

        return output;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
       int n = nums.length;
        int[] dq = new int[n];
        int head = 0, tail = 0;
        int[] result = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            // 1) Evict indices outside window
            if (head < tail && dq[head] <= i - k) {
                head++;
            }
            // 2) Pop smaller values
            while (head < tail && nums[dq[tail - 1]] < nums[i]) {
                tail--;
            }
            // 3) Push current index
            dq[tail++] = i;
            // 4) Record max once window is full
            if (i >= k - 1) {
                result[i - k + 1] = nums[dq[head]];
            }
        }
        return result;

    }



}