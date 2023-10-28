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
<h3>DTO</h3>
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

<h2>Cómo Levantar la API con TSL: </h2>
<h4> 1. Adquiere un certificado SSL/TLS válido emitido por una autoridad de certificación (CA) reconocida. Esto es esencial para habilitar una conexión segura. Alternativamente, puedes utilizar un certificado autofirmado con herramientas como OpenSSL para fines de desarrollo y pruebas, aunque no se recomienda para producción. </h4>
<h4> 2. Asegúrate de tener un servidor web o de aplicación configurado y en funcionamiento. Para nuestro caso utilizaremos Node.js </h4>
<h4> 3. Crea un archivo JavaScript para configurar y levantar tu servidor Node.js: </h4>
<p style="background:grey;"> const https = require('https');
<p style="background:grey;">const fs = require('fs');

<p style="background:grey;">const options = {
<p style="background:grey;">    key: fs.readFileSync('ruta/al/archivo/clave-privada.key'), // Ruta a tu clave privada
<p style="background:grey;">    cert: fs.readFileSync('ruta/al/archivo/certificado.crt')    // Ruta a tu certificado
};

<p style="background:grey;">const server = https.createServer(options, (req, res) => {
<p style="background:grey;">    res.writeHead(200);
<p style="background:grey;">    res.end('¡Hola, mundo seguro con TLS!\n');
<p style="background:grey;">});

<p style="background:grey;">const port = 443; // Puerto seguro por defecto

<p style="background:grey;">server.listen(port, () => {
<p style="background:grey;">    console.log(`Servidor Node.js con TLS escuchando en el puerto ${port}`);
<p style="background:grey;">});

<h4>4. Guardamos el archivo de configuración y los ejecutamos con Node.js con el comando "node nombre-del-archivo.js" y escuchará un puerto seguro (Generalmente 443) </h4>
<h4> </h4>
<h4>5. Prueba la API ya sea a traves de Postman o del navegador para rectificar que no hayan problemas </h4>