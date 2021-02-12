package coronoasrvc;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		DataService ds = new DataService();
		
		System.out.println("Neuinfektionen der letzten 24 Stunden: " + ds.getNewInfections());
		System.out.println("Gesamtinfektionen: " + ds.getTotalInfections());
		System.out.println("Anstieg der letzten 24h: " + ds.getInfectionRise());
		System.out.println("Durchschnittlicher Anstieg der letzten 4 Tage: " + ds.getAverageInfectionRise(3));
		
		System.out.println("r-Wert für Gesamtdeutschland: " + ds.getIncidenceValue());
		System.out.println("Ziel-Gesamtinfektion: " + ds.getTargetTotalInfections());
		System.out.println("Notwendige Tage des Lockdowns: " + ds.getDaysOfLockdown());
	}
}
