CREATE TABLE IF NOT EXISTS p_hub (
    id INT AUTO_INCREMENT PRIMARY KEY,
    hubName VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    district VARCHAR(255) NULL,
    street VARCHAR(255) NULL,
    house_number VARCHAR(255) NULL,
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL
);
--
-- -- 서울특별시 센터
-- INSERT INTO p_hub (hubName, city, district, street, latitude, longitude)
-- VALUES ('서울특별시 센터', '서울특별시', '송파구', '송파대로 55', 37.4742027808565, 127.123621185562);
--
-- -- 경기 북부 센터
-- INSERT INTO p_hub (hubName, city, district, street, latitude, longitude)
-- VALUES ('경기 북부 센터', '경기도', '고양시 덕양구', '권율대로 570', 37.6403771056018, 126.87379545786);
--
-- -- 경기 남부 센터
-- INSERT INTO p_hub (hubName, city, district, street, latitude, longitude)
-- VALUES ('경기 남부 센터', '경기도', '이천시', '덕평로 257-21', 37.1896213142136, 127.375050006958);
--
-- -- 부산광역시 센터
-- INSERT INTO p_hub (hubName, city, district, street, latitude, longitude)
-- VALUES ('부산광역시 센터', '부산광역시', '동구', '중앙대로 206', 35.117605126596, 129.045060216345);
--
-- -- 대구광역시 센터
-- INSERT INTO p_hub (hubName, city, district, street, latitude, longitude)
-- VALUES ('대구광역시 센터', '대구광역시', '북구', '태평로 161', 35.8758849492106, 128.596129208483);
--
-- -- 인천광역시 센터
-- INSERT INTO p_hub (hubName, city, district, street, latitude, longitude)
-- VALUES ('인천광역시 센터', '인천광역시', '남동구', '정각로 29', 37.4560499608337, 126.705255744089);
--
-- -- 광주광역시 센터
-- INSERT INTO p_hub (hubName, city, district, street, latitude, longitude)
-- VALUES ('광주광역시 센터', '광주광역시', '서구', '내방로 111', 35.1600994105234, 126.851461925213);
--
-- -- 대전광역시 센터
-- INSERT INTO p_hub (hubName, city, district, street, latitude, longitude)
-- VALUES ('대전광역시 센터', '대전광역시', '서구', '둔산로 100', 36.3503849976553, 127.384633005948);
--
-- -- 울산광역시 센터
-- INSERT INTO p_hub (hubName, city, district, street, latitude, longitude)
-- VALUES ('울산광역시 센터', '울산광역시', '남구', '중앙로 201', 35.5379472830778, 129.311256608093);
--
-- -- 세종특별자치시 센터
-- INSERT INTO p_hub (hubName, city, district, street, latitude, longitude)
-- VALUES ('세종특별자치시 센터', '세종특별자치시', '', '한누리대로 2130', 36.4800579897497, 127.289039408864);
--
-- -- 강원특별자치도 센터
-- INSERT INTO p_hub (hubName, city, district, street, latitude, longitude)
-- VALUES ('강원특별자치도 센터', '강원특별자치도', '춘천시', '중앙로 1', 37.8800729197963, 127.727907820318);
--
-- -- 충청북도 센터
-- INSERT INTO p_hub (hubName, city, district, street, latitude, longitude)
-- VALUES ('충청북도 센터', '충청북도', '청주시 상당구', '상당로 82', 36.6353867908159, 127.491428436987);
--
-- -- 충청남도 센터
-- INSERT INTO p_hub (hubName, city, district, street, latitude, longitude)
-- VALUES ('충청남도 센터', '충청남도', '홍성군 홍북읍', '충남대로 21', 36.6590666265439, 126.672978750559);
--
-- -- 전북특별자치도 센터
-- INSERT INTO p_hub (hubName, city, district, street, latitude, longitude)
-- VALUES ('전북특별자치도 센터', '전북특별자치도', '전주시 완산구', '효자로 225', 35.8194374902358, 127.106374667247);
--
-- -- 전라남도 센터
-- INSERT INTO p_hub (hubName, city, district, street, latitude, longitude)
-- VALUES ('전라남도 센터', '전라남도', '무안군 삼향읍', '오룡길 1', 34.8174988528003, 126.465423854957);
--
-- -- 경상북도 센터
-- INSERT INTO p_hub (hubName, city, district, street, latitude, longitude)
-- VALUES ('경상북도 센터', '경상북도', '안동시 풍천면', '도청대로 455', 36.5761205474728, 128.505722686385);
--
-- -- 경상남도 센터
-- INSERT INTO p_hub (hubName, city, district, street, latitude, longitude)
-- VALUES ('경상남도 센터', '경상남도', '창원시 의창구', '중앙대로 300', 35.2378032514675, 128.691940442146);
