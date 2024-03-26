str1 = input()
count_1 = 0
count_0 = 0
if str1[0] == "1":
    count_1 += 1
elif str1[0] == "0":
    count_0 += 1
    
for c in range(1,len(str1)): #1~길이까지 (두번째부터 마지막수 카운트)
    if str1[c] == "1" :
        if str1[c-1] != "1":
            count_1 += 1 # 카운트 기준 추가해주기
    elif str1[c] == "0" :
        if str1[c-1] != "0":
            count_0 += 1
print(min(count_0,count_1))