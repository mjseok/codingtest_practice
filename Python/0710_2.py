T=int(input())
for tc in range(1,T+1):
    arr=[]
    for i in range(9):
        arr.append(list(map(int,input().split())))
    
    ans=1
    for i in range(9):
        checkR=[]
        checkC=[]
        for j in range(9):
            if arr[i][j] not in checkR:
                checkR.append(arr[i][j])
            if arr[j][i] not in checkC:
                checkC.append(arr[j][i])
        if len(checkR)!=9 or len(checkC)!=9:
            ans=0
            break
    print(f'#{tc}')
    print(ans)

