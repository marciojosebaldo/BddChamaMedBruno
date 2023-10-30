#language: pt
  Funcionalidade: testar a tela de login
    Cenario: acessar a pagina de login no site da aplicacao
      Dado que o usuario acessa a tela de login "http://localhost:8080/"
      E envia os dados de matricula "123" e senha "123"
      Quando o usuario clica no botao login
      Entao sera aberta uma nova janela "http://localhost:8080/home"