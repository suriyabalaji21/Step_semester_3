public static void testFirstNonRepeating(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result == '\0') {
            System.out.printf("\"%s\" No Non-Repeating Character Found\n", text);
        } else {
            System.out.printf("\"%s\" First Non-Repeating Character: '%c'\n", text, result);
        }
    }

    public static char findFirstNonRepeatingChar(String text) {
        int[] charCounts = new int[256]; 
        
        // Compute frequencies
        for (int i = 0; i < text.length(); i++) {
            charCounts[text.charAt(i)]++;
        }
        
        // Scan for the first character with a frequency of exactly 1
        for (int i = 0; i < text.length(); i++) {
            if (charCounts[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        
        // Return null character if no non-repeating character exists
        return '\0'; 
    }