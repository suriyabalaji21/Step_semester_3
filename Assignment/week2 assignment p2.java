public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder reversedSentence = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder reversedWord = new StringBuilder(words[i]);
            reversedWord.reverse();
            reversedSentence.append(reversedWord);
            
            // Append a space if it's not the last word
            if (i < words.length - 1) {
                reversedSentence.append(" ");
            }
        }
        return reversedSentence.toString();
    }