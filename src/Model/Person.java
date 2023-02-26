package Model;

import java.time.LocalDate;

public class Person {
    //Форматы данных:
    //фамилия, имя, отчество - строки
    //дата_рождения - строка формата dd.mm.yyyy
    //номер_телефона - целое беззнаковое число без форматирования
    //пол - символ латиницей f или m.


    private String LastName;
    private String FirstName;
    private String PatronymicName;
    private LocalDate Birthday;
    private long PhoneNumber;
    private Gender Gender;

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getPatronymicName() {
        return PatronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        PatronymicName = patronymicName;
    }



    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        PhoneNumber = phoneNumber;
    }


    public Model.Gender getGender() {
        return Gender;
    }

    public void setGender(Model.Gender gender) {
        Gender = gender;
    }

    public LocalDate getBirthday() {
        return Birthday;
    }

    public void setBirthday(LocalDate birthday) {
        Birthday = birthday;
    }
}
