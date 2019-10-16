package nzh.dev.codeservice.model;

import java.util.Collection;

/**
 * Created by nzh-dev on 16/10/2019.
 */
public class CodeSet {
    private String id;
    private String name;
    private Collection<Code> codes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Code> getCodes() {
        return codes;
    }

    public void setCodes(Collection<Code> codes) {
        this.codes = codes;
    }
}
