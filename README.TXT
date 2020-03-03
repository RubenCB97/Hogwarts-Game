----------------------------------------------------------------------------
The objective of this project is to create a simulation based on the Harry 
Potter's fantasy novels saga.
It simulates a duel competition between Hogwarts castle's houses (initially
Gryffindor, Slytherin and Hufflepuff). Each house has different characters
that belong to those houses and will compete against each other until there
is a winner or the simulation comes to an end (turn limit: 10 initially).

(La información que se muestra a continuación hemos optado por expresarla
en castellano para que sea lo más clara posible.)

Requisitos extra:
    - Pruebas unitarias con JUnit en todas las clases menos en las princi-
      pales: Hogwarts, InitData y HogwartsDemo.
    - Aplicación del patrón estrategia para la representación de la clase
      Wand y sus diferentes comportamientos (WandBehavior), y aplicación
      del patrón decorador para la representación de la clase Potion y de
      sus dos tipos: InvigorarioPotion y FelixFelicisPotion.
    - Uso de comparadores para ordenar los personajes pertenecientes a las
      distintas casas (clase House) y para ordenar las varitas de la simu-
      lación (clase Hogwarts).
    - Uso de iteradores en la clase Hogwarts.
    - Uso de la excepción FileNotFoundException en la clase HogwartsDemo.

En el enunciado del proyecto se especifica que los personajes de cada
casa se ordenarán, en caso de empate en el orden inicial, alfabéticamente 
por su nombre en orden creciente.
En los ficheros de salida que se proporcionan junto al enunciado de la
práctica, los personajes pertenecientes a la casa 'Slytherin' no cumplen 
este requisito, ya que aparecen ordenados, en caso de empate en el orden 
inicial, alfabéticamente por su nombre en orden decreciente. Esto es lo que
ocurre si a la hora de ordenar los personajes de la casa 'Slytherin' se 
utiliza el mismo comparador que para ordenar los personajes de la casa
'Hufflepuff' pero invirtiendo el orden.
Por esta razón es por la que, en un principio y sin haber consultado los
ficheros de salida, decidimos crear un comparador distinto para ordenar los
personajes de la casa 'Slytherin' (ReverseOffensiveComparator), en vez de 
invertir el orden del que habíamos utilizado en la casa 'Hufflepuff'.
Dicho esto, hemos optado por respetar el contenido de los ficheros de sali-
da que se nos han proporcionado para facilitar la detección de errores y la
corrección del código, y también por mantener la clase que contiene el có-
digo correspondiente al comparador mencionado anteriormente aunque no se 
utilice.

Modificaciones respecto a la primera entrega:
    - Se ha modificado el método checkWhoWon de la clase Hogwarts. Ahora de-
      bería resolver los empates correctamente.
    - Se han modificado los métodos checkNumberOfMembers, checkHouseMostEnergy,
      checkHouseOffensiveDefensive de la clase House. Ahora deberían resolver
      los empates de manera correcta y más eficientemente.
    - Uno de los métodos searchHouseCharacter ahora está implementado en la 
      clase House, donde debería haber estado desde el principio.
    - Se han añadido pruebas a la clase Hogwarts.
------------------------------------------------------------------------------

PROJECT TITLE: The Potter's Challenge.
MAIN CLASS: HogwartsDemo
VERSION or DATE: 10/01/2020
GROUP NAME: The Order of the Phoenix.
AUTHORS: Jorge Cancho Casado, Rubén Costa Barriga and Arturo Mejías Velasco.
