n = input()
cnt = 0
answer = 0
for i in range(len(n) - 1) :
    if n[i] != n[i + 1] :
        cnt += 1
answer = ((cnt + 1) // 2)