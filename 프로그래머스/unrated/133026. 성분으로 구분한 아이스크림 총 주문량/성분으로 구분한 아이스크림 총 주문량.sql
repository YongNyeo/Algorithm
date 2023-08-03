-- 코드를 입력하세요
SELECT INGREDIENT_TYPE, sum(TOTAL_ORDER) as TOTAL_ORDER
from icecream_info ice
join first_half half on ice.flavor = half.flavor
group by ice.INGREDIENT_TYPE
order by sum(total_order)