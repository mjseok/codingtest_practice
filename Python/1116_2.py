def solution(absolutes, signs):
    answer = 0
    for idx,val in enumerate(absolutes):
        if signs[idx]=='false':
            answer-=val
        else:
            answer+=val
    return answer
