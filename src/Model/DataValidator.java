package Model;

import Model.Exception.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DataValidator {
    private Person person;

    public DataValidator() {
        person = new Person();
    }

    public void Validate(String[] splitedString) throws ValidateFormatException {
        if (splitedString == null) {
            throw new NullPointerException("Нет данных");
        }

        StringBuilder errorMessages = new StringBuilder();
        for (String data : splitedString) {
            if (Character.isLetter(data.charAt(0))) {
                if (data.length() == 1) {
                    if (this.person.getGender() == null) {
                        try {
                            this.person.setGender(checkGender(data));
                        } catch (BadGenderException e) {
                            errorMessages.append(e.getMessage());
                        }
                    } else {
                        errorMessages.append("Пол указан больше 1 раза\n");
                    }
                } else {
                    if (this.person.getLastName() == null) {
                        try {
                            this.person.setLastName(checkFLP(data));
                        } catch (BadFLPFormatException e) {
                            errorMessages.append(e.getMessage());
                        }
                    } else if (this.person.getFirstName() == null) {
                        try {
                            this.person.setFirstName(checkFLP(data));
                        } catch (BadFLPFormatException e) {
                            errorMessages.append(e.getMessage());
                        }
                    } else if (this.person.getPatronymicName() == null) {
                        try {
                            this.person.setPatronymicName(checkFLP(data));
                        } catch (BadFLPFormatException e) {
                            errorMessages.append(e.getMessage());
                        }
                    } else {
                        errorMessages.append("Обнаружено много данных формата ФИО\n");
                    }
                }
            } else {

                if (data.matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}")) {
                    if (this.person.getBirthday() == null) {
                        try {
                            this.person.setBirthday(checkBirthday(data));
                        } catch (BadBirthdayFormatException e) {
                            errorMessages.append(e.getMessage());
                        }
                    } else {
                        errorMessages.append("Обнаружено несколько дат");
                    }
                } else {
                    if (this.person.getPhoneNumber() == 0) {
                        try {
                            this.person.setPhoneNumber(checkPhoneNumber(data));
                        } catch (BadPhoneNUmberFormatException e) {
                            errorMessages.append(e.getMessage());
                        }
                    } else {
                        errorMessages.append("Обнаружено несколько телефонных номеров");
                    }
                }

            }
        }
        if (!errorMessages.isEmpty()) {
            throw new ValidateFormatException(errorMessages.toString());
        }
    }

    public String getLastName() {
        return person.getLastName();
    }

    private String checkFLP(String inputString) throws BadFLPFormatException {
        if (inputString.toLowerCase().matches("^[a-zа-яё]*$")) {
            return inputString;
        } else {
            throw new BadFLPFormatException(inputString);
        }
    }

    private long checkPhoneNumber(String inpuString) throws BadPhoneNUmberFormatException {
        if (inpuString.length() == 10) {
            try {
                return Long.parseLong(inpuString);
            } catch (NumberFormatException e) {
                throw new BadPhoneNUmberFormatException(inpuString);
            }
        } else {
            throw new BadPhoneNUmberFormatException(inpuString);
        }
    }

    private Gender checkGender(String inputString) throws BadGenderException {
        try {
            return Gender.valueOf(inputString);
        } catch (IllegalArgumentException e) {
            throw new BadGenderException(inputString);
        }
    }

    private LocalDate checkBirthday(String inputString) throws BadBirthdayFormatException {
        try {
            return LocalDate.parse(inputString,
                    DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            throw new BadBirthdayFormatException(inputString);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(person.getLastName()).append(">")
                .append("<").append(person.getFirstName()).append(">")
                .append("<").append(person.getPatronymicName()).append(">")
                .append("<").append(person.getBirthday()).append(">")
                .append("<").append(person.getPhoneNumber()).append(">")
                .append("<").append(person.getGender()).append(">");
        return sb.toString();
    }

}
