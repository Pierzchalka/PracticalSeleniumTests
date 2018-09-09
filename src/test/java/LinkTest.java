import edu.emory.mathcs.backport.java.util.Arrays;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

@RunWith(value = Parameterized.class)

public class LinkTest {
    @Parameterized.Parameter(0)
    public String targetPage;

    @Parameterized.Parameter(1)
    public String targetPageTitle;

    @Parameterized.Parameters(name = "{index}: Open social link for {0} and expect title with{1}")
    public static Collection <Object[]> data(){
        return Arrays.asList(new Object[][]{
            {"facebook", "facebook"},
            {"twitter", "twitter"},
            {"youtube", "youtube"},
            {"google-plus", "google+"}
            });
    }
// dołozyc test z poprzedniego dnia.

}
