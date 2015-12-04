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
package org.apache.coheigea.cxf.oauth2.oauthservice;

import java.util.List;

import org.apache.cxf.rs.security.oauth2.grants.code.DefaultEHCacheCodeDataProvider;

/**
 * Extend the DefaultEHCacheCodeDataProvider to allow refreshing of tokens
 */
public class EHCacheRefreshTokenProvider extends DefaultEHCacheCodeDataProvider {
    
    @Override
    protected boolean isRefreshTokenSupported(List<String> theScopes) {
        return true;
    }
    
    /*
    @Override
    public List<OAuthPermission> convertScopeToPermissions(Client client, List<String> requestedScope) {
        if (requestedScope.size() == 1 && "read_balance".equals(requestedScope.get(0))) {
            OAuthPermission permission = new OAuthPermission();
            permission.setHttpVerbs(Collections.singletonList("GET"));
            String partnerAddress = "https://localhost:" + BalanceServiceTest.PORT + "/bankservice/partners/balance";
            permission.setUris(Collections.singletonList(partnerAddress));
            
            return Collections.singletonList(permission);
        }
        
        throw new OAuthServiceException("invalid_scope");
    }
    */
}
