/*=================<< select >>====================*/

select * from student_mst;

/* 전체 컬럼 조회 */ 
select 
	*
from 
	student_mst;
    
/* 지정 컬럼 조회*/
select 
	student_id,
    student_name,
    mento_id
from
	student_mst;
    
/* 임시 컬럼 추가 */
select 
	1 as num, 
    '김준일' as name;
    
select 
	student_id,
    student_name,
    '김준일' as instructor_name
from
	student_mst;
    
/* 컬럼명을 임시로 바꾸는 방법 as(alias) 알리아스 */
select 
	sm.student_id studentId /* 나중에 자바랑 연동시 자바는 카멜표기법이기에 그거와 일치를 시켜주기 위해*/
from 
	student_mst sm;

/* 조회 조건문 where */
select 
	*
from
	student_mst
where 
	mento_id = (select 
					mento_id
				from 
					mento_mst
				where 
					mento_name = '문자영');
                    
select 
	student_id,
    student_name,
    mento_id,
    (select 
		mento_name
	from
		mento_mst
	where 
		mento_id = student_mst.mento_id) as mento_name
from
	student_mst;
    
/* 그룹으로 묶어서 조회하기 */

select 
	count(student_id) as student_count,
    min(student_id) as min_student_id,
    max(student_id) as max,
    round(avg(student_id),1),
    sum(student_id),
	mento_id
from
	student_mst
group by 
	mento_id;

/* 중복 제거 */
select distinct
	mento_id
from 
	student_mst;

/* 그룹으로 조회한, 결과에 조건주는 방법*/
select 
	count(mento_id) as mento_count,
    min(student_id) as min_student_id,
    max(student_id) as max,
    round(avg(student_id),1),
    sum(student_id),
	mento_id
from
	student_mst
group by 
	mento_id
having
	mento_count = 5;
    
 /* 정렬 */
select
	*
from
	student_mst
order by
	student_id desc
    ,mento_id desc;
    
/* 전체 조합 실습 */
select 
	count(*) as student_count,
    mento_id
from
	student_mst
where
	student_id > 2
group by 
	mento_id
having
	student_count = 1
order by 
	mento_id desc;


    
