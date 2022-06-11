def solution(bridge_length, weight, truck_weights):
    time = 0
    bridge=[0 for _ in range(len(truck_weights))]
    while bridge:
        time+=1
        bridge.pop(0)

        if truck_weights:
            if sum(bridge)+truck_weights[0]<=weight:
                bridge.append(truck_weights.pop(0))
            else:
                bridge.append(0)
    return time