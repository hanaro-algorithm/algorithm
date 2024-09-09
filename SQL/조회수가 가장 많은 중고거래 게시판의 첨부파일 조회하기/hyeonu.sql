select concat('/home/grep/src/', f.BOARD_ID, '/', FILE_ID, FILE_NAME, FILE_EXT)
from USED_GOODS_BOARD b
         join USED_GOODS_FILE f on b.BOARD_ID = f.BOARD_ID
where views = (select max(views) from USED_GOODS_BOARD)
order by FILE_ID desc