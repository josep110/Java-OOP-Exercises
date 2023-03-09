class ListSet<E>{
    class ListSetIterator<E> implements Iterator<E>{

        int ptr;

        ListSetIterator(){
            ptr = -1;
        }

        public boolean hasNext(){
            if (ptr >= len-1){ return false; }
            else { return true; }
        }

        public E next(){
            if (hasNext()) { return (E)arr[++ptr]; }
            else { return null; }
        }

        public void remove(){
            ListSet.this.remove(arr[ptr]);
        }
    
    }

    Object[] arr;
    int len;

    ListSet(){
        arr = new Object[0];
        len = 0;
    }

    public <E> boolean contains(E val){
        for (int i=0;i < len;i++){
            if (arr[i].equals(val)){
                return true;
            }
        }
        return false;
    }

    public <E> boolean add(E val){
        if (!contains(val)){
            Object[] newA = new Object[len+1];
            for (int i=0;i < len;i++){
                newA[i] = arr[i];
            }
            newA[len] = val;
            arr = newA;
            len++;
            return true;
        } else { return false; }
    }

    public <E> boolean remove(E val){
        if (!contains(val)){
            return false;
        } else {
            int j = 0;
            Object[] newA = new Object[len-1];
            for (int i=0;i < len;i++){
                if (!arr[i].equals(val)){
                    newA[j++] = arr[i]; 
                }
            }
            arr = newA;
            len--;
            return true;
              
        }
    }

    public int size(){
        return len;
    }

    public String toString(){
        String out = "[";
        for (int i=0;i < len;i++){
            out = out + arr[i] + " , ";
        }
        out = out + "]";
        return out;
    }

    public boolean equals(ListSet a){
        if (a.size() != len){ return false; }
        for (int i=0;i < len;i++){
            if (!a.contains(arr[i])){
                return false;
            }
        }
        return true;
    }

    public <E> Iterator<E> iterator(){
        return new ListSetIterator();
    }

}

