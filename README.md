# GalaxyWeather
Respuesta al ejercicio de predicción del clima de tres civilizaciones: Vulcanos, Ferengis y Betasoides

## Enunciado
En una galaxia lejana, existen tres civilizaciones. Vulcanos, Ferengis y Betasoides. Cada
civilización vive en paz en su respectivo planeta.
Dominan la predicción del clima mediante un complejo sistema informático.
A continuación el diagrama del sistema solar.

Premisas:

	● El planeta Ferengi se desplaza con una velocidad angular de 1 grados/día en sentido horario. Su distancia con respecto al sol es de 500Km.

	● El planeta Betasoide se desplaza con una velocidad angular de 3 grados/día en sentido horario. Su distancia con respecto al sol es de 2000Km.

	● El planeta Vulcano se desplaza con una velocidad angular de 5 grados/día en sentido anti­horario, su distancia con respecto al sol es de 1000Km.

	● Todas las órbitas son circulares.

Cuando los tres planetas están alineados entre sí y a su vez alineados con respecto al sol, el
sistema solar experimenta un período de sequía.

Cuando los tres planetas no están alineados, forman entre sí un triángulo. Es sabido que en el
momento en el que el sol se encuentra dentro del triángulo, el sistema solar experimenta un
período de lluvia, teniendo éste, un pico de intensidad cuando el perímetro del triángulo está en
su máximo.

Las condiciones óptimas de presión y temperatura se dan cuando los tres planetas están
alineados entre sí pero no están alineados con el sol.

Realizar un programa informático para poder predecir en los próximos 10 años:
1. ¿Cuántos períodos de sequía habrá?
2. ¿Cuántos períodos de lluvia habrá y qué día será el pico máximo de lluvia?
3. ¿Cuántos períodos de condiciones óptimas de presión y temperatura habrá?

Bonus:

Para poder utilizar el sistema como un servicio a las otras civilizaciones, los Vulcanos requieren
tener una base de datos con las condiciones meteorológicas de todos los días y brindar una API
REST de consulta sobre las condiciones de un día en particular.

1) Generar un modelo de datos con las condiciones de todos los días hasta 10 años en adelante
utilizando un job para calcularlas.
2) Generar una API REST la cual devuelve en formato JSON la condición climática del día
consultado.
3) Hostear el modelo de datos y la API REST en un cloud computing libre (como APP Engine o
Cloudfoudry) y enviar la URL para consulta:
Ej: GET → http://….../clima?dia=566 → Respuesta: {“dia”:566, “clima”:”lluvia”}

## Aclaraciones

Se optó por realizar una aplicación Java para el programa informático, el cual se encuentra en la carpeta JavaApplication. Mientras que para el Bonus se utilizó un proyecto Spring y se encuentra en la carpeta Bonus.

## Tecnologías

- Java
- Spring
- Hibernate
- JUnit 5

## Suposiciones
	- El primer día es el día 0.
	- No existen años biciestos. Todos los años tienen 365 días.
	- Los planetas son un punto en el espacio. Se despreció el radio/diámetro que puedan tener éstos. Así mismo ocurrió con el Sol.
	- El punto de inicio de los planetas es el eje Y (en un plano cartesiano sus coordenadas de inicio serían (0, distancia al sol)).
	- El código está en inglés. Por lo que los climas de los días son:
		- RAINY
		- MAX_RAINY
		- DROUGHT
		- OPTIMUM_TEMP_AND_PRESSURE
	- Se asumió que para los días en los cuales no se cumplen las condiciones del enunciado, no hay información suficiente para determinarlos por lo que su clima es: UNKNOWN.

## Funcionamiento

Para hacer funcionar el programa (JavaApplication), importar el proyecto a un IDE o correrlo con la terminal compilando con el comando 'javac' y luego corriendo con 'java'. 

Para ver el funcionamiento del Bonus, ver la sección [API](https://github.com/AgusHorn/GalaxyWeather#api)

## API

Para el Bonus, se creó la siguiente API:

1. Para saber el clima de un día específico tenemos:

https://galaxy-weather-meli.herokuapp.com/clima?dia=0

En vez de un 0, se le puede pasar cualquier día desde el 0 hasta 3649.

2. Para saber los días con cierto clima:

https://galaxy-weather-meli.herokuapp.com/clima/weather?weather=DROUGHT

El último parámetro pasado puede ser cualquiera de los siguintes valores:
	- DROUGHT
	- RAINY
	- MAXIMUM_RAINY
	- OPTIMUM_TEMP_AND_PRESSURE
	- UNKNOWN

3. Para saber todos los días con sus respectivos climas:

https://galaxy-weather-meli.herokuapp.com/clima/allDays


## Respuestas a las preguntas

Realizar un programa informático para poder predecir en los próximos 10 años:
> 1. ¿Cuántos períodos de sequía habrá?
_Cantidad de días de Sequía 21_

> 2. ¿Cuántos períodos de lluvia habrá y qué día será el pico máximo de lluvia?
_Cantidad de días de Lluvia 806 y de pico máximo de lluvia 40_

> 3. ¿Cuántos períodos de condiciones óptimas de presión y temperatura habrá?
_Cantidad de días de Optimas Condiciones 20_

Se puede apreciar cada uno de los días con su respectivo clima en la consola tanto del IDE o la terminal una vez ejecutado el programa.


