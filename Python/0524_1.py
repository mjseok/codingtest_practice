T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    answer=0
    buildings=list(map(int,input().split()))
    for idx,building in enumerate(buildings):
        if(building>0):
            maxN=max(buildings[idx-2],
            buildings[idx-1],
            buildings[idx+1],
            buildings[idx+2])
            if(maxN<building):
                answer+=(building-maxN)
    print(f'#{test_case} {answer}')