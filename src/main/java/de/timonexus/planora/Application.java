package de.timonexus.planora;

import de.timonexus.planora.database.DatabaseInitializer;

public class Application {
    
    // attributes
    private final DatabaseInitializer databaseInitializer;

    // constructor
    public Application(){
        this.databaseInitializer = new DatabaseInitializer();

        prepareApplication();
    }

    // method for preparing the application to run
    private void prepareApplication(){
        try {
            this.databaseInitializer.initialize();
        } catch (Exception e) {
            System.out.println("Failed to initialize Database correctly (class: Application, mehtod: prepareApplication())");
            e.printStackTrace();
        } 
    }

    // method to start application
    public void startApplication(){
        System.out.println("Application successfully started");
    }

    // getter
    public DatabaseInitializer getDatabaseInitializer() {
        return databaseInitializer;
    }
}
