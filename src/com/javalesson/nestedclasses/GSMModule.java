package com.javalesson.nestedclasses;

public class GSMModule {

    public GSMModule() {
        System.out.println("GSM module initialized");
    }

    public void call(String numberOfThePhone) {
        int numberLength = 10;

        class PhoneNumber {
            String phoneNumber;
            int validNumber;

            public PhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public boolean isValid() {
                if (phoneNumber.length() != numberLength) {
                    return false;
                }
                try {
                    validNumber = Integer.parseInt(phoneNumber);
                    return true;
                } catch (NumberFormatException e){
                    return false;
                }
            }

            public void dialIn(){
                if(isValid()){
                    System.out.println("Calling number "+validNumber);
                } else {
                    System.out.println("Your number is invalid. Please correct your number");
                }
            }
        }

        PhoneNumber number = new PhoneNumber(numberOfThePhone);
        number.dialIn();


    }
}
