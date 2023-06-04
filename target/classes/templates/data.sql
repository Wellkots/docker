INSERT INTO users3 (id, `age`, `name`, `username`, `password`, `email`)
VALUES
(1, 25, 'admin', 'admin', '$2a$12$994Fd5ZwG2Z8nGtdK3sklOMT2HctcAhsVQe6W1G8DXwfrUDsvD03G', 'admin@mail.ru'),
(2, 26, 'user', 'user', '$2a$12$994Fd5ZwG2Z8nGtdK3sklOMT2HctcAhsVQe6W1G8DXwfrUDsvD03G', 'user@mail.ru');

/*пароль root*/

INSERT INTO roles3 (id, name)
VALUES
(1,'ROLE_ADMIN'),
(2,'ROLE_USER');

insert into users_roles
values
(1, 1),
(2, 2);
