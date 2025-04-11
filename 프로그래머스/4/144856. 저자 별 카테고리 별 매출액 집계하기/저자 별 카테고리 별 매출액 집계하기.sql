-- 코드를 입력하세요

/*
    2022년 1월의 기준 저자 별, 카테고리 별 매출액(TOTAL_SALES = 판매량 * 판매가) 
    저자 ID(AUTHOR_ID), 저자명(AUTHOR_NAME), 카테고리 (CATEGORY), 매출액(SALES) 리스트
*/

SELECT view1.AUTHOR_ID, view1.AUTHOR_NAME, view1.CATEGORY, SUM(view1.price * view2.sales) as TOTAL_SALES
FROM 
    (
        SELECT b.book_id, b.category, a.author_id, b.price, a.author_name
        FROM BOOK b
            JOIN AUTHOR a
            ON a.AUTHOR_ID = b.AUTHOR_ID
    ) as view1
    JOIN
    (
    SELECT *
    FROM BOOK_SALES
    WHERE DATE_FORMAT(sales_date, "%Y-%m") = '2022-01'
    ) as view2
    ON view1.BOOK_ID = view2.BOOK_ID
GROUP BY AUTHOR_ID, CATEGORY
ORDER BY view1.AUTHOR_ID, view1.CATEGORY DESC
;