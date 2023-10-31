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

    @Dado("que o usuario esta na tela {string}")
    public void queOUsuarioEstaNaTela(String site) {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Aluno\\Desktop\\msedgedriver"); // Aponta para o executável do ChromeDriver
        driver = new EdgeDriver();
        driver.get(site);
    }

    @Quando("o usuario clica no botao Adicionar Usuario e abre uma nova janela {string}")
    public void oUsuarioClicaNoBotaoAdicionarUsuarioEAbreUmaNovaJanela(String novaJanela) {
        WebElement clicaBotao = driver.findElement(By.className("btn btn-primary"));
        clicaBotao.click();
        String janelaCadastro = driver.getCurrentUrl();
        Assert.assertEquals(novaJanela, janelaCadastro);
    }

    @E("digitar o nome {string}, numero de matricula {string} e selecionar o cargo {string}")
    public void digitarONomeNumeroDeMatriculaESelecionarOCargo(String novoNome, String novaMatricula, String novoCargo) {
        driver.findElement(By.id("nome")).sendKeys(novoNome);
        driver.findElement(By.id("matricula")).sendKeys(novaMatricula);
        driver.findElement(By.id("cargo")).sendKeys("Gestor");
    }

    @E("clica no botao Salvar Cadastro")
    public void clicaNoBotaoSalvarCadastro() {
        driver.findElement(By.id("enviar")).click();
    }

    @Entao("sera salvo um novo usuario e retorna para a janela anterior {string}")
    public void seraSalvoUmNovoUsuarioERetornaParaAJanelaAnterior(String janelaRetorna) {
        String siteRetorno = driver.getCurrentUrl();
        Assert.assertEquals(janelaRetorna, siteRetorno);
    }
}