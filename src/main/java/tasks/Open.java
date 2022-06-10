package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import userinterfaces.TocumenPanamaHome;

import static net.serenitybdd.screenplay.actions.Open.*;

public class Open implements Task {

    private TocumenPanamaHome tocumenPanamaHome;

    public static Open thePage() {

        return Tasks.instrumented(Open.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                browserOn(tocumenPanamaHome)
        );

    }
}
