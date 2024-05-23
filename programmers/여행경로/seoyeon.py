from collections import defaultdict

def solution(tickets):
    t_dict = defaultdict(list)
    
    for s, e in tickets:
        t_dict[s].append(e)
    for t_key in t_dict.keys():
        t_dict[t_key].sort(reverse = True)
    
    answer = []
    path = ["ICN"]
    
    while path:
        now = path[-1]
        if now not in t_dict or len(t_dict[now]) == 0:
            answer.append(path.pop())
        else:
            path.append(t_dict[now].pop())
    
    return answer[::-1]