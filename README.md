## 주제 : 카페 키오스크
### 개발툴 : JDK11, javafx, SceneBuilder, mysql
### 사용되는 클래스 : Member, Product, Order
### 씬빌더 fxml : main, list, order, success
### 담당
#### 이보름 : 고객 주문창
#### 이찬주
#### 최은영


create table member(
  num INT primary key,
  id varchar(45) not null,
  pw varchar(45) not null,
  name varchar(45) not null,
  email varchar(45),
  phone varchar(45)
);
