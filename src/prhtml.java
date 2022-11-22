import javax.swing.text.html.HTMLEditorKit;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class prhtml {
    public static final Logger LOG = Logger.getLogger(prhtml.class.getName());
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void procesa(BufferedReader html) {
        String word;
        Scanner sc = new Scanner(System.in);


        parser p = new parser();

        HTMLEditorKit.Parser procesador = p.getParser();
        System.out.print(ANSI_PURPLE + "Escriba la palabra para buscarla en doc: " + ANSI_RESET);
        word = sc.nextLine();


        try {
            procesador.parse(html, new parrafo(word), true);
        } catch (IOException e) {
            LOG.severe("No se puede leer el HTML");
            System.exit(2);
        }
    }
}