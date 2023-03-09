class BSTree<E extends Comparable<E>>{
    
    class Cell<E extends Comparable<E>>{
        E root;
        Cell<E> left;
        Cell<E> right;

        Cell(){
            root = null;
            left = null;
            right = null;
        }

        public void add(E obj){
            
            if (root==null){ root = obj; }
            else if (root.compareTo(obj) < 0) { 
                if (right == null) {right = new Cell<E>(); }
                right.add(obj); 
            } else {
                if (left == null) {left = new Cell<E>(); }
                left.add(obj);
            }
        }
    }

    Cell<E> c;

    private BSTree(Cell<E> nc){
        c = nc;
    }

    private BSTree(){
        c = new Cell<E>();
    }

    public E root(){ return c.root; }

    public BSTree<E> left(){ return new BSTree<E>(c.left); }

    public BSTree<E> right(){ return new BSTree<E>(c.right); }

    public boolean isEmpty(){ return (c.root == null); }

    public static <E extends Comparable<E>> BSTree<E> empty(){ 
        return new BSTree<E>();
    }

    public BSTree<E> add(E obj){
        BSTree<E> neu = new BSTree(c);
        neu.c.add(obj);
        return neu;
    }

    public boolean contains(E obj){
        return containsR(obj, c);
    }

    private boolean containsR(E obj, Cell<E> c){
        E r = c.root;
        int x = r.compareTo(obj);

        switch (x){
            case (0): return true; 
            case (1): 
                if (c.left==null) { return false; }
                else { return containsR(obj, c.left); }
            case (-1):
                if (c.right==null){ return false; }
                else { return containsR(obj, c.right); }
        }
        return false;
    }


    public BSTree<E> remove(E obj){
        return removeR(obj, c, new BSTree());
        
    } 

    private BSTree<E> removeR(E obj, Cell<E> ptr, BSTree<E> neu){
        
        System.out.println(ptr.root);

        if (ptr.left==null && ptr.right==null){ // end of branch.
            if (ptr.root.compareTo(obj)==0){ return neu.add(ptr.root); }
            else { neu.add(ptr.root); return neu; }

        } else if (ptr.left==null){
            if (ptr.root.compareTo(obj)==0){
                neu.add(ptr.right.root);
                return neu;
            }
            else if (ptr.root.compareTo(obj)>0){ return neu.add(ptr.root); }
            else {return removeR(obj, ptr.right, neu.add(ptr.root));}
        }
        else if (ptr.right==null){
            if (ptr.root.compareTo(obj)==0){
                neu.add(ptr.left.root);
                return neu;
            }
            else if (ptr.root.compareTo(obj)<0){ return neu.add(ptr.root); }
            else {return removeR(obj, ptr.left, neu.add(ptr.root));}

        } else {
            if (ptr.root.compareTo(obj)==0){ 
                neu.add(ptr.right.root);
                return neu;
            }
            else if (ptr.root.compareTo(obj)>0){ return removeR(obj, ptr.left, neu.add(ptr.root)); }
            else { return removeR(obj, ptr.right, neu.add(ptr.root));}
        }

            
    }
        

}
