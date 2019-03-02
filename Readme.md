
 REST API
 Java 8 (Сoncurrent,Time API,Lambda),
 Maven,
 Spring MVC,
 Hibernate,
 Tomcat,
 Mysql,
 Postgres.
 Heroku.

Описание задачи:
Требуется разработать сервис, предоставляющий следующее REST API
1. POST /task
Без параметров
Создает запись в БД (любой) c сгенерированным GUID, текущим временем и
статусом “created”
Возвращает клиенту код 202 и GUID задачи 
Обновляет в БД для данного GUID текущее время и меняет статус на “running”
Ждет 2 минуты
Обновляет в БД для данного GUID текущее время и меняет статус на
“finished”
2. GET /task/{id}
Параметр id: GUID созданной задачи
Возвращает код 200 и статус запрошенной задачи:

{
"status" : "статус", //Один из: "created","running","finished"
"timestamp": "Время смены статуса" // Дата и время в формате ISO 8601
}

Возвращает 404, если такой задачи нет
Возвращает 400, если передан не GUID

Проверка приложения:
На Heroku: https://restlogdate.herokuapp.com

или

Добавление задачи и полученние guid:
curl -X POST -v https://restlogdate.herokuapp.com/task/
 или через браузер: 
data:text/html,&lt;form action="https://restlogdate.herokuapp.com/task" method="post"&gt;&lt;input type="submit"&gt;&lt;/form&gt;

Просмотр статуса задачи по guid:
curl -v https://restlogdate.herokuapp.com/task/{guid}
или через браузер:
https://restlogdate.herokuapp.com/task/{guid}

например: 
запрашиваем не существующий task :
curl -v https://restlogdate.herokuapp.com/task/88
или через браузер https://restlogdate.herokuapp.com/task/88
ответ : NO SUCH task: 88

запрашиваем существующий task :
https://restlogdate.herokuapp.com/task/77777
или через браузер https://restlogdate.herokuapp.com/task/77777
ответ : Task GUID = 77777 dateTime = 2019-02-20T15:11:01 Status = created 

При компиляции локально:

Запуск осуществляеться с помомощью вебсервера Tomcat, при конфигурации не указывать дополнительный путь, только /

Для запуска с MySql необходимо: создать базу test, юзера user c паролем Password1! , выполнить скрипт createDBMySql.sql в созданную базу, а затем добавление данных addData.sql

Для запуска с Postgres необходимо: закоментировать настройки mysql в config, раскоментировать настройки c Postgres,
создать базу restlogdate, юзера user c паролем password , выполнить скрипт createDB_Postgress_hsqldb.sql в созданную базу, а затем добавление данных addData.sql

Добавление задачи и полученние guid:
curl -X POST -v http://localhost:8080/task/
или через браузер: 
data:text/html,&lt;form action="http://localhost:8080/task" method="post"&gt;&lt;input type="submit"&gt;&lt;/form&gt;

Просмотр статуса задачи по guid:
curl -v http://localhost:8080/task/{guid}
или через браузер:
http://localhost:8080/task/{guid}

например: 
запрашиваем не существующий task :
curl -v http://localhost:8080/task/88
или через браузер http://localhost:8080/task/88
ответ : NO SUCH task: 88

запрашиваем существующий task :
http://localhost:8080/task/77777
или через браузер http://localhost:8080/task/77777
ответ : Task GUID = 77777 dateTime = 2019-02-20T15:11:01 Status = created 

