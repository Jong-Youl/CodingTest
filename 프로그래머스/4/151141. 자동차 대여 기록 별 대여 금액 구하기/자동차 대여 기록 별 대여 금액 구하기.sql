-- 코드를 입력하세요

/*
    자동차 종류가 '트럭'인 자동차의 대여 기록
    대여 기록 별로 대여 금액(컬럼명: FEE)
    대여 기록 ID와 대여 금액 리스트를 출력
*/

SELECT 
    history.HISTORY_ID, 
    CASE 
        WHEN DATEDIFF(history.END_DATE, history.START_DATE) + 1 >= 90 
        THEN DAILY_FEE * (DATEDIFF(history.END_DATE, history.START_DATE) + 1) * 
             (100 - (SELECT REPLACE(DISCOUNT_RATE, '%', '') 
                     FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
                     WHERE DURATION_TYPE = "90일 이상" 
                     AND CAR_TYPE = car.CAR_TYPE)) / 100
        WHEN DATEDIFF(history.END_DATE, history.START_DATE) + 1 >= 30 
        THEN DAILY_FEE * (DATEDIFF(history.END_DATE, history.START_DATE) + 1) * 
             (100 - (SELECT REPLACE(DISCOUNT_RATE, '%', '') 
                     FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
                     WHERE DURATION_TYPE = "30일 이상" 
                     AND CAR_TYPE = car.CAR_TYPE)) / 100
        WHEN DATEDIFF(history.END_DATE, history.START_DATE) + 1 >= 7 
        THEN DAILY_FEE * (DATEDIFF(history.END_DATE, history.START_DATE) + 1) * 
             (100 - (SELECT REPLACE(DISCOUNT_RATE, '%', '') 
                     FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
                     WHERE DURATION_TYPE = "7일 이상" 
                     AND CAR_TYPE = car.CAR_TYPE)) / 100
        ELSE DAILY_FEE * (DATEDIFF(history.END_DATE, history.START_DATE) + 1)
    END AS FEE
FROM CAR_RENTAL_COMPANY_CAR AS car
INNER JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS history
    ON car.car_id = history.car_id
WHERE car.car_type = "트럭"
ORDER BY FEE DESC, history.HISTORY_ID DESC
;