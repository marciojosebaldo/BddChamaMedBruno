#language: pt
Funcionalidade: cadastrar um interruptor no sistema na tela "http://localhost:8080/showNewInterruptorForm"
  Cenario: acessar a pagina do interruptor "http://localhost:8080/showInterruptor" e cadastrar um interruptor do leito em "http://localhost:8080/showNewInterruptorForm"
    Dado que o usuario acessa a tela dos interruptores "http://localhost:8080/showInterruptor"
    Quando o usuario clicar no botao Adicionar Interruptor
    E abrir uma nova janela "http://localhost:8080/showNewInterruptorForm"
    Entao o usuario preenchera o nome do interruptor com "novoInterruptor", deixara o valor booleano "true" e o Setor "novoSetor"