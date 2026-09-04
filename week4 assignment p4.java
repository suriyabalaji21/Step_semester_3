public static int subarraySum(int[] nums, int k) {
        int count = 0, currentSum = 0;
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        
        // Base case: a prefix sum of 0 has occurred exactly once at the start
        prefixMap.put(0, 1);
        
        for (int num : nums) {
            currentSum += num;
            
            // If currentSum - k exists in the map, a valid subarray ends here
            if (prefixMap.containsKey(currentSum - k)) {
                count += prefixMap.get(currentSum - k);
            }
            
            // Record the current prefix sum
            prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }