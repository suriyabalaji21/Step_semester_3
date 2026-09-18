public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;
        
        // We use a boolean array to avoid printing the same duplicate multiple times
        boolean[] checked = new boolean[seatNumbers.length];

        for (int i = 0; i < seatNumbers.length; i++) {
            if (checked[i]) continue;
            
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    if (!duplicateFound) {
                        System.out.print("Duplicate Seat Number Found: " + seatNumbers[i]);
                    } else {
                        System.out.print(", " + seatNumbers[i]);
                    }
                    duplicateFound = true;
                    checked[j] = true;
                    break;
                }
            }
        }
        
        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        } else {
            System.out.println();
        }
    }