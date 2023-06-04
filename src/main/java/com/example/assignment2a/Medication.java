package com.example.assignment2a;

import javafx.collections.ObservableList;

public class Medication {
    private String fileName;
    private String name;
    private String mClass;
    private String dosage;
    private String route;
    private String effect;
    private String expiration;
    private String price;

    /**
     * Constructor, initializes the Student object.
     */
    public Medication(String name, String mClass, String effect, String dosage, String route, String expiration, String price, String fileName) {
        setName(name);
        setMClass(mClass);
        setEffect(effect);
        setDosage(dosage);
        setRoute(route);
        setExpiration(expiration);
        setPrice(price);
        setImage(fileName);
    }

    /**
     * Returns a fileName path of an image to BlisterPackController.java
     */
    public String getImage()
    {
        return fileName;
    }
    /**
     * Could be used for fileName path validation
     */
    public void setImage(String fileName) {
        this.fileName = fileName;
    }
    /**
     * Returns firstName to BlisterPackController.java
     */
    public String getName() {
        return name;
    }
    /**
     * This method validates that name: has no leading or trailing white spaces, is at least 2 characters long, first letter is capital
     */
    public void setName(String name) {
        //at least 2 characters long check && first letter capital check  -------
        if (name.length() >= 2 && Character.isUpperCase(name.charAt(0)) && !Character.isWhitespace(name.charAt(0)) && !Character.isWhitespace(name.charAt(name.length()-1)))
            this.name = name;
        else
            throw new IllegalArgumentException("Medication name: ["+name +"] must have the following attributes: no leading or trailing white space, at least 2 characters long, first letter capital");
    }
    /**
     * Returns mClass to BlisterPackController.java
     */
    public String getMClass() {
        return mClass;
    }
    /**
     * This method validates that mClass: has no leading or trailing white spaces, is at least 2 characters long, first letter is capital
     */
    public void setMClass(String mClass) {
        //at least 2 characters long check && first letter capital check -------
        if (mClass.length() >= 2 && Character.isUpperCase(mClass.charAt(0)) && !Character.isWhitespace(mClass.charAt(0)) && !Character.isWhitespace(mClass.charAt(mClass.length()-1)))
            this.mClass = mClass;
        else
            throw new IllegalArgumentException("Medication class: ["+mClass +"] must have the following attributes: no leading or trailing white space, at least 2 characters long, first letter capital");
    }
    /**
     * Returns effect to BlisterPackController.java
     */
    public String getEffect() {
        return effect;
    }
    /**
     * This method validates that effect: has no leading or trailing white spaces, is at least 2 characters long, first letter is capital
     */
    public void setEffect(String effect) {
        //at least 2 characters long check && first letter capital check -------
        if (effect.length() >= 2 && !Character.isWhitespace(effect.charAt(0)) && !Character.isWhitespace(effect.charAt(effect.length()-1)))
            this.effect = effect;
        else
            throw new IllegalArgumentException("Effect: ["+effect +"] must have the following attributes: no leading or trailing white space, at least 2 characters long, first letter capital");
    }
    /**
     * Returns dosage to BlisterPackController.java
     */
    public String getDosage() {
        return dosage;
    }
    /**
     * This method validates that dosage: has no leading or trailing white spaces, is at least 2 characters long, first letter is capital
     */
    public void setDosage(String dosage) {
        //at least 2 characters long check && first letter capital check -------
        if (dosage.length() >= 2 && Character.isDigit(dosage.charAt(0)) && !Character.isWhitespace(dosage.charAt(0)) && !Character.isWhitespace(dosage.charAt(dosage.length()-1)))
            this.dosage = dosage;
        else
            throw new IllegalArgumentException("Dosage: ["+dosage +"] must have the following attributes: no leading or trailing white space, at least 2 characters long, first character is a digit");
    }
    /**
     * Returns route to BlisterPackController.java
     */
    public String getRoute() {
        return route;
    }
    /**
     * This method validates that route: has no leading or trailing white spaces, is at least 2 characters long, first letter is capital
     */
    public void setRoute(String route) {
        //at least 2 characters long check && first letter capital check -------
        if (route.length() >= 2 && !Character.isWhitespace(route.charAt(0)) && !Character.isWhitespace(route.charAt(route.length()-1)))
            this.route = route;
        else
            throw new IllegalArgumentException("Route: ["+route +"] must have the following attributes: no leading or trailing white space, at least 2 characters long, first letter capital");
    }
    /**
     * Returns expiration to BlisterPackController.java
     */
    public String getExpiration() {
        return expiration;
    }
    /**
     * This method validates that expiration: has no leading or trailing white spaces, is at least 2 characters long, first letter is capital
     */
    public void setExpiration(String expiration) {
        if (expiration.length() >= 2 && Character.isDigit(expiration.charAt(0)) && !Character.isWhitespace(expiration.charAt(0)) && !Character.isWhitespace(expiration.charAt(expiration.length()-1)))
            this.expiration = expiration;
        else
            throw new IllegalArgumentException("Expiration: ["+expiration +"] must have the following attributes: no leading or trailing white space, at least 2 characters long, first character is a digit");
    }
    /**
     * Returns price to BlisterPackController.java
     */
    public String getPrice() {
        return price;
    }
    /**
     * This method validates that price: has no leading or trailing white spaces, is at least 2 characters long
     */
    public void setPrice(String price) {
        if (price.length() >= 2 && !Character.isWhitespace(price.charAt(0)) && !Character.isWhitespace(price.charAt(price.length()-1)))
            this.price = price;
        else
            throw new IllegalArgumentException("Price: ["+price +"] must have the following attributes: no leading or trailing white space, at least 2 characters long");
    }
}