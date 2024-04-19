import math

def solution(fees, records):
    global basic_time, basic_fee, part_time, part_fee
    answer = []
    basic_time, basic_fee, part_time, part_fee = fees

    history = dict()

    for record in records:
        time, car_number, in_out = record.split(" ")
        if car_number not in history:
            history[car_number] = [0, time]  # [total 시간, 입차 시간]
            continue

        if in_out == "IN":
            history[car_number][1] = time  # 입차 시간
        else:
            in_time = history[car_number][1]
            history[car_number][0] += stringToTime(in_time, time)  # total 시간 연산
            history[car_number][1] = 0

    for key, value in sorted(history.items()):
        if value[1] == 0:
            answer.append(calculateFee(value[0]))
        else:
            total_time = value[0] + stringToTime(value[1], '23:59')
            answer.append(calculateFee(total_time))

    return answer


def stringToTime(in_time, out_time):
    start_hour, start_min = list(map(int, in_time.split(':')))
    end_hour, end_min = list(map(int, out_time.split(':')))

    start_time = start_hour * 60 + start_min
    end_time = end_hour * 60 + end_min

    total_min = end_time - start_time
    return total_min


def calculateFee(total_time):
    diff = total_time - basic_time

    if diff <= 0:
        return basic_fee
    else:
        total_fee = basic_fee + math.ceil(diff / part_time) * part_fee
        return total_fee