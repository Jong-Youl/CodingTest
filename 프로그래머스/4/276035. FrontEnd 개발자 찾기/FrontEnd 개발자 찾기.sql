-- 코드를 작성해주세요
SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS
WHERE SKILL_CODE & (SELECT SUM(CODE)
                   FROM SKILLCODES 
                   WHERE CATEGORY = "Front End" ) <> 0
ORDER BY ID
;


/*
    16 -> 
    2048 -> 
    8192 -> 
    10100000010000    
*/