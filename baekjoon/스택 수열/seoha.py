n = int(input())
arr = []
st = []
result=[]
a=1

for i in range(n):
    arr.append(int(input()))

for num in arr:
    while True:
        if a>(n+1):
            break
        if len(st) !=0:
            if st[-1]==num:
                st.pop()
                result.append('-')
                break
        st.append(a)
        result.append('+')
        a+=1

if len(st) != 0:
    print('NO')
else:
    for r in result:
        print(r)