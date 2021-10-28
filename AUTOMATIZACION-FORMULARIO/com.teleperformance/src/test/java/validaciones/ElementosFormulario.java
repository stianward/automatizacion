package validaciones;
import java.io.IOException;
import org.openqa.selenium.By;
import java.util.logging.*;
public class ElementosFormulario {
    protected By name;
    protected By address;
    protected By city;
    protected By phone;
    protected By status;
    protected By by;
    protected By validateLink;
    protected By validatePage;
    protected By clickSubmit;
    protected By validateAlert;
    protected String vName;
    protected String vAddress;
    protected String vCity;
    protected String vPhone;
    protected boolean vCheck;
    protected String nombreClase;
    

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getvAddress() {
        return vAddress;
    }

    public void setvAddress(String vAddress) {
        this.vAddress = vAddress;
    }

    public String getvCity() {
        return vCity;
    }

    public void setvCity(String vCity) {
        this.vCity = vCity;
    }

    public String getvPhone() {
        return vPhone;
    }

    public void setvPhone(String vPhone) {
        this.vPhone = vPhone;
    }

    public boolean getvCheck() {
        return vCheck;
    }

    public void setvCheck(boolean vCheck) {
        this.vCheck = vCheck;
    }

    public By getValidateAlert() {
        return validateAlert;
    }

    public void setValidateAlert(By validateAlert) {
        this.validateAlert = validateAlert;
    }

    public By getClickSubmit() {
        return clickSubmit;
    }

    public void setClickSubmit(By clickSubmit) {
        this.clickSubmit = clickSubmit;
    }

    public By getValidatePage() {
        return validatePage;
    }

    public void setValidatePage(By validatePage) {
        this.validatePage = validatePage;
    }

    public By getValidateLink() {
        return validateLink;
    }

    public void setValidateLink(By validateLink) {
        this.validateLink = validateLink;
    }

    public By getName() {
        return name;
    }

    public void setName(By name) {
        this.name = name;
    }

    public By getAddress() {
        return address;
    }

    public void setAddress(By address) {
        this.address = address;
    }

    public By getCity() {
        return city;
    }

    public void setCity(By city) {
        this.city = city;
    }

    public By getPhone() {
        return phone;
    }

    public void setPhone(By phone) {
        this.phone = phone;
    }

    public By getStatus() {
        return status;
    }

    public void setStatus(By status) {
        this.status = status;
    }

    public By getBy() {
        return by;
    }

    public void setBy(By by) {
        this.by = by;
    }
 

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }
       public String getNombreClase() {
        return nombreClase;
    }
    
//       public Logger writeLog(String nameClase) throws IOException{
//           
//           Handler consoleHandler = new ConsoleHandler();
//           Handler fileHandler=new FileHandler("~/Escritorio/log.log",false);
//           Logger logger=Logger.getLogger(getNombreClase());
//           logger.addHandler(fileHandler);
//           SimpleFormatter simpleFormatter = new SimpleFormatter();
//           fileHandler.setFormatter(simpleFormatter);
//           
//    return logger;
//    } 


    
    
    
}
