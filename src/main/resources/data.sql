--create sequence student_seq start with 1 minvalue 1 increment by 1;
--create sequence subject_seq start with 1 minvalue 1 increment by 1;

--CREATE table student (id int(3) default student_seq.nextval, first_name varchar(20), last_name varchar(20), PRIMARY KEY (id));
--CREATE table subject (id int (3) default subject_seq.nextval, subject_name varchar(20), PRIMARY KEY (id));
--CREATE table result (id int(3), student_id  int(3), grade varchar(1), score int (2), subject_id int (3), PRIMARY KEY (id), FOREIGN KEY (student_id) REFERENCES student(id), FOREIGN KEY (subject_id) REFERENCES subject(id));

insert into student (id, first_name, last_name, version) values (1, 'Rohit', 'Sharma',0);
insert into student (id, first_name, last_name, version) values (2, 'Virat', 'Kohli',0);

insert into subject (id,subject_name, version) values (1,'English',0);
insert into subject (id,subject_name, version) values (2,'Hindi',0);
insert into subject (id,subject_name, version) values (3,'Maths',0);
insert into subject (id,subject_name, version) values (4, 'Science',0);

insert into result (id, student_id, grade, score, subject_id,version) values (1, 1, 'B',33, 1,0);
insert into result (id, student_id, grade, score, subject_id,version) values (2, 1, 'B',45, 2,0);
insert into result (id, student_id, grade, score, subject_id,version) values (3, 1, 'C',22, 3,0);
insert into result (id, student_id, grade, score, subject_id,version) values (4, 1, 'D',11, 4,0);

insert into result (id, student_id, grade, score, subject_id,version) values (5, 2, 'B',66, 1,0);
insert into result (id, student_id, grade, score, subject_id,version) values (6, 2, 'B',55, 2,0);
insert into result (id, student_id, grade, score, subject_id,version) values (7, 2, 'C',33, 3,0);
insert into result (id, student_id, grade, score, subject_id,version) values (8, 2, 'D',12, 4,0);