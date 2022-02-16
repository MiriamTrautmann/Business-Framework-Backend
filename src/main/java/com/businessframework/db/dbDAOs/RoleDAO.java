package com.businessframework.db.dbDAOs;

/**
 * Java-Klasse, die die Datenbank-Informationsstruktur einer Nutzer-Rolle definiert.
 */
public class RoleDAO {
    private String _id;
    private String roleName;
    private Boolean isAdmin;
    private String _created;
    private String  _changed;

    public RoleDAO() {
    }

    public RoleDAO(String _id, String roleName, Boolean isAdmin, String _created, String _changed) {
        this._id = _id;
        this.roleName = roleName;
        this.isAdmin = isAdmin;
        this._created = _created;
        this._changed = _changed;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdminAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String get_created() {
        return _created;
    }

    public void set_created(String _created) {
        this._created = _created;
    }

    public String get_changed() {
        return _changed;
    }

    public void set_changed(String _changed) {
        this._changed = _changed;
    }
}
