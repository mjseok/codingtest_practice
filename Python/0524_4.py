from collections import deque
count=[]

def bfs(appartment,i,j):
    n=len(appartment)
    dx=[0,0,1,-1]
    dy=[1,-1,0,0]
    visited=deque()
    visited.append([i,j])
    appartment[i][j]=0
    count=1
    while visited:
        x,y=visited.popleft()
        for pos in range(4):
            nx=dx[pos]+x
            ny=dy[pos]+y
            if nx<0 or nx>=n or ny<0 or ny>=n:
                continue
            if appartment[nx][ny]==1:
                appartment[nx][ny]=0
                visited.append([nx,ny])
                count+=1
    return count


N=int(input())
appartment=[]
for i in range(N):
    appartment.append(list(map(int,input())))

for i in range(N):
    for j in range(N):
        if appartment[i][j]==1:
            count.append(bfs(appartment,i,j))
count.sort()
print(len(count))
for c in count:
    print(c)