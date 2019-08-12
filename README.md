Procedimento para instalação:

Apartir do path raiz do projeto

- Copiar o conteúdo da pasta docker para /tmp
- Copiar o war do projeto para a pasta /tmp/click-bus/app com o seguinte nome: click-bus-place-0.0.1-SNAPSHOT.war
- Acesse a pasta /tmp/click-bus/app com o comando cd /tmp/click-bus/app
- Execute o seguinte comando docker-compose build e aguarde até o fim da construção do container
- Acesse a pasta /tmp/click-bus/up
- Execute o seguinte comando docker-compose up -d e espere alguns instantes para dar tempo da API iniciar

Para verificar as API disponível acesse via navegador o swagger através da URI: http://<hostname>:8051/swagger-ui.html
