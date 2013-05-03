# Introduction to Agile Development
Кирилл Корняков  
Май 2013

# Содержание
  * Agile сегодня
  * История и предпосылки возникновения
  * Методологии разработки ПО
  * Общая характеристика Agile

# Современное состояние
  * Огромная масса небольших и средних проектов выполняется согласно гибким методологиям.
  * В крупных компаниях:
    - Intel (XP, Scrum)
    - Microsoft (Agile MSF)
    - Google (Scrum)
    - IBM
  * Имеются успешные опыты внедрения гибких методологий в крупных и распределенных проектах (British Telecoms).
  * Отдельные практики гибких методологий проникли во все другие методологии.

# Adoption Rate of Agile Technique
Copyright 2008 Scott W. Ambler <www.ambysoft.com/surveys/>

![](./images/adoption_rate_of_agile_techniques.png)

# How Have Agile Approaches Affected the Quality of Systems Deployed?
Copyright 2008 Scott W. Ambler <www.ambysoft.com/surveys/>

![](./images/how_have_agile_approaches_affected_the_quality_of_systems_deployed.png)

# Предпосылки и история
  * Первый кризис программирования
    - Стоимость ПО обгоняет стоимость аппаратуры
    - Рождение программной инженерии, направленной на сокращение стоимости ПО
  * Продолжение кризиса

![](./images/crisis.png)

# Предпосылки и история
  * Сложность разработки ПО:
    - Сложность решаемых задач
    - Техническая сложность разработки
    - Сложность организации процесса разработки
  * Поиски серебряной пули. Фредерик Брукс _"Мифический человеко-месяц"_, 1975

# Предпосылки и история
  * Технологические способы решения:
    - Модульное программирование
    - Структурное программирование
    - ООП
    - Паттерны
    - Более совершенные языки и технологии
    - Инструментальная поддержка разработки (CASE)

# Методология разработки
  * Нетехнологические способы решения:
    - Практики
    - Методологии разработки ПО

**Методология разработки** – описание того, как в целом организована разработка ПО.  
Включает дисциплины:

+------------------------+------------------------------+
| * управление проектами | * написание кода             |
| * анализ требований    | * интеграция и тестирование  |
| * проектирование       | * контроль качества          |
+------------------------+------------------------------+

# Методологии разработки
Проекты отличаются по масштабам, бюджету, срокам, сложности и критичности.  
Нет методологии, подходящей сразу для всех проектов.

  * MSF - Microsoft Solution Framework
  * RUP - Rational Unified Process

Agile

  * eXtreme Programming
  * Scrum
  * Lean software development (Kanban)
  * Agile MSF, Agile RUP

# Agile Methodologies
  * [Scrum](http://en.wikipedia.org/wiki/Scrum_(development))
  * [Extreme Programming (XP)](http://en.wikipedia.org/wiki/Extreme_Programming)
  * [Kanban (development)](http://en.wikipedia.org/wiki/Kanban_(development))
  * [Lean software development](http://en.wikipedia.org/wiki/Lean_software_development)
  * Crystal Clear
  * Agile Unified Process (AUP)
  * Essential Unified Process (EssUP)
  * Open Unified Process (OpenUP)
  * Dynamic Systems Development Method (DSDM)
  * Feature Driven Development (FDD)
  * GSD
  * Velocity tracking

# Agile Methodology Most Closely Followed
![](./images/agile_methodology_most_closely_followed.png)

# Каскадная модель
![](./images/cascad.png)

  * Каждая фаза начинается после завершения предыдущей
  * Каждая фаза полностью документируется
  * Основа модели – сформулированные требования (ТЗ)
  * Критерий качества – соответствие ТЗ

# Стоимость внесения изменений
![](./images/cost_of_change.png)

# Итеративная модель
![](./images/msf.png)

# Ниша Agile
_"Экстремальное программирование — это упрощенная методика организации производства для небольших и
средних по размеру команд специалистов, занимающихся разработкой программного продукта в условиях
неясных или быстро меняющихся требований."_  

Кент Бек

# Стоимость внесения изменений
![](./images/cost_of_change_vs_time.png)

Agile позволяет контролировать стоимость внесения изменений.

# Гибкие методологии
* Особенность гибких (agile) методологий – ориентация на **адаптивность** вместо предсказуемости.

Agile Manifesto (2001)

+--------------------------------+------+---------------------------------+
| * Individuals and interactions | over | * Processes and tools           |
| * Working software             |      | * Comprehensive documentation   |
| * Customer collaboration       |      | * Contract negotiation          |
| * Responding to change         |      | * Following a plan              |
+--------------------------------+------+---------------------------------+

That is, while there is value in the items on the right, we value the items on the left more.

# Major Principles of Agile Software

  * Working software is the primary measure of progress.
  * Simplicity – the art of maximizing the amount of work not done.
  * The most efficient and effective method of conveying information to and within a development
    team is face-to-face conversation.
  * The best architectures, requirements, and designs emerge from self-organizing teams.
  * At regular intervals, the team reflects on how to become more effective, then tunes and adjusts
    its behavior accordingly.

# 4 переменные
![](./images/3comp.png)

Заказчик определяет значения только двух переменных, величину третьей определяет команда разработчиков.

# 4 переменные
![SCOPE + ](./images/3comp.png)

  * Первые три переменные фиксируются.
  * Scope – число функций системы.
  * Scope корректируется с учетом обстоятельств.
  * Самое важное в первую очередь!

# Основные черты
  * Итеративный процесс
    - 2-4 недели
    - на выходе каждой итерации – рабочий продукт
    - минимум необходимого
        - Планирования
        - Проектирования
        - Документации

# Основные черты
  * Команды разработчиков
    - самостоятельно организуют свою работу
    - располагаются в общем открытом офисе
    - ежедневные stand-up meeting
    - тесная связь с заказчиком

# Основные черты
  * Отношение к документам
    - личное общение предпочитается письменным документам
        - общение с заказчиком
        - общение внутри команды
    - документация либо не пишется совсем, либо необходимый минимум

# Сравнение основ
+------------------------------------+--------------------------------------+
| Гибкие методики                    | Методики с четким планированием      |
|                                    |                                      |
|   - Частая смена требований        |   - Требования фиксированы           |
|   - Небольшое число разработчиков  |   - Большое количество разработчиков |
|   - Небольшие и средние проекты    |   - Крупные проекты                  |
+------------------------------------+--------------------------------------+

  * Препятствия для внедрения гибких методик:
    - Большие команды разработчиков (более 20)
    - Распределенные команды разработчиков
    - Культура управления в компании

# Спасибо за внимание!
  * Вопросы?
