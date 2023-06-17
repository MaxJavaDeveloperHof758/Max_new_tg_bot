import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class NewBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        //sunflower BQACAgIAAxkBAAMNZI3yiU1QqDpDHw13eWGOCrx_fNIAAvkxAAJKYnBI_7viQWIAAYKmLwQ
        //mountains BQACAgIAAxkBAAMPZI3yw0oG1o4IBsc_iKALvSxRw_wAAgQyAAJKYnBIZ6LuAybec_svBA
        //dog BQACAgIAAxkBAAMRZI3y7WcMdG8mPXXRdhzBmDn8-CMAAgkyAAJKYnBImdRu_fVP3oovBA
        // cat BQACAgIAAxkBAAMTZI3zA4NTdT65l8wI8PSv38wpe80AAgwyAAJKYnBIkwAB6Aiy__ydLwQ
        SendMessage sendMessage=new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        KeyboardRow keyboardRow1=new KeyboardRow();
        KeyboardRow keyboardRow2=new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("Sunflower"));
        keyboardRow1.add(new KeyboardButton("Mountains"));
        keyboardRow2.add(new KeyboardButton("Cat"));
        keyboardRow2.add(new KeyboardButton("Dog"));
        List<KeyboardRow>list=new ArrayList<>();
        list.add(keyboardRow1);
        list.add(keyboardRow2);
        ReplyKeyboardMarkup replyKeyboardMarkup=new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(list);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        SendDocument sendDocument=new SendDocument();
        sendDocument.setChatId(update.getMessage().getChatId().toString());
        InputFile inputFile=new InputFile();
        switch (update.getMessage().getText()){
            case "Sunflower":
                inputFile.setMedia("BQACAgIAAxkBAAMNZI3yiU1QqDpDHw13eWGOCrx_fNIAAvkxAAJKYnBI_7viQWIAAYKmLwQ");
                break;
            case "Mountains":
                inputFile.setMedia("BQACAgIAAxkBAAMPZI3yw0oG1o4IBsc_iKALvSxRw_wAAgQyAAJKYnBIZ6LuAybec_svBA");
                break;
            case "Cat":
                inputFile.setMedia("BQACAgIAAxkBAAMTZI3zA4NTdT65l8wI8PSv38wpe80AAgwyAAJKYnBIkwAB6Aiy__ydLwQ");
                break;
            case "Dog":
                inputFile.setMedia("BQACAgIAAxkBAAMRZI3y7WcMdG8mPXXRdhzBmDn8-CMAAgkyAAJKYnBImdRu_fVP3oovBA");
                break;
        }
        sendDocument.setDocument(inputFile);
        try {
            execute(sendDocument);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String getBotUsername() {
        return "Max_superbrand_new_bot";
    }
    @Override
    public String getBotToken(){
        return "6114256559:AAFzY48KkcuKjMEBqhFGK2TrET1PkgvJQT8";
    }
}
