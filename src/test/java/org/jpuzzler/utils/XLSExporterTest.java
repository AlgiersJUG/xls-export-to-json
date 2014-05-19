package org.jpuzzler.utils;

import org.fest.assertions.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Abderrazak BOUADMA
 * Date: 5/19/14
 * Time: 2:20 PM
 */
public class XLSExporterTest {

    @Test
    public void XSLLoadedShouldExportToJSON() throws IOException {
        final InputStream xls = this.getClass().getClassLoader().getResourceAsStream("sheet.xls");
        String expectedJsonResponse = "[{\"cells\":[{\"content\":\"a1\"},{\"content\":\"b1\"}]},{\"cells\":[{\"content\":\"a2\"},{\"content\":\"b2\"}]},{\"cells\":[{\"content\":\"a3\"},{\"content\":\"b3\"}]},{\"cells\":[{\"content\":\"a4\"},{\"content\":\"b4\"}]},{\"cells\":[{\"content\":\"a5\"},{\"content\":\"b5\"}]}]";
        final String json = XlsExportService.toJSON(xls);
        Assertions.assertThat(json).isNotEmpty().isEqualTo(expectedJsonResponse);
    }
}
