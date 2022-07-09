T=int(input())
for tc in range(1,T+1):
    arr=[]
    N=int(input())
    for i in range(N):
        arr.append(list(map(int,input().split())))
    dg90=[]
    dg180=[]
    dg270=[]
    for i in range(N):
        for j in range(N):
            dg90.append(arr[N-j-1][i])
            dg180.append(arr[N-i-1][N-j-1])
            dg270.append(arr[j][N-i-1])
    print(f'#{tc}')
    for i in range(N):
        ans=''
        for j in range(N):
            ans+=str(dg90[i*N+j])
        ans+=' '
        for k in range(N):
            ans+=str(dg180[i*N+k])
        ans+=' '
        for l in range(N):
            ans+=str(dg270[i*N+l])
        print(ans)