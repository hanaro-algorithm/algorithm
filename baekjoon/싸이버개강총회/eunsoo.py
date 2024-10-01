import sys
input = sys.stdin.readline

a,b,c = map(str,input().split())
sm, ss = map(int,a.split(':'))
em, es = map(int,b.split(':'))
fm, fs = map(int,c.split(':'))
start = sm * 60 + ss
end = em * 60 + es
finish = fm * 60 + fs

start_set = set()
end_set = set()

while True:
    try:
        time, name = map(str, input().split())
        m, s = map(int,time.split(':'))
        if m*60+s <= start:
            start_set.add(name)
        elif end <= m*60+s <= finish:
            end_set.add(name)
    except:
        break

print(len(start_set&end_set))

