package coronoasrvc;

public class DataService {

	private Country country;
	private Incidence incidence;
	
	public DataService() throws Exception {
		JohnHopkins johnHopkins = new JohnHopkins();
		RobertKoch robertKoch = new RobertKoch();
		
		country = johnHopkins.getCountry();
		incidence = robertKoch.getIncidence();
	}
	
	//returns the new infections of the last 24 hours
	public int getNewInfections() {
		return (country.getGermany().get((country.getGermany().size()) - 1).getConfirmed()) 
				- country.getGermany().get((country.getGermany().size()) - 2).getConfirmed();
	}
	
	//returns the total infections
	public int getTotalInfections() {
		return ((country.getGermany().get((country.getGermany().size()) - 1).getConfirmed()) 
				   - (country.getGermany().get((country.getGermany().size()) - 1).getRecovered()));
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
	
	//returns the incidence value of germany
	public float getIncidenceValue() {
		float incidenceValue = 0;
		
		for(int i = 0; i < incidence.getFeatures().size(); i++) {
			incidenceValue += incidence.getFeatures().get(i).getAttributes().getCases7_bl_per_100k();
		}
		
		return incidenceValue / incidence.getFeatures().size();
	}
	
	//returns the target total infection
	public float getTargetTotalInfections() { 
		return (getTotalInfections() / getIncidenceValue()) * 35;
	}
	
	//returns the days of necessary days of lockdown
	public float getDaysOfLockdown(int days) {
		return (getTotalInfections() - getTargetTotalInfections()) / getAverageInfectionRise(days);
	}
	
	public float getAverageNewInfectionRise(int days) {
		
		float averageNewInfectionRise = 0;
		
		for (int i = 0; i < days; i++) {
			averageNewInfectionRise += ((country.getGermany().get((country.getGermany().size()) - (i + 1)).getConfirmed()) 
										- (country.getGermany().get((country.getGermany().size()) - (i + 2)).getConfirmed()))
											- ((country.getGermany().get((country.getGermany().size()) - (i + 2)).getConfirmed()) 
											- (country.getGermany().get((country.getGermany().size()) - (i + 3)).getConfirmed()));
		}
		
		return averageNewInfectionRise / days;
		
	}
}
