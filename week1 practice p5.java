public static String reverseCustomerName(String customerName) {
        char[] original = customerName.toCharArray();
        char[] reversed = new char[original.length];
        
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        
        return new String(reversed);
    }
}