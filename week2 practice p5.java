public static String normalizeReference(String raw) {
        if (raw == null) return "";
        
        String trimmed = raw.trim();
        
        // Ensure it has at least 3 characters before attempting substring on the first 3
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase(); 
        }
        
        // Uppercase only the first 3 characters, keep the rest untouched
        String firstThree = trimmed.substring(0, 3).toUpperCase();
        String remainder = trimmed.substring(3);
        
        return firstThree + remainder;
    }

    public static String validateAndFormat(String reference) {
        String normalized = normalizeReference(reference);
        
        // 1. Length validation
        if (normalized.length() != 14) {
            return "Invalid: wrong length";
        }
        
        // 2. First 3 chars must be letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(normalized.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        
        // 3. Remaining 11 chars must be digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(normalized.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        
        // If valid, build formatted string: "[BANKCODE] DATE: dd/MM/yy | SEQ: 12345"
        String bankCode = normalized.substring(0, 3);
        String dd = normalized.substring(3, 5);
        String mm = normalized.substring(5, 7);
        String yy = normalized.substring(7, 9);
        String seq = normalized.substring(9, 14);
        
        StringBuilder formattedString = new StringBuilder();
        formattedString.append("[").append(bankCode).append("] ")
                       .append("DATE: ").append(dd).append("/").append(mm).append("/").append(yy)
                       .append(" | SEQ: ").append(seq);
                       
        return formattedString.toString();
    }
}