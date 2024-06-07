from itertools import product, combinations

def solution(clothes):
    answer=0
    clothes_dict={}
    for arr in clothes:
        if arr[1] in clothes_dict:
            temp=clothes_dict[arr[1]]
            temp.append(arr[0])
            clothes_dict[arr[1]]=temp
        else:
            clothes_dict[arr[1]]=[arr[0]]

    for i in range(1,len(clothes_dict.keys())+1):
        for combo in combinations(clothes_dict.values(), i):
            answer+=len(list(product(*combo)))

    return answer

arr=[["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]
arr2=[["a", "headgear"], ["b", "headgear"], ["c", "eyewear"], ["d", "eyewear"], ["e", "face"], ["f", "face"]]
print(solution(arr2))