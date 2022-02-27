-- create table planning_permission (reference_id integer not null, applicant_first_name varchar(255) not null, applicant_last_name varchar(255) not null, application_status varchar(255) not null, application_type_id integer not null, house_area double not null, primary key (reference_id))

insert into planning_permission(reference_id, applicant_first_name, applicant_last_name, house_area, application_status, application_type_id) values(1, 'Donal', 'Crotty', 234.6, 'In Progress', 0)
insert into planning_permission(reference_id, applicant_first_name, applicant_last_name, house_area, application_status, application_type_id) values(2, 'James', 'Nicholson', 154.3, 'Further Information', 0)
insert into planning_permission(reference_id, applicant_first_name, applicant_last_name, house_area, application_status, application_type_id) values(3, 'Marh', 'Hoyle', 334.1, 'Rejected', 1)
insert into planning_permission(reference_id, applicant_first_name, applicant_last_name, house_area, application_status, application_type_id) values(4, 'John', 'Travers', 178.7, 'Completed', 1)
