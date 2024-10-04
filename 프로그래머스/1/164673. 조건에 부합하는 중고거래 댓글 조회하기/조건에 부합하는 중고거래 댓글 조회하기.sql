-- 코드를 입력하세요
SELECT a.TITLE, a.BOARD_ID, b.REPLY_ID, b.WRITER_ID, b.CONTENTS, date_format(b.created_date, "%Y-%m-%d") as created_date
from used_goods_board a inner join used_goods_reply b on a.board_id = b.board_id
where substr(a.created_date, 1, 7) = "2022-10"
order by b.created_date, a.title
;