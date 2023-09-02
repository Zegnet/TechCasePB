package Web.Pages;

import Web.Attributes.AttributesHome;
import engine.Web.Utils;

public final class PageHome extends AttributesHome implements Utils {

    public PageHome(){
        super();
    }

    public PageHome buttonsValidate(){

        navigateTo("https://the-internet.herokuapp.com/challenging_dom", "Navegar até a página da aplicação");
        validate(button, "Validar que os botoões foram apresentados");
        click(button, "Clicar no botão comum 'Azul'");
        click(alertButton,"Clicar no botão de alerta 'Vermelho'");
        click(successButton, "Clicar no botão de sucesso 'Verde'");

        return this;
    }

    public PageHome editLinksValidade(){

        for(int i = 0; i < rows.size(); i++){
            click(editLinks.get(i), "Clicar no link 'edit' da linha " + rows.get(i).getText());
        }

        return this;
    }

    public PageHome deleteLinksValidade(){
        for(int i = 0; i < rows.size(); i++){
            click(deleteLinks.get(i), "Clicar no link 'delete' da linha " + rows.get(i).getText());
        }

        return this;
    }
}
