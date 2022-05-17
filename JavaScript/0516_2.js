//순열과 조합 알고리즘(소수 찾기에서 헷갈렸던 것)
const getPermutation=(arr,num)=>{
    const result=[];
    //1개씩 택할 때는 모든 배열의 원소 return 하면 됨
    if(num===1) return arr.map((value)=>[value])

    arr.forEach((current,idx,origin)=>{
        const fixed=current; //고정된 값 한개
        console.log(fixed)
        const restArr=[...origin.slice(0,idx),...origin.slice(idx+1)] //fixed 빼고 나머지
        const permutations=getPermutation(restArr,num-1);// 나머지로 순열 구하기
        const attached=permutations.map((permutation)=>[fixed,...permutation])//순열+fixed값
        result.push(...attached)
        console.log(result)
    });
    return result;
}
const getCombination=(arr,num)=>{
    const result=[];
    if(num===1) return arr.map((value)=>[value])
    arr.forEach((current,idx,origin)=>{
        const fixed=current;
        const restArr=origin.slice(idx+1)
        const combinations=getCombination(restArr,num-1)
        const attached=combinations.map((combination)=>[fixed,...combination]);
        result.push(...attached)
    })
    return result;
}
