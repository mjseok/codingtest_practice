N=int(input())
cnt=[0]
def dfs(queenPos,curCol):
    #같은 col에 있으면 안됨
    if curCol in queenPos:
        return
    #지금 확인하고 있는 row
    curRow=len(queenPos)
    #대각선에 있는지 확인
    for row,col in enumerate(queenPos):
        #대각선에 있는지 확인
        if abs(row-curRow)==abs(col-curCol):
            return
    #대각선에 없으면 
    queenPos.append(curCol)
    #퀸을 다 자리에 놓았으면 방법+1
    if len(queenPos)==N:
        cnt[0]+=1
    #다음 퀸 자리에 앉히기
    for col in range(N):
        dfs(queenPos[:],col)
#맨 처음 퀸의 위치
for start in range(N):
    queenPos=[] # idx=row, value=column
    dfs(queenPos,start)
print(cnt[0])