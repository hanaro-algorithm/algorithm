import math

def calcTime(inTime, outTime):
    inList = list(map(int, inTime.split(":")))
    outList = list(map(int, outTime.split(":")))
    if outList[1] - inList[1] < 0:
        result = (outList[0] - inList[0] - 1) * 60 + (60 + outList[1] - inList[1])
    else:
        result = (outList[0] - inList[0]) * 60 + (outList[1] - inList[1])
    return result

def calcFee(Time, baseFee, unitTime, unitFee):
    if Time <= 0:
        return baseFee
    else:
        return baseFee + math.ceil(Time / unitTime) * unitFee

def solution(fees, records):
    dic = {} # 출입 현황 저장
    timeDic = {} # 차량별 총 시간 저장
    result = []

    for str in records:
        time, number, status = str.split()
        if status == 'IN':
            dic[number] = time
        elif status == 'OUT':
            inTime = dic[number]
            outTime = time
            if number in timeDic:
                timeDic[number] += calcTime(inTime, outTime)
            else:
                timeDic[number] = calcTime(inTime, outTime)
            del dic[number]

    for k, v in dic.items():
        if k in timeDic:
            timeDic[k] += calcTime(v, '23:59')
        else:
            timeDic[k] = calcTime(v, '23:59')

    timeDic = sorted(timeDic.items())

    for totalTime in timeDic:
        result.append(calcFee(totalTime[1] - fees[0], fees[1], fees[2], fees[3]))

    return result


res = solution([180, 5000, 10, 600],
               ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"])
print(res)
