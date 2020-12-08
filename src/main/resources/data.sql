insert into appointment values(201, 'Monday', '3 to 8', 'Rahul', 'Arun');

insert into hospital values(946, 'Ruby', 2, 10);
insert into hospital values(947, 'Apollo', 1, 20);

insert into doctor values(101, 'Monday,Wednesday', '5 to 6', 'Y', 'sandhya', 'Dentist', 946);
insert into doctor values(102, 'Monday,Thursday', '6 to 8', 'N', 'saranya', 'Dentist', 946);
insert into doctor values(103, 'Wednesday,Thursday', '3 to 5', 'Y', 'Abhishek', 'ENT', 946);
insert into doctor values(104, 'Tuesday,Thursday', '6 to 8', 'N', 'Gopal', 'Dentist', 947);
insert into doctor values(105, 'Tuesday,Friday', '6 to 8', 'Y', 'Deepika', 'Cardiologist', 947);
insert into doctor values(106, 'Tuesday,Thursday', '12 to 4', 'Y', 'sandhya', 'Dentist', 947);

insert into patient values(501, sysDate(), 'Rajan', 'ADMITTED', 946);
insert into patient values(502, sysDate(), 'Vivek', 'ADMITTED', 946);
insert into patient values(503, sysDate(), 'Santosh', 'DISCHARGE', 946);
insert into patient values(504, sysDate(), 'Ravi', 'ADMITTED', 946);
insert into patient values(505, sysDate(), 'Rohan', 'DISCAHRGE', 946);
insert into patient values(506, sysDate(), 'Shrey', 'DISCHARGE', 946);