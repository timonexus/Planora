package de.timonexus.planora.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ApplicationInfo {

    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream input = ApplicationInfo.class
                .getResourceAsStream("/application.properties")) {

            if (input == null) {
                throw new IllegalStateException(
                        "application.properties not found."
                );
            }

            PROPERTIES.load(input);

        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private ApplicationInfo() {}

    public static String getVersion() {
        return PROPERTIES.getProperty("application.version");
    }

    public static String getName() {
        return PROPERTIES.getProperty("application.name");
    }
}