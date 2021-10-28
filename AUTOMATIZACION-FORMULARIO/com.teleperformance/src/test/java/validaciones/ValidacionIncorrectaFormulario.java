package validaciones;

import com.avianca.mavenproject1.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.logging.Logger;

public class ValidacionIncorrectaFormulario extends Base {

    ElementosFormulario elementosFormulario;
    protected WebDriver driver;
    Logger logger;
    int validation = 0;
    String nameClase = ValidacionIncorrectaFormulario.class.getName();

    public ValidacionIncorrectaFormulario(WebDriver driver) {
        super(driver);
    }

    public void ValidacionIncorrectaFormulario() throws InterruptedException {
        logger = Logger.getLogger(nameClase);

        //Esperamos a que cargue la página web
        Thread.sleep(3000);

        logger.info("=========EMPIEZA EL SETEO DE IDENTIFICADORES DE CAMPOS===============");
        elementosFormulario = new ElementosFormulario();
        elementosFormulario.setValidateLink(By.xpath("//a[@class='nav-link text-dark'][1]"));
        elementosFormulario.setValidatePage(By.xpath("//h1[@class='display-4']"));
        elementosFormulario.setName(By.id("InputName"));
        elementosFormulario.setAddress(By.id("InputAddress"));
        elementosFormulario.setCity(By.xpath("/html/body/div/main/div/form/div[3]/select/option[2]"));
        elementosFormulario.setPhone(By.id("InputPhone"));
        elementosFormulario.setStatus(By.id("InputActive"));
        elementosFormulario.setValidateAlert(By.xpath("//div[@class='alert alert-info']"));
        elementosFormulario.setClickSubmit(By.xpath("//button[@class='btn btn-primary']"));
        logger.info("=========FINALIZA EL SETEO DE IDENTIFICADORES DE CAMPOS===============");
        logger.info("=========EMPIEZA EL SETEO DE VARIABLES VACIAS===============");
        elementosFormulario.setvName("PE");
        elementosFormulario.setvAddress(" ");
        elementosFormulario.setvPhone(" ");
        logger.info("=========FINALIZA EL SETEO DE VARIABLES CON DATOS INCONSISTENTES===============");

//Hacemos click en la opción Home, que contiene el formulario que requerimos validar
//Validamos que nos encontremos posicionados en la página del formulario
        if (findElement(elementosFormulario.getValidatePage()).isDisplayed()) {
            logger.info("OK estamos en la página principal!");
            logger.info("=========>Hacemos click en el boton submit===============");

            executeForm();
            Thread.sleep(2000);
            //Empezamos a testear los campos, de acuerdo con la especificación indicada
            type(elementosFormulario.getvName(), elementosFormulario.getName());
            type(elementosFormulario.getvAddress(), elementosFormulario.getAddress());
            type(elementosFormulario.getvPhone(), elementosFormulario.getPhone());
            executeForm();
            Thread.sleep(2000);
            logger.info("=========>Entramos al switch===============");

            do {
                switch (findElement(elementosFormulario.getValidateAlert()).getText()) {
                    case "empty name":
                        logger.info("=========>Seteamos un NAME que no cumple la longitud minima===============");
                        elementosFormulario.setvName("PE");
                        type(elementosFormulario.getvName(), elementosFormulario.getName());
                        executeForm();
                        validation++;
                        break;
                    case "name cannot be > 30 or < 3 characters":
                        logger.info("=========>Seteamos un NAME que cumple la longitud minima===============");
                        findElement(elementosFormulario.getName()).clear();
                        elementosFormulario.setvName("PERSONA1");
                        type(elementosFormulario.getvName(), elementosFormulario.getName());
                        executeForm();
                        validation++;
                        break;
                    case "empty address":
                        logger.info("=========>ADDRESS VACIA - Seteamos un ADDRESS que no cumple la longitud minima===============");
                        elementosFormulario.setvAddress("DIR");
                        type(elementosFormulario.getvAddress(), elementosFormulario.getAddress());
                        executeForm();
                        validation++;
                        break;
                    case "address cannot be > 50 or < 10 characters":
                        logger.info("=========>Seteamos un ADDRESS que  cumple la longitud minima===============");
                        findElement(elementosFormulario.getAddress()).clear();
                        Thread.sleep(2000);
                        elementosFormulario.setvAddress("DIRECCION COMPLETA");
                        type(elementosFormulario.getvAddress(), elementosFormulario.getAddress());
                        executeForm();
                        validation++;

                        break;
                    case "empty phone":
                        logger.info("=========>PHONE vacio - Seteamos un PHONE que no cumple la longitud minima===============");
                        elementosFormulario.setvPhone("32171889");
                        type(elementosFormulario.getvPhone(), elementosFormulario.getPhone());
                        executeForm();
                        validation++;
                        break;
                    case "phone cannot be > 20 or < 10 characters":
                        logger.info("=========>Seteamos un PHONE  que cumple la longitud minima===============");
                        findElement(elementosFormulario.getPhone()).clear();
                        elementosFormulario.setvPhone("3217188931");
                        type(elementosFormulario.getvPhone(), elementosFormulario.getPhone());

                        executeForm();
                        validation++;
                        break;
                    case "phone not valid. Only numbers and spaces are allowed":
                        logger.info("=========>Seteamos un PHONE que no cumple la condición de solo numeros===============");
                        findElement(elementosFormulario.getPhone()).clear();
                        elementosFormulario.setvPhone("311");

                        type(elementosFormulario.getvPhone(), elementosFormulario.getPhone());
                        executeForm();
                        validation++;
                        break;
                    case "empty city":
                        logger.info("=========>CITY vacio - click CITY y selecciona ciudad===============");
                        click(elementosFormulario.getCity());

                        executeForm();
                        validation++;
                        break;
                    default:
                        validation++;

                }

            } while (validation < 7);

        }

    }

    public void executeForm() {
        findElement(elementosFormulario.getClickSubmit()).click();

    }

}
