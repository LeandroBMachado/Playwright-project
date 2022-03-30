package pages;

import support.data.DataYaml;

import static org.junit.Assert.assertTrue;
import static support.context.Context.report;
import static support.context.Context.web;

public class HomePageGIU {

        String  campoLogin = "//input[contains(@type,'text')]";
        String camposenha = "//input[contains(@placeholder,'Insira a senha')]";
        String btnEntrar = "//button[@class='unicomp-botao primario '][contains(.,'ENTRAR')]";
        String unimed1acessar = "//button[@class='unicomp-botao primario '][contains(.,'1 - UNIMED SANTOS')]";

    public void irPara() {

        web().getPage().navigate("https://giuhml.unimed.coop.br/login");


    }


    public void user() {
        web().getPage().waitForTimeout(1000);
       web().getPage().fill(campoLogin,"94336695253");
    }

    public void senha() {
        web().getPage().waitForTimeout(1000);
        web().getPage().fill(camposenha,"P@ssw0rd");

    }

    public void clicarBtn() {
        web().getPage().waitForTimeout(1000);
        web().getPage().click(btnEntrar);
        report().takeScreenShot();


    }

    public void validar() {

        boolean visible = web().getPage().isVisible("//h2[@class='fonte-primaria negrito title'][contains(.,'Escolha a Unimed')]");
        assertTrue(visible);
        report().takeScreenShot();

    }

    public void unimed1() {

        web().getPage().click(unimed1acessar);
    }

    public void menuAplicacoes() {

        web().getPage().click("//h2[@class='fonte-primaria medio negrito'][contains(.,'Suas aplicações')]");
    }
}
