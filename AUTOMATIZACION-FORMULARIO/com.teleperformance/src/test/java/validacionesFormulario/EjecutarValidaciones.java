package validacionesFormulario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import validaciones.*;

public class EjecutarValidaciones {

    private WebDriver driver;

    ValidacionCorrectaFormulario validacioncorrectaformulario;
    ValidacionIncorrectaFormulario validacionIncorrectaformulario;

    @Before
    public void setUp() throws Exception {
        validacioncorrectaformulario = new ValidacionCorrectaFormulario(driver);
        validacionIncorrectaformulario = new ValidacionIncorrectaFormulario(driver);

        driver = validacionIncorrectaformulario.chromeDriverConnection();

        validacionIncorrectaformulario.visit("https://userstest20211007145738.azurewebsites.net/");

    }

    @After
    public void tearDown() {
        driver.quit();
    }

//    @Test
//    public void testFormularioIncorrecto() throws Exception {
//        validacionIncorrectaformulario.ValidacionIncorrectaFormulario();
//        driver.close();
//        
//
//    }

    @Test
    public void testFormularioCorrecto() throws Exception {
        driver = validacioncorrectaformulario.chromeDriverConnection();
        validacioncorrectaformulario.visit("https://userstest20211007145738.azurewebsites.net/");
        validacioncorrectaformulario.ValidacionCorrectaFormulario();
        driver.close();

    }
}
