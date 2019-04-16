package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class HtmlTextConverterTest {
    @Test
    public void convertsTextToHtml() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverter("foo");
        BufferedReader reader = new BufferedReader(new StringReader("hello world"));
        assertEquals("hello world<br />", converter.convertToHtml(reader));
    }

    @Test
    public void convertsTextualLinebreaksToHtmlLineBreaks() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverter("foo");
        BufferedReader reader = new BufferedReader(new StringReader("hello \nworld"));
        assertEquals("hello <br />world<br />", converter.convertToHtml(reader));

    }
}
