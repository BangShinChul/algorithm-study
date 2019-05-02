import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Suffix Tree.
 */
/**
 * @Link : https://cs.nyu.edu/courses/spring14/CSCI-UA.0480-004/Lecture20Examples/SuffixTree.java
 * */
public class SuffixTree
{
    private static final int INF = Integer.MAX_VALUE-1;
    private int last;
    private String str;
    private Node root, sentinel;

    /**
     * Edge of the SuffixTree.
     * SuffixTree의 엣지.
     */
    public class Edge
    {
        /** An inclusive range [a,b] of indices into str representing the edge label. */
        /** 가장자리 레이블을 나타내는 str에 대한 인덱스의 포괄적 범위 [a, b]입니다. */
        public int a, b;

        /** Node where the edge points to */
        /** 가장자리가 가리키는 노드 */
        public Node end;
        public Edge(int a, int b, Node end) { this.a = a; this.b = b; this.end = end; }

        /** Returns the first character on the edge. */
        /** 가장자리의 첫 번째 문자를 반환합니다. */
        public char getFirst() { return str.charAt(a); }

        /** Length of the string on the edge label. */
        /** 가장자리 레이블에있는 문자열의 길이입니다. */
        public int length() { return Math.min(last,b) - a + 1; }

        @Override
        public String toString() { return str.substring(a, Math.min(b,last)+1); }
    }
    /**
     * Node of the SuffixTree.
     * SuffixTree의 노드.
     */
    public class Node implements Iterable<Edge>
    {
        /** Maps first letters to edges leading to children */
        /** 첫 글자를 children에게 이어지는 가장자리로 매핑합니다. */
        public TreeMap<Character,Edge> edges = new TreeMap<Character,Edge>();

        /** Suffix link used in linear tree building algorithm */
        /** 선형 트리 생성 알고리즘에 사용 된 접미사 링크 */
        private Node suffix;

        /** An inclusive range [a,b] of indices into str representing a prefix leading to this node */
        /** 이 노드에 이르는 접두사를 나타내는 str에 포함되는 인덱스의 포괄 범위 [a, b] */
        public int a, b;

        /** Adds an edge to the map */
        /** 지도에 가장자리를 추가합니다. */
        public void add(Edge e) { edges.put(e.getFirst(),e); }

        /** Gets the edge using the given first character */
        /** 주어진 첫 번째 문자를 사용하여 가장자리를 가져옵니다. */
        public Edge get(char c) { return edges.get(c); }

        /** Returns the number of children */
        /** children의 수를 돌려줍니다. */
        public int numChildren() { return edges.size(); }

        @Override
        public Iterator<Edge> iterator() { return edges.values().iterator(); }
        public String toString() { return str.substring(a,Math.min(b,last)+1); }
    }

    public SuffixTree(String str)
    {
        this.str = str;
        buildTree();
        setPrefix(root,null,0);
    }

    @Override
    /** Pretty prints the tree. For each node it prints the prefix leading to that node in quotes.
     * Then it prints each edge leaving the node indexed by first letter, the edge label, the inclusive range of indices,
     * and the length of the label.
     */
    /**
     * 트리를 보기좋게 보여줍니다. 각 노드에 대해 접두어를 해당 노드로 이어지는 따옴표로 프린트합니다.
     * 그런 다음 첫 번째 문자로 색인 된 노드, edge 레이블, 포괄적인 색인 범위 및 레이블 길이를 남겨두고
     * 각 edge를 프린트합니다.
     * */
    public String toString() { return prettyFormat(new StringBuilder(), root, new StringBuilder()).toString(); }
    private int fix(int x) { return x == INF ? last : x; }
    private StringBuilder prettyFormat(StringBuilder sb, Node n, StringBuilder tab)
    {
        sb.append(tab).append('"').append(n).append('"').append('\n');
        for (Edge e : n)
        {
            char c = e.getFirst();
            sb.append(tab).append(c).append(" : ").append(e).append(" = ").append(e.a).append(',').append(fix(e.b)).append(',').append(e.length()).append('\n');
            tab.append("  ");
            prettyFormat(sb,e.end,tab);
            tab.delete(tab.length()-2, tab.length());
        }
        return sb;
    }

    /** Returns the string used to make the suffix tree */
    /** 접미사 트리를 만드는 데 사용 된 문자열을 반환합니다. */
    public String getStr() { return str; }

    /** Returns the root node */
    /** 루트 노드를 반환합니다. */
    public Node getRoot() { return root; }
    private void setPrefix(Node n, Edge e, int len)
    {
        for (Edge edge : n) setPrefix(edge.end,edge,len+Math.min(edge.b,last)-edge.a+1);
        if (e == null) { n.a = 0; n.b = -1; }
        else { n.b = Math.min(e.b,last); n.a = n.b - len+1; }
    }

    private void buildTree()
    {
        root = new Node();
        sentinel = new Node();
        root.suffix = sentinel;
        Node s = root;
        int[] k = {0};
        last = -1;
        for (int i = 0; i < str.length(); ++i)
        {
            last++;
            s = update(s,k,i);
            s = canonize(s,k,i);
        }
    }

    private Node update(Node s, int[] k, int i)
    {
        Node oldr = root, r = testAndSplit(s,k[0],i-1,str.charAt(i));
        while (r != null)
        {
            Node rp = new Node();
            Edge e = new Edge(i,INF,rp);
            r.add(e);
            if (oldr != root) oldr.suffix = r;
            oldr = r;
            s = canonize(s.suffix,k,i-1);
            r = testAndSplit(s,k[0],i-1,str.charAt(i));
        }
        if (oldr != root) oldr.suffix = s;
        return s;
    }

    private Node testAndSplit(Node s, int k, int p, char c)
    {
        if (k > p) return s == sentinel ? null : s.get(c) == null ? s : null;
        Edge e = s.get(str.charAt(k));
        if (c == str.charAt(e.a+p-k+1)) return null; //check if char after implicit node is c
        Node r = new Node();
        Edge re = new Edge(e.a+p-k+1,e.b,e.end);
        r.add(re);
        Edge se = new Edge(e.a,e.a+p-k,r);
        s.add(se);
        return r;
    }

    private Node canonize(Node s, int[] k, int p)
    {
        if (p < k[0]) return s;
        if (s == sentinel) { s = root; k[0]++; if (p < k[0]) return s; }
        Edge e = s.get(str.charAt(k[0]));
        while (e.b - e.a <= p - k[0])
        {
            k[0] = k[0] + e.b - e.a + 1;
            s = e.end;
            if (k[0] <= p) e = s.get(str.charAt(k[0]));
        }
        return s;
    }

    /** Can be used to test the suffix tree on a given string given as a cmdline argument. */
    /** cmdline 인수로 주어진 문자열에서 접미어 트리를 테스트하는 데 사용할 수 있습니다. */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Any Text : ");
        String str = sc.nextLine();
//        System.out.println(new SuffixTree(args[0]));
        System.out.println(new SuffixTree(str));
    }
}