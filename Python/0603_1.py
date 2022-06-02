from collections import deque

m,n,h=map(int,input().split())
queue=deque()
dx=[0,0,1,-1]
dy=[1,-1,0,0]
tomato=[]

def bfs():
    date=0
    while queue:
        x,y,d=queue.popleft()
        up=x+n
        down=x-n
        if up<h*n and up>=0 and tomato[up][y]==0:
            tomato[up][y]=1
            queue.append((up,y,d+1))
            date=d+1
        if down<h*n and down>=0 and tomato[down][y]==0:
            tomato[down][y]=1
            queue.append((down,y,d+1))
            date=d+1

        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if nx>=n*h or nx<0 or ny>=m or ny<0:
                continue
            if tomato[nx][ny]==0 and nx//n==x//n:
                tomato[nx][ny]=1
                queue.append((nx,ny,d+1))
                date=d+1
    return date
for i in range(n*h):
    tomato.append(list(map(int,input().split())))
for i in range(n*h):
    for j in range(m):
        if tomato[i][j]==1:
            queue.append((i,j,0))
ans=bfs()
for i in range(n*h):
    for j in range(m):
        if tomato[i][j]==0:
            ans=-1
            break
print(ans)


                


