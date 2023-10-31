package ChamadasLeitos.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class cadastrarUsuario {
    @Dado("que o usuario esta na tela {string}")
    public void queOUsuarioEstaNaTela(String site) {

    }

    @Quando("o usuario clica no botao Adicionar Usuario e abre uma nova janela {string}")
    public void oUsuarioClicaNoBotaoAdicionarUsuarioEAbreUmaNovaJanela(String arg0) {
    }

    @E("digitar o nome {string}, número de matricula {string} e selecionar o cargo {string}")
    public void digitarONomeNúmeroDeMatriculaESelecionarOCargo(String arg0, String arg1, String arg2) {
    }

    @E("clica no botao Salvar Cadastro")
    public void clicaNoBotaoSalvarCadastro() {
    }

    @Entao("sera salvo um novo usuario e retorna para a janela anterior {string}")
    public void seraSalvoUmNovoUsuarioERetornaParaAJanelaAnterior(String arg0) {
    }
}
