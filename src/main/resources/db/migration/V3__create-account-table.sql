CREATE TABLE IF NOT EXISTS accounts
(
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    uid varchar(255) not null,
    iban varchar(255) not null,
    balance INTEGER,
    person_id INT not null,
    CONSTRAINT fk_person foreign key(person_id) references persons(ID),
    created_at timestamp not null,
    updated_at timestamp not null
);