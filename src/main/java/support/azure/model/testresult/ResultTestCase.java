package support.azure.model.testresult;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ResultTestCase {

    public Integer id;
    public Results results;
}
