T=int(input())
for tc in range(1,T+1):
    N,M=map(int,input().split())
    if(N>M):
        long=N
        short=M
        A=list(map(int,input().split()))
        B=list(map(int,input().split()))
    else:
        long=M
        short=N
        B=list(map(int,input().split()))
        A=list(map(int,input().split()))
    max=0
    for i in range(long-short+1):
        tmp=0
        for j in range(short):
            tmp+=B[j]*A[j+i]
        if max<tmp:
            max=tmp
    print(f'#{tc} {max}')
            



