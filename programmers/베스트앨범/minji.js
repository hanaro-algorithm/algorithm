// 각 장르별 2개씩 베스트앨범에 수록
// 1. 장르 별 속한 노래가 많이 재생된 장르 먼저 수록
// 2. 장르 내 많이 재생된 노래 먼저 수록
// 3. 재생횟수가 같으면 고유번호 낮은 것부터 먼저 수록

// genres가 Map에 존재하면 해당 키의 배열에 추가
// genres 별로 내림차순 정렬 => 먼저 play 수가 많은 것부터, 같으면 인덱스가 낮은 것부터

function solution(genres, plays) {
  let answer = [];
  let albums = new Map();

  genres.map((genre, idx) => {
    if (!albums.has(genre)) albums.set(genre, [[plays[idx], idx]]);
    else albums.set(genre, [...albums.get(genre), [plays[idx], idx]]);
  });

  let totalPlayGenres = [];
  [...albums.entries()].forEach((album) => {
    let total = album[1].reduce((acc, cur) => (acc += cur[0]), 0);
    totalPlayGenres.push([total, album[0]]);
  });
  totalPlayGenres.sort((a, b) => b[0] - a[0]);

  totalPlayGenres.map((genre) => {
    albums.get(genre[1]).sort((a, b) => b[0] - a[0]);
    if ([...albums.get(genre[1])].length >= 2) {
      answer.push(albums.get(genre[1])[0][1]);
      answer.push(albums.get(genre[1])[1][1]);
    } else {
      answer.push(albums.get(genre[1])[0][1]);
    }
  });

  return answer;
}

console.log(
  solution(
    ['classic', 'pop', 'classic', 'classic', 'pop'],
    [500, 600, 150, 800, 2500]
  )
); // [4, 1, 3, 0]
