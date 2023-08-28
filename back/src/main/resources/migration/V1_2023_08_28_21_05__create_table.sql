create table if not exists student
(
    id         int auto_increment,
    first_name varchar(255) null,
    last_name  varchar(255) null,
    grade      int          null,
    constraint student_id_uindex
        unique (id)
);

