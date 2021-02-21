package co.com.choucair.certification.proyectobase.tasks;

import co.com.choucair.certification.proyectobase.userinterface.SingUpPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Keys;

public class SingUp implements Task{

    private String strFirstName;
    private String strLastName;
    private String strEmail;
    private String strMonth;
    private String strDay;
    private String strYear;
    private String strPassword;
    private String strPasswordConfirmation;
    private String strCity;
    private String strZip;
    private String strComputer;
    private String strVersion;
    private String strLenguaje;
    private Boolean vacio = false;


    public SingUp(String strFirstName, String strLastName, String strEmail, String strMonth, String strDay, String strYear, String strPassword, String strPasswordConfirmation, String strCity, String strZip, String strComputer, String strVersion, String strLenguaje )
    {
        this.strFirstName = strFirstName;
        this.strLastName = strLastName;
        this.strEmail = strEmail;
        this.strMonth = strMonth;
        this.strDay = strDay;
        this.strYear = strYear;
        this.strPassword = strPassword;
        this.strPasswordConfirmation = strPasswordConfirmation;
        this.strCity= strCity;
        this.strZip = strZip;
        this.strComputer= strComputer;
        this.strVersion= strVersion;
        this.strLenguaje= strLenguaje;
    }

    public static SingUp the(String strFirstName, String strLastName, String strEmail, String strMonth, String strDay, String strYear, String strPassword, String strPasswordConfirmation, String strCity, String strZip, String strComputer, String strVersion, String strLenguaje ){
        return Tasks.instrumented(SingUp.class,strFirstName,strLastName,strEmail,strMonth,strDay,strYear,strPassword,strPasswordConfirmation,strCity,strZip,strComputer, strVersion,strLenguaje);
    }

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        this.DatosPersonales( actor);
        this.Direccion(actor);
        try {
            this.Dispositivo(actor);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.ContrasenaYPrivacidad(actor);
    }

    private <T extends Actor> void ContrasenaYPrivacidad(T actor) {
        actor.attemptsTo(
                Enter.theValue(strPassword).into(SingUpPage.INPUT_PASSWORD),
                Enter.theValue(strPasswordConfirmation).into(SingUpPage.INPUT_PASSWORD_CONFIRMATION),
                Click.on(SingUpPage.CHECKBOX_UTEST),
                Click.on(SingUpPage.CHECKBOX_PRIVACY),
                Click.on(SingUpPage.BUTTON_GO3)
        );
    }

    private <T extends Actor> void Dispositivo(T actor) throws InterruptedException {
       this.vacio =  this.campoVacio(actor, SingUpPage.COMPUTER_NAME);
       if (!vacio) {
           actor.attemptsTo( SelectFromOptions.byVisibleText(strComputer).from(SingUpPage.COMPUTER_NAME));
       }
       if(!(this.vacio =  this.campoVacio(actor, SingUpPage.COMPUTER_VERSION))) {
           actor.attemptsTo( SelectFromOptions.byVisibleText(strVersion).from(SingUpPage.COMPUTER_VERSION));
       }
       if (!(this.vacio =  this.campoVacio(actor, SingUpPage.COMPUTER_LANGUAGE))) {
           actor.attemptsTo( SelectFromOptions.byVisibleText(strLenguaje).from(SingUpPage.COMPUTER_LANGUAGE));
       }
        actor.attemptsTo(Click.on(SingUpPage.BUTTON_GO2));
    }

    private <T extends Actor> Boolean campoVacio(T actor, Target campo) throws InterruptedException {
        this.vacio=false;
            String name = Text.of(campo).viewedBy(actor).asString();
            if(!name.isEmpty()){
                this.vacio=true;
            }
        return this.vacio;
    }

    private <T extends Actor> void Direccion(T actor) {
        actor.attemptsTo( Enter.theValue(strCity).into(SingUpPage.INPUT_CITY),
                Hit.the(Keys.ARROW_DOWN).keyIn(SingUpPage.INPUT_CITY),
                Click.on(SingUpPage.INPUT_CITY),
                Enter.theValue(strZip).into(SingUpPage.INPUT_ZIP),
                Click.on(SingUpPage.BUTTON_GO1)
        );
    }

    private <T extends Actor> void DatosPersonales(T actor) {
        actor.attemptsTo(Enter.theValue(strFirstName).into(SingUpPage.INPUT_FIRST_NAME) ,
                Enter.theValue(strLastName).into(SingUpPage.INPUT_LAST_NAME),
                Enter.theValue(strEmail).into(SingUpPage.INPUT_EMAIL),
                SelectFromOptions.byVisibleText("February").from(SingUpPage.INPUT_MONTH),
                SelectFromOptions.byVisibleText("11").from(SingUpPage.INPUT_DAY),
                SelectFromOptions.byVisibleText("1997").from(SingUpPage.INPUT_YEAR),
                Click.on(SingUpPage.BUTTON_GO)
        );
    }


}
