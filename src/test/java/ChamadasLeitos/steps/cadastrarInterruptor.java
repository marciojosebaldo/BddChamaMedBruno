package ChamadasLeitos.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class cadastrarInterruptor {

    public WebDriver driver;

    @Dado("que o usuario acessa a tela dos interruptores {string}")
    public void queOUsuarioAcessaATelaDosInterruptores(String site) {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Aluno\\Desktop\\msedgedriver"); // Aponta para o executável do ChromeDriver
        driver = new EdgeDriver();
        driver.get(site);
    }

    @Quando("o usuario clicar no botao Adicionar Interruptor")
    public void oUsuarioClicarNoBotaoAdicionarInterruptor() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement adicionarInterruptor = driver.findElement(By.id("adicionarInterruptor"));
        adicionarInterruptor.click();
    }

    @E("abrir uma nova janela {string}")
    public void abrirUmaNovaJanela(String novaJanela) {
        String siteRetorno = driver.getCurrentUrl();
        Assert.assertEquals(novaJanela, siteRetorno);
    }

    @Entao("o usuario preenchera o nome do interruptor com {string}, deixara o valor booleano {string} e o Setor {string}")
    public void oUsuarioPreencheraONomeDoInterruptorComDeixaraOValorBooleanoEOSetor(String nomeInterruptor, String valorBooleano, String nomeSetor) {
        WebElement nomeInterruptorWeb = driver.findElement(By.id("interruptor"));
        nomeInterruptorWeb.sendKeys("novoInterruptor");

        WebElement valorBooleanoWeb = driver.findElement(By.id("estado"));
        valorBooleanoWeb.sendKeys("true");

        WebElement nomeSetorWeb = driver.findElement(By.id("setor"));
        nomeSetorWeb.sendKeys("novoSetor");

        WebElement botaoCadastrarWeb = driver.findElement(By.id("cadastrar"));
        botaoCadastrarWeb.click();
    }
}