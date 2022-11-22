import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import java.util.logging.Logger;
public class urlw {

    public static final String TAG = urlw.class.getSimpleName();
    public static final Logger LOG = Logger.getLogger(TAG);
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String surl;

        System.out.print(ANSI_PURPLE + "Ingresar el URL: " + ANSI_RESET);
        surl = sc.nextLine();

        URL webPage = null;
        try {
            webPage = new URL(surl);
        } catch (MalformedURLException ex) {
            LOG.severe(ex.getMessage());
        }

        BufferedReader leerhtml = null;
        try {
            leerhtml = new BufferedReader(
                    new InputStreamReader(webPage.openStream()));
        } catch (IOException ex) {
            LOG.severe(ex.getMessage());
        }

        prhtml wordin = new prhtml();
        wordin.procesa(leerhtml);

    }
}
