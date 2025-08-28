package Default_Interfaces;

interface DataExporter {
    void export(String data);

    // New feature added as default
    default void exportToJSON(String data) {
        System.out.println("Default JSON Export: { \"data\": \"" + data + "\" }");
    }
}

class CSVExporter implements DataExporter {
    public void export(String data) {
        System.out.println("Exporting to CSV: " + data);
    }
}

class PDFExporter implements DataExporter {
    public void export(String data) {
        System.out.println("Exporting to PDF: " + data);
    }
}

public class ReportGenerator {
    public static void main(String[] args) {
        DataExporter csv = new CSVExporter();
        DataExporter pdf = new PDFExporter();

        csv.export("Sales Report");
        csv.exportToJSON("Sales Report"); // Uses default

        pdf.export("Invoice Report");
        pdf.exportToJSON("Invoice Report"); // Uses default
    }
}

