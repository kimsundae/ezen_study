







# 1. select * from 테이블명1 , 테이블명2 [ 레코드수 X 레코드수 ]
select * from member, board;
# 2. 테이블 합치는데 기준!!! [ PK --- FK ]
	# member pk = mno / board fk = mno
    # 1. 조건 조인 [ pk 필드와 fk필드가 일치하면 검색 ] * 일반 조건들과 가독성 떨어짐 [ 조인을 위한 조건인지 식별 힘듦 ]
select * from member , board where member.mno = board.mno;
	# 2. 자연 조인 [ 자동으로 두 테이블간 pk필드와 fk필드를 식별해서 조인 ] * pk 다수일 때 힘듦
select * from member natural join board;
	select * from member m natural join board b;
    # * 내가 보고 싶은 것만 필드 골라서 출력
    # b 
select b.* , m.mid from member m natural join board b; 
