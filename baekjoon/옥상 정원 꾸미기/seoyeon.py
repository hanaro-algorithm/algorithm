import sys

input = sys.stdin.readline 
n = int(input()) 
s = [] 
count = 0 

for i in range(0,n):
    x = int(input()) 
    if len(s) == 0: s.append(x) 
    continue 
else: 
    while len(s) > 0 and x >= s[-1]: 
        s.pop() 
    count += len(s) 
    s.append(x) 
    
print(count)