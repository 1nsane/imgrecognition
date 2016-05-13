package com.imagesrecognition.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Created by Yevgeniy_Vtulkin on 5/13/2016.
 */
public class Launcher {

    private static final int PORT = 8080;

    /**
     * Starts jetty server and the whole app
     *
     * @param args args[0] may be the port to assign
     * @throws Exception any exception
     */
    public static void main(String[] args) throws Exception {
        Server server = new Server();

        ServerConnector connector = new ServerConnector(server);
        connector.setPort(getPort(args));
        server.addConnector(connector);

        WebAppContext context = new WebAppContext("webapp", "/");

        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            // fix for Windows, so Jetty doesn't lock files
            context.getInitParams().put("org.eclipse.jetty.servlet.Default.useFileMappedBuffer", "false");
        }

        server.setHandler(context);
        server.start();
    }

    private static int getPort(final String[] args) {
        if (args == null || args.length == 0) {
            return PORT;
        }
        try {
            return Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            return PORT;
        }
    }

}
