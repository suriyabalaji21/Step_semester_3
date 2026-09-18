public static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatchPosition = -1;
        char expected = ' ';
        char actual = ' ';

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i + 1; // 1-based indexing for the user output
                expected = original.charAt(i);
                actual = typed.charAt(i);
            }
        }

        double accuracy = ((double) matched / original.length()) * 100;

        if (firstMismatchPosition == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches\n", 
                              matched, original.length(), accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')\n", 
                              matched, original.length(), accuracy, firstMismatchPosition, expected, actual);
        }
    }