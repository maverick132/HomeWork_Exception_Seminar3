package Model.Exception;

public class BadFLPFormatException extends Exception {

    String inputString;

    public BadFLPFormatException(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Неправильный формат ФИО '" + inputString + "'. ФИО могут состоять только из букв.\n";
    }
}