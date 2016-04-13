Практика Java. Разработка Web приложения.
===============================

## Проект: https://github.com/JavaWebinar/webapp

## Урок 5
### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFcDBpWjZDdVVoVHM">Контейнеры/коллекции.</a>
  - <a href="http://en.wikipedia.org/wiki/Java_collections_framework">Java Сollections Framework.</a>
  - <a href="http://www.intuit.ru/studies/courses/16/16/lecture/27131?page=2">List, Set, Map, Queue, Iterator, ListIterator</a>
  - Устаревшие thread-safe реализации Hashtable, Vector, Stack
  - <a href="http://habrahabr.ru/users/tarzan82/topics/">Структуры данных в картинках</a>
  - <a href="http://info.javarush.ru/tag/Collection/">Часто-задаваемые-на-собеседованиях-вопросы-по-классам-коллекций.</a>
  - <a href="http://appliedjava.wordpress.com/2010/09/23/java-collections-framework/">Коллекции Java (Java Collections Framework)</a>
  - Посмотреть реализацию Map. <a href="http://habrahabr.ru/post/162017/">Проверить себя по статье</a>

### 2. Разбор HW4.

### 3. Логгирование
  - Логирование. <a href="http://habrahabr.ru/post/130195/">Настройка логирования</a>
  - <a href="http://habrahabr.ru/post/113145/">Java Logging: история кошмара (Optional)</a>
  - <a href="http://skipy.ru/useful/logging.html">Ведение лога приложения (Optional)</a>

### 4. Вложенные, внутренние, локальные и анонимные классы.
  - <a href="http://easy-code.ru/lesson/java-nested-classes">Вложенные и внутренние классы</a>. Примеры в Collections API: Arrays.asList, Map.Entry, LinkedList.Node, Collections, Iterator
  - <a href="http://easy-code.ru/lesson/local-anonymous-nested-classes-java">Локальные и анонимные классы.</a> Comparator.

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png)  5. <a href="http://www.youtube.com/watch?v=_PDIVhEs6TM">Доступно о Java 8 Lambda</a>

### ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Домашнее задание HW5
    Зарефакторить хранение секций и контактов на основе Map.
    Выделить общий класс AbstractStorage и реализовать подклассы ListStorage и MapStorage 
                                                                 (выбор реализации List и Map за вами).
    Сделать Position внутрениим/вложенным классом. Проверить его созадние через new
