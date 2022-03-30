package steps;

import cucumber.api.java.pt.E;
import pages.HomePageGIU;
import pages.ItemPage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

import static support.context.Context.web;

public class GiuSteps {

    public HomePageGIU homePageGIU = new HomePageGIU();
    public ItemPage itempage = new ItemPage();



    @Dado("que eu esteja na pagina de login GIU")
    public void queEuEstejaNaPaginaDeLoginGIU() {

       homePageGIU.irPara();


    }

    @E("eu insiro meu usuario")
    public void euInsiroMeuUsuario() {

        homePageGIU.user();
    }

    @E("eu insira minha senha")
    public void euInsiraMinhaSenha() {

        homePageGIU.senha();
    }

    @Quando("eu clico no botao {string}")
    public void euClicoNoBotao(String arg0) {

        homePageGIU.clicarBtn();
    }

    @Entao("eu valido que fiz login")
    public void euValidoQueFizLogin() {

        homePageGIU.validar();
    }


    @E("clico na unimed {int}")
    public void clicoNaUnimed(int arg0) {

        homePageGIU.unimed1();
    }
}
