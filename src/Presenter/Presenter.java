package Presenter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Model.Exception.ValidateFormatException;
import Model.DataValidator;
import View.View;

public class Presenter< V extends View> {

    private DataValidator model;
    private V view;

    public Presenter(V v) {
        view = v;
    }

    public void start() {
        while (true) {
            String input = view.getInput(
                    "Введите данные через пробел (Фамилию Имя Отчество ДатуРождения НомерТелефона Пол), " +
                            "или Exit для прекращения программы:\n");
            if (input.equals("Exit")) {

                break;
            } else {

                String[] inputString = input.replaceAll("\\s+", " ").split(" ");

                if (checkInputDataCount(inputString.length) == -1) {
                    view.printOutput("Слишком мало данных на вводе, должно быть: Фамилия Имя Отчество НомерТелефона ДатаРождения Пол)\n");
                } else if (checkInputDataCount(inputString.length) == 0) {
                    view.printOutput("Слишком много данных на вводе, должно быть: Фамилия Имя Отчество НомерТелефона ДатаРождения Пол)\n");
                } else {
                    try {
                        model = new DataValidator();
                        model.Validate(inputString);
                        writePersonData(model);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ValidateFormatException e) {
                        view.printOutput(e.getMessage());
                    }
                }
            }
        }
    }


    private int checkInputDataCount(int inputDataCount) {
        if (inputDataCount < 6) {
            return -1;
        } else if (inputDataCount > 6) {
            return 0;
        } else {
            return inputDataCount;
        }
    }

    private void writePersonData(DataValidator data) throws IOException {
        File filepath = new File(data.getLastName());
        try (FileWriter fw = new FileWriter(filepath, true)) {
            fw.append(data + "\n");
        } catch (IOException e) {
            throw e;
        }
    }
}