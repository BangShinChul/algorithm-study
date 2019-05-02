import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// link : https://www.geeksforgeeks.org/pattern-searching-using-trie-suffixes/

class SuffixTrieNode {

    final static int MAX_CHAR = 256; // 최대 노드 개수

    SuffixTrieNode[] children = new SuffixTrieNode[MAX_CHAR];
    List<Integer> indexes;

    SuffixTrieNode() // Constructor
    {
        // Create an empty linked list for indexes of
        // suffixes starting from this node
        /**
         * 이 노드에서 시작하는 접미사 색인에 대한 빈 연결 목록을 만듭니다.
         * */
        indexes = new LinkedList<Integer>();

        // Initialize all child pointers as NULL
        /** 모든 자식 포인터들을 NULL로 초기화 합니다. */
        for (int i = 0; i < MAX_CHAR; i++) {
            children[i] = null;
        }
    }

    // A recursive function to insert a suffix of
    // the text in subtree rooted with this node
    /**
     * 이 노드를 루트로 하는 하위 트리에 텍스트의 접미사를 삽입하는 재귀 함수
     * */
    void insertSuffix(String s, int index) {

        System.out.println("insert Suffix >>> "+s+" : "+index);

        // Store index in linked list
        /** 연결된 목록에 인덱스 저장 */
        indexes.add(index);

        // If string has more characters
        /** 문자열에 더 많은 문자가있는 경우 */
        if (s.length() > 0) {

            // Find the first character
            /** 첫번째 문자 찾기 */
            char cIndex = s.charAt(0);

            // If there is no edge for this character, add a new edge
            /** 이 문자에 edge가 없으면 새 edge를 추가합니다. */
            /** = cIndex로 된 자식노드가 없으면 cIndex로 새로운 자식노드를 추가합니다. */
            if (children[cIndex] == null) {
                children[cIndex] = new SuffixTrieNode();
            }

            // Recur for next suffix
            /** 다음 접미사를 반복합니다. */
            children[cIndex].insertSuffix(s.substring(1), index + 1);
        }
    }

    // A function to search a pattern in subtree rooted
    // with this node.The function returns pointer to a
    // linked list containing all indexes where pattern
    // is present. The returned indexes are indexes of
    // last characters of matched text.
    /**
     * 이 노드를 루트로하는 하위 트리의 패턴을 검색하는 함수입니다.
     * 이 함수는 패턴이있는 모든 인덱스를 포함하는 링크 된 목록에 대한 포인터를 반환합니다.
     * 반환 된 인덱스는 일치하는 텍스트의 마지막 문자 인덱스입니다.
     * */
    List<Integer> search(String s) {

        // If all characters of pattern have been processed,
        /** 패턴의 모든 문자가 처리된 경우, */
        if (s.length() == 0) {
            return indexes;
        }

        // if there is an edge from the current node of suffix tree, follow the edge.
        /**
         * 접미사 트리의 현재 노드에서 edge가 있으면 edge를 따릅니다.
         * */
        if (children[s.charAt(0)] != null) {
            return (children[s.charAt(0)]).search(s.substring(1));

            // If there is no edge, pattern doesnt exist in text
            /** 만약 edge가 없으면, 문자열에 패턴이 없는 것입니다. */
        } else {
            return null;
        }
    }
}

// A Trie of all suffixes
/** 모든 접미사들의 Trie */
class Suffix_tree{

    SuffixTrieNode root = new SuffixTrieNode();

    // Constructor (Builds a trie of suffies of the given text)
    /**
     * 생성자 (주어진 문자열의 접미사를 작성합니다.)
     * */
    Suffix_tree(String txt) {

        // Consider all suffixes of given string and
        // insert them into the Suffix Trie using
        // recursive function insertSuffix() in
        // SuffixTrieNode class
        /**
         * 주어진 문자열의 모든 접미사를 고려하여
         * SuffixTrieNode 클래스에있는
         * 재귀 함수 insertSuffix()를 사용하여 Suffix Trie에 삽입합니다.
         * */
        int txtLength = txt.length();
        for (int i = 0; i < txtLength; i++) {
            root.insertSuffix(txt.substring(i), i);
        }
    }

    /* Prints all occurrences of pat in the Suffix Trie S
    (built for text) */
    /**
     * Suffix Trie 에서 매개변수 pat에 대해 발생한 모든것을 프린트합니다.
     * */
    void search_tree(String pat) {

        // Let us call recursive search function for
        // root of Trie.
        // We get a list of all indexes (where pat is
        // present in text) in variable 'result'
        /**
         * Trie의 루트에 대한 재귀적 검색 함수를 호출합니다.
         * 매개변수 pat이 텍스트에 있는 경우 변수 'result'에 모든 색인 목록을 얻습니다.
         * */
        List<Integer> result = root.search(pat);

        // Check if the list of indexes is empty or not
        /** 인덱스 목록이 비어있는지 확인합니다. */
        if (result == null)
            System.out.println("Pattern not found");
        else {

            int patLen = pat.length();

            for (Integer i : result) {
                System.out.println("Pattern found at position " + (i - patLen));
            }
        }
    }

    // driver program to test above functions
    /** 위에서 작성한 코드들을 테스트하는 메인 메서드 */
    public static void main(String args[]) {

        // Let us build a suffix trie for text
        /** 텍스트에 대한 접미사 Trie를 만들어봅니다. */
        // "geeksforgeeks.org"
//        String txt = "geeksforgeeks.org";
//        Suffix_tree S = new Suffix_tree(txt);
//
//        System.out.println("geeksforgeeks.org : ");
//
//        System.out.println("\nSearch for 'ee'");
//        S.search_tree("ee");
//
//        System.out.println("\nSearch for 'geek'");
//        S.search_tree("geek");
//
//        System.out.println("\nSearch for 'quiz'");
//        S.search_tree("quiz");
//
//        System.out.println("\nSearch for 'forgeeks'");
//        S.search_tree("forgeeks");

        Scanner sc = new Scanner(System.in);

        System.out.println("\nPlease Enter Text : ");
        String txt = sc.nextLine();
        Suffix_tree S = new Suffix_tree(txt);

        System.out.println("\nPlease Enter Search for : ");
        String findTxt = sc.nextLine();
        S.search_tree(findTxt);

        System.out.println("\n==================\n");

        List<Integer> imsi = new ArrayList<>();
        int lstIndex = 0;
        while (txt.indexOf(findTxt, lstIndex) > -1) {
            lstIndex = txt.indexOf(findTxt, lstIndex);
            imsi.add(lstIndex);
        }

        System.out.print("[indexOf] Pattern found at position ");
        for(Integer item : imsi) {
            System.out.print(item + " ");
        }
    }
}
// This code is contributed by Sumit Ghosh
