function solution(numbers){
    var answer=new Set();
    var tmp=[]
    const getPermutation=(arr,str)=>{
        for(let i=0;i<arr.length;i++){
            let tmp=[...arr];
            tmp.splice(i,1)
            getPermutation(tmp,str+arr[i])
        }
        if(str>0) answer.add(Number(str))
    }
    getPermutation([...numbers],'')
    tmp=[...answer]
    tmp=tmp.filter(v=>{
        n=0;
        for(let i=1;i<=v;i++){
            if(parseInt(v)%i===0) n+=1
        }
        if(n===2) return parseInt(v)
    })
    console.log(tmp)
    
    return tmp.length;
}
console.log(solution("011"))