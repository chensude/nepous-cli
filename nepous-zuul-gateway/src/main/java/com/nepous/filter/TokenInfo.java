package com.nepous.filter;

import lombok.Data;

@Data
public class TokenInfo {

    private boolean active;

    private String clientId;

    private String[] scopes;

    private String username;

    private String[] aud;

    private Data exp;

    private String[] authorities;
}
