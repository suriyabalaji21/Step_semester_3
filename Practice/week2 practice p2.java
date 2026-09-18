public static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        
        if (fields.length == 3) {
            System.out.printf("Name: %s | Roll No: %s | Dept: %s\n", fields[0], fields[1], fields[2]);
        } else {
            System.out.println("Invalid Record");
        }
    }
