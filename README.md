# Hibernate_Muchos_a_Muchos 
Proyecto de la Materia Orientacion a Objetos II - Universidad Nacional de Lanus - UNLa.
Persistencia de Objetos a Base de Datos utilizando especificacion ORM (Object Relational Mapping)
## Detalles
### **hibernate.cfg.xml**
se ubica dentro de carpeta src (para no tener que indicar su ubicacion en la definicion de la clase HibernateUtil  
- en en el archivo de configuracion de conexion a la dataBase se utiliza esta version del driver MySQL:  
`<property name="connection.driver_class">`**com.mysql.cj.jdbc.Driver**`</property>`
### Clase HibernateUtil ###
metodo **getSessionFactory**
	- declaracion StandardServiceRegistry. Metodo configure toma el archivo de  
	configuracion por defecto (hibernate.cfg.xml) de la localizacion  
	de recursos estandar (standard resource location)  
	`StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
						.configure()`
