drop table if exists login;

create table login (
    login_name varchar(255) primary key,
    password varchar(255),
    append varchar(255)
)ENGINE = InnoDB;

insert into login(login_name, password, append) values
    ('user1', '123456', '1111'),
    ('user2', '123456', '2222');
