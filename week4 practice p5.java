 public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        // Reduce k to avoid unnecessary full rotations
        k = k % nums.length;
        
        int[] newArray = new int[nums.length];

        // Work out the new position for each element
        for (int i = 0; i < nums.length; i++) {
            newArray[(i + k) % nums.length] = nums[i];
        }

        // The task allows returning the new array
        return newArray; 
    }
}