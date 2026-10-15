import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

interface Question {
    double grade();
    String getType();
}

class ExactMatchQuestion implements Question {
    private String type, correctAnswer, studentAnswer;
    private double points;

    public ExactMatchQuestion(String type, String correctAnswer, String studentAnswer, double points) {
        this.type = type; this.correctAnswer = correctAnswer; this.studentAnswer = studentAnswer; this.points = points;
    }
    public double grade() { return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0.0; }
    public String getType() { return type; }
}

class EssayQuestion implements Question {
    private String correctAnswer, studentAnswer;
    private double points;

    public EssayQuestion(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer; this.studentAnswer = studentAnswer; this.points = points;
    }
    public double grade() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        String studentLower = studentAnswer.toLowerCase();
        
        for (String keyword : keywords) {
            if (studentLower.contains(keyword.trim().toLowerCase())) {
                matchCount++;
            }
        }
        
        if (matchCount >= 2) return points * 0.75;
        if (matchCount == 1) return points * 0.50;
        return 0.0;
    }
    public String getType() { return "ESSAY"; }
}

public class GraderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Question> questions = new ArrayList<>();
        
        // Regex to parse space-separated tokens, handling quoted strings safely
        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);
            List<String> tokens = new ArrayList<>();
            while (matcher.find()) {
                tokens.add(matcher.group(1) != null ? matcher.group(1) : matcher.group(2));
            }
            
            String type = tokens.get(0);
            String correct = tokens.get(2);
            String student = tokens.get(3);
            double points = Double.parseDouble(tokens.get(4));
            
            if (type.equals("MCQ") || type.equals("TF")) {
                questions.add(new ExactMatchQuestion(type, correct, student, points));
            } else if (type.equals("ESSAY")) {
                questions.add(new EssayQuestion(correct, student, points));
            }
        }

        double total = 0;
        for (Question q : questions) {
            double score = q.grade();
            System.out.printf("%s: %.2f\n", q.getType(), score);
            total += score;
        }
        System.out.printf("Total Score: %.2f\n", total);
    }
}