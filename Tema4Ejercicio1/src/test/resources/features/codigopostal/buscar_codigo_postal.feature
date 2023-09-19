Feature: Buscando codigos postales
  Scenario Outline: Buscar ubicaciones de Ciudades por Codigo Postal
    When Busco un codigo postal <Codigo Postal> para el codigo de pais <Codigo Pais>
    Then la ubicacion deberia ser <Ubicacion> en <Pais>
    Examples:
      | Codigo Postal | Codigo Pais | Pais | Ubicacion |
      | 10000 | US | United States | New York City |
      | 90210 | US | United States | Beverly Hills |
      | 13001 | FR | France | Marseille 01 |