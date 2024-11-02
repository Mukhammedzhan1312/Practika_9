// Модуль 09 Структурные паттерны. Декоратор.
interface IReport {
    String generate();
}


class SalesReport implements IReport {
    @Override
    public String generate() {
        return "Sales report data";
    }
}

class UserReport implements IReport {
    @Override
    public String generate() {
        return "User report data";
    }
}

abstract class ReportDecorator implements IReport {
    protected IReport report;

    public ReportDecorator(IReport report) {
        this.report = report;
    }

    @Override
    public String generate() {
        return report.generate();
    }
}

class DateFilterDecorator extends ReportDecorator {
    private String startDate;
    private String endDate;

    public DateFilterDecorator(IReport report, String startDate, String endDate) {
        super(report);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String generate() {
        return report.generate() + "\nFiltered by date from " + startDate + " to " + endDate;
    }
}

class SortingDecorator extends ReportDecorator {
    private String criteria;

    public SortingDecorator(IReport report, String criteria) {
        super(report);
        this.criteria = criteria;
    }

    @Override
    public String generate() {
        return report.generate() + "\nSorted by " + criteria;
    }
}

class CsvExportDecorator extends ReportDecorator {
    public CsvExportDecorator(IReport report) {
        super(report);
    }

    @Override
    public String generate() {
        return report.generate() + "\nExported to CSV format";
    }
}

class PdfExportDecorator extends ReportDecorator {
    public PdfExportDecorator(IReport report) {
        super(report);
    }

    @Override
    public String generate() {
        return report.generate() + "\nExported to PDF format";
    }
}

public class Decorator {
    public static void main(String[] args) {
        IReport report = new SalesReport();
        report = new DateFilterDecorator(report, "2023-01-01", "2023-12-31");
        report = new SortingDecorator(report, "date");
        report = new CsvExportDecorator(report);

        System.out.println(report.generate());
    }
}




