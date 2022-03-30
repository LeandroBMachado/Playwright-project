# language: pt
# charset: UTF-8
# Supported severity values: blocker, critical, normal, minor, trivial. ex.: @severity=critical
# Every Feature or Scenario can be annotated by following tags: @flaky, @muted, @known

  @AmazonTest
  Funcionalidade: Menu Amazon

    Cenario: Selecionar primeiro resultado de pesquisa
      Dado que eu esteja na pagina da Amazon
      Quando selecionar a aba todos
      E exibir o menu
      E selecionar o item "Mais Vendidos"
      Entao selecionar o primeiro item
      E visualizar a pagina do item e o mesmo valor
