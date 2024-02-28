#创建数据库db_practices02
CREATE DATABASE IF NOT EXISTS `db_practices02`;


#使用数据库db_practices02
USE `db_practices02`;

#创建学生信息表tb_student
CREATE TABLE IF NOT EXISTS `tb_student` (
  `sno` VARCHAR (20) NOT NULL PRIMARY KEY COMMENT '学号',
  `sname` VARCHAR (20) NOT NULL COMMENT '姓名',
  `ssex` VARCHAR (20) NOT NULL COMMENT '性别',
  `sbirthday` DATETIME COMMENT '出生日期',
  `class` VARCHAR (20) COMMENT '班级'
) ;

#创建教师信息表tb_teacher
CREATE TABLE IF NOT EXISTS `tb_teacher` (
  `tno` VARCHAR (20) NOT NULL PRIMARY KEY COMMENT '教师编号',
  `tname` VARCHAR (20) NOT NULL COMMENT '姓名',
  `tsex` VARCHAR (20) NOT NULL COMMENT '性别',
  `tbirthday` DATETIME COMMENT '出生日期',
  `prof` VARCHAR (20) COMMENT '职称',
  `depart` VARCHAR (20) NOT NULL COMMENT '科系'
) ;

#创建课程表tb_course
CREATE TABLE IF NOT EXISTS `tb_course` (
  `cno` VARCHAR (20) NOT NULL PRIMARY KEY COMMENT '课程编号',
  `cname` VARCHAR (20) NOT NULL COMMENT '课程名称',
  `tno` VARCHAR (20) NOT NULL COMMENT '授课教师编号',
  CONSTRAINT fk_course_tno FOREIGN KEY (`tno`) REFERENCES `tb_teacher` (`tno`)
) ;

#创建成绩表tb_score
CREATE TABLE IF NOT EXISTS `tb_score` (
  `sno` VARCHAR (20) NOT NULL COMMENT '学生学号',
  `cno` VARCHAR (20) NOT NULL COMMENT '课程编号',
  `degree` NUMERIC (4, 1) COMMENT '成绩',
  CONSTRAINT fk_score_sno FOREIGN KEY (`sno`) REFERENCES `tb_student` (`sno`),
  CONSTRAINT fk_score_cno FOREIGN KEY (`cno`) REFERENCES `tb_course` (`cno`)
) ;
#------------------------------------------------------------------------------------------------


#向tb_student表中添加数据
INSERT INTO `tb_student` (`sno`,`sname`,`ssex`,`sbirthday`,`class`) VALUES (108 ,'曾华' 
,'男' ,'1977-09-01','95033');
INSERT INTO `tb_student` (`sno`,`sname`,`ssex`,`sbirthday`,`class`) VALUES (105 ,'匡明' 
,'男' ,'1975-10-02','95031');
INSERT INTO `tb_student` (`sno`,`sname`,`ssex`,`sbirthday`,`class`) VALUES (107 ,'王丽' 
,'女' ,'1976-01-23','95033');
INSERT INTO `tb_student` (`sno`,`sname`,`ssex`,`sbirthday`,`class`) VALUES (101 ,'李军' 
,'男' ,'1976-02-20','95033');
INSERT INTO `tb_student` (`sno`,`sname`,`ssex`,`sbirthday`,`class`) VALUES (109 ,'王芳' 
,'女' ,'1975-02-10','95031');
INSERT INTO `tb_student` (`sno`,`sname`,`ssex`,`sbirthday`,`class`) VALUES (103 ,'陆君' 
,'男' ,'1974-06-03','95031');


#向tb_teacher表中添加数据
INSERT INTO `tb_teacher`(`tno`,`tname`,`tsex`,`tbirthday`,`prof`,`depart`) 
VALUES (804,'李诚','男','1958-12-02','副教授','计算机系');
INSERT INTO `tb_teacher`(`tno`,`tname`,`tsex`,`tbirthday`,`prof`,`depart`) 
VALUES (856,'张旭','男','1969-03-12','讲师','电子工程系');
INSERT INTO `tb_teacher`(`tno`,`tname`,`tsex`,`tbirthday`,`prof`,`depart`) 
VALUES (825,'王萍','女','1972-05-05','助教','计算机系');
INSERT INTO `tb_teacher`(`tno`,`tname`,`tsex`,`tbirthday`,`prof`,`depart`) 
VALUES (831,'刘冰','女','1977-08-14','助教','电子工程系');

