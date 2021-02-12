package coronoasrvc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import com.google.gson.Gson;


public class JohnHopkins {
	
	private Country country;
	private String json;
	
	public JohnHopkins() throws Exception {
		
		json = readUrl("https://pomber.github.io/" + "covid19/timeseries.json");
		
		Gson gson = new Gson();
		country = gson.fromJson(json, Country.class);
	}
	
	private static String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
	    try {
	        URL url = new URL(urlString);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1) {
	        	buffer.append(chars, 0, read);
	        }
	        return buffer.toString();
	        
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	}
	
	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
}
