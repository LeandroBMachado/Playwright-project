package pages;

import static support.context.Context.web;

public class ItemPage {

    String btnadicionaraoCarrinho = "//input[@id=\"add-to-cart-button\"]";


    public boolean checkadicionaraoCarrinho() {

        web().getPage().hover(btnadicionaraoCarrinho);
        return web().getPage().isVisible(btnadicionaraoCarrinho); //RETORNA SE O BOTAO É VISIVEL

    }
}
