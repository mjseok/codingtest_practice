import math
n=int(input())
for i in range(n):
    x1,y1,r1,x2,y2,r2=map(int,input().split())
    d=math.sqrt((x2-x1)**2+(y2-y1)**2)
    ## 일치
    if d==0 and r1==r2:
        print(-1)
    # 내접 또는 외접(일치 조건 후에 해야함)
    elif d==r1+r2 or d==abs(r2-r1):
        print(1)
    elif abs(r2-r1)<d<r2+r1:
        print(2)
    else:
        print(0)