#向tb_course表中添加数据
INSERT INTO `tb_course`(`cno`,`cname`,`tno`)VALUES ('3-105' ,'计算机导论',825);
INSERT INTO `tb_course`(`cno`,`cname`,`tno`)VALUES ('3-245' ,'操作系统' ,804);
INSERT INTO `tb_course`(`cno`,`cname`,`tno`)VALUES ('6-166' ,'数字电路' ,856);
INSERT INTO `tb_course`(`cno`,`cname`,`tno`)VALUES ('9-888' ,'高等数学' ,831);

#向tb_score表中添加数据
INSERT INTO `tb_score`(`sno`,`cno`,`degree`)VALUES (103,'3-245',86);
INSERT INTO `tb_score`(`sno`,`cno`,`degree`)VALUES (105,'3-245',75);
INSERT INTO `tb_score`(`sno`,`cno`,`degree`)VALUES (109,'3-245',68);
INSERT INTO `tb_score`(`sno`,`cno`,`degree`)VALUES (103,'3-105',92);
INSERT INTO `tb_score`(`sno`,`cno`,`degree`)VALUES (105,'3-105',88);
INSERT INTO `tb_score`(`sno`,`cno`,`degree`)VALUES (109,'3-105',76);
INSERT INTO `tb_score`(`sno`,`cno`,`degree`)VALUES (101,'3-105',64);
INSERT INTO `tb_score`(`sno`,`cno`,`degree`)VALUES (107,'3-105',91);
INSERT INTO `tb_score`(`sno`,`cno`,`degree`)VALUES (108,'3-105',78);
INSERT INTO `tb_score`(`sno`,`cno`,`degree`)VALUES (101,'6-166',85);
INSERT INTO `tb_score`(`sno`,`cno`,`degree`)VALUES (107,'6-166',79);
INSERT INTO `tb_score`(`sno`,`cno`,`degree`)VALUES (108,'6-166',81);
#------------------------------------------------------------------------------------------------

#01、查询tb_student表中的所有记录的sname、ssex和class列。
SELECT sname,ssex,class FROM tb_student;

#02、查询教师所有的单位(即不重复的depart列)。
SELECT DISTINCT depart FROM tb_teacher;

#03、查询tb_student表的所有记录。
SELECT * FROM tb_student;

#04、查询tb_score表中成绩在60到80之间的所有记录。
SELECT * FROM tb_score WHERE degree<=80 AND degree>=60;

#05、查询tb_score表中成绩为85，86或88的记录。
SELECT * FROM tb_score WHERE degree IN(85,86,88);


#06、查询tb_student表中“95031”班或性别为“女”的同学记录。
SELECT * FROM tb_student WHERE class = '95031' OR ssex = '女';

#07、以class降序查询tb_student表的所有记录。
SELECT * FROM tb_student ORDER BY class DESC;

#08、以cno升序、degree降序查询tb_score表的所有记录。
 SELECT * FROM tb_score ORDER BY cno ASC,degree DESC;

#09、查 询“95031”班的学生人数。
SELECT COUNT(*) '“95031”班的学生人数' FROM tb_student WHERE class = '95031';


#10、查询tb_score表中的最高分的学生学号和课程号。（子查询或者排序）
SELECT sno,cno FROM tb_score WHERE degree = (SELECT MAX(degree) FROM tb_score);

#11、查询每门课的平均成绩。
SELECT cno,AVG(degree) FROM tb_score GROUP BY cno;

#12、查询tb_score表中至少有5名学生选修的并以3开头的课程的平均分数。
SELECT COUNT(*) FROM tb_score GROUP BY cno HAVING cno LIKE '3%';

SELECT cno,AVG(degree) FROM tb_score  GROUP BY cno HAVING cno LIKE '3%' AND COUNT(*)>=5 ;

