
## Autor:
### Sergio Andrés Otero Herrera

# Taller 3 AREP:
En este taller se hizo uso de docker para crear imagenes y diferentes contenedores en la nube. En este caso se uso AWS. Se creo un balanceador de carga tipo RoundRobin, diferentes instancias de un amisma API creada con Spark, las cuales fueron conectadas a una misma base de datos de MongoDB. con el objetivo de que el usuario realice la consulta a nuestra api de forma rapida  y eficiente.

![image](https://user-images.githubusercontent.com/98189066/224153010-9c7cb7eb-2c74-40ba-9ecd-aedc1c669c92.png)


## Prerrequisitos
- GIT
- JAVA
- MVN

## Instalación
De querer usar este codigo, se tiene que hacer lo siguiente:

Se clona el repositorio

```
git clone https://github.com/Sergi0tero/AREP_Taller5.git
```

Ahora, si queremos verificar la integridad del codigo

```
mvn package
```
## Correr el código
Para correr la clase main, la cual se encuentra en FirstApp.java, corremos los siguientes comando en la terminal:
```
mvn compile
```
```
mvn exec:java
```
o
```
java -cp target/classes RoundRobin
```

## Diseño
El proyecto fue realizado en Java. El ciclo de vida empieza por el usuario, quien, usando las opciones dadas en el inicio, elige el archivo que desee. Continua con el servidor redirecciona dependiendo del servicio elegido.
Este servicio lee el archivo seleccionado en una direccion especificada. Llama a nuestra nueva clase Spark, la cual utiliza una funcion lambda anteriormente creada para saber que peticion HTTP esta haciendo el usuario (Actualmente implementadas estan el GET y el POST, se recomienda POSTMAN para usar el POST). Si no, realiza las consultas a los nuevos componentes creados

## Patrones
- Singleton

## Modular
Estas son las diferentes capaz que podemos ver:
- Spark
- Docker
- MongoDB
- LogerServices

## Pruebas
![image](https://user-images.githubusercontent.com/98189066/224149980-83d7e0ff-a496-4b9b-b3e2-0de18bf7cde6.png)
![image](https://user-images.githubusercontent.com/98189066/224150051-af734c39-ea0a-417d-b00a-81be6608a498.png)


## Version
1.0
