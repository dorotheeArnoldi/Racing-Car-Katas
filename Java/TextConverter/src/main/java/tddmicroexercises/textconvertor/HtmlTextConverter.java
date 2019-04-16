package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HtmlTextConverter
{
    private String fullFilenameWithPath;

    public HtmlTextConverter(String fullFilenameWithPath)
    {
        this.fullFilenameWithPath = fullFilenameWithPath;
    }

    public String convertToHtml() throws IOException {
        return convertToHtml(new BufferedReader(new FileReader(fullFilenameWithPath)));
    }

    public String convertToHtml(BufferedReader bufferedReader) throws IOException{
    
	    BufferedReader reader = bufferedReader;
	    
	    String line = reader.readLine();
	    String html = "";
	    while (line != null)
	    {
	    	html += StringEscapeUtils.escapeHtml(line);
	        html += "<br />";
	        line = reader.readLine();
	    }
	    return html;

    }

	public String getFilename() {
		return this.fullFilenameWithPath;
	}
}
