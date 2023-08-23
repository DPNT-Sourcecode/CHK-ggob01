package befaster.solutions.HLO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HelloSolutionTest {

    private HelloSolution solution;

    @BeforeEach
    public void setUp() {
        solution = new HelloSolution();
    }

    @Test
    public void testSayHello() {
        assertThat(solution.hello("Jon"), equalTo("Hello, World!"));
    }

}


