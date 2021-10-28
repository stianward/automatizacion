package validaciones;

import com.avianca.mavenproject1.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.logging.Logger;

public class ValidacionCorrectaFormulario extends Base {

    ElementosFormulario elementosFormulario;
    protected WebDriver driver;
    Logger logger;

    public ValidacionCorrectaFormulario(WebDriver driver) {
        super(driver);
    }

    public void ValidacionCorrectaFormulario() throws InterruptedException {

        logger = Logger.getLogger(ValidacionCorrectaFormulario.class.getName());
        //Esperamos a que cargue la página web
        Thread.sleep(3000);

        logger.info("=========EMPIEZA EL SETEO DE IDENTIFICADORES DE CAMPOS===============");
        elementosFormulario = new ElementosFormulario();
        elementosFormulario.setValidateLink(By.xpath("//a[@class='nav-link text-dark'][1]"));
        elementosFormulario.setValidatePage(By.xpath("/html/body/div/main/div/div/h1"));
        elementosFormulario.setName(By.id("InputName"));
        elementosFormulario.setAddress(By.id("InputAddress"));
        elementosFormulario.setCity(By.xpath("/html/body/div/main/div/form/div[3]/select/option[2]"));
        elementosFormulario.setPhone(By.id("InputPhone"));
        elementosFormulario.setStatus(By.id("InputActive"));
        elementosFormulario.setValidateAlert(By.xpath("//div[@class='alert alert-info']"));
        elementosFormulario.setClickSubmit(By.xpath("//button[@class='btn btn-primary']"));
        logger.info("=========FINALIZA EL SETEO DE IDENTIFICADORES DE CAMPOS===============");
        logger.info("=========EMPIEZA EL SETEO DE VARIABLES===============");
        elementosFormulario.setvName("Christian Barrios");
        elementosFormulario.setvAddress("KR 13 #27-45 - SAN DIEGO");
        elementosFormulario.setvPhone("3197140832");

//Hacemos click en la opción Home, que contiene el formulario que requerimos validar
        if (findElement(elementosFormulario.getValidateLink()) != null) {
            logger.info("OK estamos en la página principal!");

//Validamos que nos encontremos posicionados en la página del formulario
            if (isDisplayed(elementosFormulario.getValidatePage())) {

                //Empezamos a testear los campos, de acuerdo con la especificación indicada
                type(elementosFormulario.getvName(), elementosFormulario.getName());
                type(elementosFormulario.getvAddress(), elementosFormulario.getAddress());
                click(elementosFormulario.getCity());
                type(elementosFormulario.getvPhone(), elementosFormulario.getPhone());

                if (findElement(elementosFormulario.getStatus()).isSelected()) {
                    logger.info("casilla de activación marcada");
                } else {
                    logger.info("casilla de activación no marcada - proceder a marcar");
                    findElement(elementosFormulario.getStatus()).click();
                }

            } else {
                logger.info("\"NO EXISTE EL ELEMENTO\"");

            }

            findElement(elementosFormulario.getClickSubmit()).click();
            if (elementosFormulario.getValidateAlert() != null) {
                logger.info("Se ha enviado satisfactoriamente el formulario con los siguientes datos:"
                        + "\n NAME: " + findElement(elementosFormulario.getName()).getText()
                        + "\n ADDRESS: " + findElement(elementosFormulario.getAddress()).getText()
                        + "\n CITY: " + findElement(elementosFormulario.getCity()).getText()
                        + "\n PHONE: " + findElement(elementosFormulario.getPhone()).getText());

            }

        } else {
            logger.info("---->NO FUE POSIBLE ENCONTRAR LA PÁGINA PRINCIPAL<---------");
        }

    }

}
