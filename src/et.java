import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import java.util.Enumeration;
public class et extends HTMLEditorKit.ParserCallback  {
    @Override
    public void handleText(char[] data, int pos) {
        String textda = new String( data );
        textda.replace("\n","");
        System.out.println("\t" + textda );
    }
    @Override
    public void handleStartTag(HTML.Tag tag, MutableAttributeSet attributes, int pos) {
        String tagName = tag.toString().toUpperCase();

        int n = attributes.getAttributeCount();

        System.out.printf("%s: %d%n", tagName, n );


        Enumeration a =  attributes.getAttributeNames();

        while (a.hasMoreElements()) {
            Object nombreatributo = a.nextElement();

            System.out.printf("%s = %s%n", nombreatributo.toString(),
                    attributes.getAttribute (nombreatributo )  );
        }
    }

    @Override
    public void handleSimpleTag(HTML.Tag tag, MutableAttributeSet attributes, int pos) {
        String tagName = tag.toString().toUpperCase();
        int az = attributes.getAttributeCount();
        System.out.printf("%s: %d%n", tagName, az );
        Enumeration gg = attributes.getAttributeNames();

        while (gg.hasMoreElements()) {
            Object nombreatributo = gg.nextElement();
            System.out.printf("%s = %s%n", nombreatributo.toString(),
                    attributes.getAttribute (nombreatributo )  );
        }
    }
}

