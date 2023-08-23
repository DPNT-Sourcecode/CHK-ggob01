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
        String friendName = "John";
        String greeting = "Hello, John!";

        assertThat(solution.hello(friendName), equalTo(greeting));
    }

}



