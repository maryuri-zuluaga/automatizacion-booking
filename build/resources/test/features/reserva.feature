Feature:  Hacer reserva de hotel en booking

  Scenario Outline: Reserva exitosa de hotel
    Given El usuario entra en la pagina principal de booking
    When El usuario ingresara los datos de filtro para el hotel <ciudad>
    And El usuario selecciona el hotel mas barato
    Then EL usuario visualizara una pantalla de confirmacion de reserva
    Examples:
      | ciudad    |
      | cartagena |