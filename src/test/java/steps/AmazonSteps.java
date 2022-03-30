package steps;


import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import pages.HomePageAmazon;
import pages.ItemPage;
import pages.MaisVendidosPage;

import static support.context.Context.report;

public class AmazonSteps {

    public HomePageAmazon homePageAmazon =  new HomePageAmazon();
    public MaisVendidosPage maisvendidospage =  new MaisVendidosPage();
    public ItemPage itempage = new ItemPage();



    @Dado("que eu esteja na pagina da Amazon")
    public void que_eu_esteja_na_pagina_da_Amazon() {
        homePageAmazon.irPara();
        homePageAmazon.checkPage();


    }

    @Quando("selecionar a aba todos")
    public void selecionar_a_aba_todos() {

        homePageAmazon.clicarBtnAbaTodos();

    }

    @Quando("exibir o menu")
    public void exibir_o_menu() {
        report().takeScreenShot();
       Assert.assertTrue("Falha ao visualizar lateral esquerdo ",homePageAmazon.checkMenuEsquerdo()); //VALIDAR SE EXIBE O MENU

    }

    @Quando("selecionar o item {string}")
    public void selecionar_o_item(String item) {

        homePageAmazon.selecionarItem(item);

    }

    @Entao("selecionar o primeiro item")
    public void selecionar_o_primeiro_item() {

        maisvendidospage.clicarPrimeiroItem();

    }

    @Entao("visualizar a pagina do item e o mesmo valor")
    public void visualizar_a_pagina_do_item_e_o_mesmo_valor() {
        report().takeScreenShot();
    Assert.assertTrue("Falha ao adicionar",itempage.checkadicionaraoCarrinho()); //VALIDAR SE ADICIONOU NO CARRINHO


    }



}
