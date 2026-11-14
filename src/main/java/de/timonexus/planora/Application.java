package de.timonexus.planora;

import de.timonexus.planora.database.DatabaseInitializer;
import de.timonexus.planora.ui.frame.PlanoraFrame;

public class Application {
    
    // attributes
    private final DatabaseInitializer databaseInitializer;
    private final PlanoraFrame planoraFrame;

    // constructor
    public Application(){
        this.databaseInitializer = new DatabaseInitializer();
        this.planoraFrame = new PlanoraFrame();

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

        this.planoraFrame.prepareFrame();
    }

    // method to start application
    public void startApplication(){
        System.out.println("[INFO] Application successfully started");
        this.planoraFrame.setVisible(true);
    }

    // getter
    public DatabaseInitializer getDatabaseInitializer() {
        return databaseInitializer;
    }
}
