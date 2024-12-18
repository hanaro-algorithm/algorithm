import sys
input = sys.stdin.readline

while True:
    try:
        N, M = map(int, input().split())
        result = 0
        for i in range(N, M+1):
            if len(str(i)) == len(set(str(i))):  #중복체크->set
                result += 1
        print(result)
    except:
        break