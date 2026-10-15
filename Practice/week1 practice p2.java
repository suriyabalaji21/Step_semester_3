public static void checkPalindromes(String text) {
        String iterResult = isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome";
        String recResult = isPalindromeRecursive(text) ? "Palindrome" : "Not Palindrome";
        String arrResult = isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome";
        
        System.out.printf("\"%s\" Iterative: %s | Recursive: %s | Array Reversal: %s\n", 
                          text, iterResult, recResult, arrResult);
    }

    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) return false;
            left++; right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();
        char[] reversedArr = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversedArr[i] = arr[arr.length - 1 - i];
        }
        String reversedText = new String(reversedArr);
        return text.equals(reversedText);
    }