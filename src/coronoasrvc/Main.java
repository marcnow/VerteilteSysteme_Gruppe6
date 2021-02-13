package coronoasrvc;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		
		try {
			TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new Herbert_Bot());
            System.out.println("Telegramm-Bot gestartet...");
            
        } catch (TelegramApiException e) {
        	e.printStackTrace();
        }
		
		
		
		DataService ds = new DataService();
		System.out.println("Neuinfektionen der letzten 24 Stunden: " + ds.getNewInfections());
		System.out.println("Gesamtinfektionen: " + ds.getTotalInfections());
		System.out.println("Anstieg der letzten 24h: " + ds.getInfectionRise());
		System.out.println("Durchschnittlicher Anstieg der letzten 3 Tage: " + ds.getAverageInfectionRise(3));
		
		System.out.println("r-Wert für Gesamtdeutschland: " + ds.getIncidenceValue());
		System.out.println("Ziel-Gesamtinfektion: " + ds.getTargetTotalInfections());
		System.out.println("Notwendige Tage des Lockdowns: " + ds.getDaysOfLockdown());
	}
}
