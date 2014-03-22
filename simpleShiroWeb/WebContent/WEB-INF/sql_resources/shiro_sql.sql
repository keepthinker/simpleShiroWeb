create table user(
	id bigint primary key auto_increment,
	username varchar(50) not null,
	password varchar(50) not null
);
create table role(
	id bigint primary key auto_increment,
	role_name varchar(50) not null
);
create table user_role(
	id bigint primary key auto_increment,
	user_id bigint,
	role_id bigint,
	foreign key(user_id) references user(id),
	foreign key(role_id) references role(id)
);

create table permission(
	id bigint primary key auto_increment,
	permission_name varchar(50) not null
);
create table role_permission(
	id bigint primary key auto_increment,
	role_id bigint,
	permission_id bigint,
	foreign key(role_id) references role(id),
	foreign key(permission_id) references permission(id)
);


#insert user role permission information
insert into user(username,password) values('root','123456');
insert into user(username,password) values('xiaomi','123456');
insert into user(username,password) values('samsung','123456');

insert into role(role_name) values('admin');
insert into role(role_name) values('corporate');

insert into permission(permission_name) values('corporate:*');
insert into permission(permission_name) values('*');#you are allow to do everything

# insert user_role information
insert into user_role(user_id,role_id) values(
(select id from user where username='root'),
(select id from role where role_name='admin'));

insert into user_role(user_id,role_id) values(
(select id from user where username='xiaomi'),
(select id from role where role_name='corporate'));

insert into user_role(user_id,role_id) values(
(select id from user where username='samsung'),
(select id from role where role_name='corporate'));
#insert role_permission information
insert into role_permission(role_id,permission_id) values(
(select id from role where role_name='admin'),
(select id from permission where permission_name='*'));

insert into role_permission(role_id,permission_id) values(
(select id from role where role_name='corporate'),
(select id from permission where permission_name='corporate:*'));

# check relationship bettween user and role
select username,role_name from user,role,user_role 
where user_role.user_id=user.id
and user_role.role_id=role.id;

# check relationship bettween role and permission
select role_name,permission_name from role,permission,role_permission
where role_permission.role_id=role.id
and role_permission.permission_id=permission.id;
