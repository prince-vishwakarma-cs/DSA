class StockSpanner {
    Stack<Integer> st;
    Map<Integer, Integer> mp;
    int index;

    public StockSpanner() {
        st = new Stack<>();
        mp = new HashMap<>();
        index = 0;
    }

    public int next(int price) {
        while (!st.isEmpty() && mp.get(st.peek()) <= price) {
            st.pop();
        }
        index++;
        mp.put(index, price);
        int span;
        if (st.isEmpty()) {
            span = index;
        } else {
            span = index - st.peek();
        }
        st.push(index);
        return span;
    }
}
