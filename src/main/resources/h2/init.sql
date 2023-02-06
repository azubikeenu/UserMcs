CREATE TABLE  users (
   id bigint auto_increment,
   name varchar(50),
   balance int,
   primary key(id)
);

CREATE TABLE user_transaction(
   id bigint auto_increment,
   user_id bigint ,
   amount bigint ,
   transaction_date timestamp ,
   foreign key(user_id) references users(id) ON DELETE CASCADE ,
   primary key(id)
);


INSERT INTO users (name , balance) VALUES ('Richard' , 2000), ('Amaka' , 2500) , ('Boma' , 1700), ('Mike' , 4200);