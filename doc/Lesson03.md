Практика Java. Разработка Web приложения.
===============================

## Проект: https://github.com/JavaWebinar/webapp

## Урок 3

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFRkM0SEFMS0s1MGc">Разбор HW2. Enum. equals/hashCode/toString</a>
- <a href="http://easy-code.ru/lesson/enum-types-java">Enum</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 2. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFalpNMC1HZ3JvT0U">Работа со строками.</a>
  - <a href="http://easy-code.ru/lesson/java-string">Строки в Java</a>. Кодировка. <a href="https://ru.wikipedia.org/wiki/UTF-8">UTF-8</a> vs <a href="https://ru.wikipedia.org/wiki/UTF-16">UTF-16</a>
  - <a href="http://easy-code.ru/lesson/manipulating-characters-string-java">Управление строками, функции для работы со строками в Java.</a>
  - <a href="http://java67.blogspot.ru/2014/08/difference-between-string-literal-and-new-String-object-Java.html">String literal pool</a>
  - <a href="https://dzone.com/articles/changes-stringsubstring-java-7">Changes to String.substring in Java 7</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 3. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFQVV0VDQtcHNTQXM">Массивы</a>.
  - <a href="http://www.intuit.ru/studies/courses/16/16/lecture/27121">Массивы.</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 4. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFcElqUmtpTWtUS28">valueOf, StringBuilder</a>
  - <a href="http://www.intuit.ru/studies/courses/16/16/lecture/27129?page=2">Классы-обертки</a>
  - <a href="http://habrahabr.ru/post/132241/">Маленькие хитрости Java</a>: valueOf, StringBuilder vs StringBuffer

### ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 5. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFaU41d0FiSW5XMVk">DAO. Домашнее задание HW03</a>
-  <a href="https://ru.wikipedia.org/wiki/Data_Access_Object">Data Access Object</a>. Интерфейс для хранения резюме.

  - Добавить в резюме `OrganizationSection` (в `MainArrayStorage`)
  - Реализовать `Storage` на основе массива (`ArrayStorageImpl` в проекте)
  - Сделать несколько вызовов `Storage` из `MainArrayStorage`

### Optional: оценить <a href="https://drive.google.com/file/d/0B9Ye2auQ_NsFNEJWRFJkVDA3TkU">Time complexity</a> реализации.
  - Сделать реализацию `SortedArrayStorageImpl` с time complexity: O(log N)
    -  <a href="https://drive.google.com/file/d/0B9Ye2auQ_NsFNEJWRFJkVDA3TkU/view">Time complexity</a>
    -  <a href="https://ru.wikipedia.org/wiki/Временная_сложность_алгоритма">Временная сложность алгоритма</a>
    -  <a href="https://ru.wikipedia.org/wiki/Вычислительная_сложность">Вычислительная сложность</a>