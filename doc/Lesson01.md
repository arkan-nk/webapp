Практика Java. Разработка Web приложения.
===============================

## Проект: https://github.com/JavaWebinar/webapp

## Урок 1

### 1. ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFWUxzYlQtQlA5ZkU">Настройка проекта</a>
- <a href="https://github.com/JavaOPs/topjava/wiki/Git">Git Wiki</a> (актуально все кроме патчей, на этом проекте пока без них)
- <a href="https://github.com/JavaOPs/topjava/wiki/IDEA">Idea Wiki</a> (поставить кодировку UTF-8, поменять фонт по умолчанию на DejaVu)

  - git занести в переменная окружения PATH, перезапустить cmd
  - Клонировать к себе локально наш проект `git clone https://github.com/JavaWebinar/webapp.git`
  - `git remote -v`
  - `git remote set-url origin https://github.com/JavaWebinar/webapp.git` - настройка pull
  - `git remote set-url --push origin https://github.com/YouGitHub/YourRepo.git` - настройка push
  - `git push -u origin master`

### 2. ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVFJuR2tBZVVXT00">Приложение "Hello Webapp". Debug. Выполнение домашнего задания в ветке HW1</a>
- <a href="http://info.javarush.ru/idea_help/2014/01/22/Руководство-пользователя-IntelliJ-IDEA-Отладчик-.html">Отладчик IntelliJ IDEA</a>
- <a href="http://jeeconf.com/archive/jeeconf-2013/materials/intellij-idea/">Эффективная работа с кодом в IntelliJ IDEA</a>

### 3. ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFTUstMUo4QldKWGM">Принципы ООП. Объекты и классы Java</a>
  - <a href="http://www.intuit.ru/studies/courses/16/16/lecture/27107">Основы объектно-ориентированного программирования</a>
- ООП. Объектная модель. Класс. Объект. Состояние, поведение, индивидуальность (<a href="http://www1.fcenter.ru/forprint.shtml?online/articles/software/interview/7963">Гради Буч</a>).
- <a href="http://www.intuit.ru/studies/courses/16/16/lecture/27107?page=3">Инкапсуляция. Наследование. Полиморфизм. Класс, объект, поля, методы.</a>
- <a href="https://ru.wikipedia.org/wiki/Диаграмма_классов#.D0.92.D0.B7.D0.B0.D0.B8.D0.BC.D0.BE.D1.81.D0.B2.D1.8F.D0.B7.D0.B8">Типы отношений между классами: наследование, агрегация, композиция, ассоциация.</a>
- <a href="http://citforum.ru/programming/oop_rsis/glava2_1_10.shtml">Множественное наследование. Делегирование.</a>
- Дополнительно:
  - <a href="https://www.youtube.com/watch?v=G6LJkWwZGuc">Николай Алименков — Парадигмы ООП</a>
  - <a href="http://devcolibri.com/720">Что такое ООП и с чем его едят?</a>
  - <a href="http://ru.wikipedia.org/wiki/Объектно-ориентированное_программирование">Объектно ориентированное программирование</a>
  - <a href="http://htmlpreview.github.io/?https://raw.githubusercontent.com/blacky0x0/java-docs-ru/master/tutorials/java/concepts/index.html">Концепции объектно-ориентированного программирования</a>

-----------------------

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Домашнее задание HW01
Прочитать <a href="http://www.intuit.ru/studies/courses/16/16/lecture/27113?page=4">Соглашения по именованию.</a>

#### Сделать объектную модель резюме (диаграмма и классы).

  - Образец резюме (делаем упрощенно): http://gkislin.ru/ru/cv_ru.html.
Делать только классы, включаемые в Resume, c полями и без методов.
Некоторые из объектов схожи по структуре и функциональности: сделать для них один класс.
Модель упрощаем для хранения только необходимой информации для вывода/ редактирования резюме.
Resume - главный класс. В него все включается (композиция - строгий вид агрегации).

  - В модели резюме должны быть представлены контакты и следующие разделы:

    - OBJECTIVE("Позиция")
    - ACHIEVEMENT("Достижения")
    - QUALIFICATIONS("Квалификация")
    - EXPERIENCE("Опыт работы")
    - EDUCATION("Образование")

    В секциях Достижения и Квалификация хранить данные так, чтобы можно было выводить их одним списком.

  - Учесть в классах модели, что обработка резюме (вывод в html, сохранение, чтение) будет сделано следующим образом:
обработка специальных полей (`fullName` нарпимер), цикл обработки по контактам, цикл обработки по секциям (т.е. использовать полиморфизм, как для фигур круг, квадрат..). При добавлении/удалении новых видов контактов (например домашний телефон) или разделов изменения в коде (и БД) должны быть минимальны.

  - Список всех резюме будет выводится с email (или например телефоном) его владельца: должна быть возможность просто достать из модели резюме контакт заданного типа.

  - Учесть, что на одной работе (в одном учебном заведении)
можно работать/ учиться в разные периоды и при этом имя организации не дублируется.

#### Инструменты для рисования:

- <a href="http://stackoverflow.com/questions/8942751/use-intellij-to-generate-class-diagram#26926334">Generate class diagram in IntelliJ IDEA</a> (<a href="https://www.jetbrains.com/help/idea/2016.1/working-with-diagrams.html?origin=old_help">Help: working with Diagrams</a>)
- Нарисовать и сфотографировать
- <a href="http://www.draw.io">Online: www.draw.io</a>
- <a href="https://www.yworks.com/">yEd - Graph Editor</a>
