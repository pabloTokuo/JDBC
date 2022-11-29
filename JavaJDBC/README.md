# JDBC
Checklist: <br>
Usando o MySQL Workbench, crie uma base de dados chamada "coursejdbc"<br>
Baixar o MySQL Java Connector<br>
Caso ainda não exista, criar uma User Library contendo o arquivo .jar do driver do MySQL<br>
Window -> Preferences -> Java -> Build path -> User Libraries<br>
Dê o nome da User Library de MySQLConnector<br>
Add external JARs -> (localize o arquivo jar)<br>
Criar um novo Java Project<br>
o Acrescentar a User Library MySQLConnector ao projeto<br>
Na pasta raiz do projeto, criar um arquivo "db.properties" contendo os dados de conexão:<br>
user=developer<br>
password=1234567<br>
dburl=jdbc:mysql://localhost:3306/coursejdbc<br>
useSSL=false<br>
No pacote "db", criar uma exceção personalizada DbException<br>
No pacote "db", criar uma classe DB com métodos estáticos auxiliares<br>
Obter e fechar uma conexão com o banco<br>