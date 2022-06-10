package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterfaces.TocumenPanamaHome;

import static net.serenitybdd.screenplay.actions.Click.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.waits.WaitUntil.the;

public class SearchLostAndFound implements Task {

    private TocumenPanamaHome tocumenPanamaHome;

    public static SearchLostAndFound policy() {

        return Tasks.instrumented(SearchLostAndFound.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                on(TocumenPanamaHome.SERVICES_BUTTOM),
                on(TocumenPanamaHome.TRAVELER_BUTTOM),
                on(TocumenPanamaHome.LOST_AND_FOUND_BUTTOM),
                on(TocumenPanamaHome.DOWNLOAD_BUTTOM),
                WaitUntil.the(TocumenPanamaHome.DOWNLOAD_BUTTOM,isVisible()).forNoMoreThan(10).seconds()
        );

    }
}
