
## Autor:
### Sergio Andrés Otero Herrera

# Taller 6 AREP:
En este taller se hizo uso de docker para crear imagenes y diferentes contenedores en la nube. En este caso se uso AWS. Se creo un balanceador de carga tipo RoundRobin, diferentes instancias de un amisma API creada con Spark, las cuales fueron conectadas a una misma base de datos de MongoDB. con el objetivo de que el usuario realice la consulta a nuestra api de forma rapida  y eficiente.

![image](https://user-images.githubusercontent.com/98189066/224490598-ff3774c4-5df4-4af9-87fa-658a4e1071cb.png)

## Prerrequisitos
- GIT
- AWS
- JAVA
- MVN

## Instalación
De querer usar este codigo de forma local, se tiene que hacer lo siguiente:

Se clona el repositorio

```
git clone https://github.com/Sergi0tero/AREP_Taller6.git
```

Ahora, si queremos verificar la integridad del codigo

```
mvn package
```
```
mvn clean install
```
Corremos el codigo:
```
java -cp target/classes RoundRobin
```
**Si se quiere probar de forma local, se debe cambiar las IPs en las clases ```Main``` y ```RoundRobin``` a localhost**

Para probar la instancia de AWS, la cual debe estar corriendo, se hace la consulta al siguiente URL: 
http://ec2-54-90-253-130.compute-1.amazonaws.com:4567/logs.html

## Diseño
El proyecto fue realizado en Java. El ciclo de vida empieza por el usuario, quien utiliza la pagina inicial con la ruta /logs.html. En esta pagina inical el usuaro puede crear y consultar los logs dados, se le presentan solo 10. Esto por detras busca en una base de datos de MondoDB usando Spark.

## Modular
Estas son las diferentes capaz que podemos ver:
- RoundRobin
- AWS
- MongoDB
- LogerServices

## Pruebas y proceso
Despues de crear las clases y verificar el funcionamiento local del codigo, empezamos creando las instancias:
![image](https://user-images.githubusercontent.com/98189066/224490139-a21993ae-4de6-445a-b50f-640d0142c183.png)
![image](https://user-images.githubusercontent.com/98189066/224490165-caf69db2-7fcc-477f-a308-adb4fc85a17d.png)
![image](https://user-images.githubusercontent.com/98189066/224490167-008e9112-c81e-470c-b9f4-558df8042d89.png)
![image](https://user-images.githubusercontent.com/98189066/224490175-dcf7e287-9d35-4197-a0fa-230a67757425.png)
![image](https://user-images.githubusercontent.com/98189066/224490182-fa1d3037-3bc0-4b8d-8834-a17055e90404.png)
![image](https://user-images.githubusercontent.com/98189066/224490188-6b6f0586-b456-4f9a-87e3-00b8df29af82.png)

Una vez hecho esto, intalamos java en cada instancia (Exceptuando la de Mongod, aca instalamos mongod e iniciamos una nueva base de datos); subimos el archivo local target comprimido como zip a cada maquina usando el protocolo SFTP (nuevamente exceptuando Mongo). Descomprimimos este archivo en cada instancia y corremos en una instancia el RoundRobin, en las otras 3 corremos el Main usando el siguiente comando:

java -cp "target/classes:target/dependency/*" <Main o RoundRobin>

![image](https://user-images.githubusercontent.com/98189066/224490460-50334409-b138-4dfc-aff9-95b9cf4916ce.png)

Luego se realizo esta prueba para verificar el correcto funcionamiento individual de cada instancia de LogService (clase Main):
![image](https://user-images.githubusercontent.com/98189066/224490518-3f72b8fe-9600-42ab-8caa-f904e909d03c.png)

Por ultimo, se hizo la prueba con el HTML y JS creados en un principio, esto llama directamente a la clase RoundRobin:
![image](https://user-images.githubusercontent.com/98189066/224490561-1e91ceef-52f4-40c2-86ed-e2c92b886552.png)

## Version
1.0
