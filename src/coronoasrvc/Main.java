package coronoasrvc;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.google.gson.Gson;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		/**
		try {
			TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new Herbert_Bot());
            System.out.println("Telegramm-Bot gestartet...");
            
        } catch (TelegramApiException e) {
        	e.printStackTrace();
        }
		**/
		
		
		DataService ds = new DataService();
		CovidKeyIndicators covidKeyIndicators = new CovidKeyIndicators(ds.getNewInfections(), 
																	   ds.getTotalInfections(),
																	   ds.getInfectionRise(),
																	   ds.getAverageInfectionRise(3),
																	   ds.getIncidenceValue(),
																	   ds.getTargetTotalInfections(),
																	   ds.getDaysOfLockdown());
		
		Gson gson = new Gson();
		String json = gson.toJson(covidKeyIndicators);
		
		System.out.println(json);
	}
}
