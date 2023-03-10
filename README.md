
## Autor:
### Sergio Andrés Otero Herrera

# Taller 5 AREP:
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
java -cp target/classes RoundRobin
```
**Si se quiere probar de forma local, se debe cambiar las IPs en las clases ```Main``` y ```RoundRobin``` a localhost**

## Diseño
El proyecto fue realizado en Java. El ciclo de vida empieza por el usuario, quien utiliza la pagina inicial con la ruta /logs.html. En esta pagina inical el usuaro puede crear y consultar los logs dados, se le presentan solo 10. Esto por detras busca en una base de datos de MondoDB usando Spark.

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
![image](https://user-images.githubusercontent.com/98189066/224179616-694e0692-b539-42c2-8a5e-c04dd9500b7f.png)
![image](https://user-images.githubusercontent.com/98189066/224208446-88db633c-8522-475e-9478-a85ee2838ed5.png)
![image](https://user-images.githubusercontent.com/98189066/224208785-d5a62279-eda9-4ef1-8953-f34e9f6aa5bf.png)
![image](https://user-images.githubusercontent.com/98189066/224208853-de29cd94-3ce2-497e-ae0f-e7faee888072.png)


## Version
1.0
