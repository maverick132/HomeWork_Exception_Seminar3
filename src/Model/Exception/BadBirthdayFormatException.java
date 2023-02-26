package Model.Exception;

public class BadBirthdayFormatException extends Exception {

    String inputString;

    public BadBirthdayFormatException(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Ошибка при вводе даты '" + inputString + "', требуем формат 'дд.мм.гггг'.\n";
    }
}
