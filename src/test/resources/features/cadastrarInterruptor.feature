#language: pt
  Funcionalidade: cadastrar um interruptor no sistema
    Cenario: acessar a página do interruptor e cadastrar um interruptor do leito
      Dado que o usuário está na tela dos interruptores
      Quando o usuário clicar em cadastrar
      Entao um novo registro de interruptor será criado


      Funcionalidade: cadastrar um interruptor no sistema de modo a causar erro propositalmente
        Cenario: acessar a página do interruptor e cadastrar um interruptor do leito com dados incorretos
          Dado que o usuário está na tela dos interruptores
          Quando o usuário clicar no botão cadastrar
          E preencher com as informações necessárias e incorretas
          Entao o sistema não permitirá que um novo interruptor seja criado