package com.javalesson.nestedclasses;


public class CellPhone {

    private String vendor;
    private String model;
    private float price;
    private Display display;
    private GSMModule gsmModule;
    private AbstractButton button;

    public interface AbstractButton{

        void onClickAction();
    }


    public CellPhone(String vendor, String model, float price) {
        this.vendor = vendor;
        this.model = model;
        this.price = price;
    }

    public void turnOn(){


        renderDisplay();
        gsmModule = new GSMModule();
        button = new AbstractButton() {

          private  String number = "123456789";
            @Override
            public void onClickAction() {
               gsmModule.call(number);
            }



        };
    }

    public  void renderDisplay(){
        display = new Display(1920, 1280);
    }

    public Display getDisplay() {
        return display;
    }

    public void call(String phone){
        gsmModule.call(phone);
    }

}
