import javax.swing.text.html.HTMLEditorKit;



//para conseguir el parser
public class parser extends HTMLEditorKit{
    public  HTMLEditorKit.Parser getParser() {
        return super.getParser();
    }

}