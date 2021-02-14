package coronoasrvc;

public class CovidKeyIndicators {
	
	private int newInfections;
	private int totalInfections;
	private int infectionRise;
	private float averageInfectionRise;
	private float incidenceValue;
	private float targetTotalInfections;
	private float daysOfLockdown;
	
	public CovidKeyIndicators(int newInfections, int totalInfections, int infectionRise, float averageInfectionRise,
			float incidenceValue, float targetTotalInfections, float daysOfLockdown) {
		
		this.newInfections = newInfections;
		this.totalInfections = totalInfections;
		this.infectionRise = infectionRise;
		this.averageInfectionRise = averageInfectionRise;
		this.incidenceValue = incidenceValue;
		this.targetTotalInfections = targetTotalInfections;
		this.daysOfLockdown = daysOfLockdown;
	}
}
