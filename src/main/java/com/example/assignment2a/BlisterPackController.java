package com.example.assignment2a;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * This class loads initial variables and methods into scene
 */
public class BlisterPackController implements Initializable{
    private ArrayList<Medication> blisterPackController;
    /**
     * BlisterPackController constructor
     */
    public BlisterPackController(){
        blisterPackController = new ArrayList<>();
    } /*Constructor*/
    public void addMedication(Medication medication){
        blisterPackController.add(medication);
    }
    public void removeMedication(Medication medication){blisterPackController.remove(medication);}
    public ArrayList<Medication> getMedications(){
        return blisterPackController;
    }


    @FXML
    private Label nameFX;
    @FXML
    private Label mClassFX;
    @FXML
    private Label effectFX;
    @FXML
    private Label dosageFX;
    @FXML
    private Label routeFX;
    @FXML
    private Label expirationFX;
    @FXML
    private Label priceFX;
    @FXML
    private Label amountFX;
    @FXML
    private Label timeFX;
    @FXML
    private ImageView myImageView;
    @FXML
    private TableView<PersonalValues> tableView;
    @FXML
    private TableColumn<PersonalValues, String> nameColumn;
    @FXML
    private TableColumn<PersonalValues, String> amountColumn;
    @FXML
    private TableColumn<PersonalValues, String> timeColumn;
    @FXML
    private TextField nameInput;
    @FXML
    private TextField dosageInput;
    @FXML
    private TextField timeInput;

