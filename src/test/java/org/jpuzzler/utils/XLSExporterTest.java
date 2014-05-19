package org.jpuzzler.utils;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Abderrazak BOUADMA
 * Date: 5/19/14
 * Time: 2:20 PM
 */
public class XLSExporterTest {

    private static final Logger logger = LoggerFactory.getLogger(XLSExporterTest.class);

    @Test
    public void XSLLoadedShouldExportToJSON() throws IOException {
        String excelDocumentFilename = "/home/merzoug/sheet.xls";
        String expectedJsonString = "[{\"cells\":[{\"content\":\"a1\"},{\"content\":\"b1\"}]},{\"cells\":[{\"content\":\"a2\"},{\"content\":\"b2\"}]},{\"cells\":[{\"content\":\"a3\"},{\"content\":\"b3\"}]},{\"cells\":[{\"content\":\"a4\"},{\"content\":\"b4\"}]},{\"cells\":[{\"content\":\"a5\"},{\"content\":\"b5\"}]}]";
        String json = XlsExportService.toJSON(excelDocumentFilename);
        Assertions.assertThat(json).isNotEmpty().isEqualTo(expectedJsonString.trim());
    }
}
