import sys
input = sys.stdin.readline

while True:
    data = input().rstrip()
    if not data:
        break

    N, M = data.split()

    result = 0
    for num in range(int(N), int(M)+1):
        if len(set(str(num))) == len(str(num)):
            result += 1

    print(result)