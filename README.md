Un metodo de ordenamiento es ESTABLE si cuando hay elementos con el mismo valor de comparacion
  (en este caso el mismo nombre), estos mantienen el orden relativo que tenian en la lista original.
 
  Por ejemplo, Carlos(25) aparece antes que Maria(25) en la lista original.
  Un algoritmo estable garantiza que Carlos siempre aparecera antes que Maria en el resultado.
 
  - Bubble Sort:    ESTABLE - solo intercambia elementos adyacentes cuando uno es estrictamente mayor,
                    por lo que elementos iguales nunca se intercambian entre si.
 
  - Insertion Sort: ESTABLE - inserta cada elemento en su posicion correcta sin mover los elementos
                    que ya tienen el mismo valor, preservando el orden original.
 
  - Selection Sort: NO ESTABLE - al intercambiar el minimo con la posicion actual, puede saltar
                    por encima de elementos iguales y cambiar su orden relativo.
                    Ejemplo: lista [3a, 3b, 1] -> selecciona 1, lo intercambia con 3a -> [1, 3b, 3a]
                    Ahora 3b aparece antes que 3a, el orden original se perdio.
 
