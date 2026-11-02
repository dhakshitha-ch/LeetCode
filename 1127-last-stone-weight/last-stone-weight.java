class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq =
    new PriorityQueue<>(Collections.reverseOrder());
    for(int i=0;i<stones.length;i++)
    {
        pq.offer(stones[i]);
    }
    while(pq.size() >1)
    {
        int x= pq.poll();
        int y = pq.poll();
        if(x==y)
        {
                continue;
        }
        else
        {
          pq.offer(x-y);
        }
    }
    if(pq.isEmpty())
    return 0;
     else
    return pq.poll();
    }
}