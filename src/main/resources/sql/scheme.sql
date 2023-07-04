use mybatis;
-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- user Table Create SQL
-- 테이블 생성 SQL - user
CREATE TABLE user
(
    `id`      INT            NOT NULL    AUTO_INCREMENT COMMENT '회원id',
    `name`    VARCHAR(45)    NULL        COMMENT '이름',
    `email`   VARCHAR(45)    NULL        COMMENT '메일',
    `gender`  INT            NULL        COMMENT '성별',
    PRIMARY KEY (id)
);

-- 테이블 Comment 설정 SQL - user
ALTER TABLE user COMMENT '회원';


-- board Table Create SQL
-- 테이블 생성 SQL - board
CREATE TABLE board
(
    `id`       INT            NOT NULL    AUTO_INCREMENT COMMENT '게시글id',
    `title`    VARCHAR(45)    NULL        COMMENT '제목',
    `content`  VARCHAR(45)    NULL        COMMENT '내용',
    `writer`   INT            NULL        COMMENT '작성자',
    `editor`   INT            NULL        COMMENT '작성자',
    PRIMARY KEY (id)
);

-- 테이블 Comment 설정 SQL - board
ALTER TABLE board COMMENT '게시판';

-- Foreign Key 설정 SQL - board(writer) -> user(id)
ALTER TABLE board
    ADD CONSTRAINT FK_board_writer_user_id FOREIGN KEY (writer)
        REFERENCES user (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

-- Foreign Key 삭제 SQL - board(writer)
-- ALTER TABLE board
-- DROP FOREIGN KEY FK_board_writer_user_id;


-- address Table Create SQL
-- 테이블 생성 SQL - address
CREATE TABLE address
(
    `id`           INT            NOT NULL    AUTO_INCREMENT COMMENT '주소id',
    `user_id`      INT            NULL        COMMENT '회원id',
    `zip_code`     INT            NULL        COMMENT '우편번호',
    `detail_addr`  VARCHAR(45)    NULL        COMMENT '상세주소',
    PRIMARY KEY (id)
);

-- 테이블 Comment 설정 SQL - address
ALTER TABLE address COMMENT '주소';

-- Foreign Key 설정 SQL - address(user_id) -> user(id)
ALTER TABLE address
    ADD CONSTRAINT FK_address_user_id_user_id FOREIGN KEY (user_id)
        REFERENCES user (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

-- Foreign Key 삭제 SQL - address(user_id)
-- ALTER TABLE address
-- DROP FOREIGN KEY FK_address_user_id_user_id;


