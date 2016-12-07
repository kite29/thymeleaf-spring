/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2016, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.thymeleaf.spring5.context.reactive;

import org.springframework.ui.context.Theme;
import org.springframework.web.reactive.result.view.RequestContext;
import org.springframework.web.server.ServerWebExchange;
import org.thymeleaf.exceptions.TemplateProcessingException;
import org.thymeleaf.spring5.context.IThymeleafRequestContext;
import org.thymeleaf.util.Validate;

/**
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 3.0.3
 *
 */
public class SpringWebReactiveThymeleafRequestContext implements IThymeleafRequestContext {

    private final RequestContext requestContext;
    private final ServerWebExchange serverWebExchange;


    public SpringWebReactiveThymeleafRequestContext(
            final RequestContext requestContext, final ServerWebExchange serverWebExchange) {
        super();
        Validate.notNull(requestContext, "Spring Web MVC RequestContext cannot be null");
        Validate.notNull(serverWebExchange, "Server Web Exchange cannot be null");
        this.requestContext = requestContext;
        this.serverWebExchange = serverWebExchange;
    }


    public ServerWebExchange getServerWebExchange() {
        return this.serverWebExchange;
    }


    @Override
    public Theme getTheme() {
        throw new TemplateProcessingException("Themes are not supported in Spring Web Reactive");
    }





    @Override
    public String toString() {
        return this.requestContext.toString();
    }


}