#13、查询分数大于70，小于90的sno列。
SELECT sno FROM tb_score WHERE degree>=70 AND degree<=90;


#14、查询所有学生的sname、cno和degree列。
SELECT sname,cno,degree 
FROM tb_score JOIN tb_student ON tb_score.`sno` = tb_student.sno;


#15、查询所有学生的sno、cname和degree列。
SELECT sno,cname,degree
FROM tb_score tb_s JOIN tb_course tb_c ON tb_s.`cno` = tb_c.`cno`;


#16、查询所有学生的sname、cname和degree列
SELECT sname,cname,degree
FROM tb_score JOIN tb_student ON tb_score.`sno`=tb_student.`sno` JOIN tb_course ON tb_score.`cno`=tb_course.`cno`;


#17、查询“95033”班学生的平均分。
SELECT AVG(degree) 
FROM tb_score 
WHERE sno IN(SELECT sno FROM tb_student WHERE class='95033');


#18、假设使用如下命令建立了一个grade表：
CREATE TABLE IF NOT EXISTS `tb_grade` (
  `low` INT (3) COMMENT '底限',
  `upp` INT (3) COMMENT '上限',
  `rank` CHAR(1) COMMENT '等级'
) ;
#向tb_grade表中添加数据
INSERT INTO `tb_grade` VALUES(90,100,'A');
INSERT INTO `tb_grade` VALUES(80,89,'B');
INSERT INTO `tb_grade` VALUES(70,79,'C');
INSERT INTO `tb_grade` VALUES(60,69,'D');
INSERT INTO `tb_grade` VALUES(0,59,'E');
#现查询所有同学的sno、cno和rank列。
SELECT sno,cno,`rank`
FROM tb_score NATURAL RIGHT JOIN tb_grade
WHERE degree<=upp AND degree>=low ORDER BY `rank`;


#19、查询选修“3-105”课程的成绩高于“109”号同学成绩的所有同学的记录。
SELECT * 
FROM tb_score
WHERE cno='3-105' AND degree>(SELECT MAX(degree) FROM tb_score WHERE sno='109');

#20、查询tb_score中选学多门课程的同学中分数为非最高分成绩的记录。
SELECT *
FROM tb_score
WHERE (cno,degree) NOT IN (SELECT cno,MAX(degree)
	FROM tb_score
	GROUP BY cno);


#21、查询成绩高于学号为“109”、课程号为“3-105”的成绩的所有记录。
SELECT degree
FROM tb_score
WHERE sno='109' AND cno='3-105';


#22、查询和学号为107的同学同年出生的所有学生的sno、sname和sbirthday列。
SELECT sno,sname,sbirthday
FROM tb_student
WHERE YEAR(sbirthday) = (SELECT YEAR(sbirthday)

			FROM tb_student
			WHERE sno = '107');


#23、查询“张旭“教师任课的学生成绩。
SELECT degree
FROM tb_course tb_c JOIN tb_teacher tb_t ON tb_c.`tno`=tb_t.`tno` JOIN tb_score tb_s ON tb_c.`cno` = tb_s.`cno`
WHERE tname='张旭';


#24、查询选修某课程的同学人数多于5人的教师姓名。
SELECT DISTINCT tname
FROM tb_course tb_c JOIN tb_teacher tb_t ON tb_c.`tno`=tb_t.`tno` JOIN tb_score tb_s ON tb_c.`cno` = tb_s.`cno`
WHERE tb_c.cno=(SELECT cno
FROM tb_score
GROUP BY cno HAVING COUNT(*)>5);


#25、查询95033班和95031班全体学生的记录。
SELECT *
FROM tb_student
WHERE class IN ('95033','95031');

#26、查询存在有85分以上成绩的课程cno.
SELECT DISTINCT cno
FROM tb_score
WHERE degree>85;


#27、查询出“计算机系“教师所教课程的成绩表。
SELECT *
FROM tb_score
WHERE cno IN(SELECT cno
FROM tb_course
WHERE tno IN(SELECT tno
FROM tb_teacher
WHERE depart='计算机系'));

