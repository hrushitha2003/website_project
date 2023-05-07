import java.util.*;
class tnode
{
    int data;
    tnode lchild;
    tnode rchild;
}

class BST
{
    tnode create(tnode root,int x)
    {
        tnode nn,cur,prev=null;
        nn=new tnode();
        nn.data=x;
        nn.lchild=null;
        nn.rchild=null;
        if(root==null)
        {
            root=nn;
            return root;
        }
        cur=root;

        while(cur!=null)
        {
            prev=cur;
            if(x<cur.data)
            cur=cur.lchild;
            else
            cur=cur.rchild;
        }

        if(x<prev.data)
        prev.lchild=nn;
        else
        prev.rchild=nn;

        return root;
    }

    void inorder(tnode root)
    {
        if(root!=null)
        {
            inorder(root.lchild);
            System.out.print(root.data+" ");
            inorder(root.rchild);
        }
    }
    void levelorder(tnode root)
    {
        tnode t=new tnode();
        if(root==null)
        {
            System.out.println("Tree is empty");
            return;
        }
        Queue<tnode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            t=q.poll();
            System.out.print(t.data+" ");
            if(t.lchild!=null)
            q.offer(t.lchild);
            if(t.rchild!=null)
            q.offer(t.rchild);
        }
        System.out.println();
    }

    void lonelynodes(tnode root)
    {
        tnode t=new tnode();
        if(root==null)
        {
            System.out.println("Tree is empty");
            return;
        }
        List<Integer> ln=new LinkedList<>();
        Queue<tnode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            t=q.poll();
            if(t.lchild!=null)
            {
                if(t.rchild==null)
                ln.add(t.lchild.data);
            q.offer(t.lchild);
            }
            if(t.rchild!=null)
            {
                if(t.lchild==null)
                ln.add(t.rchild.data);
            q.offer(t.rchild);
            }
        }
        System.out.println(ln);
    }
    int height(node root)
    {
        if(root==null)
          return 0;
        else{
            return 1+math.max(height(root.lchild),height(root.rchild));
        }
    }



    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        tnode root=new tnode();
        root=null;
        BST b=new BST();
        while(true)
        {
            System.out.println("\n1.create");
            System.out.println("2.inorder");
            System.out.println("3.levelorder");
            System.out.println("4.lonely nodes");
            System.out.println("5.exit");
            System.out.println("Enter choice");
            int ch=s.nextInt();
            switch(ch)
            {
                case 1:System.out.println("Enter a value");
                        int x=s.nextInt();
                        root=b.create(root,x);
                        break;
                case 2:b.inorder(root);
                        System.out.println();
                        break;
                case 3:b.levelorder(root);
                        break;
                case 4:b.lonelynodes(root);
                        break;
                case 5:b.height(root);
                        break;
                case 6:System.exit(0);
            }
        }
    } 
}