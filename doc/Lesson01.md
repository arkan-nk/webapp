Практика Java. Разработка Web приложения.
===============================

## Проект: https://github.com/JavaWebinar/webapp

## Урок 1

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFWUxzYlQtQlA5ZkU">Настройка проекта</a>
- <a href="https://github.com/JavaOPs/topjava/wiki/Git">Git Wiki</a> (актуально все кроме патчей, на этом проекте пока без них)
- <a href="https://github.com/JavaOPs/topjava/wiki/IDEA">Idea Wiki</a> (поставить кодировку UTF-8, поменять фонт по умолчанию на DejaVu)

  1. git занести в переменная окружения PATH, перезапустить cmd
  2. Клонировать к себе локально наш проект `git clone https://github.com/JavaWebinar/webapp.git`
  3. `git remote -v`
  4. `git remote set-url origin https://github.com/JavaWebinar/webapp.git` - настройка pull
  5. `git remote set-url --push origin https://github.com/YouGitHub/YourRepo.git` - настройка push
  6. `git push -u origin master`

### Сегодня выложу остальные видео

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Домашнее задание HW01

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
обработка уникальных полей, цикл обработки по контактам, цикл обработки по секциям. При добавлении/удалении новых видов контактов или разделов изменения в коде (и БД) должны быть минимальны.

  - Список всех резюме будет выводится с email (или например телефоном) его владельца: должна быть возможность просто достать из модели резюме контакт заданного типа.

  - Учесть, что на одной работе (в одном учебном заведении)
можно работать/ учиться в разные периоды и при этом имя организации не дублируется.

#### Инструменты для рисования:

- <a href="http://stackoverflow.com/questions/8942751/use-intellij-to-generate-class-diagram#26926334">Generate class diagram in IntelliJ IDEA</a> (<a href="https://www.jetbrains.com/help/idea/2016.1/working-with-diagrams.html?origin=old_help">Help: working with Diagrams</a>)
- Нарисовать и сфотографировать
- <a href="http://www.draw.io">Online: www.draw.io</a>
- <a href="https://www.yworks.com/">yEd - Graph Editor</a>
