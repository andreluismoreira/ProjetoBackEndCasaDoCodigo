create table products.product (
    id bigserial primary key,
    productIdentifier varchar not null,
    nome varchar(100) not null,
    descricao varchar(100) not null,
    preco float not null,
    category_id bigint REFERENCES products.category(id)
);