n = int(input())
room = [list(input().rstrip()) for _ in range(n)]

h, v = 0, 0
for i in range(n):
    h_cnt, v_cnt = 0, 0
    for j in range(n):   
        if room[i][j]=='.':  #가로 체크
            h_cnt += 1
            if h_cnt == 2:
                h += 1
        else:
            h_cnt = 0
            
        if room[j][i]=='.':  #세로 체크
            v_cnt += 1
            if v_cnt == 2:
                v += 1
        else:
            v_cnt = 0    
        
print(h, v)