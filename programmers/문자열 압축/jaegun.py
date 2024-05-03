def compress(text, length):
    compressed = ""
    count = 1

    for i in range(0, len(text), length):
        current = text[i:i + length]
        next_sub = text[i + length:i + 2 * length]
        if current == next_sub:
            count += 1
        else:
            if count > 1:
                compressed += str(count) + current
            else:
                compressed += current
            count = 1
    return compressed


def solution(s):
    min_length = len(s)
    for l in range(1, len(s) // 2 + 1):
        compressed_version = compress(s, l)
        min_length = min(min_length, len(compressed_version))

    return min(min_length, len(s))