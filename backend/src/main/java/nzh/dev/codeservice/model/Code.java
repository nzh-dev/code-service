package nzh.dev.codeservice.model;

import java.util.List;

/**
 * Created by nzh-dev on 16/10/2019.
 */
public class Code {
    private String valueId;
    private String value;
    private String setId;
    private String setName;
    private List<String> parentValueIds;

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSetId() {
        return setId;
    }

    public void setSetId(String setId) {
        this.setId = setId;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public List<String> getParentValueIds() {
        return parentValueIds;
    }

    public void setParentValueIds(List<String> parentValueIds) {
        this.parentValueIds = parentValueIds;
    }
}
