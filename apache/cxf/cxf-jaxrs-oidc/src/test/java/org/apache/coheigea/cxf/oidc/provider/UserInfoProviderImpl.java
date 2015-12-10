/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.coheigea.cxf.oidc.provider;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.cxf.rs.security.oauth2.common.OAuthPermission;
import org.apache.cxf.rs.security.oauth2.common.UserSubject;
import org.apache.cxf.rs.security.oidc.common.IdToken;
import org.apache.cxf.rs.security.oidc.common.UserInfo;
import org.apache.cxf.rs.security.oidc.idp.UserInfoProvider;

public class UserInfoProviderImpl implements UserInfoProvider {

    public UserInfoProviderImpl() {

    }

    @Override
    public IdToken getIdToken(String clientId, UserSubject authenticatedUser, List<OAuthPermission> scopes) {
        IdToken token = new IdToken();
        
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 60);
        token.setExpiryTime(cal.getTimeInMillis() / 1000L);
        token.setIssuedAt(new Date().getTime() / 1000L);
        token.setAudience(clientId);
        token.setSubject(authenticatedUser.getLogin());
        token.setIssuer("OIDC IdP");
        
        return token;
    }

    @Override
    public UserInfo getUserInfo(String clientId, UserSubject authenticatedUser, List<OAuthPermission> scopes) {
        // TODO Auto-generated method stub
        return null;
    }

}
