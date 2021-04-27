import java.util.Random;

class Program {
    public static void main(String[] args) {
        int testSize = 1_000_000;
        int range = 50;

        if(args.length > 0) {
            range = Integer.parseInt(args[0]);
        }

        if(args.length > 1) {
            testSize = Integer.parseInt(args[1]);
        }

        new Program(testSize, range).run();
    }

    private final int m_range;
    private final int m_testSize;
    private final Random m_leftRandom;
    private final Random m_rightRandom;

    private Program(int testSize, int range) {
        if(testSize < 1) {
            throw new IllegalArgumentException("The test size has to be greater than zero!");
        }

        if(range < 2) {
            throw new IllegalArgumentException("The test range has to be greater than one!");
        }

        int seed = new Random().nextInt();
        m_leftRandom = new Random(seed + 1);
        m_rightRandom = new Random(seed + 2);

        m_testSize = testSize;
        m_range = range;
    }

    private void run() {
        int[] histogram = new int[m_range * 2 - 1];
        for(int i = 0; i < m_testSize; ++i) {
            int diff = createRandomDifference();
            histogram[diff + m_range - 1] += 1;
        }

        for(int i = 0; i < histogram.length; ++i) {
            System.out.printf("%3d: ", i - m_range + 1);
            int proMille = (histogram[i] * 1000) / m_testSize;
            for (int p = 0; p < proMille; ++p) {
                System.out.print('#');
            }
            System.out.println();
        }
    }

    private int createRandomDifference() {
        return m_leftRandom.nextInt(m_range) - m_rightRandom.nextInt(m_range);
    }
}