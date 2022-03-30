package steps;


import cucumber.api.java.pt.*;
import lombok.extern.log4j.Log4j2;
import support.data.DataYaml;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import java.util.Map;

@Log4j2
public class LoginSteps {

    //Page Objects
    private LoginPage loginPage;
    private HomePage homePage;
    private Map map;

    public LoginSteps() {
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Dado("eu estou na pagina de login")
    public void eu_estou_na_pagina_de_login() {
        loginPage.navigateToUrl();
    }

    @Quando("eu efetuar o login com {string}")
    public void euEfetuarOLoginCom(String dataType) {
        map = DataYaml.getMapYamlValues("Usuarios", dataType);
        loginPage.logar((String) map.get("usuario"), (String) map.get("senha"));
    }

    @Entao("sera apresentado a tela do menu principal")
    public void sera_apresentado_a_tela_do_menu_principal() {
        Assert.assertTrue(homePage.validarMenuPresente());
    }


    @Entao("^sera apresentado uma mensagem de erro$")
    public void seraApresentadoUmaMensagemDeErro() throws Throwable {
        Assert.assertTrue(loginPage.seraApresentadoUmaMensagemDeErro());
    }
}
