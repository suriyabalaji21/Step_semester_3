public static String validateFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        
        // Handle cases where there is no dot or it's the last character
        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }
        
        String extension = filename.substring(dotIndex + 1);
        
        if (extension.equalsIgnoreCase("pdf") || 
            extension.equalsIgnoreCase("docx") || 
            extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        } else {
            return "Rejected — invalid file type";
        }
    }