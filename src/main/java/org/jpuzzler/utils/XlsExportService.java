package org.jpuzzler.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abderrazak BOUADMA
 * Date: 5/19/14
 * Time: 3:10 PM
 */
public class XlsExportService {

    public static String toJSON(InputStream stream) throws IOException {

        // create the sheet
        HSSFWorkbook workbook = new HSSFWorkbook(stream);

        // Conversion Boilerplate Code
        final List<MyRow> myRows = new ArrayList<>();

        // Extraction of sheet needed data
        HSSFSheet sheet = workbook.getSheetAt(0);
        final Iterator<Row> rows = sheet.iterator();
        while (rows.hasNext() ){
            MyRow myRow = new MyRow();
            myRows.add(myRow);
            final Iterator<Cell> cells = rows.next().iterator();
            while (cells.hasNext()) {
                MyCell myCell = new MyCell(cells.next().getStringCellValue());
                myRow.addCell(myCell);
            }
        }

        // export to json
        final Gson gson = new GsonBuilder().create();
        return gson.toJson(myRows);
    }

}
