Практика Java. Разработка Web приложения.
===============================
## Урок 1

- Знакомство с Adobe Meeting
- IDEA: Version Control, toolbar, интеграция с git, UTF-8, plugins, password для git
- Настройка проекта:
  1. git занести в переменная окружения PATH, перезапустить cmd
  2. git clone https://github.com/JavaWebinar/webapp.git (где лежит .git)
  3. git remote -v
  4. git remote set-url origin https://github.com/JavaWebinar/webapp.git - для pull
  5. git remote set-url --push origin https://github.com/YouGitHub/YourRepo.git - для push
  6. git push -u origin master

- Первое приложение Hello World. Пакеты, импорт пакетов. Commit (commit+push,comments), debug

- Выполнение ДЗ в ветке: HW1
    New Branch
    Code convention
    Commit + push (master-> origin/master, hw1-> origin/hw1)
    Checkout master


### 1. ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFUFI0dGh4QjA5U0k" target="_blank">Обзор проекта</a>

### 2. ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFQ3FLZFFyTXhPUUk" target="_blank">Литература</a>

<a href="http://javawebinar.ru/books.html">Рекомендуемые книги по Java и разработке ПО</a>

### 3. ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) <a href="https://www.youtube.com/watch?v=zhPH8Vnidw8">Системы управления версиями. Git.</a>

<a href="http://ru.wikipedia.org/wiki/Система_управления_версиями">Система управления версиями</a>. <a
                    href="http://ru.wikipedia.org/wiki/%D0%A1%D0%B8%D1%81%D1%82%D0%B5%D0%BC%D0%B0_%D1%83%D0%BF%D1%80%D0%B0%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D1%8F_%D0%B2%D0%B5%D1%80%D1%81%D0%B8%D1%8F%D0%BC%D0%B8#.D0.A0.D0.B0.D1.81.D0.BF.D1.80.D0.B5.D0.B4.D0.B5.D0.BB.D1.91.D0.BD.D0.BD.D1.8B.D0.B5_.D1.81.D0.B8.D1.81.D1.82.D0.B5.D0.BC.D1.8B_.D1.83.D0.BF.D1.80.D0.B0.D0.B2.D0.BB.D0.B5.D0.BD.D0.B8.D1.8F_.D0.B2.D0.B5.D1.80.D1.81.D0.B8.D1.8F.D0.BC.D0.B8">VCS/DVSC</a>.

- Справичник (читать все НЕ надо, использовать как справочник)
  -  <a href="https://try.github.io/levels/1/challenges/1">Интерактивная Git обучалка</a>
  -  <a href="http://githowto.com/ru">Основы Git</a>
  -  <a href="https://www.youtube.com/playlist?list=PLIU76b8Cjem5B3sufBJ_KFTpKkMEvaTQR">Видео по обучению Git</a>
  -  <a href="http://habrahabr.ru/post/125799/">Как начать работать с GitHub: быстрый старт</a>
  -  <a href="http://ndpsoftware.com/git-cheatsheet.html">Справочник в графическом виде</a>
  -  <a href="https://blog.interlinked.org/tutorials/git.html">Git Overview</a>
  -  <a href="http://geekbrains.ru/gitstart">Видеокурс по Git</a>

### 4. ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) <a href="http://www.youtube.com/watch?v=stYj2RhjvQ8" target="_blank">Видео по установке ПО (Java, Git, IntelliJ IDEA)</a>

**Внимание: клонировать проект нужно из https://github.com/JavaWebinar/webapp**

     git clone https://github.com/JavaWebinar/webapp.git
     
- **<a href="http://javawebinar.ru/#/soft">Ссылка на используемое на вебинаре ПО</a>**

### 5. ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFeGtUTDNUdVZaQ3M" target="_blank">Обзор языка Java</a>

- <a href="http://zeroturnaround.com/rebellabs/java-tools-and-technologies-landscape-for-2014/">Обзор популярности инструментов и технологий Java за 2014 г.</a>
- <a href="http://ru.wikipedia.org/wiki/Java">Java</a>, <a href="http://ru.wikipedia.org/wiki/Виртуальная_машина_Java">JVM</a>, <a href="http://ru.wikipedia.org/wiki/JIT">JIT-компиляция</a>
- <a href="http://ru.wikipedia.org/wiki/Java_Platform,_Micro_Edition">ME</a>, <a href="http://en.wikipedia.org/wiki/Java_Platform,_Standard_Edition">SE</a> (<a href="http://ru.wikipedia.org/wiki/Java_Platform,_Standard_Edition">русский</a>), <a href="http://en.wikipedia.org/wiki/Java_Platform,_Enterprise_Edition">EE (<a href="http://ru.wikipedia.org/wiki/Java_Platform,_Enterprise_Edition">русский</a>)</a>
- <a href="http://docs.oracle.com/javase/8/docs/index.html">Oracle Java8 Home</a>
- <a href="http://www.tiobe.com/index.php/content/paperinfo/tpci/index.html">Programming languages TIOBE Index</a>

-  Дополнительно:
  - <a href="http://www.intuit.ru/studies/courses/16/16/lecture/27105">Что такое Java? История создания</a>
  - <a href="http://ggenikus.github.io/blog/2014/05/04/gc/">Понимаем основы Java garbage collection</a>
  - <a href="http://www.youtube.com/watch?v=iGRfyhE02lA&list=PLjvY25uoBsUp_V9PnDap_R8g-9vY5hSWF">Владимир Иванов: Garbage Collectors</a>

### Ресурсы для подготовки
-  <a href="http://www.intuit.ru/studies/courses/16/16/info">Интуит. Программирование на Java</a>
-  <a href="https://www.codecademy.com/learn/learn-sql">Learn SQL</a>
-  <a href="http://campus.codeschool.com/courses/try-sql/contents">Try SQL</a>
-  <a href="http://www.intuit.ru/studies/courses/1102/134/info">Основы работы с HTML</a>
-  <a href="http://jeeconf.com/materials/intellij-idea/">Эффективная работа с кодом в IntelliJ IDEA</a>
