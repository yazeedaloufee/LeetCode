/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> flattened;
    int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        flattened = new ArrayList<>();
        int index = 0; 
        dfs(nestedList, flattened);
    }
    public void dfs(List<NestedInteger> nested, List<NestedInteger> flat) {

        for(int i = 0; i < nested.size() ;i++) {
            NestedInteger nestedInteger = nested.get(i);

            if(nestedInteger.isInteger()) {
                flat.add(nestedInteger);
            } else {
                dfs(nestedInteger.getList(), flat);
            }
        }
    }

    @Override
    public Integer next() {
        if(index >= flattened.size()) return 0;

       return flattened.get(index++).getInteger(); 
    }

    @Override
    public boolean hasNext() {
        if( index < flattened.size()) {
            return true;
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */