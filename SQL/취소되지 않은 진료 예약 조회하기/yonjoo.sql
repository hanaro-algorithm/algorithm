# -- 코드를 입력하세요
# SELECT tmp.apnt_no, tmp.pt_name, tmp.pt_no, tmp.mcdp_cd, d.DR_NAME, tmp.apnt_ymd
# FROM doctor d, (
#         SELECT a.apnt_no, p.pt_name, p.pt_no, a.mcdp_cd, a.apnt_ymd, a.mddr_id
#         FROM APPOINTMENT a
#         inner join PATIENT p
#         on a.pt_no = p.pt_no
#         where year(a.apnt_ymd) = 2022 and month(a.apnt_ymd) = 4 and day(a.apnt_ymd) = 13 and a.apnt_cncl_yn = 'N'
#     ) tmp
    
# where d.dr_id = tmp.mddr_id
# order by a.apnt_ymd asc

SELECT APNT_NO, PT_NAME, a.PT_NO, a.MCDP_CD, DR_NAME, APNT_YMD
FROM APPOINTMENT a 
    JOIN PATIENT p ON a.PT_NO = p.PT_NO
    JOIN DOCTOR d ON MDDR_ID = DR_ID
WHERE APNT_CNCL_YN = 'N'
    AND a.MCDP_CD = 'CS'
    AND APNT_YMD LIKE '2022-04-13%'
ORDER BY APNT_YMD
