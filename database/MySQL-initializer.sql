#데이터 베이스 생성문
CREATE DATABASE SPRING DEFAULT CHARACTER SET 'utf8';

#계정 생성
CREATE USER spring IDENTIFIED BY 'spring';

#권한 부여
GRANT ALL PRIVILEGES ON spring.* to spring;

