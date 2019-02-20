<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyCRUD</title>
</head>
<body>
<div style="text-align: center;">
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <h3>Описание</h3>
    <br/>
    <a href="<c:url value="/task"/>" target="_blank">Войти</a>
    <br/>
    Требуется разработать сервис, предоставляющий следующее REST API
    1. POST /task
     Без параметров
     Создает запись в БД (любой) c сгенерированным GUID, текущим временем и
    статусом “created”
     Возвращает клиенту код 202 и GUID задачи
    Обновляет в БД для данного GUID текущее время и меняет статус на “running”
     Ждет 2 минуты
     Обновляет в БД для данного GUID текущее время и меняет статус на
    “finished”
    2. GET /task/{id}
     Параметр id: GUID созданной задачи
     Возвращает код 200 и статус запрошенной задачи:

    {
    "status" : "статус", //Один из: "created","running","finished"
    "timestamp": "Время смены статуса" // Дата и время в формате ISO 8601
    }

    Возвращает 404, если такой задачи нет
    Возвращает 400, если передан не GUID

</div>
</body>
</html>
