from collections import deque

dx=[0,0,1,-1]
dy=[1,-1,0,0]
M,N=map(int,input().split())

def bfs(tomato,i,j):
    queue=deque()
    date=0

    queue.append((i,j,0))
    while queue:
        x,y,day=queue.popleft()
        for pos in range(4):    
            nx=x+dx[pos]
            ny=y+dy[pos]
            if nx>=N or nx<0 or ny>=M or ny<0:
                continue
            if tomato[nx][ny]==0:
                tomato[nx][ny]=1
                queue.append((nx,ny,day+1))
                date=day+1
    return date

tomato=[]
for i in range(N):
    tomato.append(list(map(int,input().split())))
print(tomato)
for i in range(N):
    for j in range(M):
        if tomato[i][j]==1:
            ans=bfs(tomato,i,j)
for i in range(N):
    for j in range(M):
        if tomato[i][j]==0:
            ans=-1
            break

print(ans)
