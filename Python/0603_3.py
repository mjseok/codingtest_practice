from collections import deque

R,C=map(int,input().split())
map=[]
# 방향
dx=[0,0,-1,1]
dy=[-1,1,0,0]

dir=deque()
water=deque()
for i in range(R):
    map.append(list(input()))

#물,고슴도치 둘 다 관리
for i in range(R):
    for j in range(C):
        if map[i][j]=='S':
            dir.append((i,j,0))
        if map[i][j]=='*':
            water.append((i,j))
def bfs():
    sec=0
    #자취를 남길때마다
    while dir:
        #그때 당시의 물 상태 업데이트
        for _ in range(len(water)):
            wx,wy=water.popleft()
            for i in range(4):
                wnx=wx+dx[i]
                wny=wy+dy[i]
                if wnx>=R or wnx<0 or wny>=C or wny<0:
                    continue
                if map[wnx][wny]=='.':
                    map[wnx][wny]='*'
                    water.append((wnx,wny))
        #그 때 당시의 자취 업데이트
        for _ in range(len(dir)):
            x,y,s=dir.popleft()
            for i in range(4):
                nx=x+dx[i]
                ny=y+dy[i]
                if nx>=R or nx<0 or ny>=C or ny<0:
                    continue
                if map[nx][ny]=='.':
                    map[nx][ny]='S'
                    dir.append((nx,ny,s+1))
                    sec=s+1
                if map[nx][ny]=='D':
                    sec=s+1
                    return sec
    return 'KAKTUS'
print(bfs())



