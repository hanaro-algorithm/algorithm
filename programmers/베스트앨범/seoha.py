def play_sort(arr, plays):
    sorted_arr = []
    temp=[]
    for a in arr:
        temp.append([a,plays[a]])
    temp.sort(key=lambda x:x[1], reverse=True)
    for i in temp:
        sorted_arr.append(i[0])
    return sorted_arr


def solution(genres, plays):
    answer=[]
    total_dict = {} #{"classic":3,~}
    split_dict = {}
    for i in range(len(genres)):
        if genres[i] in total_dict:
            total_dict[genres[i]]+=plays[i]
        else:
            total_dict[genres[i]]=plays[i]
    sorted_genres=sorted(total_dict, key=total_dict.get, reverse = True)

    for index, genre,  in enumerate(genres):
        if genre in split_dict:
            arr=split_dict[genre]
            arr.append(index)
            split_dict[genre]=play_sort(arr,plays)
        else:
            split_dict[genre]=[index]

    for genre in sorted_genres:
        if len(split_dict[genre])==1:
            answer.append(split_dict[genre][0])
        else:
            answer.append(split_dict[genre][0])
            answer.append(split_dict[genre][1])

    return answer


genres = ["classic", "pop", "classic", "classic", "pop"]
plays = [500, 600, 150, 800, 2500]

print(solution(genres, plays))
