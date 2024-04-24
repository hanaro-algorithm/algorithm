str = input()
res = 0
for s in str:
    if res == 0 or int(s) == 0:
        res+=int(s)
    else:
        res*=int(s)

print(res)