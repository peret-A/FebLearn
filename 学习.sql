

# 注释的两种方法
# 1. #   注释
-- 2. -- 注释

# DDL
# 创建数据库 db_mylearn
CREATE DATABASE db_mylearn;

# 删除数据库 db_mylrean
DROP DATABASE `db_mylrean`;

# 使用数据库db_mylearn
USE `db_mylearn`;

# 创建学生表
CREATE TABLE student(
id INT(8),
`name` VARCHAR(20),
age INT(3),
adder VARCHAR(50)
);

# 查看所有数据库
SHOW DATABASES;

#查看所有表
SHOW TABLES;

# 创建教师表 id 为 主键 name不为空
CREATE TABLE teacher(
id INT(8) PRIMARY KEY COMMENT "教师id",
`name` VARCHAR(20) NOT NULL COMMENT "教师名字",
age INT(3) COMMENT "教师年龄"
);

# 修改字段类型
ALTER TABLE student MODIFY adder VARCHAR(20);


# 修改字段名称
ALTER TABLE student CHANGE adder dept VARCHAR(30);

# 删除字段
ALTER TABLE student DROP dept;

# 添加字段
ALTER TABLE student ADD dept VARCHAR(30);

# 修改表名
ALTER TABLE student RENAME student01;

# 删除表
DROP TABLE IF  EXISTS student01;

# 显示表结构
DESC student;

#显示表创建
SHOW CREATE TABLE student;


# DML
# 创建学生信息 id 10001212 name 小码 age 12 adder 1-11
INSERT INTO  student VALUES(10001212,"小码",12,"1-11");


CREATE TABLE student02(
StudentNo INT(4) NOT NULL COMMENT '学号',
LoginPwd VARCHAR(20) DEFAULT NULL,
StudentName VARCHAR(20) DEFAULT NULL COMMENT '学生姓名',
Sex TINYINT(1) DEFAULT NULL COMMENT '性别,取值0或者1',
GradeId INT(11) DEFAULT NULL COMMENT '年纪编号',
Phone VARCHAR(50) NOT NULL COMMENT '联系电话',
Address VARCHAR(255) NOT NULL COMMENT '地址',
BornDate DATETIME DEFAULT NULL COMMENT '出生时间',
Email VARCHAR(50) NOT NULL COMMENT '邮箱账号',
IdentityCard VARCHAR(18) DEFAULT NULL COMMENT '身份证号'
);


ALTER TABLE student02 RENAME student01;



# 创建数据库db_pracice01
CREATE DATABASE db_practice01;

# 使用数据库
USE db_practice01;

# 创建员工表 tb_workers
CREATE TABLE tb_workers(
wid INT,
`name` VARCHAR(20),
gender VARCHAR(2),
birthday DATE;,
email VARCHAR(10),
remark VARCHAR(50)
);

# 创建数据库db_practices02
CREATE DATABASE IF NOT EXISTS db_practices02;

#使用数据库db_practices02
USE db_practices02;

# 创建学习信息表tb_student
CREATE TABLE IF NOT EXISTS tb_student(
sno VARCHAR(20) NOT NULL COMMENT '学号',
sname VARCHAR(20) NOT NULL COMMENT '姓名',
ssex VARCHAR(20) NOT NULL COMMENT '性别',
sbirthday DATETIME DEFAULT NULL COMMENT '出生日期',
class VARCHAR(20) DEFAULT NULL COMMENT '班级'
);

# 创建教师信息表tb_teacher
CREATE TABLE IF NOT EXISTS tb_teacher(
tno VARCHAR(20) NOT NULL COMMENT '教师编号',
tname VARCHAR(20) NOT NULL COMMENT '姓名',
tsex VARCHAR(20) NOT NULL COMMENT '性别',
tbirthday DATETIME DEFAULT NULL COMMENT '出生日期',
prof VARCHAR(20) DEFAULT NULL COMMENT '职称',
depart VARCHAR(20) NOT NULL COMMENT '科系'
);

# 创建课程表tb_course
CREATE TABLE IF NOT EXISTS tb_course(
cno VARCHAR(20) NOT NULL COMMENT '课程编号',
tname VARCHAR(20) NOT NULL COMMENT '课程名称',
tno VARCHAR(20) NOT NULL COMMENT '授课教师编号',
);

# 创建课程表tb_score
CREATE TABLE IF NOT EXISTS tb_score(
sno VARCHAR(20) NOT NULL COMMENT '学生学号',
cno VARCHAR(20) NOT NULL COMMENT '课程编号',
degree DECIMAL(4,1) NOT NULL COMMENT '成绩',
);





