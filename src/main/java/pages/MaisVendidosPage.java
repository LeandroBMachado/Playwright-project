package pages;

import static support.context.Context.web;

public class MaisVendidosPage {

    String primeiroItem = "//ol[@class=\"a-carousel\"][1]//li[1]";

    public void clicarPrimeiroItem(){

        web().getPage().click(primeiroItem);
    }


}
