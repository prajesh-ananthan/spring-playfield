package io.prajesh.service.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author Prajesh Ananthan
 *         Created on 25/8/2017.
 */
public class UserDetailsImpl implements UserDetails {

  private Collection<SimpleGrantedAuthority> authorities;
  private String username;
  private String password;
  private Boolean enabled = true;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  public void setAuthorities(Collection<SimpleGrantedAuthority> authorities) {
    this.authorities = authorities;
  }

  @Override
  public String getPassword() {
    return null;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String getUsername() {
    return null;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return false;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }
}
