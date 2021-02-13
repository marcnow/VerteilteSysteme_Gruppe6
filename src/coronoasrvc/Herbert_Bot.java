package coronoasrvc;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

     public class Herbert_Bot extends TelegramLongPollingBot {

		public void onUpdateReceived(Update update) {
			// TODO was passiert wenn einem über Telegramm geschrieben wird
			 
			String command = update.getMessage().getText();
			DataService ds = null;
			try {
				ds = new DataService();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			SendMessage message = new SendMessage();
			
			if(command.equals("/start")) {
				System.out.println(update.getMessage().getText());
				
				message.setText("Hallo ich bin Herbert, der von den Studenten der HRW programmierte Bot, über den man die aktuellen Corona Kennzahlen in Deutschland beziehen kann. Wie kann ich Ihnen weiterhelfen?");
			}
			else if(command.equals("/neuinfektionen")) {
				System.out.println(update.getMessage().getText());
				
				message.setText("Von gestern auf heute haben sich " + ds.getNewInfections()  + " Leute neu mit Corona infiziert");
			}
			
			else if(command.equals("/gesamtinfektionen")) {
				System.out.println(update.getMessage().getText());
				message.setText("Von gestern auf heute haben sich .... Leute neu mit Corona infiziert");
			}
			
			else if(command.equals("/anstieg")) {
				System.out.println(update.getMessage().getText());
				message.setText("Von gestern auf heute haben sich .... Leute neu mit Corona infiziert");
			}
			
			else if(command.equals("/durchschnittlicheranstieg")) {
				System.out.println(update.getMessage().getText());
				message.setText("Von gestern auf heute haben sich .... Leute neu mit Corona infiziert");
			}
			
			else if(command.equals("/rwert")) {
				System.out.println(update.getMessage().getText());
				message.setText("Von gestern auf heute haben sich .... Leute neu mit Corona infiziert");
			}
			
			else if(command.equals("/zielgesamtinfektionen")) {
				System.out.println(update.getMessage().getText());
				message.setText("Von gestern auf heute haben sich .... Leute neu mit Corona infiziert");
			}
			
			else if(command.equals("/voraussage")) {
				System.out.println(update.getMessage().getText());
				message.setText("Von gestern auf heute haben sich .... Leute neu mit Corona infiziert");
			}
			
			// den hier braucht man wahrscheinlich nicht der zeigt nur an, wenn Text in Telegramm geschrieben wird - error entsteht weil probiert wird ne nachricht zu senden
			else {
				System.out.println(update.getMessage().getText());
			}
			
			message.setChatId(update.getMessage().getChatId().toString());
			
			if(message.getText()!=null) {
			try {
				execute(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			}
		}
		
		//hier muss immer der Bot Username returned werden
		public String getBotUsername() {
			return "HRWGruppe6_Herbert_Bot";
		}
		// hier muss immer der Bot Token returned werden
		@Override
		public String getBotToken() {
			return "1617533748:AAHNMwFsp17gySJwEsxewNYhlJV76ARgKiI";
		}

     }
