SELECT * FROM user;

insert into user(name, email, gender) values("라이언", "lion@kakao.com", 1);
insert into user(name, email, gender) values("어피치", "apeach@kakao.com", 2);
insert into user(name, email, gender) values("무지", "muji@kakao.com", 2);

SELECT * FROM address;

insert into address(user_id, zip_code, detail_addr) values(1, 47532, "부산광역시 해운대구");
insert into address(user_id, zip_code, detail_addr) values(2, 48091, "부산광역시 남구");
insert into address(user_id, zip_code, detail_addr) values(3, 41948, "부산광역시 사상구");

SELECT * FROM board;

insert into board(title, content, writer, editor) values("카카오톡에 새롭게 찾아온 오픈채팅탭", "카카오톡의 세번째 탭이 세상의 모든 관심사를 이어주는 오픈채팅탭으로 새로워집니다.", 1, 2);
insert into board(title, content, writer, editor) values("이번 여름 휴가는 어디로 갈까요?", "톡 프로필 공감스티커에 친구들에게 투표를 받을 수 있는 스티커가 추가되었어요.", 3, 1);
insert into board(title, content, writer, editor) values("보이스톡/페이스톡 업데이트 사전 안내", "소중한 사람과 더욱 가까워질 수 있도록 보이스톡과 페이스톡이 업데이트됩니다!", 2, 3);