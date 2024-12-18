from itertools import combinations

H, W = map(int, input().split())

S = []
for _ in range(int(input())):
    r, c = map(int, input().split())
    if (r<=H and c<=W) or (c<=H and r<=W):
        S.append([r,c])

result = 0
for com in combinations(S, 2):
    r1, c1, r2, c2 = com[0][0], com[0][1], com[1][0], com[1][1]
    if (r1+r2<=H and max(c1,c2)<=W) or (r1+r2<=W and max(c1,c2)<=H):
        result = max(result, r1*c1 + r2*c2)
    elif (r1+c2<=H and max(c1,r2)<=W) or (r1+c2<=W and max(c1,r2)<=H):
        result = max(result, r1*c1 + r2*c2)
    elif (c1+r2<=H and max(r1,c2)<=W) or (c1+r2<=W and max(r1,c2)<=H):
        result = max(result, r1*c1 + r2*c2)
    elif (c1+c2<=H and max(r1,r2)<=W) or (c1+c2<=W and max(r1,r2)<=H):
        result = max(result, r1*c1 + r2*c2)

print(result)