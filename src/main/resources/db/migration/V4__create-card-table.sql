CREATE TABLE IF NOT EXISTS cards
(
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    uid varchar(255) not null,
    pan  varchar(16) not null,
    balance INTEGER,
    account_id INT not null,
    CONSTRAINT fk_account foreign key(account_id) references accounts(ID),
    expiration_date timestamp not null,
    pin varchar(6) not null,
    cvv varchar(3) not null,
    status varchar(100) not null,
    person_id INT not null,
    CONSTRAINT fk_person foreign key(person_id) references persons(ID),
    created_at timestamp not null,
    updated_at timestamp not null
);