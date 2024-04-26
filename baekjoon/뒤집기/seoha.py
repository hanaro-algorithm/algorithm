str = input()
one_count = 0
zero_count = 0
pre=str[0]
if pre=='0':
    zero_count+=1
else:
    one_count+=1

for s in str:
    if pre != s:
        if s == '0':
            zero_count+=1
        else:
            one_count+=1
        pre=s

print(min(zero_count,one_count))
