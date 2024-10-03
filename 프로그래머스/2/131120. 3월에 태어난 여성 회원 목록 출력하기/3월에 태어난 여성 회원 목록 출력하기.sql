-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, "%Y-%m-%d") as DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE TLNO is not null AND MONTH(DATE_OF_BIRTH) = 3 AND GENDER = "W"
ORDER BY MEMBER_ID
;