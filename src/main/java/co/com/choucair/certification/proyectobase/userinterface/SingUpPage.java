package co.com.choucair.certification.proyectobase.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SingUpPage {
   //Registro datos personales
    public static final Target INPUT_FIRST_NAME = Target.the("Donde escribimos el nombre").located(By.id("firstName"));
    public static final Target INPUT_LAST_NAME = Target.the("Donde escribimos el apellido").located(By.id("lastName"));
    public static final Target INPUT_EMAIL = Target.the("Donde escribimos el correo ").located(By.id("email"));
    public static final Target INPUT_MONTH = Target.the("Donde se escoge el mes de cumpleaños").located(By.id("birthMonth"));
    public static final Target INPUT_DAY = Target.the("Donde se escoge el dia de cumpleaños").located(By.id("birthDay"));
    public static final Target INPUT_YEAR = Target.the("Donde se escoge el año de cumpleaños").located(By.id("birthYear"));
    public static final Target BUTTON_GO = Target.the("Da en siguiente a los datos personales ").located(By.xpath("//*[@id=\"regs_container\"]/div/div[2]/div/div[2]/div/form/div[2]/a"));
   //Registro de dirreccion
    public static final Target INPUT_CITY = Target.the("Donde escribimos la ciudad").located(By.id("city"));
    public static final Target INPUT_ZIP = Target.the("Donde escribimos la ciudad").located(By.id("zip"));
    public static final Target BUTTON_GO1 = Target.the("Da en siguiente a la parte 1 de formulario direccion ").located(By.xpath("/html/body/ui-view/main/section/div/div[2]/div/div[2]/div/form/div[2]/div/a"));
    //Registro de Dispositivo
    public static final Target COMPUTER_NAME = Target.the("Extrae el nombre del computador").located(By.xpath("//*[@id=\"web-device\"]/div[1]/div[2]/div/div[1]/span"));
    public static final Target COMPUTER_VERSION = Target.the("Extrae la version del computador").located(By.xpath("//*[@id=\"web-device\"]/div[2]/div[2]/div/div[1]/span"));
    public static final Target COMPUTER_LANGUAGE = Target.the("Extrae el lenguaje del computador").located(By.xpath("//*[@id=\"web-device\"]/div[3]/div[2]/div/div[1]/span"));


    public static final Target BUTTON_GO2 = Target.the("Da en siguiente a la parte 2 de formulario dispositivos").located(By.xpath("/html/body/ui-view/main/section/div/div[2]/div/div[2]/div/div[2]/div/a"));
   //Registro  de Contraseña y confirmacion de privacidad
    public static final Target INPUT_PASSWORD = Target.the("Donde escribimos la contraseña").located(By.id("password"));
    public static final Target INPUT_PASSWORD_CONFIRMATION = Target.the("Donde escribimos la confirmacion de la contraseña").located(By.id("confirmPassword"));
    public static final Target CHECKBOX_UTEST = Target.the("Acepta haber leido los terminos de uTest  ").located(By.xpath("/html/body/ui-view/main/section/div/div[2]/div/div[2]/div/form/div[5]/label/span[1]"));
    public static final Target CHECKBOX_PRIVACY = Target.the("Acepta haber leido los terminos de seguridad y privacidad ").located(By.xpath("/html/body/ui-view/main/section/div/div[2]/div/div[2]/div/form/div[6]/label/span[1]"));
    public static final Target BUTTON_GO3 = Target.the("Da en siguiente a la parte 4 de formulario contraseñas y terminado ").located(By.xpath("/html/body/ui-view/main/section/div/div[2]/div/div[2]/div/div/div/a"));

}
