class Solution {
    public int maxArea(int[] height) {
       int left=0;
       int right=height.length-1;
       int max=0;
       while(left<right)
       {
        int h= Math.min(height[right],height[left]);
       int  width=right - left;
        int area=h*width;
        if(area>max)
        {
            max=area;
        }
        if(height[right]<height[left])
        {
            right--;
        }
        else
        {
            left++;
        }

       }
       return max;
        
}
}