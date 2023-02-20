create table Location (
    account varchar(255) not null references Account(account),
    lng decimal(9,6) not null,
    lat decimal(8,6) not null,
);
