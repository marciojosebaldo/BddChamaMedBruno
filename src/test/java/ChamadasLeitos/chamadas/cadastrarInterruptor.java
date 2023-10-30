package ChamadasLeitos.chamadas;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class cadastrarInterruptor {

    private WebDriver driver;

    @Dado("que o usuario acessa a tela dos interruptores {string}")
    public void queOUsuarioAcessaATelaDosInterruptores(String site) {
        System.setProperty("webdriver.edge.driver", "/home/marciobaldo/Desktop/msedgedriver"); // Aponta para o executável do ChromeDriver
        driver = new EdgeDriver();
        driver.get(site);
        driver.manage().window().maximize();
        throw new io.cucumber.java.PendingException();
    }

    @Quando("o usuario clicar no botao Adicionar Interruptor")
    public void oUsuarioClicarNoBotaoAdicionarInterruptor() {
        WebElement clicaBotao = driver.findElement(By.id("adicionarInterruptor"));
        clicaBotao.click();
        throw new io.cucumber.java.PendingException();
    }

    @E("abrir uma nova janela {string}")
    public void abrirUmaNovaJanela(String novaJanela) {
        String siteRetorno = driver.getCurrentUrl();
        Assert.assertEquals(novaJanela, siteRetorno);
        throw new io.cucumber.java.PendingException();
    }

    @Entao("o usuario preenchera o nome do interruptor com {string}, deixara o valor booleano {string} e o Setor {string}")
    public void oUsuarioPreencheraONomeDoInterruptorComDeixaraOValorBooleanoEOSetor(String nomeInterruptor, String valorBooleano, String nomeSetor) {
        WebElement nomeInterruptorWeb = driver.findElement(By.id("interruptor"));
        nomeInterruptorWeb.sendKeys("novoInterruptor");

        WebElement valorBooleanoWeb = driver.findElement(By.id("estado"));
        valorBooleanoWeb.sendKeys("true");

        WebElement nomeSetorWeb = driver.findElement(By.id("setor"));
        nomeSetorWeb.sendKeys("novoSetor");
        throw new io.cucumber.java.PendingException();
    }
}