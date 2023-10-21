package model;

public class DataModel {

    private final String PHONE_VALID = "^[0-9]{10}";
    private final String EMAIL_VALID = "^[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";

    public boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    public int getNumOfDaysInMonth(int month, int year) {
        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    public boolean isValidPhone(String phone) {
        return phone.matches(PHONE_VALID);
    }

    public boolean isValidEmail(String email) {
        return email.matches(EMAIL_VALID);
    }
}
