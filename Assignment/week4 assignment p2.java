public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Decide to extend the current subarray or start fresh
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            // Track the largest sum found overall
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        
        return maxSoFar;
    }