Практика Java. Разработка Web приложения.
===============================

## Проект: https://github.com/JavaWebinar/webapp

## Урок 6

### 1. Разбор HW5.

### 2. Параметризация. Стирание типов.
 - <a href="http://developer.alexanderklimov.ru/android/java/generic.php">Обобщения (Generic)</a>
 - <a href="http://www.quizful.net/post/java-generics-tutorial">Дженерики (Java, обучающая статья)</a>
 - <a href="http://docs.oracle.com/javase/tutorial/java/generics/restrictions.html">Ограничения.</a>
 - <a href="http://stackoverflow.com/questions/4073359/understanding-java-generics-type-parameter-conventions">Understanding Java generics</a>

### Работа с патчами:
- Обновите проект (Ctrl+T). Ваша ветка master должна быть в том же состоянии, как и <a href="https://github.com/JavaWebinar/webapp/commits/master">master нашего проекта</a>
- Скачайте патчи по ссылкам ниже с Goodle Drive (можно в каталог проекта, но не добавляетй его в git)
- В Projects на патче в контекстном меню выберите `Apply Patch...`

![applypatch](https://cloud.githubusercontent.com/assets/13649199/14580016/415982d4-03c8-11e6-9085-27a8dd9aaa09.png)

- изменения в проекте после патча можно увидеть в `Version Control -> Local Changes, Ctrl+D`

![localchanges](https://cloud.githubusercontent.com/assets/13649199/14580039/643807fc-03c9-11e6-83da-e29c98fdfc20.png)

- Закомитьте изменения и переходите к следующему патчу
- После накатки всех патчей сделайте push

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 3. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFbVFyc1N1OXZKSFE">Работа с файлами. Ввод/вывод.</a>
> В проекте есть небольшие отличия от видео, например поле резюме `about` и исключение `ResumeStorageException` вместо `WebAppException`

#### Патч <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFcV9kdFlqY0N2Q0E">1_MainFiles.patch</a>
 - <a href="http://www.intuit.ru/studies/courses/16/16/lecture/27133">Пакет java.io</a>
 - <a href="http://ru.wikipedia.org/wiki/Декоратор_(шаблон_проектирования)">Паттерн Декоратор</a>.
 - Дополнительно:
   - <a href="https://habrahabr.ru/post/269667/">Эволюция Java на примере чтения строк из файла</a>
   - <a href="https://habrahabr.ru/company/luxoft/blog/278233/">Оптимальный путь преобразования InputStream в строку</a>

#### Патч <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFekZOb0hyaUgwVDQ">2_FileStorage.patch</a>

 - Реализация FileStore (хранение в файлах).
 - <a href="http://www.intuit.ru/studies/courses/16/16/lecture/27133?page=4">Ввод-вывод.</a> Реализация Store используя DataInputStream/DataOutputStream.

### ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Домашнее задание HW5
    Закончить реализацию DataStreamFileStorage (все методы и сохранение-чтение секций)
    Выделить из DataStreamFileStorage общий класс AbstractFileStorage
    Протестировать все полученные реализации.

Optional:

    Реализовать PathStorage через java.nio.file.Path.
    Сделать возможным выбор меджу FileStorage и PathStorage для сериализации через DataStream.

  - <a href="http://www.quizful.net/post/java-nio-tutorial">NIO Java 7</a>