from collections import deque
def bfs(map,i,j,h,w):
    visited=[[0]*w for _ in range(h)]
    dx=[0,0,1,-1]
    dy=[1,-1,0,0]
    queue=deque()
    queue.append((i,j,0))
    visited[i][j]=1
    distance=0
    while queue:
        x,y,d=queue.popleft()
        for pos in range(4):
            nx=dx[pos]+x
            ny=dy[pos]+y
            if nx>=h or nx<0 or ny>=w or ny<0:
                continue
            if map[nx][ny]=='L' and visited[nx][ny]==0:
                visited[nx][ny]=1
                queue.append((nx,ny,d+1))
                distance=d+1
    return distance

h,w=map(int,input().split())
distance=[]
map=[]
for i in range(h):
    map.append(list(input()))
for i in range(h):
    for j in range(w):
        if map[i][j]=='L':
            distance.append(bfs(map,i,j,h,w))
print(max(distance))