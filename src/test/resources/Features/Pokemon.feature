@PokemonAPI
Feature: API Pokémon
  Como un usuario de la API de Pokémon
  Quiero interactuar con los Pokémon usando métodos GET, POST, PUT y DELETE
  Para poder gestionar datos de Pokémon

  @GET1
  Scenario: Obtener la lista de todos los Pokémon exitosamente
    Given el actor establece el endpoint GET para obtener los Pokémon
    When el actor envía una solicitud HTTP GET
    Then el código de respuesta HTTP debería ser 200

  @POST1
  Scenario Outline: Crea un Pokémon exitosamente
    Given el actor establece el endpoint POST para crear un Pokémon
    When el actor envía una solicitud HTTP POST con "<name>" "<url>"
    Then el código de respuesta HTTP debería ser 404

    Examples:
      | name         | url                   |
      | bulbasaur    | https://pokeapi.co/api/v2/   |
      | charmander   | https://pokeapi.co/api/v2/   |

  @PUT1
  Scenario Outline: No actualiza un Pokémon exitosamente
    Given el actor establece el endpoint PUT para actualizar un Pokémon
    When el actor envía una solicitud HTTP PUT con "<id>" "<name>" "<url>"
    Then el código de respuesta HTTP debería ser 404

    Examples:
      | id | name      | url                   |
      | 1  | pikachu   | https://pokeapi.co/api/v2/    |
      | 2  | eevee     | https://pokeapi.co/api/v2/    |

  @DELETE1
  Scenario Outline: No Elimina un Pokémon exitosamente
    Given el actor establece el endpoint DELETE para eliminar un Pokémon
    When el actor envía una solicitud HTTP DELETE con "<id>"
    Then el código de respuesta HTTP debería ser 404

    Examples:
      | id |
      | 1  |
      | 2  |
