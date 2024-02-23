select d.ID,d.EMAIL,d.FIRST_NAME,d.LAST_NAME
from DEVELOPERS d
where exists 
    (select *
    from SKILLCODES
    where NAME in ('Python','C#') and d.SKILL_CODE&CODE = CODE
    )
order by ID

#   1011 (개발자의 기술 코드)
# & 0011 (Python의 코드)
# ------
#   0011 (결과)
