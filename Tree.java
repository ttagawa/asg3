import static java.lang.System.*;

class Tree {

    private class Node {
        String key;
        Queue<Integer> value;
        Node left;
        Node right;
    }
    private Node root;

    private void debugHelper(Node tree, int depth) {
        if(tree!=null){
            debugHelper(tree.left,depth);
            depth++;
            String temp="";
            for(int i=0;i<=depth;i++){
                if(i!=depth)
                    temp+="  ";
                else
                    temp+=depth+" ";
            }
            System.out.println(temp + tree.key);
            debugHelper(tree.right,depth);
        }
    }

    private void outputHelper(Node tree) {
        if(tree!=null){
            outputHelper(tree.left);
            String line = tree.key+" : ";
            for(Integer i:tree.value){
                line+=i+" ";
            }
            System.out.println(line);
            outputHelper(tree.right);
        }
    }

    public void insert(String key, Integer linenum) {
        if(finder(key)==null){
            Node newN = new Node();
            newN.key=key;
            newN.value=new Queue<Integer>();
            newN.value.insert(linenum);
            if(root==null){
                root=newN;
            }else{
                Node parent=null;
                Node cur=root;
                while(cur!=null){
                    if(key.compareTo(cur.key)<0){
                        parent=cur;
                        cur=cur.left;
                    }else{
                        parent=cur;
                        cur=cur.right;
                    }
                }

                if(key.compareTo(parent.key)<0)
                    parent.left=newN;
                else
                    parent.right=newN; 
            }
        }else{
        Node temp=finder(key);
        temp.value.insert(linenum);
    }
}
    public Node finder(String key){
        if(root==null){
            return null;
        }
        Node cur=root;
        while(!cur.key.equals(key)){
        if(key.compareTo(cur.key)<0)
            cur=cur.left;
        else
            cur=cur.right;
        if(cur==null)
            return null;
    }
    return cur;
}
    public void debug() {
        // Show debug output of tree
        debugHelper(root, 0);
    }

    public void output() {
        // Show sorted words with lines where each word appears
        outputHelper(root);
    }
    public Node getRoot(){
        return root;
    }

}
