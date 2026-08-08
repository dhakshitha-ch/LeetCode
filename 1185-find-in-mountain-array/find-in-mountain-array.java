/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
public int findpeak(MountainArray mountainArr){
    int low=0;
       int high=mountainArr.length()-1;
       while(low< high)
       {

          int mid=low+(high-low)/2;
         if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }

       } 
       return low;
    }
      public int BSacending(MountainArray mountainArr,int low,int high,int target)
     {
        while(low<=high){
        int mid=low+(high-low)/2;
        
            int value = mountainArr.get(mid);
            if(value==target)
        {
            return mid;
           }
           else if( value <target)
           {
            low=mid+1;
           }
           else
           {
            high=mid-1;
           }
        }
           return -1;
        
    }
           
   
   public int BSdecresing(MountainArray mountainArr,int low,int high,int target)
     {
        while(low<=high){
        int mid=low+(high-low)/2;
        
            int value= mountainArr.get(mid);
            if(value==target)
        {
            return mid;
           }
           else if( value <target)
           {
            high=mid-1;
           }
           else
           {
            low=mid+1;
           }
        }
           return -1;
        
    }
    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        
    int peak=findpeak(mountainArr);
    int len=mountainArr.length();
    int ans=BSacending(mountainArr,0,peak,target);
    if(ans!=-1)
    {
        return ans;
    }

    return BSdecresing(mountainArr,peak+1,len-1,target);
    }
}