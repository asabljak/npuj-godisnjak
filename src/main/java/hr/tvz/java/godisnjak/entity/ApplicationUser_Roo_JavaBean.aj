// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package hr.tvz.java.godisnjak.entity;

import hr.tvz.java.godisnjak.entity.ApplicationUser;
import hr.tvz.java.godisnjak.entity.ApplicationUserType;

privileged aspect ApplicationUser_Roo_JavaBean {
    
    public String ApplicationUser.getUsername() {
        return this.username;
    }
    
    public void ApplicationUser.setUsername(String username) {
        this.username = username;
    }
    
    public String ApplicationUser.getPassword() {
        return this.password;
    }
    
    public ApplicationUserType ApplicationUser.getUserRole() {
        return this.userRole;
    }
    
    public void ApplicationUser.setUserRole(ApplicationUserType userRole) {
        this.userRole = userRole;
    }
    
    public Boolean ApplicationUser.getEnabled() {
        return this.enabled;
    }
    
    public void ApplicationUser.setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    
}