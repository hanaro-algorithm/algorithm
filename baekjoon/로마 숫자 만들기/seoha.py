import sys

input = sys.stdin.readline

N = int(input())
rome = [1, 5, 10, 50]
num = 0
arr = [0]*1001 #제일 큰 수 50*20 (나올 수 있는 가장 큰 수)

def back(count, start):
    global num

    if count == N:
        arr[num]=1
        return
    for i in range(start, 4):
        num += rome[i]
        back(count+1, i)
        num -= rome[i]

back(0, 0)
print(sum(arr))

#정답 다 저장하면 메모리 초과