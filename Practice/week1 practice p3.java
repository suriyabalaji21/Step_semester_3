public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI   | Status");
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("  %-4d | %-10.2f | %-11.1f | %-5.2f | %s\n", 
                              (i + 1), heights[i], weights[i], bmi, status);
        }
    }

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi >= 18.5 && bmi < 25.0) return "Normal";
        if (bmi >= 25.0 && bmi < 30.0) return "Overweight";
        return "Obese";
    }