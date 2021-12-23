create table city(
    c_id int primary key,
    c_name varchar(255),
    lat varchar(255),
    lon varchar(255)
);

create table weather(
    c_id int,
    day_no int,
    fxDate varchar(255),
    tempMax int,
    tempMin int,
    textDay varchar(255),
    primary key (c_id,day_no)
);