import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import java.util.LinkedList;

public class parrafo extends HTMLEditorKit.ParserCallback {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    private int count;
    private int counttxt;
    private boolean u;
    private LinkedList<Integer> arr;
    String pal;
    public parrafo(String word) {
        this.pal = word;
        this.arr = new LinkedList<>();
    }

    @Override
    public void handleText(char[] data, int pos) {
        if (u) {
            String texto = new String(data);
            System.out.print(texto);
            if (texto.contains(pal)) {
                counttxt++;
            }

            String[] words = texto.split(" ");

            for (String one : words) {
                if (one.equals(pal)) {
                    pos = pos + 1;
                    arr.add(pos);
                } else {
                    pos=pos+1;
                }
            }
        }
    }

    @Override
    public void handleStartTag(HTML.Tag x, MutableAttributeSet y, int pos) {
        if (x == HTML.Tag.P) {
            u = true;
        }
    }

    @Override
    public void handleEndTag(HTML.Tag t, int pos) {
        if (t == HTML.Tag.P) {
            u = false;
            System.out.print("\nLine " + count + ": ");
            count++;
        }
        if (t == HTML.Tag.BODY) {
            System.out.print(ANSI_PURPLE + "\nTotal de párrafos en documento: " + ANSI_YELLOW + count + ANSI_RESET);
            System.out.print(ANSI_PURPLE + "\nLa palabra " + ANSI_YELLOW + pal + ANSI_PURPLE
                    + " tiene un total de " + ANSI_YELLOW + counttxt + ANSI_PURPLE
                    + " ocurrencias" + ANSI_RESET);
            System.out.print(ANSI_PURPLE + "\nen las posiciones " + ANSI_YELLOW + arr + ANSI_RESET);

        }
    }

}