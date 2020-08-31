// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.implementation;

import com.azure.analytics.synapse.artifacts.models.CloudErrorException;
import com.azure.analytics.synapse.artifacts.models.SqlScriptResource;
import com.azure.analytics.synapse.artifacts.models.SqlScriptsListResponse;
import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.Delete;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.Put;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in SqlScripts. */
public final class SqlScriptsImpl {
    /** The proxy service used to perform REST calls. */
    private final SqlScriptsService service;

    /** The service client containing this operation class. */
    private final ArtifactsClientImpl client;

    /**
     * Initializes an instance of SqlScriptsImpl.
     *
     * @param client the instance of the service client containing this operation class.
     */
    SqlScriptsImpl(ArtifactsClientImpl client) {
        this.service =
                RestProxy.create(SqlScriptsService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for ArtifactsClientSqlScripts to be used by the proxy service to perform
     * REST calls.
     */
    @Host("{endpoint}")
    @ServiceInterface(name = "ArtifactsClientSqlSc")
    private interface SqlScriptsService {
        @Get("/sqlScripts")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(CloudErrorException.class)
        Mono<Response<SqlScriptsListResponse>> getSqlScriptsByWorkspace(
                @HostParam("endpoint") String endpoint, @QueryParam("api-version") String apiVersion, Context context);

        @Put("/sqlScripts/{sqlScriptName}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(CloudErrorException.class)
        Mono<Response<SqlScriptResource>> createOrUpdateSqlScript(
                @HostParam("endpoint") String endpoint,
                @PathParam("sqlScriptName") String sqlScriptName,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("If-Match") String ifMatch,
                @BodyParam("application/json") SqlScriptResource sqlScript,
                Context context);

        @Get("/sqlScripts/{sqlScriptName}")
        @ExpectedResponses({200, 304})
        @UnexpectedResponseExceptionType(CloudErrorException.class)
        Mono<Response<SqlScriptResource>> getSqlScript(
                @HostParam("endpoint") String endpoint,
                @PathParam("sqlScriptName") String sqlScriptName,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("If-None-Match") String ifNoneMatch,
                Context context);

        @Delete("/sqlScripts/{sqlScriptName}")
        @ExpectedResponses({200, 204})
        @UnexpectedResponseExceptionType(CloudErrorException.class)
        Mono<Response<Void>> deleteSqlScript(
                @HostParam("endpoint") String endpoint,
                @PathParam("sqlScriptName") String sqlScriptName,
                @QueryParam("api-version") String apiVersion,
                Context context);

        @Get("{nextLink}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(CloudErrorException.class)
        Mono<Response<SqlScriptsListResponse>> getSqlScriptsByWorkspaceNext(
                @PathParam(value = "nextLink", encoded = true) String nextLink, Context context);
    }

    /**
     * Lists sql scripts.
     *
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of sql scripts resources.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<SqlScriptResource>> getSqlScriptsByWorkspaceSinglePageAsync() {
        return FluxUtil.withContext(
                        context ->
                                service.getSqlScriptsByWorkspace(
                                        this.client.getEndpoint(), this.client.getApiVersion(), context))
                .map(
                        res ->
                                new PagedResponseBase<>(
                                        res.getRequest(),
                                        res.getStatusCode(),
                                        res.getHeaders(),
                                        res.getValue().getValue(),
                                        res.getValue().getNextLink(),
                                        null));
    }

    /**
     * Lists sql scripts.
     *
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of sql scripts resources.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<SqlScriptResource> getSqlScriptsByWorkspaceAsync() {
        return new PagedFlux<>(
                () -> getSqlScriptsByWorkspaceSinglePageAsync(),
                nextLink -> getSqlScriptsByWorkspaceNextSinglePageAsync(nextLink));
    }

    /**
     * Lists sql scripts.
     *
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of sql scripts resources.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<SqlScriptResource> getSqlScriptsByWorkspace() {
        return new PagedIterable<>(getSqlScriptsByWorkspaceAsync());
    }

    /**
     * Creates or updates a Sql Script.
     *
     * @param sqlScriptName The sql script name.
     * @param sqlScript Sql Script resource type.
     * @param ifMatch ETag of the SQL script entity. Should only be specified for update, for which it should match
     *     existing entity or can be * for unconditional update.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sql Script resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<SqlScriptResource>> createOrUpdateSqlScriptWithResponseAsync(
            String sqlScriptName, SqlScriptResource sqlScript, String ifMatch) {
        return FluxUtil.withContext(
                context ->
                        service.createOrUpdateSqlScript(
                                this.client.getEndpoint(),
                                sqlScriptName,
                                this.client.getApiVersion(),
                                ifMatch,
                                sqlScript,
                                context));
    }

    /**
     * Creates or updates a Sql Script.
     *
     * @param sqlScriptName The sql script name.
     * @param sqlScript Sql Script resource type.
     * @param ifMatch ETag of the SQL script entity. Should only be specified for update, for which it should match
     *     existing entity or can be * for unconditional update.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sql Script resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SqlScriptResource> createOrUpdateSqlScriptAsync(
            String sqlScriptName, SqlScriptResource sqlScript, String ifMatch) {
        return createOrUpdateSqlScriptWithResponseAsync(sqlScriptName, sqlScript, ifMatch)
                .flatMap(
                        (Response<SqlScriptResource> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * Creates or updates a Sql Script.
     *
     * @param sqlScriptName The sql script name.
     * @param sqlScript Sql Script resource type.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sql Script resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SqlScriptResource> createOrUpdateSqlScriptAsync(String sqlScriptName, SqlScriptResource sqlScript) {
        final String ifMatch = null;
        final Context context = null;
        return createOrUpdateSqlScriptWithResponseAsync(sqlScriptName, sqlScript, ifMatch)
                .flatMap(
                        (Response<SqlScriptResource> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * Creates or updates a Sql Script.
     *
     * @param sqlScriptName The sql script name.
     * @param sqlScript Sql Script resource type.
     * @param ifMatch ETag of the SQL script entity. Should only be specified for update, for which it should match
     *     existing entity or can be * for unconditional update.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sql Script resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public SqlScriptResource createOrUpdateSqlScript(
            String sqlScriptName, SqlScriptResource sqlScript, String ifMatch) {
        return createOrUpdateSqlScriptAsync(sqlScriptName, sqlScript, ifMatch).block();
    }

    /**
     * Creates or updates a Sql Script.
     *
     * @param sqlScriptName The sql script name.
     * @param sqlScript Sql Script resource type.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sql Script resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public SqlScriptResource createOrUpdateSqlScript(String sqlScriptName, SqlScriptResource sqlScript) {
        final String ifMatch = null;
        final Context context = null;
        return createOrUpdateSqlScriptAsync(sqlScriptName, sqlScript, ifMatch).block();
    }

    /**
     * Gets a sql script.
     *
     * @param sqlScriptName The sql script name.
     * @param ifNoneMatch ETag of the sql compute entity. Should only be specified for get. If the ETag matches the
     *     existing entity tag, or if * was provided, then no content will be returned.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a sql script.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<SqlScriptResource>> getSqlScriptWithResponseAsync(String sqlScriptName, String ifNoneMatch) {
        return FluxUtil.withContext(
                context ->
                        service.getSqlScript(
                                this.client.getEndpoint(),
                                sqlScriptName,
                                this.client.getApiVersion(),
                                ifNoneMatch,
                                context));
    }

    /**
     * Gets a sql script.
     *
     * @param sqlScriptName The sql script name.
     * @param ifNoneMatch ETag of the sql compute entity. Should only be specified for get. If the ETag matches the
     *     existing entity tag, or if * was provided, then no content will be returned.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a sql script.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SqlScriptResource> getSqlScriptAsync(String sqlScriptName, String ifNoneMatch) {
        return getSqlScriptWithResponseAsync(sqlScriptName, ifNoneMatch)
                .flatMap(
                        (Response<SqlScriptResource> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * Gets a sql script.
     *
     * @param sqlScriptName The sql script name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a sql script.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SqlScriptResource> getSqlScriptAsync(String sqlScriptName) {
        final String ifNoneMatch = null;
        final Context context = null;
        return getSqlScriptWithResponseAsync(sqlScriptName, ifNoneMatch)
                .flatMap(
                        (Response<SqlScriptResource> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * Gets a sql script.
     *
     * @param sqlScriptName The sql script name.
     * @param ifNoneMatch ETag of the sql compute entity. Should only be specified for get. If the ETag matches the
     *     existing entity tag, or if * was provided, then no content will be returned.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a sql script.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public SqlScriptResource getSqlScript(String sqlScriptName, String ifNoneMatch) {
        return getSqlScriptAsync(sqlScriptName, ifNoneMatch).block();
    }

    /**
     * Gets a sql script.
     *
     * @param sqlScriptName The sql script name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a sql script.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public SqlScriptResource getSqlScript(String sqlScriptName) {
        final String ifNoneMatch = null;
        final Context context = null;
        return getSqlScriptAsync(sqlScriptName, ifNoneMatch).block();
    }

    /**
     * Deletes a Sql Script.
     *
     * @param sqlScriptName The sql script name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteSqlScriptWithResponseAsync(String sqlScriptName) {
        return FluxUtil.withContext(
                context ->
                        service.deleteSqlScript(
                                this.client.getEndpoint(), sqlScriptName, this.client.getApiVersion(), context));
    }

    /**
     * Deletes a Sql Script.
     *
     * @param sqlScriptName The sql script name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> deleteSqlScriptAsync(String sqlScriptName) {
        return deleteSqlScriptWithResponseAsync(sqlScriptName).flatMap((Response<Void> res) -> Mono.empty());
    }

    /**
     * Deletes a Sql Script.
     *
     * @param sqlScriptName The sql script name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void deleteSqlScript(String sqlScriptName) {
        deleteSqlScriptAsync(sqlScriptName).block();
    }

    /**
     * Get the next page of items.
     *
     * @param nextLink The nextLink parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of sql scripts resources.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<SqlScriptResource>> getSqlScriptsByWorkspaceNextSinglePageAsync(String nextLink) {
        return FluxUtil.withContext(context -> service.getSqlScriptsByWorkspaceNext(nextLink, context))
                .map(
                        res ->
                                new PagedResponseBase<>(
                                        res.getRequest(),
                                        res.getStatusCode(),
                                        res.getHeaders(),
                                        res.getValue().getValue(),
                                        res.getValue().getNextLink(),
                                        null));
    }
}
