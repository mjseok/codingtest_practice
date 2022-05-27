T=int(input())
for test_case in range(1,T+1):
    num,change=input().split()
    change=int(change)
    numLst=list(map(int,num))
    for i in range(change):
        maxN=numLst.index(max(numLst[i+1:]))
        print(max(numLst[1:]))
        numLst[i],numLst[maxN]=numLst[maxN],numLst[i]
    print(numLst)
    
    #print(f'#{test_case} {answer}')
#최대 상금 문제(bfs,dfs공부 필요)