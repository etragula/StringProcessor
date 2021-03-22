import org.junit.Assert;
import org.junit.Test;

public class OutputTest extends StringProcessor {
    @Test
    public void test_1() {
        System.out.print("actual : ");
        blocksParser("2[3[x]y]");
        System.out.print("\nexpect : xxxyxxxy\n\n");

        System.out.print("actual : ");
        blocksParser("3[xyz]4[xy]z");
        System.out.print("\nexpect : xyzxyzxyzxyxyxyxyz\n\n");

        System.out.print("actual : ");
        blocksParser("2[3[x]y]3[xyz]4[xy]z");
        System.out.print("\nexpect : xxxyxxxyxyzxyzxyzxyxyxyxyz\n\n");

        System.out.print("actual : ");
        blocksParser("ab3cde2abcd4e");
        System.out.print("\nexpect : ab3cde2abcd4e\n\n");

        System.out.print("actual : ");
        blocksParser("2[3[2[b]a]]");
        System.out.print("\nexpect : bbabbabbabbabbabba\n\n");

        System.out.print("actual : ");
        blocksParser("3[xyz]4[xy]z");
        System.out.print("\nexpect : xyzxyzxyzxyxyxyxyz\n\n");

        System.out.print("actual : ");
        blocksParser("ab3[2c]de2a[]bc[]d4[e]");
        System.out.print("\nexpect : ab2c2c2cde2abcdeeee\n\n");

        System.out.print("actual : ");
        blocksParser("4[3[2[1[a]b]c]d]");
        System.out.print("\nexpect : ababcababcababcdababcababcababcdababcababcababcdababcababcababcd\n\n");

        System.out.print("actual : ");
        blocksParser("2[3[bc]2z4[a]]");
        System.out.print("\nexpect : bcbcbc2zaaaabcbcbc2zaaaa\n\n");

        System.out.print("actual : ");
        blocksParser("3[xy]3[2[3[4[ab]c]z]xy]");
        System.out.print("\nexpect : xyxyxyababababcababababcababababczababababcababababcababababczxyababababcababababcababababczababababcababababcababababczxyababababcababababcababababczababababcababababcababababczxy\n\n");
    }
}
