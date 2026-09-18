class Problem4 {
    static double rowAverage(int[] row) {
        int sum = 0;

        for (int x : row)
            sum += x;

        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        String result = "";

        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);

            if (i > 0)
                result += " | ";

            result += "Match " + i + ": ";

            if (avg >= threshold)
                result += "Power Surge";
            else
                result += "Normal";
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] runs = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };

        System.out.println(classifyMatches(runs, 8));
    }
}