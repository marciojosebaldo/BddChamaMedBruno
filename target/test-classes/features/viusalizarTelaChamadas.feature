#language: pt
  Funcionalidade: Visualizar a tela de chamadas do link "http://localhost:8080/chamados"
    Cenario: Acessar a página e visualizar os chamados no site "http://localhost:8080/chamados"
        Dado que usuário está na tela dos chamados "http://localhost:8080/chamados"
        E visualiza os lançamentos
        Quando o usuário clica sobre na tela
        Entao é retornado para a página "http://localhost:8080/simulacao"