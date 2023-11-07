Feature: Verificar las credenciales y navegar a diferentes páginas en el sitio web saucedemo
  Background: Configuracion del navegador
    Given Estoy en la página de inicio de sesion
  Scenario Outline: Llegar a la pagina de inventario desde la pagina de inicio de sesion
    When Ingreso <username> y password secret_sauce
    And Hago clic en el boton de inicio de sesion
    Then Ingresare a la pagina de inventario
    Examples:
      | username |
      |"standard_user" |
      |"problem_user" |
      |"performance_glitch_user"|
#  Scenario: Permanecer en la pagina de inicio de sesion como resultado de username incorrecto
#    When Inserto un username invalido y un password valido
#    And Hago clic en el boton de inicio de sesion
#    Then Me quedare en la pagina de inicio de sesion
#  Scenario: Permanecer en la pagina de inicio de sesion como resultado de password incorrecto
#    When Inserto un username valido y un password invalido
#    And Hago clic en el boton de inicio de sesion
#    Then Me quedare en la pagina de inicio de sesion