#28、查询“计算机系”与“电子工程系“不同职称的教师的tname和prof。
SELECT tname,prof
FROM tb_teacher
WHERE prof NOT IN (SELECT prof FROM tb_teacher WHERE depart='计算机系' AND prof  IN (SELECT prof FROM tb_teacher WHERE depart='电子工程系'));


#29、查询选修编号为“3-105“课程且成绩至少高于选修编号为“3-245”的同学的cno、sno和degree,并按degree从高到低次序排序。
SELECT cno,sno,degree
FROM tb_score
WHERE degree > (SELECT MAX(degree) FROM tb_score WHERE cno='3-245')  AND cno='3-105' ORDER BY degree DESC;                                                                               )

#30、查询选修编号为“3-105”且成绩高于选修编号为“3-245”课程的同学的cno、sno和degree.
SELECT cno,sno,degree
FROM tb_score
WHERE degree > (SELECT MAX(degree) FROM tb_score WHERE cno='3-245')  AND cno='3-105';

#31、查询所有教师和同学的name、sex和birthday.
SELECT sname `name` ,ssex sex,sbirthday birthday
FROM tb_student
UNION
SELECT tname `name` ,tsex sex ,tbirthday birthday
FROM tb_teacher
ORDER BY `name`,sex,birthday;

#32、查询所有“女”教师和“女”同学的name、sex和birthday.
SELECT sname `name` ,ssex sex,sbirthday birthday
FROM tb_student
WHERE ssex='女'
UNION
SELECT tname `name` ,tsex sex ,tbirthday birthday
FROM tb_teacher
WHERE tsex ='女' ORDER BY `name`,sex,birthday;


#33、查询成绩比该课程平均成绩低的同学的成绩表。
SELECT *
FROM tb_score
WHERE degree<(SELECT AVG(degree) FROM tb_score);


#34、查询所有任课教师的tname和depart.
SELECT tname,depart
FROM tb_course  JOIN tb_teacher ON tb_course.`tno`=tb_teacher.`tno`
WHERE cno   IN (SELECT cno FROM tb_score GROUP BY cno);


#35、查询所有未讲课的教师的tname和depart.
SELECT tname,depart
FROM tb_course  JOIN tb_teacher ON tb_course.`tno`=tb_teacher.`tno`
WHERE cno  NOT IN (SELECT cno FROM tb_score GROUP BY cno);


#36、查询至少有2名男生的班号。
SELECT class 
FROM tb_student
WHERE ssex='男' GROUP BY class HAVING COUNT(*)>=2;


#37、查询tb_student表中不姓“王”的同学记录。
SELECT *
FROM tb_student
WHERE sname<>'王%';


#38、查询tb_student表中每个学生的姓名和年龄。
SELECT sname,FLOOR(DATEDIFF(NOW(),sbirthday)/365) '年龄'
FROM tb_student;




#39、查询tb_student表中最大和最小的sbirthday日期值。
SELECT MAX(sbirthday),MIN(sbirthday)
FROM tb_student;


#40、以班号和年龄从大到小的顺序查询student表中的全部记录。
SELECT *
FROM tb_student
ORDER BY class DESC,sbirthday DESC;


#41、查询“男”教师及其所上的课程。
SELECT tname,cname
FROM tb_teacher JOIN tb_course ON tb_teacher.`tno` = tb_course.`tno`
WHERE tb_teacher.`tsex`='男';


#42、查询最高分同学的sno、cno和degree列。
SELECT *
FROM tb_score
WHERE degree = (SELECT MAX(degree) FROM tb_score );


#43、查询和“李军”同性别的所有同学的sname.
SELECT sname
FROM tb_student
WHERE ssex = (SELECT ssex FROM tb_student WHERE sname = '李军') ;

#44、查询和“李军”同性别并同班的同学sname.
SELECT sname
FROM tb_student
WHERE ssex = (SELECT ssex FROM tb_student WHERE sname = '李军') AND class  = (SELECT class FROM tb_student WHERE sname = '李军');


#45、查询所有选修“计算机导论”课程的“男”同学的成绩表。
SELECT degree
FROM tb_score
WHERE cno IN (SELECT cno FROM tb_course WHERE cname = '计算机导论') AND sno IN(SELECT sno FROM tb_student WHERE ssex = '男');
    
