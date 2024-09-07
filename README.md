Spring boot приложение работы с SQL представлением аккаунтов клиентов, сделано сразу с прицелом на расширение функционала (TO DO функция кэшбека, функция авторизации клиентом и аккаунтов с ограниченным функционалом).
bank-service-operations-api/bank-service-operations-api/src/main/java/com/example/bankserviceoperationsapi - по этому пути реализация REST API, в том числе с элементами Spring security. Архитектура состоит из слоёв:
Entity (сущности с полями, аналогичные представлениям в БД); 
Service, реализующий связь со слоем Repository;
Repository, по сути просто под-интерфейсы JpaRepository;
Controller, описывающий маппинг запросов.
