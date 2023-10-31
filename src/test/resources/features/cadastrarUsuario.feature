#language: pt
  Funcionalidade: cadastrar um usuario na aplicacao
    Cenario: usuario acessara a aplicacao e preenhcera os dados necessarios para cadastrar um usuario
      Dado que o usuario esta na tela "http://localhost:8080/showUsuario"
      Quando o usuario clica no botao Adicionar Usuario e abre uma nova janela "http://localhost:8080/showNewUsuarioForm"
      E digitar o nome "novoNome", número de matricula "1234" e selecionar o cargo "Gestor"
      E clica no botao Salvar Cadastro
      Entao sera salvo um novo usuario e retorna para a janela anterior "http://localhost:8080/showUsuario"