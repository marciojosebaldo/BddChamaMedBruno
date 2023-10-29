package ChamadasLeitos.chamadas;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class visualizarTelaChamadas {

    private WebDriver driver;

    @Dado("que usuario acessa a tela dos chamados {string}")
    public void queUsuarioAcessaATelaDosChamados(String site) {
        System.setProperty("webdriver.edge.driver", "/home/marciobaldo/Desktop/msedgedriver"); // Aponta para o executável do ChromeDriver
        driver = new EdgeDriver(); // Usa o EdgeDriver. Instalada a versão Dev 120.0.2172.1
        driver.get(site);
        driver.manage().window().maximize();
    }

    @Quando("o usuario clica sobre a tela")
    public void oUsuarioClicaSobreATela() {
        WebElement clicaTela = driver.findElement(By.className("identificacao"));
        clicaTela.click();
    }

    @Entao("retorna para a pagina de simulacao {string}")
    public void retornaParaAPaginaDeSimulacao(String siteTeste) {
        String siteRetorno = driver.getCurrentUrl();
        Assert.assertEquals(siteTeste, siteRetorno);
    }
}
