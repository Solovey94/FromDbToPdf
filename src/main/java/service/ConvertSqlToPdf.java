package service;

import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.sql.*;

public class ConvertSqlToPdf {
    public static void convert() throws Exception{
        /* Create Connection objects */
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/fromDbToPdf", "postgres", "solovey");
        Statement stmt = conn.createStatement();

        ResultSet query_set = stmt.executeQuery("SELECT sectionId,section,data FROM testdata");

        Document my_pdf_report = new Document();
        PdfWriter.getInstance(my_pdf_report, new FileOutputStream("pdf_from_sql_1.pdf"));
        my_pdf_report.open();

        PdfPTable my_report_table = new PdfPTable(3);

        PdfPCell table_cell;

        while (query_set.next()) {
            String sectionId = query_set.getString("sectionId");
            table_cell = new PdfPCell(new Phrase(sectionId));
            my_report_table.addCell(table_cell);
            String section = query_set.getString("section");
            table_cell = new PdfPCell(new Phrase(section));
            my_report_table.addCell(table_cell);
            String data = query_set.getString("data");
            table_cell = new PdfPCell(new Phrase(data));
            my_report_table.addCell(table_cell);
        }

        /* Attach report table to PDF */
        my_pdf_report.add(my_report_table);
        my_pdf_report.close();

        /* Close all DB related objects */
        query_set.close();
        stmt.close();
        conn.close();
    }


}
