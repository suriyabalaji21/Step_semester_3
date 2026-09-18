public static String maskPhoneNumber(String phone) {
        // Validate exact length
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }
        
        // Validate all characters are digits
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }
        
        StringBuilder maskedPhone = new StringBuilder("XXXXXX");
        maskedPhone.append("-");
        maskedPhone.append(phone.substring(6)); // append last 4 digits
        
        return maskedPhone.toString();
    }