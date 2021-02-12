package coronoasrvc;

public class DataService {

	private Country country;
	
	public DataService() throws Exception {
		JohnHopkins johnHopkins = new JohnHopkins();
		RobertKoch robertKoch = new RobertKoch();
		
		country = johnHopkins.getCountry();
	}
	
	//returns the new infections of the last 24 hours
	public int getNewInfections() {
		return (country.getGermany().get((country.getGermany().size()) - 1).getConfirmed()) 
				- country.getGermany().get((country.getGermany().size()) - 2).getConfirmed();
	}
	
	//returns the total infections
	public int getTotalInfections() {
		return country.getGermany().get((country.getGermany().size()) - 1).getConfirmed();
	}
	
	//returns the infection rise of the last 24 hours
	public int getInfectionRise() {
		return ((country.getGermany().get((country.getGermany().size()) - 1).getConfirmed()) 
			   - (country.getGermany().get((country.getGermany().size()) - 1).getRecovered()))
					- ((country.getGermany().get((country.getGermany().size()) - 2).getConfirmed())
					- (country.getGermany().get((country.getGermany().size()) - 2).getRecovered()));
	}
	
	//returns the average infection rise of the last n days
	public float getAverageInfectionRise(int days) {
		float averageInfectionRise = 0;
		
		for(int i = 0; i < days; i++) {
			averageInfectionRise += ((country.getGermany().get((country.getGermany().size()) - (i + 1)).getConfirmed()) 
									- (country.getGermany().get((country.getGermany().size()) - (i + 1)).getRecovered()))
										- ((country.getGermany().get((country.getGermany().size()) - (i + 2)).getConfirmed()) 
										- (country.getGermany().get((country.getGermany().size()) - (i + 2)).getRecovered()));
		}
		return averageInfectionRise / days;
	}
	
}
