package Model.Exception;

public class BadPhoneNUmberFormatException extends Exception {
    String inputString;

    public BadPhoneNUmberFormatException(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Не получилось преобразовать " + inputString + " в телефонный номер, (нужный формат телефона 10 цифр без разделителей)\n";
    }
}
