def solution(N):
    leds=[6,2,5,5,4,5,6,3,7,6]
    d=[0 for _ in range(51)]
    for i in range(1,len(leds)):
        d[leds[i]]+=1
    for i in range(1,N):
        for led in leds:
            if i+led <=N:
                d[i+led]+=d[i]
    d[6]+=1
    return d[N]
print(solution(6))