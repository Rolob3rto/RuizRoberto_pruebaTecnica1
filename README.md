# Prueba Técnica

Este proyecto es una aplicación de consola para realizar el mantenimiento de empleados. LLeva a cabo operaciones básicas como crear, listar, modificar y eliminar empleados.

## Configuración

1. **Clonar el Repositorio**

2. **Importar el Proyecto:**

   Importa el proyecto en tu IDE favorito.

3. **Configurar la Conexión a la Base de Datos:**

   Configura la conexión a la base de datos en `persistence.xml`:

   ```xml
   <!-- Configuración de la unidad de persistencia -->
   <persistence-unit name="empleadoJpaPU" transaction-type="RESOURCE_LOCAL">
       <!-- ... -->
       <properties>
           <!-- Configuración de la conexión a la base de datos -->
           <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
           <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/empleados" />
           <property name="javax.persistence.jdbc.user" value="root" />
           <property name="javax.persistence.jdbc.password" value="" />
           <!-- ... -->
       </properties>
   </persistence-unit>
4. **Importar datos sql:**

   Importa los datos pasados en al carpeta resources.

   ## Uso

La aplicación presenta un menú interactivo que te realiza las siguientes operaciones:

- **Crear Empleado:** Permite ingresar los datos de un nuevo empleado.
- **Listar Empleados:** Muestra una lista de todos los empleados registrados.
- **Modificar Empleado:** Permite modificar los datos de un empleado existente.
- **Eliminar Empleado:** Elimina un empleado según su ID.
- **Salir:** Finaliza la aplicación.

Sigue las instrucciones en la consola para interactuar con la aplicación.
