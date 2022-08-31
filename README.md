Тестовое задание aikamsoft
======================

Написать консольную версию endpoint.

Используемые инструменты
------
Maven
Spring 5
Lombok
JUnit 5
Hibernate
PostgreSQL
Docker

Структура проекта
======================

\migrate - содержит файлы sql для простого теста
\migrate-pgadmin - содержит файл db для монтирования при запуске pgAdmin. Добавлена БД в список Серверов.
\test-data - содержит входные тестовые данный в формате json

Запуск проекта
======================
Сборка выполняется с использованием Maven. Все команды выполнять в корневой папке проекта. Используется Eclipse Temurin
1.8.0_345.

Очистить проект
---------------
`mvn clean`

Внимание! Удаляются также папки для Docker

Собрать проект
--------------
`mvn package`

Для удобства запуска собираются два артефакта. Один jar-файл будет содержать все зависимости сторонних библиотек, второй
только классы и ресурсы проекта.   
Артефакты сборки можно найти в папке \target:

* \target\aikamsoft-test-1.0-jar-with-dependencies.jar
* \target\aikamsoft-test-1.0.jar

## Запуск

Внимание! Предварительно запустить БД в докере (см ниже).

Рекомендуется запускать aikamsoft-test-1.0-jar-with-dependencies.jar из корневой папки:

`java -jar target\aikamsoft-test-1.0-jar-with-dependencies.jar search test-data\input-search.json output-search.json`<br/>
`java -jar target\aikamsoft-test-1.0-jar-with-dependencies.jar stat test-data\input-search.json output-stat.json`<br/>

Запуск PostgreSQL и pgAdmin в Docker
======================
Для удобства работы DB работает в контейнере. При создании контейнера автоматически выполняются файлы из папок \migrate*.  

Запуск контейнеров
--------------------

`docker-compose up`

При запуске будет развернуто два контейнера:

* PostgreSQL<br/>

  POSTGRES_DB: aikam<br/>
  POSTGRES_USER: user<br/>
  POSTGRES_PASSWORD: pgpwd<br/>
  localhost:5432<br/>
  <br/>
* pgAdmin:<br/>

  PostgreSQL DB host: host.docker.internal<br/>
  master password: pgadmin (или pgpwd)<br/>
  http://localhost:5050/browser/  <br/>

Остановка и удаление контейнеров
-------------------------------
`docker-compose down`

