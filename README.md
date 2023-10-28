# RecursosHumanos

<h6> Luisa Fernanda Niño Ardila / Camilo Navarro Ortiz / Andres Felipe Bonilla Avila </h6>

<h4> http://localhost:8080/swagger-ui/index.html# </h4>
<h3>Requisitos/build.gradle.kts</h3>
<h4>JDK: 17</h4>
<h4>Java version 17</h4>
<h4>Pluggin Jacoco:Necesario para la realizacion del reporte coverage </h4>
<h3>Logica</h3>
<h4>PerfilEmpleadoLogica y CertificadoLogica: permite la lectura la informacion de los empleados, busca estos datos en la BD (necesarios para el
funcionamiento de PerfilEmpleadoController y CertificadoCoontroller respectivamente)</h4>
<h4>EmpleadoLogica: crear, actualizar y eliminar empleados</h4>
<h3>dto</h3>
<h4>PerfilEmpleadoController y CertificadoCoontroller: permite la lectura la informacion de los empleados mediante postman o el navvegador web</h4>
<h4>EmpleadoController: recolecta los datos (de postman, navegador web, etc) para realizar la gestion de la BD de los empleados (Crear,Actualizar,Eliminar y Consultar)</h4>
<h3>Config</h3>
<h4>SwaggerConfig:ayuda a la automatizacion de la documentacion</h4>
<h3>Build</h3>
<h3>Reports</h3>
<h4>Jacoco: archivo html que muestra los datos del coverage</h4>
<h3>test</h3>
<h4>Donde se almacenan las pruebas unitarias y de integridad para comprobar el funcionamiento del Api y calcular el coverage</h4>
<h3>.github/workflow</h3>
<h4>CI.yml: Automatizacion de los procesos para el Continuos Integration (Github actions)</h4>
