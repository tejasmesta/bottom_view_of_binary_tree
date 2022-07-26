class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        Map<Integer,Integer> map = new TreeMap<>();
        
        if(root==null)
        {
            return ans;
        }
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(root,0));
        
        while(!q.isEmpty())
        {
            Pair p = q.remove();
            
            Node rem = p.n;
            int l = p.level;
            
            map.put(l,rem.data);
            
            if(rem.left!= null)
            {
                q.add(new Pair(rem.left,l-1));
            }
            
            if(rem.right!=null)
            {
                q.add(new Pair(rem.right,l+1));
            }
        }
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            ans.add(entry.getValue());
        }
        
        return ans;
        
    }
    
    class Pair{
        Node n;
        int level;
        
        Pair(Node n,int level)
        {
            this.n = n;
            this.level = level;
        }
    }
}
