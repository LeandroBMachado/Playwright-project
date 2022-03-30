package pages;

import static support.context.Context.web;

public class HomePageAmazon {

    String logoAmazon = "//*[@id=\"nav-logo-sprites\"]";
    String btnAbaTodos = "(//span[text()='Todos'])[2]";
    String boxMenuEsquerdo = "//*[@id=\"hmenu-customer-profile-right\"]";

    public void irPara(){

        web().getPage().navigate("https://www.amazon.com.br/ref=nav_logo");
    }

    public boolean checkPage(){
        web().getPage().hover(logoAmazon); //HOVER. CARREGAR OPCAO
        return web().getPage().isVisible(logoAmazon);




    }

    public void clicarBtnAbaTodos(){
        //web().getPage().pause(); CHAMAR INSPECTOR PLAYWRIGHT
        web().getPage().click(btnAbaTodos);

    }

    public boolean checkMenuEsquerdo(){
             web().getPage().hover(boxMenuEsquerdo); // VALIDAR CARREGAR MENU hover
    return   web().getPage().isVisible(boxMenuEsquerdo); // VALIDAR SE MENU E VISIVEL

    }

    public void selecionarItem(String nomeItem){
        //inspeção personalidazada
        web().getPage().click("//li//a[text()='"+ nomeItem+"']" );



    }


}
