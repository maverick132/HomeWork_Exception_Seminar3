package Model.Exception;

public class ValidateFormatException extends Exception {
    String message;

    public ValidateFormatException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}