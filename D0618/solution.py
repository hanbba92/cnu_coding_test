N= int(input())
sols=[int(x) for x in input().split()]

def quick_sort(array):

    if len(array) <= 1:
        return array
    
    pivot = array[0]
    tail = array[1:]

    left_side = [x for x in tail if x <= pivot]
    right_side = [x for x in tail if x > pivot]

    return quick_sort(left_side) + [pivot] + quick_sort(right_side)

sols = quick_sort(sols)
       

def binary_search(N, array, start, end, closest_num, min_diff):
    if start > end:
        return array.index(closest_num)

    mid = (start+end) // 2

    if mid > 0 : 
        min_diff_left = abs(array[mid-1])
    
    if mid + 1 <= N:
        min_diff_right = abs(array[mid+1])

    if min_diff_left < min_diff :
        min_diff = min_diff_left
        closest_num = array[mid-1]
    
    if min_diff_right < min_diff:
        min_diff = min_diff_right
        closest_num = array[mid+1]

    if array[mid] < 0 :
        return binary_search(N, array, mid + 1, end, closest_num, min_diff)
    elif array[mid] > 0 :
        return binary_search(N, array, start, mid-1, closest_num, min_diff)
    else:
        return array.index(0)


def find_sol(sols, N):
    if sols[0] >= 0:
        return sols[0]+ sol[1]
    elif sols[-1] <= 0:
        return sols[-1]+sols[-2]
    else:
        pairs=[]
        for idx, a in enumerate(sols):
            for b in sols[idx+1:]:
                pairs.append((a,b))
        sum_list = []
        
        for pair in pairs:
            sum_list.append(sum(pair))

        min_diff= int(1e9)
        closest_num=None
        sum_index = binary_search(N, sum_list, 0, N-1, closest_num, min_diff)

        return pairs[sum_index]

a,b=find_sol(sols,N)
print(a,b)