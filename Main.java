class OrderedStream {
    int ptr = 1; // Used just like in the animation to mark the next gap
    String[] values;
    List<String> valueList;
    
    public OrderedStream(int n) {
        values = new String[n];
        valueList = Arrays.asList(values); // Backed by same array, allows us to use subList
    }
    
    public List<String> insert(int idKey, String value) {
        values[idKey - 1] = value;
        if (idKey == ptr) {
            int oldPtr = ptr;
            while (ptr <= values.length && values[ptr - 1] != null) ptr++;
            
            List<String> retVal = valueList.subList(oldPtr - 1, ptr - 1);
            return retVal;
        }
        return Collections.emptyList();
    }
}
