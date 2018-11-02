package com.avaloq.oauth.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class OAuthClientDetail {

  @Column
  private String clientId;

  @Column
  private String resourceIds;

  @Column
  private String clientSecret;

  @Column
  private String scope;

  @Column
  private String authorisedGrantTypes;

  @Column
  private String authorities;

  @Column
  private Long accessTokenValidity;

  @Column
  private Long refreshTokenValidity;

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public String getResourceIds() {
    return resourceIds;
  }

  public void setResourceIds(String resourceIds) {
    this.resourceIds = resourceIds;
  }

  public String getClientSecret() {
    return clientSecret;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }

  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }

  public String getAuthorisedGrantTypes() {
    return authorisedGrantTypes;
  }

  public void setAuthorisedGrantTypes(String authorisedGrantTypes) {
    this.authorisedGrantTypes = authorisedGrantTypes;
  }

  public String getAuthorities() {
    return authorities;
  }

  public void setAuthorities(String authorities) {
    this.authorities = authorities;
  }

  public Long getAccessTokenValidity() {
    return accessTokenValidity;
  }

  public void setAccessTokenValidity(Long accessTokenValidity) {
    this.accessTokenValidity = accessTokenValidity;
  }

  public Long getRefreshTokenValidity() {
    return refreshTokenValidity;
  }

  public void setRefreshTokenValidity(Long refreshTokenValidity) {
    this.refreshTokenValidity = refreshTokenValidity;
  }

}
