package view;

import controller.DataController;

public class Data {

    public void menu() {
        
        DataController dv=new DataController();
        
        System.out.print("Số điện thoại: ");
        String phone = dv.getInputPhone();
        System.out.print("Ngày: ");
        String date = dv.getInputDate();

        System.out.print("Email: ");
        String email = dv.getInputEmail();

        // Process the data or perform additional logic based on the inputs
    }
}
