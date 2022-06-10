package userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("http://www.tocumenpanama.aero/")

public class TocumenPanamaHome extends PageObject {

    public static final Target SERVICES_BUTTOM = Target.the("services buttom")
            .located(By.xpath("//nav[@id=\"menutop\"]/ul/li[4]"));
    public static final Target TRAVELER_BUTTOM = Target.the("services buttom")
            .located(By.xpath("//nav[@id=\"menutop\"]/ul/li[4]/ul/li[1]/a"));
    public static final Target LOST_AND_FOUND_BUTTOM = Target.the("services buttom")
            .located(By.xpath("//nav[@id=\"menutop\"]/ul/li[4]/ul/li[1]/ul/li[8]/a"));
    public static final Target DOWNLOAD_BUTTOM = Target.the("services buttom")
            .located(By.xpath("//main[@id=\"content\"]/div[1]/div/p[5]/a[1]/img"));

}
