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

public class cadastrarUsuario {

    public WebDriver driver;

    @Dado("o usuario clica no botao Adicionar Usuario e abre uma nova janela {string}")
    public void oUsuarioClicaNoBotaoAdicionarUsuarioEAbreUmaNovaJanela(String site) {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Aluno\\Desktop\\msedgedriver.exe"); // Aponta para o executável do ChromeDriver
        driver = new EdgeDriver();
        driver.get(site);
    }

    @Quando("E digitar o nome {string}, numero de matricula {string} e selecionar o cargo")
    public void eDigitarONomeNumeroDeMatriculaESelecionarOCargo(String novoNome, String novaMatricula) {
        WebElement campoNome = driver.findElement(By.id("nome"));
        campoNome.sendKeys(novoNome);

        WebElement campoMatricula = driver.findElement(By.id("matricula"));
        campoMatricula.sendKeys(novaMatricula);

        WebElement campoCargo = driver.findElement(By.id("cargo"));
        campoCargo.sendKeys("Gestor");
    }

    @E("clica no botao Salvar Cadastro")
    public void clicaNoBotaoSalvarCadastro() {
        WebElement botaoSalvar = driver.findElement(By.id("enviar"));
        botaoSalvar.click();
    }

    @Entao("sera salvo um novo usuario e retorna para a janela anterior {string}")
    public void seraSalvoUmNovoUsuarioERetornaParaAJanelaAnterior(String janelaRetorna) {
        String siteRetorno = driver.getCurrentUrl();
        Assert.assertEquals(janelaRetorna, siteRetorno);
    }
}