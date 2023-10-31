#language: pt
  Funcionalidade: cadastrar um usuario na aplicacao
    Cenario: usuario acessara a aplicacao e preenhcera os dados necessarios para cadastrar um usuario
      Dado o usuario clica no botao Adicionar Usuario e abre uma nova janela "http://localhost:8080/showNewUsuarioForm"
      Quando E digitar o nome "novoNome", numero de matricula "1234" e selecionar o cargo
      Entao sera salvo um novo usuario e retorna para a janela anterior "http://localhost:8080/showUsuario"