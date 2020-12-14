package lozm.serialize;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Coffee implements Serializable {

    private String name;
    private String size;
    private int price;
    private Description description = new Coffee.Description("desc name", "desc contents", "desc secret");
    private transient String secret;

    class Description implements Serializable {
        String name;
        String contents;
        transient String secret;

        public Description(String name, String contents, String secret) {
            this.name = name;
            this.contents = contents;
            this.secret = secret;
        }
    }

}
