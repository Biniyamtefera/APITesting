package D2.POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//Adding lombok will help us to remove adding getter and setter explicitly
//Rather we can add
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true) //if it is difficult to connect variable name
public class GetLinks {
    private String rel;
    private String href;
}
