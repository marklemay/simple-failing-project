/**
 * @author markl
 */
package stuff;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitWebElement;


/**
 * @author markl
 *
 */
@Ignore("Ignored for obvious reasons")
public class IntentionalyFailingFireFoxTest extends IntegrationTest {

    /**
     * @param w
     */
    public IntentionalyFailingFireFoxTest() {
        super(new FirefoxDriver());
    }

    @CaptureFile String otherDubugInformation = "";
    String impotantDubugInformation = "";


    @CaptureFile
    public String captureDebug() {
        return impotantDubugInformation;
    }

    //    @Test
    //    public void fails() {
    //        impotantDubugInformation = "dg is 'fun'";
    //        otherDubugInformation = "the problem is complicated";
    //        fail();
    //    }

    @Test
    public void failsinBrowser() {
        driver.get(baseDomain);
        impotantDubugInformation = "google";

        HtmlUnitWebElement elem = (HtmlUnitWebElement) waiter.withMessage("regression for #3272").until(
                presenceOfElementLocated(By.partialLinkText("Title Thingy")));
    }

    
    @Test
    public void failsinyahoo() {
        driver.get("http://www.yahoo.com/");
        impotantDubugInformation = "yahoo!";

        HtmlUnitWebElement elem = (HtmlUnitWebElement) waiter.withMessage("regression for #3272").until(
                presenceOfElementLocated(By.partialLinkText("Title Thingy")));
    }

    @Test
    public void succeeds() {
    }
}
