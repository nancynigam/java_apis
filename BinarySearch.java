/**
 * @Date 18/04/2020
 * @author Nancy Nigam
 * Question : implement BinarySearch
 * Link : https://leetcode.com/problems/search-insert-position/
 * First mentioned a few important Collections api related to binary search and then what the implementation would have been like ..
**/

/**
* Most basic example of using Binary search collections API..
* Searches the specified list for the specified object using the binary search algorithm. The list must be sorted into ascending order 
* according to the specified comparator (as by the sort(List, Comparator) method), prior to making this call. If it is not sorted, the 
* results are undefined. If the list contains multiple elements equal to the specified object, there is no guarantee which one will be found.
* For the element not present : return (-idx-1)
* If no special comparator is mentioned, it sorts according to normal acsending order. Collections.reverseOrder() to sort in decreasing order.
* https://docs.oracle.com/javase/7/docs/api/java/util/Collections.html#binarySearch(java.util.List,%20T,%20java.util.Comparator)
* https://www.geeksforgeeks.org/collections-binarysearch-java-examples/ -> describes the 3 comparator.
* Arrays.binarysearch() works for arrays which can be of primitive data type also. Collections.binarysearch() works for objects Collections like ArrayList and LinkedList.
**/

import java.util.*;
class Solution {
    public int searchInsert(int[] nums, int target) {
        List<Integer> ls = new ArrayList<>();
        for(Integer i:nums)
            ls.add(i);
        int idx = Collections.binarySearch(ls,target);
        if(idx<0)
            return (-1-idx);
        else
            return idx;
    }
}




/**
* Implementation of the binary search API with a slight change in the return of index of element which is not present.
**/
class BinarySearch {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length<=0)
            return 0;
        return binarySearch(0,nums.length-1,nums,target);
    }
    
    public int binarySearch(int first, int last, int[] nums, int target){
        if(first <= last){
            int mid = Integer.valueOf(first+last)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid]<target)
                return binarySearch(mid+1,last,nums,target);
            else
                return binarySearch(first,mid-1,nums,target);

        }
        return first;
    }
}
