# Java-школа
## Домашнее задание №4

В рамках одной транзакции произвести комплексное обновление связанных таблиц (обновление двух таблиц)

Скачать и установить базу данных на выбор: postgresql , mysql, oracle.
Создать несколько таблиц (любых), так, что бы между ними было хотя бы отношение «один ко многим» или «многие ко многим»
Написать программу, которая будет подключаться к базе данных и производить чтение-запись(в методе main, например, сделать сохранение, обновление, чтение и удаление). 
В рамках одной транзакции произвести комплексное обновление связанных таблиц (обновление двух таблиц)
Для каждой таблицы должна существовать Entity в вашей программе.
Подключение к бд осуществить через Hibernate
Конфигурацию подключения вынести в конфигурационный файл, в java коде не хранить конфигурацию.
Использовать свойство ddl.auto update для автоматического обновления схемы бд.

## Описание
Описание БД и таблицы содержится в db/db.sql

## Результат выполнения программы
```
=== Users ===
models.User {id = 1, name = John, age = 24}
models.User {id = 2, name = Nick, age = 45}

update = models.Device {id = 4, type = Phone, model = New Model, user_id = 2}

=== Devices ===
models.Device {id = 1, type = Laptop, model = Asus, user_id = 1}
models.Device {id = 2, type = Laptop, model = Dell, user_id = 2}
models.Device {id = 3, type = Phone, model = Xiaomi, user_id = 1}
models.Device {id = 4, type = Phone, model = New Model, user_id = 2}

save = models.User {id = 3, name = Steve, age = 16}

=== Users ===
models.User {id = 1, name = John, age = 24}
models.User {id = 2, name = Nick, age = 45}
models.User {id = 3, name = Steve, age = 16}

=== Devices ===
models.Device {id = 1, type = Laptop, model = Asus, user_id = 1}
models.Device {id = 2, type = Laptop, model = Dell, user_id = 2}
models.Device {id = 3, type = Phone, model = Xiaomi, user_id = 1}
models.Device {id = 4, type = Phone, model = New Model, user_id = 2}
models.Device {id = 5, type = Mouse, model = Asus, user_id = 3}
models.Device {id = 6, type = Keyboard, model = Razor, user_id = 3}

delete = models.User {id = 1, name = John, age = 24}

=== Users ===
models.User {id = 2, name = Nick, age = 45}
models.User {id = 3, name = Steve, age = 16}

=== Devices ===
models.Device {id = 2, type = Laptop, model = Dell, user_id = 2}
models.Device {id = 4, type = Phone, model = New Model, user_id = 2}
models.Device {id = 5, type = Mouse, model = Asus, user_id = 3}
models.Device {id = 6, type = Keyboard, model = Razor, user_id = 3}
```
