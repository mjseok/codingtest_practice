from collections import deque


def check(place):
    startList=[]
    for i in range(5):
        for j in range(5):
            if place[i][j]=='P':
                startList.append([i,j])
    
    for start in startList:
        queue=deque([start])
        visited = [[False]*5]*5   # 방문 처리 리스트
        distance = [[0]*5]*5  # 경로 길이 리스트
        
        visited[start[0]][start[1]]=True

        while queue:
            tmpy,tmpx=queue.popleft()
            dx=[-1,1,0,0]
            dy=[0,0,-1,1]

            for i in range(4): #상하좌우 확인
                x=tmpx+dx[i]
                y=tmpy+dy[i]
                
                if 0<=x<5 and 0<=y<5 and not visited[y][x]:
                    if place[y][x]=='O': #탐색 중에 만난게 O일 경우
                        queue.append([y,x]) #O는 탄색가능하니까 추가
                        visited[y][x]=True
                        distance[y][x]=distance[tmpy][tmpx]+1 #상하좌우 중 하나니까 거리는 +1
                    
                    if place[y][x]=='P' and distance[tmpy][tmpx]<=1: #탐색 중에 만난게 P일 경우 맨하튼 거리 고려
                        return False
    return True

def solution(places):
    answer = []
    for place in places:
        if check(place):
            answer.append(1)
        else:
            answer.append(0)
    return answer

print(solution([["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]))