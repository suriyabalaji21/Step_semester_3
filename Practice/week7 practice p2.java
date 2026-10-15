public class Scorecard {
    private final boolean[] results;
    private int currentIndex;

    public Scorecard(int totalQuestions) {
        this.results = new boolean[totalQuestions];
        this.currentIndex = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (currentIndex < results.length) {
            this.results[currentIndex] = isCorrect;
            currentIndex++;
        }
    }

    public int getScore() {
        int score = 0;
        // Only loop up to the answers actually recorded
        for (int i = 0; i < currentIndex; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }
}