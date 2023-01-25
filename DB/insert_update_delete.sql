/*
	DML
	c: insert / into 데이터 추가
    r: select / from 데이터 조회
    U: update / set	 데이터 수정
    D: delect / from 데이터 삭제
*/

/*================<< insert >>=============*/
insert into student_mst
	(student_id, 	student_name, 	mento_id)
values 
	(5, 			'이강용', 		10),
	(6, 			'김준경', 		10),
	(7, 			'이현수', 		10),
	(8, 			'정의현', 		10);

insert into university_mst
	(university_id, univerisy_name)
values
	(4, '동아대'),
    (5, '부경대'),
    (6, '고려대'),
    (7, '춘천대'),
    (8, '서강대'),
    (9, '부산외대');
 
select * from university_mst;

select univerisy_name 
from university_mst
where university_id in (1, 9);

select * from student_mst;

/*================<< update >>=============*/

update student_mst 
set
	student_name = '김재영',
	mento_id = 15
where
	student_id = 5;
select * from student_mst;

/* 멘토 아이디가 10인 학생들의 멘토 아이디를 1로 바꾸어라*/

update student_mst
set 
	mento_id = 1
where 
	mento_id = 10;
select * from student_mst;

select * from university_mst;
delete
from	
	university_mst;

/*================<< delete >>=============*/
delete 
from 
	student_mst 
where 
	student_id = 4
and student_name = '손지호';

