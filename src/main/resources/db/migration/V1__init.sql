create table categories
(
    id         bigserial primary key,
    title      varchar(255) unique,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table products
(
    id          bigserial primary key,
    title       varchar(255),
    category_id bigint references categories (id),
    price       int,
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);

insert into categories (title)
values ('Food'),
       ('Others');

insert into products (title, price, category_id)
values ('Milk', 80, 1),
       ('Bread', 25, 1),
       ('Cheese', 300, 1);

create table users
(
    id       bigserial primary key,
    username varchar(36)  not null,
    password varchar(80)  not null,
    address  varchar(255) not null,
    phone    varchar(255) not null,
    email    varchar(255) not null
);

create table roles
(
    id   bigserial primary key,
    name varchar(50) not null
);

create table users_roles
(
    user_id bigint not null references users (id),
    role_id bigint not null references roles (id),
    primary key (user_id, role_id)
);

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into users (username, password, address, phone, email)
values ('bob', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i',
        'проспект Дзержинского д.8 кв.205', '8-927-345-24-98', 'bob12@mail.ru'),
       ('john', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'улица Энгельса д.15 кв.94',
        '8-967-456-09-23', 'john45@mail.ru');

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2);

create table orders
(
    id          bigserial primary key,
    user_id     bigint       not null references users (id),
    total_price int          not null,
    address     varchar(255) not null,
    phone       varchar(255) not null,
    email       varchar(255) not null,
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);

create table order_items
(
    id                bigserial primary key,
    product_id        bigint not null references products (id),
    order_id          bigint not null references orders (id),
    quantity          int    not null,
    price_per_product int    not null,
    price             int    not null,
    created_at        timestamp default current_timestamp,
    updated_at        timestamp default current_timestamp
);