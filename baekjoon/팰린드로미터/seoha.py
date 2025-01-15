import sys
input = sys.stdin.readline

num = input().rstrip()

def check(arr):
    for i in range(len(arr)//2):
        if arr[i] != arr[-(i+1)]:
            return False
    return True

while num != '0':
    flag = check(str(num).zfill(len(num)))
    cnt = 0
    while not flag:
        cnt += 1
        num_len = len(num)
        temp = int(num) + cnt
        flag = check(str(temp).zfill(num_len))

    print(cnt)
    num = input().rstrip()