    /**
     * This method adds BlisterPackController object properties at program start (Override)
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Medication nitroglycerin = new Medication("Nitroglycerin","Vasodilator","Relieves chest pain","0.1 mg","Dermal","2023-12-12", "$1.50/unit","images/Medication1.jpg"); //This will go through validation
        Medication lorazepam = new Medication("Lorazepam","Benzodiazepine","Anti-anxiety","1 mg","Oral","2023-12-12", "$0.50/unit","images/Medication0.jpg"); //This will go through validation
        Medication albuterolSulfate = new Medication("Albuterol Sulfate","Beta-2 agonist","Easier to breathe","90 mcg","Inhaler","2023-12-12", "$2.50/unit","images/Medication2.jpg"); //This will go through validation
        Medication enoxaparin = new Medication("Enoxaparin","Low molecular weight heparin","Blood clot prevention","40 mg","Subcutaneous","2023-12-12", "$11.30/unit","images/Medication3.jpg"); //This will go through validation

        BlisterPackController blisterPackController = new BlisterPackController();
        blisterPackController.addMedication(nitroglycerin);
        blisterPackController.addMedication(lorazepam);
        blisterPackController.addMedication(albuterolSulfate);
        blisterPackController.addMedication(enoxaparin);
        blisterPackController.addMedication(lorazepam);

        //initial personal values to be shown on view
        PersonalValues personalValues = new PersonalValues("Nitroglycerin","1patch","0800");
        //preloaded instances of tableView entries
        tableView.getItems().add(new PersonalValues("Nitroglycerin", "1patch", "0800"));
        tableView.getItems().add(new PersonalValues("Lorazepam", "2pills", "0800"));
        tableView.getItems().add(new PersonalValues("Albuterol Sulfate", "2puffs", "1400"));
        tableView.getItems().add(new PersonalValues("Enoxaparin", "1injection", "2000"));
        tableView.getItems().add(new PersonalValues("Lorazepam", "2pills", "2000"));

        //initial medication to be shown on view
        Medication medication = new Medication("Nitroglycerin","Vasodilator","Relieves chest pain","0.1 mg","Dermal","2023-12-12", "$1.50/unit","images/Medication1.jpg"); //This will go through validation
        //sets initial scene medication
        nameFX.setText(medication.getName());
        mClassFX.setText(medication.getMClass());
        effectFX.setText(medication.getEffect());
        dosageFX.setText(medication.getDosage());
        routeFX.setText(medication.getRoute());
        expirationFX.setText(medication.getExpiration());
        priceFX.setText(medication.getPrice());
        amountFX.setText(personalValues.getAmount());
        timeFX.setText(personalValues.getTime());
        myImageView.setImage(new Image(Medication.class.getResourceAsStream(medication.getImage())));
        //myTableView.getItems().addAll((Medication) medication.getActivities()); //sets initial scene activities ArrayList
        //myImageView.setImage(new Image(Student.class.getResourceAsStream("images/Medication0.jpg"))); //1. alternate way of setting first image
        nameColumn.setCellValueFactory(new PropertyValueFactory<PersonalValues, String>("medName"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<PersonalValues, String>("amount"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<PersonalValues, String>("time"));

        //prints to terminal on initialization
        System.out.println(blisterPackController.toString());
        System.out.println(blisterPackController.getTotalMedClasses());
        System.out.println(blisterPackController.getTotalMedEffects());
        System.out.println(blisterPackController.getTotalMedRoutes());
        System.out.println(blisterPackController.getTotalDosages());
        System.out.println(blisterPackController.getTotalMedExpirations());
        System.out.println(blisterPackController.getTotalPrices());

    }

    /**
     * This method activates on clicking button "Add Med" in blisterpack-view.fxml
     * Adds PersonalValues class attributes to the table View
     */
    //Submit button
    @FXML
    void submit(/*ActionEvent event*/) {
        //Adds a new instance of personalValues to the tableView
        PersonalValues personalValues = new PersonalValues(nameInput.getText(),dosageInput.getText(),timeInput.getText());
        ObservableList<PersonalValues> personalValues1 = tableView.getItems();
        personalValues1.add(personalValues);
        tableView.setItems(personalValues1);

        //Adding a medication will initially be an unknown value
        Medication unknown = new Medication("Nan","Nan","Nan","0000","Nan","0000", "Nan","images/NanMed.jpg");
        nameFX.setText(unknown.getName());
        mClassFX.setText(unknown.getMClass());
        effectFX.setText(unknown.getEffect());
        dosageFX.setText(unknown.getDosage());
        routeFX.setText(unknown.getRoute());
        expirationFX.setText(unknown.getExpiration());
        priceFX.setText(unknown.getPrice());
        myImageView.setImage(new Image(Medication.class.getResourceAsStream(unknown.getImage())));

        //known values from PersonalValues class
        nameFX.setText(personalValues.getMedName());
        amountFX.setText(personalValues.getAmount());
        timeFX.setText(personalValues.getTime());

            //array of added items <itemList> + match to index number (tableView.getSelectionModel().getSelectedIndex()


    }
    @FXML
    void remove(/*ActionEvent event*/) {
        int id = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(id);
    }
    @FXML
    void display(/*ActionEvent event*/) {
        if (nameColumn.getCellData(tableView.getSelectionModel().getSelectedIndex()) != "Enoxaparin" || nameColumn.getCellData(tableView.getSelectionModel().getSelectedIndex()) != "Nitroglycerin" || nameColumn.getCellData(tableView.getSelectionModel().getSelectedIndex()) != "Lorazepam" || nameColumn.getCellData(tableView.getSelectionModel().getSelectedIndex()) != "Albuterol Sulfate" ) {
            //sets text of Medication class instance enoxaparin specific values (does not depend on personal values)
            Medication unknown = new Medication("Nan","Nan","Nan","0000","Nan","0000", "Nan","images/NanMed.jpg");
            nameFX.setText(unknown.getName());
            mClassFX.setText(unknown.getMClass());
            effectFX.setText(unknown.getEffect());
            dosageFX.setText(unknown.getDosage());
            routeFX.setText(unknown.getRoute());
            expirationFX.setText(unknown.getExpiration());
            priceFX.setText(unknown.getPrice());
            myImageView.setImage(new Image(Medication.class.getResourceAsStream(unknown.getImage())));

            //PersonalValues personalValues = new PersonalValues("Lorazepam","2pills","2000");
            nameFX.setText(nameColumn.getCellData(tableView.getSelectionModel().getSelectedIndex()));
            amountFX.setText(amountColumn.getCellData(tableView.getSelectionModel().getSelectedIndex())); //updates amount onclick
            timeFX.setText(timeColumn.getCellData(tableView.getSelectionModel().getSelectedIndex())); //updates time onclick
        }
        if (nameColumn.getCellData(tableView.getSelectionModel().getSelectedIndex()) == "Lorazepam"){
            //sets text of Medication class instance lorazepam specific values (does not depend on personal values)
            Medication lorazepam = new Medication("Lorazepam","Benzodiazepine","Anti-anxiety","1 mg","Oral","2023-12-12", "$0.50/unit","images/Medication0.jpg"); //This will go through validation
            nameFX.setText(lorazepam.getName());
            mClassFX.setText(lorazepam.getMClass());
            effectFX.setText(lorazepam.getEffect());
            dosageFX.setText(lorazepam.getDosage());
            routeFX.setText(lorazepam.getRoute());
            expirationFX.setText(lorazepam.getExpiration());
            priceFX.setText(lorazepam.getPrice());
            myImageView.setImage(new Image(Medication.class.getResourceAsStream(lorazepam.getImage()))); //updates image onclick

            PersonalValues personalValues = new PersonalValues("Lorazepam","2pills","2000");
            amountFX.setText(amountColumn.getCellData(tableView.getSelectionModel().getSelectedIndex())); //updates amount onclick
            timeFX.setText(timeColumn.getCellData(tableView.getSelectionModel().getSelectedIndex())); //updates time onclick
        }
        if (nameColumn.getCellData(tableView.getSelectionModel().getSelectedIndex()) == "Nitroglycerin"){
            //sets text of Medication class instance nitroglycerin specific values (does not depend on personal values)
            Medication nitroglycerin = new Medication("Nitroglycerin","Vasodilator","Relieves chest pain","0.1 mg","Dermal","2023-12-12", "$1.50/unit","images/Medication1.jpg"); //This will go through validation
            nameFX.setText(nitroglycerin.getName());
            mClassFX.setText(nitroglycerin.getMClass());
            effectFX.setText(nitroglycerin.getEffect());
            dosageFX.setText(nitroglycerin.getDosage());
            routeFX.setText(nitroglycerin.getRoute());
            expirationFX.setText(nitroglycerin.getExpiration());
            priceFX.setText(nitroglycerin.getPrice());
            myImageView.setImage(new Image(Medication.class.getResourceAsStream(nitroglycerin.getImage())));

            //PersonalValues personalValues = new PersonalValues("Nitroglycerin","1patch","0800");
            amountFX.setText(amountColumn.getCellData(tableView.getSelectionModel().getSelectedIndex()));
            timeFX.setText(timeColumn.getCellData(tableView.getSelectionModel().getSelectedIndex()));
        }
        if (nameColumn.getCellData(tableView.getSelectionModel().getSelectedIndex())== "Albuterol Sulfate") {
            ////sets text of Medication class instance albuterolSulfate specific values (does not depend on personal values)
            Medication albuterolSulfate = new Medication("Albuterol Sulfate","Beta-2 agonist","Easier to breathe","90 mcg","Inhaler","2023-12-12", "$2.50/unit","images/Medication2.jpg"); //This will go through validation
            nameFX.setText(albuterolSulfate.getName());
            mClassFX.setText(albuterolSulfate.getMClass());
            effectFX.setText(albuterolSulfate.getEffect());
            dosageFX.setText(albuterolSulfate.getDosage());
            routeFX.setText(albuterolSulfate.getRoute());
            expirationFX.setText(albuterolSulfate.getExpiration());
            priceFX.setText(albuterolSulfate.getPrice());
            myImageView.setImage(new Image(Medication.class.getResourceAsStream(albuterolSulfate.getImage())));

            //PersonalValues personalValues = new PersonalValues("Albuterol Sulfate","2puffs","1400");
            amountFX.setText(amountColumn.getCellData(tableView.getSelectionModel().getSelectedIndex()));
            timeFX.setText(timeColumn.getCellData(tableView.getSelectionModel().getSelectedIndex()));
        }
        if (nameColumn.getCellData(tableView.getSelectionModel().getSelectedIndex()) == "Enoxaparin") {
            Medication enoxaparin = new Medication("Enoxaparin","Low molecular weight heparin","Blood clot prevention","40 mg","Subcutaneous","2023-12-12", "$11.30/unit","images/Medication3.jpg"); //This will go through validation
            nameFX.setText(enoxaparin.getName());
            mClassFX.setText(enoxaparin.getMClass());
            effectFX.setText(enoxaparin.getEffect());
            dosageFX.setText(enoxaparin.getDosage());
            routeFX.setText(enoxaparin.getRoute());
            expirationFX.setText(enoxaparin.getExpiration());
            priceFX.setText(enoxaparin.getPrice());
            //dosageFX.setText(String.valueOf(medication.getDosage()));
            myImageView.setImage(new Image(Medication.class.getResourceAsStream(enoxaparin.getImage())));

            //PersonalValues personalValues = new PersonalValues("Enoxaparin","1injection","2000");
            amountFX.setText(amountColumn.getCellData(tableView.getSelectionModel().getSelectedIndex()));
            timeFX.setText(timeColumn.getCellData(tableView.getSelectionModel().getSelectedIndex()));
        }
    }
    public String getTotalMedClasses(){ //returns total calories of meal
        String medClasses = "";
        for(Medication medication:blisterPackController)
            medClasses += medication.getMClass()+", ";
        return medClasses.substring(0,medClasses.length()-2);
    }
    public String getTotalMedEffects(){ //returns total calories of meal
        String medEffects = "";
        for(Medication medication:blisterPackController)
            medEffects += medication.getEffect()+", ";
        return medEffects.substring(0,medEffects.length()-2);
    }
    public String getTotalMedRoutes(){ //returns total calories of meal
        String medRoutes = "";
        for(Medication medication:blisterPackController)
            medRoutes += medication.getRoute()+", ";
        return medRoutes.substring(0,medRoutes.length()-2);
    }
    public String getTotalMedExpirations(){ //returns total calories of meal
        String medExpirations = "";
        for(Medication medication:blisterPackController)
            medExpirations += medication.getExpiration()+", ";
        return medExpirations.substring(0,medExpirations.length()-2);
    }
    public String getTotalDosages(){ //returns total calories of meal
        String medDoses = "";
        for(Medication medication:blisterPackController)
            medDoses += medication.getDosage()+", ";
        return medDoses.substring(0,medDoses.length()-2);
    }
    public String getTotalPrices(){ //returns total calories of meal
        String medPrices = "";
        for(Medication medication:blisterPackController)
            medPrices += medication.getPrice()+", ";
        return medPrices.substring(0,medPrices.length()-2);
    }
    public String toString() {
        return String.format("BlisterPack: %s", blisterPackController); //.2f = reserve spot for a floating point number

    }
}