package pages;


import lombok.extern.log4j.Log4j2;
import support.report.Report;

import static org.junit.Assert.assertEquals;
import static support.context.Context.*;


@Log4j2
public class HomePage {

    //Page Elements
    private String txtMessage = "xpath=//div[contains(text(),'Bem vindo')]";

    public boolean validarMenuPresente() {

        report().takeScreenShot();
        return web().getPage().isVisible(txtMessage);
    }

    public void validarMenuPresenteEmTodasAsAbas() {
        for(int pageNumber = 1; pageNumber < web().getBrowserContext().pages().size(); pageNumber++){
            web().changeFocusPage(pageNumber);
            report().takeScreenShot();
            assertEquals("Bem vindo, teste!", web().getPage().innerHTML(".alert"));
        }
    }


}
