package wrappers;

import java.util.ArrayList;
import java.util.List;

public class OutputLine {
    
	private ExcelName path;
	
	public ExcelName getPath() {
		return path;
	}

	private ApachePoiStyles style;
	
	public ApachePoiStyles getStyle() {
		return style;
	}

	public List<String> getValues() {
		return values;
	}

	private List<String> values = new ArrayList<String>();
	
	public OutputLine(ApachePoiStyles style , List<String> values , ExcelName path) {
		this.style=style;
		this.values=values;
		this.path=path;
		
	}
	
	public OutputLine(ApachePoiStyles style,ExcelName path) {
	
		this.style=style;
		this.path=path;
		
	}
}
