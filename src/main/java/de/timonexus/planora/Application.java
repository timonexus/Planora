package de.timonexus.planora;

import javax.swing.SwingUtilities;

import de.timonexus.planora.database.DatabaseInitializer;
import de.timonexus.planora.service.frame.PlanoraFrameService;
import de.timonexus.planora.service.services.FrameService;
import de.timonexus.planora.ui.frame.PlanoraFrame;

public class Application {

    // Attributes
    private final DatabaseInitializer databaseInitializer;
    private PlanoraFrame planoraFrame;
    private final FrameService frameService;

    // Constructor
    public Application() {
        this.databaseInitializer = new DatabaseInitializer();
        this.frameService = new PlanoraFrameService();

        prepareApplication();
    }

    // Method for preparing the application to run
    private void prepareApplication() {
        try {
            databaseInitializer.initialize();
        } catch (Exception e) {
            System.err.println(
                "[ERROR] Failed to initialize database correctly."
            );
            e.printStackTrace();
        }
    }

    // Method to start application
    public void startApplication() {
        SwingUtilities.invokeLater(() -> {
            if (planoraFrame == null) {
                planoraFrame = new PlanoraFrame();
                planoraFrame.prepareFrame();
            }

            planoraFrame.setVisible(true);
            planoraFrame.openWindow();

            System.out.println("[INFO] Application successfully started");
        });

        this.frameService.isVisible(true);
    }

    // Getter
    public DatabaseInitializer getDatabaseInitializer() {
        return databaseInitializer;
    }
}