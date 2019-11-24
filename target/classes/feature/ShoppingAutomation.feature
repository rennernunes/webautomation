#Author: Renner Nunes - https://www.linkedin.com/in/rennernunes/
#language: pt
Funcionalidade: Realizar uma compra online
  Como cliente
  Eu quero realizar uma compra online

  Contexto: 
    Dado que acesso a pagina de compras

  Cenario: Comprar um produto disponível no estoque
    E seleciono um produto
    Quando adiciono o produto na sacola
    Entao sou direcionado para o carrinho

  @ignore
  Cenario: Comprar um produto indisponível no estoque
    Quando adiciono o produto na sacola
    Entao sou direcionado para o carrinho

  Cenario: Produto da busca não encontrado
    Quando realizo a busca de um produto inválido
    Entao aparece uma mensagem de busca inválida
