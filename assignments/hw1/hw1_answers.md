Ejercicio 1:

¿Cuál es la complejidad de inicializar los valores de un arreglo?

- el loop

Ejercicio 2:

¿cuál es la complejidad de determinar si un valor está presente en el arreglo?

- recorrer el arreglo

- identificar el elemento a través de una comparación

Ejercicio 3:

(b)  ¿Por qué en la línea 6 del método tenemos que observar si numArray\[i\] == −1?

Porque una de nuestras condiciones es que un array compacto, lo cual implicaría que si es una localidad vacía llegamos al index donde ya no hay más valores, lo que es igual de bueno para insertar un nuevo valor.

(c)  De acuerdo con nuestro código, ¿cuál es la complejidad de insertar un elemento en un arreglo ordenado?

- Compactar Array

- Problemas anteriores más recorrido

- Descubrir si tiene espacio y si no duplicar el tamaño del Array

- Encontrar dónde insertar el nuevo elemento

- recorrer los siguientes elementos

Ejercicio 4:

(a) De acuerdo con tu código, ¿cuál es la complejidad de eliminar un elemento dentro de un arreglo ordenado?

- encontrar al elemento,

- eliminarlo

- recorrer los valores

- sin que hayan espacios vacíos

- encontrando por lo tanto el siguiente valor no vacío

Ejercicio 5:

¿Cuál es la ventaja de hacerlo de esta manera (con una constante para definir una locación vacía igual a -1)?

Se mantiene más control sobre el código, además de que es más mantenible

Ejercicio 6:

¿Cuál es la complejidad de verificar si una palabra es un palíndromo?

- Verificar las posiciones y los caracteres

Preguntas

1.  Explica con tus palabras qué es una estructura de datos. Tengo dos ideas al respecto. Una, es como si definiéramos como van a ser nuestras entidades primitivas (int, float… etc.), pero la verdad no me parece muy cierta. Más bien creo que es cómo creamos una nueva entidad derivada de estas, y definimos cómo interactúa y se comporta frente a otros datos.
2.  ¿Qué ventajas encuentras en usar arreglos? ¿Qué desventajas? Son fáciles de mapear, los conozco bien (aunque creo que más bien son listas las que conozco). Son estáticos.
3.  ¿Por qué decimos que los arreglos son de acceso aleatorio? Porque cuentan con un index que permite localizar una ubicación de ellos de manera exacta y son guardados en la memoria de manera consecutiva, asegurando la ubicación exacta de sus componentes, lo que hace que puedas acceder en cualquier momento a ellos (de manera aleatoria)…
4.  ¿A qué se refiere el que un arreglo sea una estructura de datos estática? A que tiene un tamaño específico definido y no lo puedes hacer crecer.
5.  ¿Cómo se reservan las localidades de memoria en la computadora al inicializar un arreglo? Con un 0, y de manera consecutiva.
6.  Supongamos que declaramos un arreglo de elementos de tipo long de la siguiente manera:
7.  public static long \[\] numbers = new long \[57\];
8.  ¿Cuántos bytes de memoria se reservan para dicho arreglo? Ni idea… o 57 o 57\*4???
