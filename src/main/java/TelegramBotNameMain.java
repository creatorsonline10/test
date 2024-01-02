import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.UpdatesListener;

public class TelegramBotNameMain {

  public static long chatId = 6648628804L;

  public static void main(String[] args) {

    System.out.println("hi");
    TelegramBot bot = new TelegramBot("6935993835:AAGX-L1e7hPzVBVXLPghTeenWxAOfQh-Twc");

    new Thread(
            () -> {
              SendMessage message = new SendMessage(chatId, "A New Device Connected");
              SendResponse response = bot.execute(message);
            })
        .start();

    bot.setUpdatesListener(
        updates -> {
          for (Update update : updates) {
            Message message = update.message();

            if (message != null && message.text() != null) {
              String text = message.text();
              SendMessage msg = new SendMessage(chatId, "dhat");
              bot.execute(msg);
            }
          }
          return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
  }
}

