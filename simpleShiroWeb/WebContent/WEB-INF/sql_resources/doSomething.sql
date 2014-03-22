create table user(
	id bigint primary key auto_increment,
	username varchar(50) not null,
	password varchar(50) not null
)

drop table user;

create table user_role(
	id bigint primary key auto_increment,
	user_id bigint,
	role_id bigint,
	foreign key(user_id) references user(id),
	foreign key(role_id) references role(id)
)

drop table user_role;

create table role(
	id bigint primary key auto_increment,
	role_name varchar(50) not null
)
drop table role;
alter table role add primary key (id)

create table role_permission(
	id bigint primary key auto_increment,
	role_id bigint,
	permission_id bigint,
	foreign key(role_id) references role(id),
	foreign key(permission_id) references permission(id)
)
drop table role_permission;
alter table role_permission add primary key(id)
alter table role_permission add foreign key(role_id) references role(id)
alter table role_permission add foreign key(permission_id)references permission(id)
create table permission(
	id bigint primary key auto_increment,
	permission_name varchar(50) not null
)
drop table permission;
alter table permission add primary key(id);



	select permission from roles_permissions where role_name = ?