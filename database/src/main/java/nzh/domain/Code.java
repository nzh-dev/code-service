package nzh.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by nzh-dev on 05/10/2019.
 */
@Entity
@Table(name = "code")
public class Code extends Audit {
    private Integer id;
    private String codeId;
    private String codeText;
    private String valueId;
    private String valueText;
    private String creator;
    private String modifier;
    private Integer optlock;
    private Collection<CodeRelation> parentCodeRelationsByValueId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code_id", nullable = false, length = -1)
    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    @Basic
    @Column(name = "code_text", nullable = false, length = -1)
    public String getCodeText() {
        return codeText;
    }

    public void setCodeText(String codeText) {
        this.codeText = codeText;
    }

    @Basic
    @Column(name = "value_id", nullable = false, length = -1)
    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    @Basic
    @Column(name = "value_text", nullable = false, length = -1)
    public String getValueText() {
        return valueText;
    }

    public void setValueText(String valueText) {
        this.valueText = valueText;
    }

    @Basic
    @Column(name = "creator", nullable = false, length = -1)
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Basic
    @Column(name = "modifier", nullable = true, length = -1)
    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    @Version
    @Column(name = "optlock", nullable = true)
    public Integer getOptlock() {
        return optlock;
    }

    public void setOptlock(Integer optlock) {
        this.optlock = optlock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Code code = (Code) o;

        if (id != null ? !id.equals(code.id) : code.id != null) return false;
        if (codeId != null ? !codeId.equals(code.codeId) : code.codeId != null) return false;
        if (codeText != null ? !codeText.equals(code.codeText) : code.codeText != null) return false;
        if (valueId != null ? !valueId.equals(code.valueId) : code.valueId != null) return false;
        if (valueText != null ? !valueText.equals(code.valueText) : code.valueText != null) return false;
        if (creator != null ? !creator.equals(code.creator) : code.creator != null) return false;
        if (modifier != null ? !modifier.equals(code.modifier) : code.modifier != null) return false;
        if (optlock != null ? !optlock.equals(code.optlock) : code.optlock != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (codeId != null ? codeId.hashCode() : 0);
        result = 31 * result + (codeText != null ? codeText.hashCode() : 0);
        result = 31 * result + (valueId != null ? valueId.hashCode() : 0);
        result = 31 * result + (valueText != null ? valueText.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        result = 31 * result + (modifier != null ? modifier.hashCode() : 0);
        result = 31 * result + (optlock != null ? optlock.hashCode() : 0);
        return result;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "childCode")
    public Collection<CodeRelation> getParentCodeRelationsByValueId() {
        return parentCodeRelationsByValueId;
    }

    public void setParentCodeRelationsByValueId(Collection<CodeRelation> parentCodeRelationsByValueId) {
        this.parentCodeRelationsByValueId = parentCodeRelationsByValueId;
    }
}

