package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LostAndFoundPolicy implements Question <Boolean> {

    private String pdfText;
    private String title = "Objetos Extraviados";

    public LostAndFoundPolicy (String pdfText) {
        this.pdfText = pdfText;
    }

    public static LostAndFoundPolicy isCorrect(String pdfText) {

        return new LostAndFoundPolicy(pdfText);
    }

    @Override
    public Boolean answeredBy(Actor actor){
        boolean result;
        result = pdfText.contains(title);
        return result;

    }
}
