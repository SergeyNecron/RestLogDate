<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>RestLogDate</title>
</head>
<body>
<pre>
        <h1>                                  REST API </h1>
<h2>                                            Java 8 (Сoncurrent,Time API,Lambda),
                                            Maven 3.39,
                                            Spring MVC 4.0.3,
                                            Hibernate 4.3.5,
                                            Tomcat 8.5.9,
                                            Mysql 5.1.36,
                                            Postgres 42.2.1.
</h2>
        <div style="text-align: center;"> <form action="http://localhost:8080/task" method="post"><input
                value="Отправить Post запрос" type="submit"></form>
        Далее для получениея статуса введите полученный guid строку браузера, после task: <a
                    href="http://localhost:8080/task/77777">http://localhost:8080/task/77777</a></div>

<span style="font-size: large; color: black; font-family: Arial; ">
   <b> Описание приложения:</b>
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
    Возвращает 400, если передан не GUI
    </span>
    </pre>
</body>
</html>
