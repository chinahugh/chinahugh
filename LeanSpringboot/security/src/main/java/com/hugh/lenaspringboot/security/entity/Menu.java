package com.hugh.lenaspringboot.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName s_menu
 */
@TableName(value ="s_menu")
public class Menu implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField(value = "munu")
    private String munu;

    /**
     * 
     */
    @TableField(value = "menu_value")
    private String menuValue;

    /**
     * 
     */
    @TableField(value = "auth")
    private String auth;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     */
    public String getMunu() {
        return munu;
    }

    /**
     * 
     */
    public void setMunu(String munu) {
        this.munu = munu;
    }

    /**
     * 
     */
    public String getMenuValue() {
        return menuValue;
    }

    /**
     * 
     */
    public void setMenuValue(String menuValue) {
        this.menuValue = menuValue;
    }

    /**
     * 
     */
    public String getAuth() {
        return auth;
    }

    /**
     * 
     */
    public void setAuth(String auth) {
        this.auth = auth;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Menu other = (Menu) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMunu() == null ? other.getMunu() == null : this.getMunu().equals(other.getMunu()))
            && (this.getMenuValue() == null ? other.getMenuValue() == null : this.getMenuValue().equals(other.getMenuValue()))
            && (this.getAuth() == null ? other.getAuth() == null : this.getAuth().equals(other.getAuth()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMunu() == null) ? 0 : getMunu().hashCode());
        result = prime * result + ((getMenuValue() == null) ? 0 : getMenuValue().hashCode());
        result = prime * result + ((getAuth() == null) ? 0 : getAuth().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", munu=").append(munu);
        sb.append(", menuValue=").append(menuValue);
        sb.append(", auth=").append(auth);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}