package com.example.assignment2a;

public class PersonalValues {
    private String medName;
    private String amount;
    private String time;
    public PersonalValues(String medName, String amount, String time){
        setMedName(medName);
        setAmount(amount);
        setTime(time);
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        if (medName.length() >= 2 && !Character.isWhitespace(medName.charAt(0)) && !Character.isWhitespace(medName.charAt(medName.length()-1)))
            this.medName = medName;
        else
            throw new IllegalArgumentException("Medication name: ["+medName +"] must have the following attributes: no leading or trailing white space, at least 2 characters long, first letter capital");
    }

    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        if (amount.length() >= 2 && Character.isDigit(amount.charAt(0)) && !Character.isWhitespace(amount.charAt(0)) && !Character.isWhitespace(amount.charAt(amount.length()-1)))
            this.amount = amount;
        else
            throw new IllegalArgumentException("Medication amount: ["+amount +"] must have the following attributes: no leading or trailing white space, at least 2 characters , and a digit as the first character");
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        if (Integer.valueOf(time) >= 0 && Integer.valueOf(time) <= 2401)
            this.time = time;
        else
            throw new IllegalArgumentException("Time: ["+time+ "] must be within the range 0 to 2401");
    }
}
