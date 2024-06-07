def solution(genres, plays):
    answer = []
    genre_dic = {}
    play_dic = {}

    for i in range(len(genres)):
        genre_dic[genres[i]] = genre_dic.get(genres[i], 0) + plays[i]
        play_dic[genres[i]] = play_dic.get(genres[i], []) + [(plays[i], i)]

    sorted_genres = sorted(genre_dic.items(), key=lambda x: x[1], reverse=True)

    for genre, _ in sorted_genres:
        songs = sorted(play_dic[genre], key=lambda x: (-x[0], x[1]))

        for song in songs[:2]:
            answer.append(song[1])

    return answer