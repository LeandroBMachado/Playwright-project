# language: pt
# charset: UTF-8
# Supported severity values: blocker, critical, normal, minor, trivial. ex.: @severity=critical
# Every Feature or Scenario can be annotated by following tags: @flaky, @muted, @known

@login
@Plan_Id=1
@Des_Suite_Id=4
@Qa_Suite_Id=4
@Hom_Suite_Id=4
Funcionalidade: Teste de validação Web - Login
  Eu como cliente gostaria de acessar o sistema via login somente com credenciais validas

  @Positivo
  @Test_Id=6
  Cenario: CT001 - Login - Executar login com dados validos
    Dado eu estou na pagina de login
    Quando eu efetuar o login com "credenciais validas"
    Entao sera apresentado a tela do menu principal

  @Negativo
  @Test_Id=7
  Cenario:  CT002 - Login - Executar login com invalido
    Dado eu estou na pagina de login
    Quando eu efetuar o login com "credenciais invalidas"
    Entao sera apresentado uma mensagem de erro

