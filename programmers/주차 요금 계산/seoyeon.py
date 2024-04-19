import math
from collections import defaultdict

def solution(fees, records):
    answer = []
    table = defaultdict(list)
    
    for i in range(len(records)):
        time,number,state = records[i].split()
        minutes = int(time[:2]) * 60 + int(time[3:])
        table[number].append(minutes)
    
    for i in table :
        if ( len(table[i] ) % 2 == 1 ) :
            table[i].append(23*60+59)
    
    cars = sorted(table.keys())
    
    for c in cars :
        money = 0
        time = sum(table[c][1::2]) - sum(table[c][::2])
        if time > fees[0] :
            money += fees[1] + math.ceil((time - fees[0]) / fees[2]) * fees[3]
        else :
            money += fees[1]
        
        
        answer.append(money)

    return answer