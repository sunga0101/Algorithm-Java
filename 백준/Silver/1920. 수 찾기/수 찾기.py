import sys
input = sys.stdin.readline

def binary(array, target, min, max):
    if min > max :
        print(0)
        return None
    guess = (min+max) // 2 
    if array[guess] == target: #있을때
        print(1) 
        return guess
    elif array[guess] < target: #추측값 작을때
        return binary(array, target, guess+1, max) 
    else:
        return binary(array, target, min, guess-1)

n = int(input())
n_array = sorted(list(map(int, input().split()))) # 소팅
m = int(input())
num_list = list(map(int, input().split()))

for i in num_list:
    binary(n_array, i, 0, len(n_array)-1)