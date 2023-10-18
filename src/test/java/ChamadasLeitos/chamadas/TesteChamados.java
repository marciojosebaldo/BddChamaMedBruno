package ChamadasLeitos.chamadas;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class TesteChamados {
    private WebDriver driver;

    @Dado("que usuário está na tela dos chamados {string}")
    public void queUsuárioEstáNaTelaDosChamados(String site) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aluno\\Desktop\\BddChamaMedBruno\\driver\\chromedriver.exe"); // Aponta para o executável do ChromeDriver
        driver = new ChromeDriver(); // Usa o ChromeDriver
        driver.get(site);
        driver.manage().window().maximize();
        throw new io.cucumber.java.PendingException();
    }

    @E("visualiza os lançamentos")
    public void visualizaOsLançamentos() {
        driver.findElement(By.className("interruptor desligado"));
        throw new io.cucumber.java.PendingException();
    }

    @Quando("o usuário clica sobre na tela")
    public void oUsuárioClicaSobreNaTela() {
        WebElement clicaTela = driver.findElement(By.className("identificacao"));
        clicaTela.click();
        throw new io.cucumber.java.PendingException();
    }

    @Entao("é retornado para a página {string}")
    public void éRetornadoParaAPágina(String siteTeste) {
        String siteRetorno = driver.getCurrentUrl();
        Assert.assertEquals(siteTeste, siteRetorno);
        throw new io.cucumber.java.PendingException();
    }
}