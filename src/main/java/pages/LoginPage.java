package pages;

import lombok.extern.log4j.Log4j2;
import static support.context.Context.*;

@Log4j2
public class LoginPage {

    //Page Elements
    private String inputEmail = "id=email";
    private String inputSenha = "id=senha";
    private String btnButton = "xpath=//button";
    private String msgErroLogin = "xpath=//div[@class='alert alert-danger']";

    public void navigateToUrl(){
        web().tentarIrPara(config().getPropsEnv().url());
    }

    public void logar(String user, String pass){
        report().takeScreenShot();
        web().getPage().type(inputEmail,user);
        web().getPage().type(inputSenha,pass);
        web().getPage().click(btnButton);
    }

    public void logarEmTodasAsAbas(String user, String pass){
        for(int pageNumber = 1; pageNumber < web().getBrowserContext().pages().size(); pageNumber++){
            web().changeFocusPage(pageNumber);
            report().takeScreenShot();
            web().getPage().type(inputEmail,user);
            web().getPage().type(inputSenha,pass);
            web().getPage().click(btnButton);
        }
    }

    public void navigateToUrlAllPages() {
        for(int pageNumber = 0; pageNumber < web().getBrowserContext().pages().size(); pageNumber++){
            report().takeScreenShot();
            web().changeFocusPage(pageNumber).navigate("https://seubarriga.wcaquino.me/login");
            report().takeScreenShot();
        }
    }

    public void abrirNovaPagina(){
        web().createAnotherPageWithoutFocus();
    }

    public boolean seraApresentadoUmaMensagemDeErro() {
        web().getPage().hover(msgErroLogin);
        return web().getPage().isVisible(msgErroLogin);
    }

}
