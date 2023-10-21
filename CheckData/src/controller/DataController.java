package controller;

import java.text.ParseException;
import java.util.Scanner;
import model.DataModel;

public class DataController {

    private final Scanner in = new Scanner(System.in);

    public String getInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Không được để trống.");
            } else {
                return result;
            }
        }
    }

    public String getInputDate() {
        while (true) {
            try {
                String dateCheck = getInputString();

                String[] parts = dateCheck.split("/");
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);

                if (month < 1 || month > 12) {
                    throw new ParseException("Tháng không hợp lệ", 0);
                }

                DataModel model = new DataModel();
                int numOfDaysInMonth = model.getNumOfDaysInMonth(month, year);
                if (day < 1 || day > numOfDaysInMonth) {
                    throw new ParseException("Ngày không hợp lệ", 0);
                }

                return dateCheck;
            } catch (ParseException ex) {
                System.err.println("Ngày không hợp lệ");
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
                System.err.println("Ngày không đúng định dạng (dd/MM/yyyy)");
            }
        }
    }

    public String getInputPhone() {
        while (true) {
            try {
                int phoneCheck = Integer.parseInt(getInputString());
                String resultCheck = String.valueOf(phoneCheck);
                DataModel model = new DataModel();
                if (!model.isValidPhone(resultCheck)) {
                    System.err.println("Số điện thoại phải có 10 chữ số");
                } else {
                    return resultCheck;
                }
            } catch (NumberFormatException ex) {
                System.err.println("Số điện thoại phải là 10 chữ số");
            }
        }
    }

    public String getInputEmail() {
        while (true) {
            String emailCheck = getInputString();
            DataModel model = new DataModel();
            if (!model.isValidEmail(emailCheck)) {
                System.err.println("Email phải ở đúng định dạng");
            } else {
                return emailCheck;
            }
        }
    }
}
