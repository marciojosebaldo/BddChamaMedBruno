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

public class fazerLogin {

    public WebDriver driver;

    @Dado("que o usuario acessa a tela de login {string}")
    public void queOUsuarioAcessaATelaDeLogin(String siteLogin) {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Aluno\\Desktop\\msedgedriver");
        driver = new EdgeDriver();
        driver.get(siteLogin);
        driver.manage().window().maximize();
    }
    @E("envia os dados de matricula {string} e senha {string}")
    public void enviaOsDadosDeMatriculaESenha(String matricula123, String senha123) {
        WebElement matricula = driver.findElement(By.id("matricula"));
        matricula.sendKeys(matricula123);

        WebElement senha = driver.findElement(By.id("senha"));
        senha.sendKeys(senha123);
        throw new io.cucumber.java.PendingException();
    }

    @Quando("o usuario clica no botao login")
    public void oUsuarioClicaNoBotaoLogin() {
        WebElement botaoLogin = driver.findElement(By.className("btn btn-sm btn-primary"));
        botaoLogin.click();
        throw new io.cucumber.java.PendingException();
    }

    @Entao("sera aberta uma nova janela {string}")
    public void seraAbertaUmaNovaJanela(String novaJanela) {
        String siteRetorno = driver.getCurrentUrl();
        Assert.assertEquals(novaJanela, siteRetorno);
        throw new io.cucumber.java.PendingException();
    }
}