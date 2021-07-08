## 주제 : 카페 키오스크
### 개발툴 : JDK11, javafx, SceneBuilder, mysql
### 사용되는 클래스 : Member, Product, Order
### 씬빌더 fxml : main, list, order, success
### 담당
#### 이보름 : 고객 주문창
#### 이찬주 : 주문 완료 현황변경(접수, 진행중, 완료)
#### 최은영 : 관리자 창(회원가입, 제품등록)

### mysql DB 구성
#### 1. 회원(member)
```
create table kiosk.member(
  num INT primary key,
  id varchar(45) not null,
  pw varchar(45) not null,
  name varchar(45) not null,
  email varchar(45),
  phone varchar(45)
);
```
##### 정보
|칼럼|설명|
|----|----|
|num|회원번호|
|id|회원아이디(admin, 일반)|
|pw|회원비밀번호|
|name|이름|
|email|이메일|
|phone|전화번호|

##### 예시
|num|id|pw|name|email|phone|
|----|----|----|----|----|----|
|0001|admin|1111|admin|admin@admin.com|010-1234-1234|



#### 2. 제품(product)
```
create table kiosk.product (
    pnum int primary key,
    ptitle varchar(45) not null,
    pcontents varchar(1000) not null,
    pprice int not null,
    pstock int,
    pimage varchar(1000)
);
```
##### 정보
|칼럼|설명|
|----|----|
|onum|제품번호|
|ptitle|제품명|
|pcontents|제품설명|
|pprice|제품가격|
|pstock|제품재고|
|pimgag|이미지|

##### 예시
|pnum|ptitle|pcontents|pprice|pstock|pimgae|
|----|----|----|----|----|----|
|1|샌드위치|햄치즈|6000|15| ../image/ryan.png|

##### 3. 주문들어온 정보(Kitchen_order)
```
create table kiosk.Kitchen_order (
	onum int primary key auto_increment,
	pnum varchar(10) not null,
	num int not null,
	pquantity varchar(100) not null, 
	oprice int not null ,
	otime varchar(100),
	osituation varchar(100) not null,
	foreign key(pnum) references Product(pnum)
	foreign key(num) references ()
);
```
##### 정보
|칼럼|설명|
|----|----|
|onum|회원번호|
|pnum|제품명|
|pquantity|제품갯수|
|oprice|제품가격|
|otime|주문시각|
|osituation|주문현황|

##### 예시
|onum|pnum|pquantity|oprice|otime|osituation|
|----|----|----|----|----|----|
|1|1 아메리카노|1|3000|13:00|완료|
|2|3 카라멜마키아또|2|6000|14:15|진행중|

