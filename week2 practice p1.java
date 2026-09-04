public static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        
        // Convert to lowercase to make checking case-insensitive
        String lowerText = text.toLowerCase();

        for (int i = 0; i < lowerText.length(); i++) {
            char ch = lowerText.charAt(i);
            
            // Ignore spaces and check only alphabetic characters
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.printf("Vowels: %d | Consonants: %d\n", vowels, consonants);
    }