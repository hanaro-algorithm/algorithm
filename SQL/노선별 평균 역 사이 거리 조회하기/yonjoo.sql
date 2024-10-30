-- 코드를 작성해주세요
SELECT 
    ROUTE,
    concat(round(sum(d.d_between_dist), 1), 'km') as 'TOTAL_DISTANCE',
    concat(round(avg(d.d_between_dist), 2),'km') as 'AVERAGE_DISTANCE'
FROM SUBWAY_DISTANCE d
group by d.route
order by d.route desc;