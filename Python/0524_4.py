#다시 풀어보기
from collections import deque
dx=[0,0,1,-1]
dy=[1,-1,0,0]

def bfs(apartment,a,b):
    n=len(apartment)
    queue=deque()
    queue.append((a,b))
    apartment[a][b]=0
    cnt=1

    while queue:
        x,y=queue.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if nx<0 or nx>=n or ny<0 or ny>=n:
                continue
            if apartment[nx][ny]==1:
                apartment[nx][ny]=0
                queue.append((nx,ny))
                cnt+=1
    return cnt

N=int(input())
apartment=[]
for i in range(N):
   apartment.append(list(map(int,input())))
count=[]
for i in range(N):
    for j in range(N):
        if apartment[i][j]==1:
            count.append(bfs(apartment,i,j))
count.sort()
print(len(count))
for i in range(len(count)):
    print(count[i])
