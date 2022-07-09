T=int(input())
for tc in range(1,T+1):
    arr=[]
    N,M=map(int,input().split())
    for i in range(N):
        arr.append(list(map(int,input().split())))
    max=0
    for i in range(0,N-M+1):
        for j in range(0,N-M+1):
            fly=0
            for ii in range(M):
                for jj in range(M):
                    fly+=arr[i+ii][j+jj]
            if max<fly:
                max=fly
    print(f'#{tc} {max}')