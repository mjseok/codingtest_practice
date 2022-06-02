from collections import deque

#상하좌우
dx=[0,0,1,-1]
dy=[1,-1,0,0]
M,N=map(int,input().split())
# 익은 토마토
queue=deque()

def bfs(tomato):
    #토마토 익는데 걸리는 시간
    date=0
    while queue:
        x,y,day=queue.popleft()
        #상하좌우 토마토만
        for pos in range(4):    
            nx=x+dx[pos]
            ny=y+dy[pos]
            if nx>=N or nx<0 or ny>=M or ny<0:
                continue
            #안 익은 토마토
            if tomato[nx][ny]==0:
                #익음
                tomato[nx][ny]=1
                #익은 토마토와 걸린 시간
                queue.append((nx,ny,day+1))
                date=day+1
    return date

tomato=[]
#입력
for i in range(N):
    tomato.append(list(map(int,input().split())))
for i in range(N):
    for j in range(M):
        #익은 토마토부터 시작하니까
        if tomato[i][j]==1:
            queue.append((i,j,0))
ans=bfs(tomato)
#안 익은 토마토가 있으면 실패(-1)
for i in range(N):
    for j in range(M):
        if tomato[i][j]==0:
            ans=-1
            break

print(ans)
