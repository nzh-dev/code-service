package nzh.domain;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by nzh-dev on 05/10/2019.
 */
@Entity
@Table(name = "code_relation")
public class CodeRelation extends Audit {
    private Integer id;
    private String parentValueId;
    private String childValueId;
    private String creator;
    private Integer optlock;
    @JsonIgnore
    private Code childCode;

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
    @Column(name = "parent_value_id", nullable = false, length = -1)
    public String getParentValueId() {
        return parentValueId;
    }

    public void setParentValueId(String parentValueId) {
        this.parentValueId = parentValueId;
    }

    @Basic
    @Column(name = "child_value_id", nullable = false, length = -1)
    public String getChildValueId() {
        return childValueId;
    }

    public void setChildValueId(String childValueId) {
        this.childValueId = childValueId;
    }

    @Basic
    @Column(name = "creator", nullable = false, length = -1)
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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

        CodeRelation that = (CodeRelation) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (parentValueId != null ? !parentValueId.equals(that.parentValueId) : that.parentValueId != null)
            return false;
        if (childValueId != null ? !childValueId.equals(that.childValueId) : that.childValueId != null) return false;
        if (creator != null ? !creator.equals(that.creator) : that.creator != null) return false;
        if (optlock != null ? !optlock.equals(that.optlock) : that.optlock != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (parentValueId != null ? parentValueId.hashCode() : 0);
        result = 31 * result + (childValueId != null ? childValueId.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        result = 31 * result + (optlock != null ? optlock.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "child_value_id", referencedColumnName = "value_id", nullable = false, insertable = false, updatable = false)
    public Code getChildCode() {
        return childCode;
    }

    public void setChildCode(Code childCode) {
        this.childCode = childCode;
    }
}
