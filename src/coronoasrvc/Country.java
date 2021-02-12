package coronoasrvc;

import java.util.List;

public class Country {
	
	private String countryName = "Germany";
    private List<CovidData> Germany;
    
    public Country() {
    }
    
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public List<CovidData> getGermany() {
		return Germany;
	}
	public void setGermany(List<CovidData> germany) {
		Germany = germany;
	}
}
