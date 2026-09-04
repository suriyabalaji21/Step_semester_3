public static String normalizeCode(String raw) {
        if (raw == null) return "";
        
        String trimmed = raw.trim();
        
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        
        // Uppercase only the first 3 characters, keep the rest untouched
        String firstThree = trimmed.substring(0, 3).toUpperCase();
        String remainder = trimmed.substring(3);
        
        return firstThree + remainder;
    }

    public static String validateAndFormat(String code) {
        String normalized = normalizeCode(code);
        
        // Validation: Length
        if (normalized.length() != 13) {
            return "Invalid: wrong length";
        }
        
        // Validation: First 3 chars must be letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(normalized.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        
        // Validation: Remaining 10 chars must be digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(normalized.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        
        // Format if valid
        String pubCode = normalized.substring(0, 3);
        String year = normalized.substring(3, 7);
        String catalog = normalized.substring(7, 13);
        
        StringBuilder formattedString = new StringBuilder();
        formattedString.append("[").append(pubCode).append("] ")
                       .append("YEAR: ").append(year)
                       .append(" | CATALOG: ").append(catalog);
                       
        return formattedString.toString();
    }