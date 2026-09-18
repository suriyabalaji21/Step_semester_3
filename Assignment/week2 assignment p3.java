public static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length == 3) {
            System.out.printf("Product: %s | SKU: %s | Qty: %s\n", fields[0], fields[1], fields[2]);
        } else {
            System.out.println("Invalid Record");
        }
    }