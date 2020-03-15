Sorting Map by keys : Use TreeMaps
Collections.sort can only take list as input. Hence, when we apply comparator on map we create a list of Map.Entry to sort it.
In the comparator method the 2 elements that are compared are Map.Entry elements.
To get a map that is sorted we'll have to create it by combining elements from the list.

When implementing Comparable<> -> override compareTo() method.
When implementing Comparator<> -> override compare() method.

Some implementations valid for both :

// For Integers
@Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        if(o1.getValue() < o2.getValue()) return -1;
        else if(o1.getValue() > o2.getValue()) return 1;
        else return 0;
    }
  
// For Integers
@Override
    public int compareTo(Location loc){
        if(this.x != loc.x)
            return Integer.compare(this.x,loc.x);
        else if (this.y != loc.y)
            return Integer.compare(this.y,loc.y);
        else
            return Integer.compare(this.val, loc.val);
    }
    
 // For Integer
 @Override
    public int compareTo(Movies o) {
        return this.year - o.year;
    }
    
 // For String (to arrange lexicographically.. Also this is case sensitive)
 @Override
    public int compare(Movies o1, Movies o2) {
        return o1.getName().compareTo(o2.getName());
    }
    
    
