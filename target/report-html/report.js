$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/java/feature/ShoppingAutomation.feature");
formatter.feature({
  "name": "Realizar uma compra online",
  "description": "  Como cliente\n  Eu quero realizar uma compra online",
  "keyword": "Funcionalidade"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Contexto"
});
formatter.step({
  "name": "que acesso a pagina de compras",
  "keyword": "Dado "
});
formatter.match({
  "location": "ShoppingAutomationSteps.java:22"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Produto da busca não encontrado",
  "description": "",
  "keyword": "Cenario"
});
formatter.step({
  "name": "realizo a busca de um produto inválido",
  "keyword": "Quando "
});
formatter.match({
  "location": "ShoppingAutomationSteps.java:97"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "aparece uma mensagem de busca inválida",
  "keyword": "Entao "
});
formatter.match({
  "location": "ShoppingAutomationSteps.java:104"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});