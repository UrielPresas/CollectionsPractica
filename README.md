He repartit el codi en 3 directoris, un Model on estan totes els objectes que la practica requereix (aliments, electronica, textil, carro...). 
Despres tinc el controller on faig totes les funcions per fer que el programa funcioni, trucant als getter i setters del directori "Models".
Per ultim tinc la vista on es mostra el menu i on es truca a totes les funcions del controlador.
A la vista en on tinc el main perque s'hem fa mes comodè d'aquesta forma. 

Per comprovar si un objecte es repetit amb ajuda del codi de barres he utilitzat una HashMap per tindre la clau i els valors. El que faig es quan he afegt l'objecte, 
reviso si aquest te un codi de barres igual que algun objecte ja introduit al map. Aixó ho faig amb la clau del hashMap que es el codi de barres
i si es cert afegeixo una unitat mes al objecte que te aquella clau.

Els metodes toString estan fets en general a les clases producte i producteCarro i a les clases especifiques tenen tambe el metode toString amb el seu metode especific
aixi quan es truca al toString de un aliment per exemple agafara el toString de productes (super) + la data de caducitat...
