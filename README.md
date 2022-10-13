# GuessNumber

Autor:Daniel Casado Carvajal<br>
Fecha de Finalización del proyecto:12/10/2022<br>
App que se compone de 3 Activitys: la primera para configurar el juego(ConfigActivity), la segunda para jugar al juego(PlayActivity y finalmente la tercera con el resultado final(EndPlayActivity)<br>
Versión API:31<br>
Minimun SDK:26<br>
<h3>Contenido del ejercicio:</h3><br>
Este ejercicio cuentra con 3 Activity.<br>
La primera(ConfigActivity) se pide al usuario un nombre y el numero de intentos para jugar, estos se almacenaran en una clase Juego el numero de intentos debe cumplir el requisito de ser mayor que cero.
y ningun campo puede estar vacio.<br> Si al pulsar el boton se cumplen estos requisitos se pasa a la siguiente activity.<br>
<br>
La segunda(PlayActivity) se pide al usuario el numero para jugar y se actua en consecuencia. Esta activity cuenta con dos botones, uno para borrar los campos introducidos
y otro para comprobar si el numero es correcto o no.<br>
<br>
La tercera(EndPlayActivity) muestra el resultado del juego una vez este ha concluido.<br>

<h1>ConfigActivity</h1>
Es la primera pantalla que se ejecutará al lanzar la Aplicación.</br> En ella se nos pedira nuestro nombre de usuario y el numero de intentos con el que queremos jugar.
<br>
<h1>PlayActivity</h1>
Es la pantalla que realmente gestiona nuestro juego.</br> En ella se pide al usuario introducir el numero que cree que es el correcto y se actua segun el caso:<br>
<ol>
<li> El numero es menor: Se informa al usuario que el numero que se busca es menor que el introducido y se le consume un intento para poder jugar.</li>
<li> El numero es mayor: Se informa al usuario que el numero que se busca es mayor que el introducido y se le consume un intento para poder jugar.</li>
<li> Acierto: El numero introducido por el usuario es el correcto y gana el juego</li>
</ol>
<br>
<h1>EndPlayActivity</h1>
Es la pantalla final de nuestro juego, en la cual se informa al usuario lo que ha ocurrido segun el caso, el juego finaliza de las siguientes maneras:
<ol>
<li> El usuario gana: Se informa al usuario de que ha ganado y el numero de intentos que ha consumido para ello.</li>
<li> El usuario pierde: Se informa al usuario de que ha perdido y se muetra el numero que era el correcto</li>

</ol>
Documentacion utilizada

https://moronlu18.com/wordpress/
