public static void printFilteredWordFrequency(String feedback) {
        // Define stop words
        String[] stopWordsArray = {"the", "was", "and", "a", "is", "of", "in"};
        Set<String> stopWords = new HashSet<>(Arrays.asList(stopWordsArray));

        // Normalize text: lowercase and remove punctuation
        String cleanedText = feedback.toLowerCase().replace(".", "").replace(",", "");
        
        // Split text by whitespace
        String[] words = cleanedText.split("\\s+");
        
        // Count frequencies of valid words
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty() && !stopWords.contains(word)) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }
        
        // Sort by frequency descending
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordCounts.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        
        // Print the result
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}