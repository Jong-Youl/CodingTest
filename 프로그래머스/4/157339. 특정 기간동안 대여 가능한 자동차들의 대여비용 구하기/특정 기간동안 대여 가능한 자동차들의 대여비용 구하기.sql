-- 코드를 입력하세요
/*
자동차 종류가 '세단' 또는 'SUV' 인 자동차
2022년 11월 1일부터 2022년 11월 30일까지 대여 가능
30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차

대여 금액을 기준으로 내림차순 정렬
대여 금액이 같은 경우 자동차 종류를 기준으로 오름차순 정렬
자동차 종류까지 같은 경우 자동차 ID를 기준으로 내림차순 정렬

자동차 ID, 자동차 종류, 대여 금액(컬럼명: FEE) 리스트를 출력
*/

SELECT 
car.CAR_ID as CAR_ID, 
car.CAR_TYPE as CAR_TYPE, 
CAST(car.daily_fee * 30 * (1 - plan.DISCOUNT_RATE/100) AS SIGNED) as FEE

FROM
(select * from CAR_RENTAL_COMPANY_CAR where CAR_TYPE in ('SUV', '세단')) as car 
join 
(select * from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where DURATION_TYPE = "30일 이상") as plan 
on car.car_type = plan.car_type
where
car.CAR_ID not in (select CAR_ID 
                   from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
                   where -- 11월 이후에 끝나면서 시작이 11월 이전일때, 시작이 11월 중간에 있을 때
                    START_DATE <= '2022-11-01' AND END_DATE >= '2022-11-01'                  
              )
and
(
CAST(car.daily_fee * 30 * (1 - plan.DISCOUNT_RATE/100) AS SIGNED) >= 500000
AND 
CAST(car.daily_fee * 30 * (1 - plan.DISCOUNT_RATE/100) AS SIGNED) < 2000000
)

order by CAST(car.daily_fee * 30 * (1 - plan.DISCOUNT_RATE/100) AS SIGNED) desc, car.CAR_TYPE, car.CAR_ID desc
;